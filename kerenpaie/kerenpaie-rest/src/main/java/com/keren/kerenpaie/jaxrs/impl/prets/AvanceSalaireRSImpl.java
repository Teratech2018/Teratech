
package com.keren.kerenpaie.jaxrs.impl.prets;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.prets.AvanceSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.prets.AvanceSalaireRS;
import com.keren.kerenpaie.model.prets.Acompte;
import com.keren.kerenpaie.model.prets.AvanceSalaire;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
@Path("/avancesalaire")
public class AvanceSalaireRSImpl
    extends AbstractGenericService<AvanceSalaire, Long>
    implements AvanceSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "AvanceSalaireManagerImpl", interf = AvanceSalaireManagerRemote.class)
    protected AvanceSalaireManagerRemote manager;

    public AvanceSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<AvanceSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			   MetaData meta = MetaDataUtil.getMetaData(new AvanceSalaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
			    MetaColumn workbtn = new MetaColumn("button", "work1", "Générer les reglements", false, "workflow", null);
	            workbtn.setValue("{'model':'kerenpaie','entity':'avancesalaire','method':'echeancier'}");
	            workbtn.setStates(new String[]{"etabli"});
	            workbtn.setPattern("btn btn-info");
	            meta.getHeader().add(workbtn);
	            workbtn = new MetaColumn("button", "work2", "Confirmer", false, "workflow", null);
	            workbtn.setValue("{'model':'kerenpaie','entity':'avancesalaire','method':'confirme'}");
	            workbtn.setStates(new String[]{"etabli"});
	            workbtn.setPattern("btn btn-success");
	            meta.getHeader().add(workbtn);
	            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
	            workbtn.setValue("{'model':'kerenpaie','entity':'avancesalaire','method':'annule'}");
	            workbtn.setStates(new String[]{"etabli"});
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
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		AvanceSalaire entity = manager.find("id", (Long) id);
		if(entity.getState().equalsIgnoreCase("confirme")){
			throw new KerenExecption("Avance déjà validée");
		}else if(entity.getState().equalsIgnoreCase("encours")){
			throw new KerenExecption("Avance déjà en cours de remboursement");
		}else if(entity.getState().equalsIgnoreCase("termine")){
			throw new KerenExecption("Avance déjà remboursée");
		}else if(entity.getState().equalsIgnoreCase("annule")){
			throw new KerenExecption("Avance déjà annulée");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(AvanceSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getRubrique()==null){
			throw new KerenExecption("La rubrique de paie est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de l'avance est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("Le salarié concerné est obligatoire");
		}else if(entity.getDuree()==null||entity.getDuree()<=0){
			throw new KerenExecption("La durée du remboursement de l'avance est obligatoire");
		}else if(entity.getMontant()==null||entity.getMontant()<=0){
			throw new KerenExecption("Le montant de l'avance est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(AvanceSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getRubrique()==null){
			throw new KerenExecption("La rubrique de paie est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de l'avance est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("Le salarié concerné est obligatoire");
		}else if(entity.getDuree()==null||entity.getDuree()<=0){
			throw new KerenExecption("La durée du remboursement de l'avance est obligatoire");
		}else if(entity.getMontant()==null||entity.getMontant()<=0){
			throw new KerenExecption("Le montant de l'avance est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public AvanceSalaire generereglements(HttpHeaders headers, AvanceSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getRubrique()==null){
			throw new KerenExecption("La rubrique de paie est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de l'avance est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("Le salarié concerné est obligatoire");
		}else if(entity.getDuree()==null||entity.getDuree()<=0){
			throw new KerenExecption("La durée du remboursement de l'avance est obligatoire");
		}else if(entity.getMontant()==null||entity.getMontant()<=0){
			throw new KerenExecption("Le montant de l'avance est obligatoire");
		}else if(entity.getId()<=0){
			throw new KerenExecption("Veuillez d'abord enregistrer cette entité");
		}else if(entity.getRemboursements()!=null&&!entity.getRemboursements().isEmpty()){
			throw new KerenExecption("Des remboursements existe déjà pour cette avance");
		}
		return manager.generereglement(entity);
	}

	@Override
	public AvanceSalaire confirme(HttpHeaders headers, AvanceSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getRubrique()==null){
			throw new KerenExecption("La rubrique de paie est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de l'avance est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("Le salarié concerné est obligatoire");
		}else if(entity.getDuree()==null||entity.getDuree()<=0){
			throw new KerenExecption("La durée du remboursement de l'avance est obligatoire");
		}else if(entity.getMontant()==null||entity.getMontant()<=0){
			throw new KerenExecption("Le montant de l'avance est obligatoire");
		}else if(entity.getId()<=0){
			throw new KerenExecption("Veuillez d'abord enregistrer cette entité");
		}else if(entity.getRemboursements()==null||entity.getRemboursements().isEmpty()){
			throw new KerenExecption("Aucun remboursement pour cette avance <br/> Veuillez procèder à la génération des remboursements");
		}
		return manager.confirme(entity);
	}

	@Override
	public AvanceSalaire annule(HttpHeaders headers, AvanceSalaire entity) {
		// TODO Auto-generated method stub
		if(entity.getRubrique()==null){
			throw new KerenExecption("La rubrique de paie est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La Date de l'avance est obligatoire");
		}else if(entity.getEmploye()==null){
			throw new KerenExecption("Le salarié concerné est obligatoire");
		}else if(entity.getDuree()==null||entity.getDuree()<=0){
			throw new KerenExecption("La durée du remboursement de l'avance est obligatoire");
		}else if(entity.getMontant()==null||entity.getMontant()<=0){
			throw new KerenExecption("Le montant de l'avance est obligatoire");
		}else if(entity.getId()<=0){
			throw new KerenExecption("Veuillez d'abord enregistrer cette entité");
		}else if(entity.getState()=="etabli"){
			throw new KerenExecption("Cette avance n'a fait l'objet d'aucune validation");
		}else if(entity.getState()=="termine"){
			throw new KerenExecption("Le remboursement de cette avance est déjà terminée");
		}else if(entity.getState()=="annule"){
			throw new KerenExecption("Cette avance a déjà fait l'objet d'aucune annulation");
		}
		return manager.annule(entity);
	}
    
    

}
