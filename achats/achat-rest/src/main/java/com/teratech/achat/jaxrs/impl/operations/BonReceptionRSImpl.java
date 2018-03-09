
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.BonReceptionRS;
import com.teratech.achat.model.operations.BonReception;
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

 * @since Wed Feb 28 21:40:29 GMT+01:00 2018
 * 
 */
@Path("/bonreception")
public class BonReceptionRSImpl
    extends AbstractGenericService<BonReception, Long>
    implements BonReceptionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "BonReceptionManagerImpl", interf = BonReceptionManagerRemote.class)
    protected BonReceptionManagerRemote manager;

    public BonReceptionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BonReception, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
         try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new BonReception(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer le bon", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'imprime'}");
            workbtn.setStates(new String[]{"etabli"});
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work3", "Contrôler la qualité", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work4", "Rejeter", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'rejete'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Transferer en stock", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'transfere'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work4", "Générer la facture", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'facture'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work5", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'bonreception','method':'annule'}");
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
    protected void processBeforeUpdate(BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("transfere")){
             throw new KerenExecption("Impossible de modifier un bon transféré");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
             throw new KerenExecption("Impossible de modifier un bon contrôlé");
        }
        validateLigneBR(entity, Boolean.FALSE);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BonReception entity) {
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
        validateLigneBR(entity, Boolean.FALSE);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public BonReception confirmer(HttpHeaders headers, BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("confirme")){
            throw new KerenExecption("Ce bon de reception est déjà confirmé");
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            throw new KerenExecption("Impossible de confirmer un bon déja transféré");
        }else if(entity.getState().equalsIgnoreCase("annule")){
            throw new KerenExecption("Impossible de confirmer un bon annulé");
        }
        validateLigneBR(entity, Boolean.TRUE);
        //To change body of generated methods, choose Tools | Templates.
        return manager.confirmer(entity);
    }

    @Override
    public BonReception rejeter(HttpHeaders headers, BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            throw new KerenExecption("Impossible de rejeter un bon transféré");
        }else if(entity.getState().equalsIgnoreCase("annule")){
            throw new KerenExecption("Impossible de rejeter un bon annulé");
        }
       //To change body of generated methods, choose Tools | Templates.
        return manager.rejeter(entity);
    }

    @Override
    public BonReception transferer(HttpHeaders headers, BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            throw new KerenExecption("ce bon a déja transféré");
        }else if(entity.getState().equalsIgnoreCase("annule")){
            throw new KerenExecption("Impossible de transférer un bon annulé");
        }else if(entity.getState().equalsIgnoreCase("rejete")){
            throw new KerenExecption("Impossible de transférer un bon rejeté <br/>Veuillez refaire le contrôle de la qualité");
        }
        validateLigneBR(entity, Boolean.TRUE);
        return manager.transferer(entity);
    }

    @Override
    public Response imprimer(HttpHeaders headers, BonReception entity) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BonReception annuler(HttpHeaders headers, BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            throw new KerenExecption("Annulation impossible le bon à déja fait l'objet d'un transfert");
        }
        return manager.annuler(entity);
    }
    
     /**
     * Valide les lignes de la demandes de prix
     * @param entity 
     */
    private void validateLigneBR(BonReception entity,Boolean strict){
        for(LigneDocumentAchat lign:entity.getLignes()){
            if(lign.getArticle()==null){
                throw new KerenExecption("Veuillez fournir l'article pour toute les lignes");
            }else if(lign.getPuht()==null||lign.getPuht()==0){
                throw new KerenExecption("Veuillez fournir le puht");
            }else if(lign.getQuantite()==null||lign.getQuantite()==0){
                throw new KerenExecption("Veuillez fournir la quantité voulue");
            }
            if(strict==true){
                if(lign.getArticle().getPolitiquestock().equalsIgnoreCase("1")||
                        lign.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                    if(lign.getCode()==null||lign.getCode().trim().isEmpty()){
                        throw new KerenExecption("L'article "+lign.getArticle().getDesignation()+" est géré par lot ou par série");
                    }//end if(lign.getCode()==null||lign.getCode().trim().isEmpty())
                }//end if(lign.getArticle().getPolitiquestock().equalsIgnoreCase("1")
            }//end vif(strict==true)
        }//end for(LigneDocumentAchat lign:entity.getLignes())
    }

    /**
     * 
     * @param headers
     * @param entity
     * @return 
     */
    @Override
    public BonReception facture(HttpHeaders headers, BonReception entity) {
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
        }else if(entity.getState().equalsIgnoreCase("annule")){
            throw new KerenExecption("Impossible de facturer un bon annulé");
        }else if(entity.getState().equalsIgnoreCase("rejete")){
            throw new KerenExecption("Impossible de transférer un bon rejeté <br/>Veuillez refaire le contrôle de la qualité");
        }
        validateLigneBR(entity, Boolean.TRUE);
        if(!isValideBC(entity)){
            throw new KerenExecption("Ce bon de reception a déjà fait l'objet d'une facturation");
        }//end if(!isValideBC(entity))
        return manager.facturer(entity); 
    }

     private boolean isValideBC(BonReception data){
//       boolean result = false;
       for(LigneDocumentAchat ligne:data.getLignes()){
           if(ligne.qtenonfacturee()>0){
               return true ;
           }
       }
       return false;
    }
}
