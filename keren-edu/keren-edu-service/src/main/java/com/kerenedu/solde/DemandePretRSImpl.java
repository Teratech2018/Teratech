
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
@Path("/demandepret")
public class DemandePretRSImpl
    extends AbstractGenericService<DemandePret, Long>
    implements DemandePretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "DemandePretManagerImpl", interf = DemandePretManagerRemote.class)
    protected DemandePretManagerRemote manager;

    public DemandePretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandePret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {

        // TODO Auto-generated method stub
        try {
                MetaData meta = MetaDataUtil.getMetaData(new DemandePret(), new HashMap<String, MetaData>(),new ArrayList<String>());
                MetaColumn workbtn = new MetaColumn("button", "work1", "Générer les reglements", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'echeancier'}");
                workbtn.setStates(new String[]{"etabli","confirme"});
                workbtn.setPattern("btn btn-info");
                meta.getHeader().add(workbtn);
                workbtn = new MetaColumn("button", "work2", "Confirmer", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'confirme'}");
                workbtn.setStates(new String[]{"etabli"});
                workbtn.setPattern("btn btn-success");
                meta.getHeader().add(workbtn);
                workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
                workbtn.setValue("{'model':'kereneducation','entity':'demandepret','method':'annule'}");
                workbtn.setStates(new String[]{"confirme"});
                workbtn.setPattern("btn btn-danger");
                meta.getHeader().add(workbtn);	           
                MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
                meta.getHeader().add(stautsbar);
                return meta;

            } catch (InstantiationException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();

            } catch (IllegalAccessException e) {

                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
    }

    @Override
    protected void processBeforeDelete(Object entity) {

        // TODO Auto-generated method stub
        super.processBeforeDelete(entity);
    }

    @Override
    protected void processBeforeSave(DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Prêt est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Prêt  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de début remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicité  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant proposé  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La durée du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotité cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Demande de Prêt déjà confirmée");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Prêt déjà confirmée");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Prêt déjà terminée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Prêt déjà annulée");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure à la date de remboursement");
        }

        //On set l'etat initial
        entity.setState("etabli");

        super.processBeforeSave(entity);
    }

    @Override
    protected void processBeforeUpdate(DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Prêt est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Prêt  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de début remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicité  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant proposé  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La durée du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotité cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("Demande de Prêt déjà confirmée");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Prêt déjà confirmée");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Prêt déjà terminée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Prêt déjà annulée");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure à la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant proposé, ne peut etre supérieur au montant sollicité");
        }

        super.processBeforeUpdate(entity);
    }

    @Override
    public DemandePret generereglements(HttpHeaders headers, DemandePret entity) {
       
        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Prêt est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Prêt  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de début remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicité  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant proposé  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La durée du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotité cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Prêt déjà en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Prêt déjà terminée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Prêt déjà annulée");
        }else if(entity.getRemboursements() !=null &&!entity.getRemboursements().isEmpty()){
                throw new KerenExecption("Des remboursements sont déjà générés pour cette demande");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant proposé, ne peut etre supérieur au montant sollicité");
        }

        return manager.generereglements(entity);
    }

    @Override
    public DemandePret confirme(HttpHeaders headers, DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Prêt est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Prêt  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de début remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicité  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant proposé  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La durée du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotité cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("confirme")){
                throw new KerenExecption("La demande de Prêt est déjà confirmée");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Prêt déjà en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Prêt déjà terminée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Prêt déjà annulée");
        }else if(entity.getRemboursements()==null||entity.getRemboursements().isEmpty()){
                throw new KerenExecption("Veuillez générer les remboursements");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure à la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant proposé, ne peut etre supérieur au montant sollicité");
        }

        return manager.confirme(entity);
    }

    @Override
    public DemandePret annule(HttpHeaders headers, DemandePret entity) {

        // TODO Auto-generated method stub
        if(entity.getTypepret()==null){
                throw new KerenExecption("Le Type de Prêt est obligatoire");
        }else if(entity.getEmploye()==null){
                throw new KerenExecption("Le Salarié  est obligatoire");
        }else if(entity.getDpret()==null){
                throw new KerenExecption("La date de Prêt  est obligatoire");
        }else if(entity.getDrembour()==null){
                throw new KerenExecption("La date de début remboursement  est obligatoire");
        }else if(entity.getMontantsol()==null){
                throw new KerenExecption("Le montant sollicité  est obligatoire");
        }else if(entity.getMontantpro()==null){
                throw new KerenExecption("Le montant proposé  est obligatoire");
        }else if(entity.getDuree()==null){
                throw new KerenExecption("La durée du remboursement est obligatoire");
        }else if(entity.getQuotite()==null){
                throw new KerenExecption("La Quotité cessible est obligatoire");
        }else if(entity.getState().equalsIgnoreCase("encours")){
                throw new KerenExecption("Demande de Prêt déjà en cours de remboursement");
        }else if(entity.getState().equalsIgnoreCase("termine")){
                throw new KerenExecption("Demande de Prêt déjà terminée");
        }else if(entity.getState().equalsIgnoreCase("annule")){
                throw new KerenExecption("Demande de Prêt déjà annulée");
        }else if(entity.getDpret().after(entity.getDrembour())){
                throw new KerenExecption("La date de pret ne peut etre superieure à la date de remboursement");
        }else if(entity.getMontantsol() < entity.getMontantpro()){
                throw new KerenExecption("Le montant proposé, ne peut etre supérieur au montant sollicité");
        }

        return manager.annule(entity);
    }
    
    @Override
    public DemandePret delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        DemandePret entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
    
    @Override
	public List<DemandePret> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		container.addNotEq("state", "annule");	
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	

}
