
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.BonCommandeRS;
import com.teratech.achat.model.operations.AppelOffre;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.DemandePrix;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
@Path("/boncommande")
public class BonCommandeRSImpl
    extends AbstractGenericService<BonCommande, Long>
    implements BonCommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "BonCommandeManagerImpl", interf = BonCommandeManagerRemote.class)
    protected BonCommandeManagerRemote manager;

    public BonCommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BonCommande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new BonCommande(), new HashMap<String, MetaData>(), new ArrayList<String>());
             MetaColumn workbtn = new MetaColumn("button", "work1", "Envoyé le bon de commande par e-mail", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'envoyer'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Imprimer le bon", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli"});
            
            workbtn = new MetaColumn("button", "work3", "Confirmer la commande", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Receptionner la commande", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'reception'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work4", "Générer la facture", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'facture'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work5", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'boncommande','method':'annule'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AppelOffreRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void processBeforeUpdate(BonCommande entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
         validateLigneDP(entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BonCommande entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        validateLigneDP(entity);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BonCommande envoyer(HttpHeaders headers, BonCommande entity) {
         //To change body of generated methods, choose Tools | Templates.
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        validateLigneDP(entity);
        return entity;
    }

    @Override
    public BonCommande confirmer(HttpHeaders headers, BonCommande entity) {
       //To change body of generated methods, choose Tools | Templates.
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
//        else if(entity.getState().equalsIgnoreCase("confirme")){
//            throw new KerenExecption("Ce bon de commande est déjà confirmé");
//        }
        validateLigneDP(entity);        
        manager.confirmer(entity);
        return entity;
    }

    @Override
    public BonReception reception(HttpHeaders headers, BonCommande entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
//        else if(entity.getState().equalsIgnoreCase("etabli")){
//            throw new KerenExecption("Veuillez confirmer le bon de commande");
//        }
        validateLigneDP(entity);       
        return  manager.reception(entity);
       
    }

    @Override
    public BonCommande annuler(HttpHeaders headers, BonCommande entity) {
         //To change body of generated methods, choose Tools | Templates.
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        validateLigneDP(entity);
        return manager.annuler(entity);
    }

    @Override
    public Response imprimer(HttpHeaders headers, BonCommande dmde) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Valide les lignes de la demandes de prix
     * @param entity 
     */
    private void validateLigneDP(BonCommande entity){
        for(LigneDocumentAchat lign:entity.getLignes()){
            if(lign.getArticle()==null){
                throw new KerenExecption("Veuillez fournir l'article pour toute les lignes");
            }else if(lign.getPuht()==null||lign.getPuht()==0){
                throw new KerenExecption("Veuillez fournir le puht");
            }else if(lign.getQuantite()==null||lign.getQuantite()==0){
                throw new KerenExecption("Veuillez fournir la quantité voulue");
            }
        }//end for(LigneDocumentAchat lign:entity.getLignes())
    }

    @Override
    public BonCommande facture(HttpHeaders headers, BonCommande entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getDatecommande()==null){   
           throw new KerenExecption("Veuillez saisir la date de la commande");
        }else if(entity.getFornisseur()==null){
            throw new KerenExecption("Veuillez saisir le fournisseur");
        }else if(entity.getEmplacement()==null){
            throw new KerenExecption("Veuillez saisir l'emplacement de livraison");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
            throw new KerenExecption("Veuillez saisir au moins un article");
        }
        validateLigneDP(entity);
        if(!isValideBC(entity)){
            throw new KerenExecption("Ce bon de commande a déjà fait l'objet d'un facturation");
        }//end if(!isValideBC(entity))
        //To change body of generated methods, choose Tools | Templates.
        return manager.facture(entity);
    }
    
    private boolean isValideBC(BonCommande data){
//       boolean result = false;
       for(LigneDocumentAchat ligne:data.getLignes()){
           if(ligne.qtenonfacturee()>0){
               return true ;
           }
       }
       return false;
    }
}
