
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.AppelOffreManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.AppelOffreRS;
import com.teratech.achat.model.operations.AppelOffre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
@Path("/appeloffre")
public class AppelOffreRSImpl
    extends AbstractGenericService<AppelOffre, Long>
    implements AppelOffreRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "AppelOffreManagerImpl", interf = AppelOffreManagerRemote.class)
    protected AppelOffreManagerRemote manager;

    public AppelOffreRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<AppelOffre, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta =  MetaDataUtil.getMetaData(new AppelOffre(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Confirmer", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'appeloffre','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
             meta.getHeader().add(workbtn);
             workbtn = new MetaColumn("button", "work1", "Selection de(s) offre(s)", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'appeloffre','method':'selection'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
             meta.getHeader().add(workbtn);
//              workbtn = new MetaColumn("button", "work1", "Créer un bon de commande", false, "workflow", null);
//            workbtn.setValue("{'model':'teratechachat','entity':'appeloffre','method':'termine'}");
//            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
//             meta.getHeader().add(workbtn);
            workbtn = new MetaColumn("button", "work2", "Annuler", false, "workflow", null);
            workbtn.setValue("{'model':'teratechachat','entity':'appeloffre','method':'annule'}");
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
    protected void processBeforeUpdate(AppelOffre entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw  new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getResponsable()==null){
             throw  new KerenExecption("Veuillez saisir le responsable");
        }else if(entity.getDeadline()==null){
             throw  new KerenExecption("Veuillez saisir la date limite de soummission");
        }else if(entity.getTypeselection()==null||entity.getTypeselection().trim().isEmpty()){
             throw  new KerenExecption("Veuillez saisir le type de sélection");
        }else if(entity.getDatecommande()==null){
             throw  new KerenExecption("Veuillez saisir la date de commande prevue");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
           throw  new KerenExecption("Veuillez saisir au moins un produit");
        } 
        if(entity.getTypeselection().equalsIgnoreCase("0")&&entity.getOffres().size()>1){
            throw  new KerenExecption("Cette appel d'offre ne peut être lié qu'a une seule demande de prix");
        }//end if(entity.getTypeselection().equalsIgnoreCase("0")&&entity.getOffres().size()>1)
         if(entity.getState().equalsIgnoreCase("selection")||entity.getState().equalsIgnoreCase("boncommande")){
            throw  new KerenExecption("Impossible de modifier un appel d'offre déjà selectionné ou commandé");
        } 
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(AppelOffre entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw  new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getResponsable()==null){
             throw  new KerenExecption("Veuillez saisir le responsable");
        }else if(entity.getDeadline()==null){
             throw  new KerenExecption("Veuillez saisir la date limite de soummission");
        }else if(entity.getTypeselection()==null||entity.getTypeselection().trim().isEmpty()){
             throw  new KerenExecption("Veuillez saisir le type de sélection");
        }else if(entity.getDatecommande()==null){
             throw  new KerenExecption("Veuillez saisir la date de commande prevue");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
           throw  new KerenExecption("Veuillez saisir au moins un produit");
        }        
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeDelete(Object data) {
        AppelOffre entity = manager.find("id", (Long)data);
         if(entity.getState().equalsIgnoreCase("selection")||entity.getState().equalsIgnoreCase("boncommande")){
            throw  new KerenExecption("Impossible de supprimer un appel d'offre déjà selectionné ou commandé");
        } 
        super.processBeforeDelete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public AppelOffre confirmer(HttpHeaders headers, AppelOffre entity) {
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw  new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getResponsable()==null){
             throw  new KerenExecption("Veuillez saisir le responsable");
        }else if(entity.getDeadline()==null){
             throw  new KerenExecption("Veuillez saisir la date limite de soummission");
        }else if(entity.getTypeselection()==null||entity.getTypeselection().trim().isEmpty()){
             throw  new KerenExecption("Veuillez saisir le type de sélection");
        }else if(entity.getDatecommande()==null){
             throw  new KerenExecption("Veuillez saisir la date de commande prevue");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
           throw  new KerenExecption("Veuillez saisir au moins un produit");
        }
        return manager.confirmer(entity);
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AppelOffre selectionner(HttpHeaders headers, AppelOffre entity) {
       //To change body of generated methods, choose Tools | Templates.
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw  new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getResponsable()==null){
             throw  new KerenExecption("Veuillez saisir le responsable");
        }else if(entity.getDeadline()==null){
             throw  new KerenExecption("Veuillez saisir la date limite de soummission");
        }else if(entity.getTypeselection()==null||entity.getTypeselection().trim().isEmpty()){
             throw  new KerenExecption("Veuillez saisir le type de sélection");
        }else if(entity.getDatecommande()==null){
             throw  new KerenExecption("Veuillez saisir la date de commande prevue");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
           throw  new KerenExecption("Veuillez saisir au moins un produit");
        } 
        if((entity.getOffres()==null||entity.getOffres().isEmpty())){
            throw  new KerenExecption("Veuillez selectionner les demandes de prix liée à l'offre");
        }//end if(entity.getTypeselection().equalsIgnoreCase("1")&&(entity.getOffres()==null||entity.getOffres().isEmpty())){
//        if(entity.getTypeselection().equalsIgnoreCase("0")&&entity.getOffre()==null){
//            throw  new KerenExecption("Veuillez selectionner la demande de prix liée à l'offre");
//        }//end if(entity.getTypeselection().equalsIgnoreCase("0")&&entity.getOffre()==null
       
         return manager.selectionner(entity);
    }

    @Override
    public AppelOffre annuler(HttpHeaders headers, AppelOffre entity) {
         //To change body of generated methods, choose Tools | Templates.
         if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
            throw  new KerenExecption("Veuillez saisir la reference");
        }else if(entity.getResponsable()==null){
             throw  new KerenExecption("Veuillez saisir le responsable");
        }else if(entity.getDeadline()==null){
             throw  new KerenExecption("Veuillez saisir la date limite de soummission");
        }else if(entity.getTypeselection()==null||entity.getTypeselection().trim().isEmpty()){
             throw  new KerenExecption("Veuillez saisir le type de sélection");
        }else if(entity.getDatecommande()==null){
             throw  new KerenExecption("Veuillez saisir la date de commande prevue");
        }else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
           throw  new KerenExecption("Veuillez saisir au moins un produit");
        } 
        if(entity.getState().equalsIgnoreCase("selection")||entity.getState().equalsIgnoreCase("boncommande")){
            throw  new KerenExecption("Impossible d'annuler un appel d'offre déjà selectionné ou commandé");
        } 
        return manager.annuler(entity);
    }

    @Override
    public AppelOffre termine(HttpHeaders headers, AppelOffre entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
