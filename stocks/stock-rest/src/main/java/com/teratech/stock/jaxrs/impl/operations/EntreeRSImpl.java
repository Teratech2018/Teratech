
package com.teratech.stock.jaxrs.impl.operations;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.base.ArticleManagerRemote;
import com.teratech.stock.core.ifaces.operations.EntreeManagerRemote;
import com.teratech.stock.core.ifaces.operations.LotManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.EntreeRS;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.LigneEntree;
import com.teratech.stock.model.operations.Lot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 13:26:04 GMT+01:00 2018
 * 
 */
@Path("/entree")
public class EntreeRSImpl
    extends AbstractGenericService<Entree, Long>
    implements EntreeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "EntreeManagerImpl", interf = EntreeManagerRemote.class)
    protected EntreeManagerRemote manager;
    
    @Manager(application = "teratechstock", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
    protected ArticleManagerRemote articlemanager;
    
    @Manager(application = "teratechstock", name = "LotManagerImpl", interf = LotManagerRemote.class)
    protected LotManagerRemote lotmanager;
    

    public EntreeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Entree, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta = MetaDataUtil.getMetaData(new Entree(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer la fiche de stock", false, "report", null);
            workbtn.setValue("{'name':'entree_report01','model':'teratechstock','entity':'entree','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli","qualite","transfere","disponible"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work1", "Contrôle qualité", false, "link", null);
            workbtn.setValue("{'name':'teratech_stock_ope_1_1',template:{'entree':'object','fournisseur':'object.fournisseur'},'header':['entree']}");
            workbtn.setStates(new String[]{"etabli","qualite"});
            meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work1", "Mise à disposition", false, "workflow", null);
            workbtn.setValue("{'model':'teratechstock','entity':'entree','method':'valider'}");
            workbtn.setStates(new String[]{"transfere"});
            meta.getHeader().add(workbtn);
//            workbtn = new MetaColumn("button", "work1", "Annuler l'opération", false, "link", null);
//            workbtn.setValue("{'name':'teratech_stock_ope_2',template:{'entree':'object','fournisseur':'object.fournisseur'},'header':['entree']}");
//            workbtn.setStates(new String[]{"disponible"});
//            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
        }
       
    }

    @Override
    protected void processBeforeDelete(Object entity) {
        Long id = (Long) entity;
        Entree entree = manager.find("id",id) ;
        if(entree.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible de supprimer une opération validé");
        }
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeUpdate(Entree entity) {
        if(entity.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible mettre à jour une opération validé");
        }
       if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneEntree ligne : entity.getLignes()){
            //Controle sur la ligne
            if(ligne.getId()<0){
                ligne.setId(-1);
            }//end if(ligne.getId()<0){
//            computeLigne(ligne, entity.getEntrepot());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param entity 
     */
    private void validateInout(Entree entity){
        for(LigneEntree ligne:entity.getLignes()){
           if(!stockable(ligne.getArticle())){
               continue;
           }//end if(!stockable(ligne.getArticle())){
           if(ligne.getArticle().getPolitiquestock()!=null){
               if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
                       ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                   if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
                        throw new KerenExecption("Veuillez renseigner le numéro de lot/série article :"+ligne.getArticle().getDesignation()); 
                   }else {
                       RestrictionsContainer container = RestrictionsContainer.newInstance();
                       container.addEq("lien.id", ligne.getEmplacement().getId());
                       container.addEq("code", ligne.getCode());
                       List<Lot> lots = lotmanager.filter(container.getPredicats(), null, null, 0, -1);
                       if(!lots.isEmpty()){
                           throw new KerenExecption("Un lot/serie de nom : "+ligne.getCode()+" existe déjà pour cette emplacement \nVeuillez saisir un nouveau numéro de lot/série"); 
                       }//end if(!lots.isEmpty()){
                   }//end if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
               }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                   if(ligne.getPuht()==null){
                       throw new KerenExecption("Veuillez renseigner le PUHT pour l'article :"+ligne.getArticle().getDesignation()); 
                   }
               }//end  if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
           }//end  if(ligne.getArticle().getPolitiquestock()!=null){
        }//end for(LigneEntree ligne:entity.getLignes()){
    }
   
    /**
     * 
     * @param article
     * @return 
     */
    private boolean stockable(Article article){
        return article.getType()!=null && article.getType().equalsIgnoreCase("1");
    }
    /**
     * 
     * @param article
     * @param empl
     * @return 
     */
    private Boolean stocker(Article article ,Emplacement empl){
        Article art = articlemanager.find("id", article.getId());
       
        return false;
    }

    @Override
    protected void processBeforeSave(Entree entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEntrepot()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneEntree ligne : entity.getLignes()){
           //Controle sur la ligne
            ligne.setId(-1);
//            computeLigne(ligne, entity.getEntrepot());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entree confirmer(HttpHeaders headers, Entree entity) {
         //To change body of generated methods, choose Tools | Templates.   
        validateInout(entity);
        return manager.confirmer(entity);
        //Traitement des ligne des stocks
    }

    
    @Override
    public List<Entree> imprimer(HttpHeaders headers, Entree entity) {
        //To change body of generated methods, choose Tools | Templates.
        List<Entree> datas = new ArrayList<Entree>();
        datas.add(entity);
        return datas;
    }
    
    

}
