
package com.keren.jaxrs.impl.recrutement;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.employes.EmployeManagerRemote;
import com.keren.core.ifaces.recrutement.ContratTravailManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.ContratTravailRS;
import com.keren.model.employes.Employe;
import com.keren.model.recrutement.ContratTravail;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/contrattravail")
public class ContratTravailRSImpl
    extends AbstractGenericService<ContratTravail, Long>
    implements ContratTravailRS
{

	   /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ContratTravailManagerImpl", interf = ContratTravailManagerRemote.class)
    protected ContratTravailManagerRemote manager;
    
    @Manager(application = "kerenrh", name = "EmployeManagerImpl", interf = EmployeManagerRemote.class)
    protected EmployeManagerRemote employemanager;

    public ContratTravailRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ContratTravail, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ContratTravail(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work2", "Démarrer", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'contrattravail','method':'demarrer'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);
			workbtn = new MetaColumn("button", "work1", "Cloturer le Contrat", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'contrattravail','method':'cloture'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-danger");
            meta.getHeader().add(workbtn);            
//            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
//            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
//            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-danger");
//            meta.getHeader().add(workbtn);	           
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
		Long id = (Long) entity;
		ContratTravail contrat = manager.find("id", id);
		if(contrat.getState().equalsIgnoreCase("confirme")){
			throw new KerenExecption("Le contrat est déjà en cours d'exécution ");
		}else if(contrat.getState().equalsIgnoreCase("cloture")){
			throw new KerenExecption("Le contrat a déjà fait l'objet d'une cloture ");
		}
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(ContratTravail entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du contrat est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("La salarié est obligatoire");
		}else if(entity.getCategorie()==null){
			throw new KerenExecption("La Catégorie du salarié est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type de contrat est obligatoire");
		}else if(entity.getEchelon()==null){
			throw new KerenExecption("L'Echélon du salarié est obligatoire");
		}else if(entity.getFonction()==null){
			throw new KerenExecption("L'Emploi du salarié est obligatoire");
		}else if(entity.getDrecurtement()==null){
			throw new KerenExecption("La date de recrutement du salarié est obligatoire");
		}else if(entity.getType().getCategorie().equalsIgnoreCase("2")){
			if(entity.getIndice()==null||entity.getIndice()==0){
				throw new KerenExecption("L'Indice de Solde du salarié est obligatoire");
			}
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ContratTravail entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du contrat est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("La salarié est obligatoire");
		}else if(entity.getCategorie()==null){
			throw new KerenExecption("La Catégorie du salarié est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type de contrat est obligatoire");
		}else if(entity.getEchelon()==null){
			throw new KerenExecption("L'Echélon du salarié est obligatoire");
		}else if(entity.getFonction()==null){
			throw new KerenExecption("L'Emploi du salarié est obligatoire");
		}else if(entity.getDrecurtement()==null){
			throw new KerenExecption("La date de recrutement du salarié est obligatoire");
		}else if(entity.getType().getCategorie().equalsIgnoreCase("2")){
			if(entity.getIndice()==null||entity.getIndice()==0){
				throw new KerenExecption("L'Indice de Solde du salarié est obligatoire");
			}
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public ContratTravail cloture(HttpHeaders headers, ContratTravail entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du contrat est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("La salarié est obligatoire");
		}else if(entity.getCategorie()==null){
			throw new KerenExecption("La Catégorie du salarié est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type de contrat est obligatoire");
		}else if(entity.getEchelon()==null){
			throw new KerenExecption("L'Echélon du salarié est obligatoire");
		}else if(entity.getFonction()==null){
			throw new KerenExecption("L'Emploi du salarié est obligatoire");
		}else if(entity.getDrecurtement()==null){
			throw new KerenExecption("La date de recrutement du salarié est obligatoire");
		}else if(entity.getId()<=0){
			throw new KerenExecption("Veuillez d'abord enregistrer le contrat de travail");
		}else if(entity.getDarret()==null){
			throw new KerenExecption("La date de cloture du contrat est obligatoire");
		}
		return manager.cloture(entity);
	}

	@Override
	public ContratTravail demarrer(HttpHeaders headers, ContratTravail entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Référence du contrat est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("La salarié est obligatoire");
		}else if(entity.getCategorie()==null){
			throw new KerenExecption("La Catégorie du salarié est obligatoire");
		}else if(entity.getType()==null){
			throw new KerenExecption("Le Type de contrat est obligatoire");
		}else if(entity.getEchelon()==null){
			throw new KerenExecption("L'Echélon du salarié est obligatoire");
		}else if(entity.getFonction()==null){
			throw new KerenExecption("L'Emploi du salarié est obligatoire");
		}else if(entity.getDrecurtement()==null){
			throw new KerenExecption("La date de recrutement du salarié est obligatoire");
		}else if(entity.getId()<=0){
			throw new KerenExecption("Veuillez d'abord enregistrer le contrat de travail");
		}else if(entity.getType().getCategorie().equalsIgnoreCase("2")){
			if(entity.getIndice()==null||entity.getIndice()==0){
				throw new KerenExecption("L'Indice de Solde du salarié est obligatoire");
			}
		}
		contratValidate(entity);
		
		return manager.demarrer(entity);
	}
    
    private void contratValidate(ContratTravail contrat){
    	Employe employe = employemanager.find("id",contrat.getEmploye().getId());
    	for(ContratTravail con:employe.getContrats()){
    		if(con.getState().trim().equalsIgnoreCase("confirme") && con.compareTo(contrat)!=0){
    			throw new KerenExecption("Deux contrat ne peuvent être actif en même temps <br/> Veuillez désactiver le Contrat de Travail :  "+con.getDesignation()+" et Reéssayer");
    		}//end if(con.getState().trim().equalsIgnoreCase("confirme") && con.compareTo(contrat)!=0){
    	}//end for(ContratTravail con:employe.getContrats())
    }
}
