
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
import com.teratech.stock.core.ifaces.operations.LotManagerRemote;
import com.teratech.stock.core.ifaces.operations.TransfertManagerRemote;
import com.teratech.stock.jaxrs.ifaces.operations.TransfertRS;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Lot;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 15:00:50 GMT+01:00 2018
 * 
 */
@Path("/transfert")
public class TransfertRSImpl
    extends AbstractGenericService<Transfert, Long>
    implements TransfertRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "TransfertManagerImpl", interf = TransfertManagerRemote.class)
    protected TransfertManagerRemote manager;
    
    @Manager(application = "teratechstock", name = "ArticleManagerImpl", interf = ArticleManagerRemote.class)
    protected ArticleManagerRemote articlemanager;
    
    @Manager(application = "teratechstock", name = "LotManagerImpl", interf = LotManagerRemote.class)
    protected LotManagerRemote lotmanager;
    

    public TransfertRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Transfert, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
      @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new Transfert(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
            workbtn.setValue("{'model':'teratechstock','entity':'transfert','method':'valider'}");
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
    protected void processBeforeUpdate(Transfert entity) {
        if(entity.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible de modifier une piece validée");
        }
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement source"); 
        }else if(entity.getEmplcible()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }else if(entity.getEmplacement().compareTo(entity.getEmplcible())==0){
            throw new KerenExecption("L'emplacement source et cible doivent être different"); 
        }
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            if(ligne.getId()<0){
               ligne.setId(-1);
            }//end if(ligne.getId()<0){
            lignecompute(ligne,entity.getEmplacement());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeDelete(Object entity) {
        Long id = (Long) entity;
        Transfert trans = manager.find("id", id);
        if(trans.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible de supprimer une pièce validée");
        }
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    protected void processBeforeSave(Transfert entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement source"); 
        }else if(entity.getEmplcible()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }else if(entity.getEmplacement().compareTo(entity.getEmplcible())==0){
            throw new KerenExecption("L'emplacement source et cible doivent être different"); 
        }
        //Verifier la faisabilit"
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            ligne.setId(-1);
            lignecompute(ligne,entity.getEmplacement());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param article
     * @param empl
     * @param quantite
     * @return 
     */
    private Boolean stocker(Article article ,Emplacement empl,Double quantite){
        Article art = articlemanager.find("id", article.getId());
        for(LienEmplacement lien:art.getStockages()){
            if(lien.getEmplacement().compareTo(empl)==0){
                if(lien.getStock().compareTo(quantite)<0){
                    throw new KerenExecption("Stock  de l'"+article.getCode()+" est insuffisant pour satisfaire la demande");
                }//end if(lien.getStock().compareTo(quantite)<0){
                return true;
            }
        }//end for(LienEmplacement lien:art.getStockages()){
        return false;
    }
    /**
     * 
     * @param obj 
     */
     private void canSatisfied(Transfert obj){
        Map<Article , Double> map = new HashMap<Article, Double>();
        for(LigneDocumentStock lign:obj.getLignes()){
            if(!map.containsKey(lign.getArticle())){
                map.put(lign.getArticle(), 0.0);
            }//end if(!map.containsKey(lign.getArticle()))
            Double value = map.get(lign.getArticle())+lign.getQuantite();
            map.put(lign.getArticle(), value);
        }//end for(LigneDocumentStock lign:obj.getLignes()){
        //Traitement des articles
        for(Article key:map.keySet()){
            if(!stocker(key, obj.getEmplacement(), map.get(key))){
                throw new KerenExecption("L'emplacement "+obj.getEmplacement().getCode()+" ne contient pas l'article "+key.getCode()); 
            }
            if(!stocker(key, obj.getEmplcible())){
                throw new KerenExecption("L'emplacement "+obj.getEmplcible().getCode()+" ne contient pas l'article "+key.getCode()); 
            }//end if(!stocker(key, obj.getEmplcible()))
        }
    }//end private Boolean canSatisfied(Sortie obj)

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
     
     private void lignecompute(LigneDocumentStock ligne ,Emplacement source){
//        throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" n'existe pas ;;; "+ligne.getCode()+" === "+ligne.getArticle().getPolitiquestock()); 
        if(ligne.getArticle().getPolitiquestock()!=null&&!ligne.getArticle().getPolitiquestock().trim().equalsIgnoreCase("0")){
            if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                if(ligne.getCode()==null||ligne.getCode().trim().isEmpty()){
                    throw new KerenExecption("L'article "+ligne.getArticle().getCode()+" est géré par série ou par lot"); 
                }else{
                    StringBuilder builder = new StringBuilder(ligne.getCode());
                    builder.append(source.getCode());
                    List<Lot> lots = lotmanager.findByUniqueProperty("code", ligne.getCode(), null);
//                    throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" n'existe pas :::: "+lots+" === "+lots.size()); 
                    if(lots==null||lots.isEmpty()){
                        throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" n'existe pas"); 
                    }//end if(lots.isEmpty())
                    if(lots.get(0).disponible().compareTo(ligne.getQuantite())<0){
                        throw new KerenExecption("Le N° de lot/série "+ligne.getCode()+" dispose seulement de "+lots.get(0).disponible()+" articles <br/> et ne peut par conséquent pas satisfaire votre requête"); 
                    }//end if(lots.get(0).getQuantite().compareTo(ligne.getQuantite())<0)
                }//end  if(ligne.getCode()==null||ligne.getCode().trim().isEmpty())
            }//end if(ligne.getArticle().getPolitiquestock()=="1"||ligne.getArticle().getPolitiquestock()=="5")
        }//end if(ligne.getArticle().getPolitiquestock()!=null&&!ligne.getArticle().getPolitiquestock().trim().equalsIgnoreCase("0"))
    }

    @Override
    public Transfert confirmer(HttpHeaders headers, Transfert entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("valider")){
            throw new KerenExecption("Impossible de modifier une piece validée");
        }
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement source"); 
        }else if(entity.getEmplcible()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }else if(entity.getEmplacement().compareTo(entity.getEmplcible())==0){
            throw new KerenExecption("L'emplacement source et cible doivent être different"); 
        }
        //Verifier la faisabilit"
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneDocumentStock ligne : entity.getLignes()){
            lignecompute(ligne,entity.getEmplacement());
            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        //Confirmation de la transaction
        return manager.confirmer(entity);
    }
}
