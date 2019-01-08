
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
import com.teratech.stock.model.operations.LigneTransfert;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            MetaColumn workbtn = new MetaColumn("button", "work1", "Imprimer la fiche de stock", false, "report", null);
            workbtn.setValue("{'name':'transfert_report01','model':'teratechstock','entity':'transfert','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
//            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//            meta.getHeader().add(stautsbar);
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
        }else if(entity.getSource()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt source"); 
        }else if(entity.getCible()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneTransfert ligne : entity.getLignes()){
            if(ligne.getId()<0){
               ligne.setId(-1);
            }//end if(ligne.getId()<0){
//            lignecompute(ligne,entity.getEmplacement());
//            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeDelete(Object id) {
        Transfert entity = manager.find("id", (Long)id);
        canDelete(entity);
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    protected void processBeforeSave(Transfert entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le n° de pièce");
        }else if(entity.getDate()==null){
            throw new KerenExecption("Veuillez saisir la date ");
        }else if(entity.getSource()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt source"); 
        }else if(entity.getCible()==null){
            throw new KerenExecption("Veuillez saisir l'entrepôt cible"); 
        } else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir la ligne du document"); 
        }
        //Verifier la faisabilit"
        canSatisfied(entity);
        //Traitement des ligne
        for(LigneTransfert ligne : entity.getLignes()){
            ligne.setId(-1);
//            lignecompute(ligne,entity.getEmplacement());
//            ligne.setTotalht(ligne.getPuht()*ligne.getQuantite());
        }//end for(LigneDocumentStock ligne : entity.getLignes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param entity 
     */
    private void canDelete(Transfert entity){
        for(LigneTransfert ligne:entity.getLignes()){
            if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){
                if(ligne.getEmpsource().getStock()==null
                        || ligne.getEmpcible().getStock().compareTo(ligne.getQuantite())<0){
                    throw new KerenExecption("Le stock est insuffisant pour satisfaire votre requête\nVous ne disposez que de "+ligne.getEmpcible().getStock()+" pour l'article "+ligne.getArticle().getDesignation());
                }//end  if(ligne.getEmplacement().getStock()==null
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                   if(ligne.getLotcible().disponible().compareTo(ligne.getQuantite())<0){
                       throw new KerenExecption("Le stock est insuffisant pour satisfaire votre requête\nVous ne disposez que de "+ligne.getLotcible().getQuantite()+" pour l'article "+ligne.getArticle().getDesignation());
                   }//end if(ligne.getLot()==null){
            }//end if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
        }//end  for(LigneSortie ligne:obj.getLignes()){
    }
    
    /**
     * 
     * @param obj 
     */
   private void canSatisfied(Transfert obj){
        for(LigneTransfert ligne:obj.getLignes()){
            if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){
                if(ligne.getEmpsource().getStock()==null
                        || ligne.getEmpsource().getStock().compareTo(ligne.getQuantite())<0){
                    throw new KerenExecption("Le stock est insuffisant pour satisfaire votre requête\nVous ne disposez que de "+ligne.getEmpsource().getStock()+" pour l'article "+ligne.getArticle().getDesignation());
                }//end  if(ligne.getEmplacement().getStock()==null
            }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                    ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                   if(ligne.getLot()==null){
                       throw new KerenExecption("Veuillez saisir le lot/Serie concerné");
                   }else if(ligne.getLot().disponible().compareTo(ligne.getQuantite())<0){
                       throw new KerenExecption("Le lot sélectionné ne contient que "+ligne.getLot().disponible()+" articles "+ligne.getArticle().getDesignation()+"\nVous pouvez selectionner plusieurs lots pour couvrire la quantité souhaitée");
                   }//end if(ligne.getLot()==null){
            }//end if(ligne.getArticle().getPolitiquestock()==null||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
        }//end  for(LigneSortie ligne:obj.getLignes()){
    }//end private Boolean canSatisfied(Sortie obj)

    
    

    @Override
    public List<Transfert> imprime(HttpHeaders headers, Transfert object) {
        //To change body of generated methods, choose Tools | Templates.
        List<Transfert> datas = new ArrayList<Transfert>();
        datas.add(object);
        return datas;
    }
}
