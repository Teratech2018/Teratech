
package com.teratech.stock.jaxrs.impl.operations;

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
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.EntreeV;
import com.teratech.stock.model.operations.LigneDocumentStock;
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
            MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
            workbtn.setValue("{'model':'teratechstock','entity':'entree','method':'valider'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
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
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            //Controle sur la ligne
            computeLigne(ligne, entity.getEmplacement());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void computeLigne(LigneDocumentStock ligne,Emplacement empl){
        if(!stocker(ligne.getArticle(), empl)){
            throw new KerenExecption("L'emplacement "+empl.getCode()+" ne contient pas l'article "+ligne.getArticle().getCode()); 
        }//end if(!stocker(ligne.getArticle(), entity.getEmplacement()))
        if(ligne.getArticle().getPolitiquestock()!=null&&!ligne.getArticle().getPolitiquestock().trim().equalsIgnoreCase("0")){
            if(ligne.getArticle().getPolitiquestock()=="1"||ligne.getArticle().getPolitiquestock()=="5"){
                if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
                    throw new KerenExecption("L'article "+ligne.getArticle().getCode()+" est géré par série ou par lot"); 
                }else {
                       StringBuilder builder = new StringBuilder(ligne.getCode());
                        builder.append(empl.getCode());
                        List<Lot> lots = lotmanager.findByUniqueProperty("reference", builder.toString(), null);
    //                    throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" n'existe pas :::: "+lots+" === "+lots.size()); 
                        if(lots!=null&&!lots.isEmpty()){
                            throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" existe déjà"); 
                        }//end if(lots.isEmpty())
                        
                }//end if(ligne.getCode()==null||ligne.getCode().trim().isEmpty())
            }//end if(ligne.getArticle().getPolitiquestock()=="1"||ligne.getArticle().getPolitiquestock()=="5")
        }//end if(ligne.getArticle().getPolitiquestock()!=null&&!ligne.getArticle().getPolitiquestock().trim().equalsIgnoreCase("0"))
    }//end private void computeLigne(LigneDocumentStock ligne,Emplacement empl)
    /**
     * 
     * @param article
     * @param empl
     * @return 
     */
    private Boolean stocker(Article article ,Emplacement empl){
        Article art = articlemanager.find("id", article.getId());
        for(LienEmplacement lien:art.getStockages()){
            if(lien.getEmplacement().compareTo(empl)==0){
                return true;
            }
        }//end for(LienEmplacement lien:art.getStockages()){
        return false;
    }

    @Override
    protected void processBeforeSave(Entree entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement"); 
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
           //Controle sur la ligne
            computeLigne(ligne, entity.getEmplacement());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntreeV confirmer(HttpHeaders headers, Entree object) {
         //To change body of generated methods, choose Tools | Templates.
        if(object.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Cette Opération est dejà validé");        
        }
        return manager.confirmer(object);
        //Traitement des ligne des stocks
    }
    
    

}
