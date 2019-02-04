
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.notes.CoefMatiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
@Path("/remboursementpret")
public class RemboursementPretRSImpl
    extends AbstractGenericService<RemboursementPret, Long>
    implements RemboursementPretRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "RemboursementPretManagerImpl", interf = RemboursementPretManagerRemote.class)
    protected RemboursementPretManagerRemote manager;
    

    @Manager(application = "kereneducation", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote periodemanager;

    public RemboursementPretRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RemboursementPret, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new RemboursementPret(), new HashMap<String, MetaData>(),new ArrayList<String>());
		    MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'remboursementpret','method':'confirme'}");
            workbtn.setStates(new String[]{"etabli"});
            workbtn.setPattern("btn btn-success");
            meta.getHeader().add(workbtn);   
            workbtn = new MetaColumn("button", "work1", "Refuser", false, "workflow", null);
            workbtn.setValue("{'model':'kereneducation','entity':'remboursementpret','method':'refuse'}");
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
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		RemboursementPret entity = manager.find("id", (Long)id);
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande de Prêt est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de remboursement est obligatoire");
		}else if(entity.getMontant()==null){
			throw new KerenExecption("La montant du remboursement est obligatoire");
		}else if(entity.getActif().equals(Boolean.FALSE)){
			throw new KerenExecption("Le remboursement n'est pas actif");
		}else if(entity.getState().equalsIgnoreCase("confirme")){
			throw new KerenExecption("Le remboursement est déjà confirmé");
		}
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(RemboursementPret entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande de Prêt est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de remboursement est obligatoire");
		}else if(entity.getMontant()==null){
			throw new KerenExecption("La montant du remboursement est obligatoire");
		}else if(entity.getActif().equals(Boolean.FALSE)){
			throw new KerenExecption("Le remboursement n'est pas actif");
		}
		entity.setState("confirme");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(RemboursementPret entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande de Prêt est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de remboursement est obligatoire");
		}else if(entity.getMontant()==null){
			throw new KerenExecption("La montant du remboursement est obligatoire");
		}else if(entity.getActif().equals(Boolean.FALSE)){
			throw new KerenExecption("Le remboursement n'est pas actif");
		}
//		else if(entity.getState().equalsIgnoreCase("confirme")){
//			throw new KerenExecption("Le remboursement est déjà confirmé");
//		}
		super.processBeforeUpdate(entity);
	}
	
	@Override
	protected void processAfterSave(RemboursementPret entity) {
		// TODO Auto-generated method stub
		PeriodePaie periode = periodeChecker(entity);
	//	 manager.confirme(entity, periode);
		super.processAfterSave(entity);
	}

	@Override
	public RemboursementPret confirme(HttpHeaders headers, RemboursementPret entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande de Prêt est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de remboursement est obligatoire");
		}else if(entity.getMontant()==null){
			throw new KerenExecption("La montant du remboursement est obligatoire");
		}else if(entity.getActif().equals(Boolean.FALSE)){
			throw new KerenExecption("Le remboursement n'est pas actif");
		}else if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Ce remboursement a déjà fait l'objet d'une validation <br/>ou d'un refut");
		}
		PeriodePaie periode = periodeChecker(entity);
		return manager.confirme(entity, periode);
	}

	@Override
	public RemboursementPret annule(HttpHeaders headers, RemboursementPret entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande de Prêt est obligatoire");
		}else if(entity.getDate()==null){
			throw new KerenExecption("La date de remboursement est obligatoire");
		}else if(entity.getMontant()==null){
			throw new KerenExecption("La montant du remboursement est obligatoire");
		}else if(entity.getActif().equals(Boolean.FALSE)){
			throw new KerenExecption("Le remboursement n'est pas actif");
		}else if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Ce remboursement a déjà fait l'objet d'une validation <br/>ou d'un refut");
		}
		return manager.annule(entity);
	}
    
	/**
	 * Permete de verifier que ;
	 * il exites une periode ouvert contenant la date
	 *  du remboursement en cours
	 * @param entity
	 */
	private PeriodePaie periodeChecker(RemboursementPret entity){
		  PeriodePaie periode = periodemanager.getPeriodeFromDate(entity.getDate());
		  if(periode==null){
			  throw new KerenExecption("Impossible de trouver une période contenant cette date");
		  }else if(periode.getState().equalsIgnoreCase("etabli")){
			  throw new KerenExecption("La periode "+periode.getDesignation()+" n'est pas ouverte <br/> Veuillez ouvrir la periode");
		  }else if(periode.getState().equalsIgnoreCase("ferme")){
			  throw new KerenExecption("La période "+periode.getDesignation()+" est déjà fermée");
		  }
		  return periode;
	}
	
	@Override
	public List<RemboursementPret> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		PeriodePaie periode = (PeriodePaie) CacheMemory.getValue(id, TypeCacheMemory.PERIODE);
		
		if (periode != null) {
			container.addGe("date",periode.getDdebut());
			container.addLe("date",periode.getDfin());
		} // end if(classe!=null)
		container.addNotEq("state", "annule");	
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	
	
}
