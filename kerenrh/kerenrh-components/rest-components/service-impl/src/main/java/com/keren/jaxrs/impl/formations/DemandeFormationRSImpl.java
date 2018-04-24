
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.DemandeFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.DemandeFormationRS;
import com.keren.model.formations.DemandeFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/demandeformation")
public class DemandeFormationRSImpl
    extends AbstractGenericService<DemandeFormation, Long>
    implements DemandeFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DemandeFormationManagerImpl", interf = DemandeFormationManagerRemote.class)
    protected DemandeFormationManagerRemote manager;

    public DemandeFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		MetaData meta = null;
   		try {
   			meta = MetaDataUtil.getMetaData(new DemandeFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'demandeformation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
   	        workbtn = new MetaColumn("button", "work1", "Rejeter", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'demandeformation','method':'rejete'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-danger");
   	        meta.getHeader().add(workbtn);   
   	        MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
   	        meta.getHeader().add(stautsbar);	
   		} catch (InstantiationException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IllegalAccessException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return meta;
   	}
    
    

	@Override
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		DemandeFormation entity = manager.find("id", (Long) id);
		if(!entity.getState().equals("etabli")){
			throw new KerenExecption("Cette Demande à déjà fait l'objet d'une validation ou d'un rejet");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(DemandeFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDemandeur()==null){
			throw new KerenExecption("Le demandeur est obligatoire");
		}
		if(entity.getDate()==null){
			entity.setDate(new Date());
		}
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(DemandeFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDemandeur()==null){
			throw new KerenExecption("Le demandeur est obligatoire");
		}
		if(entity.getDate()==null){
			entity.setDate(new Date());
		}
		if(entity.getState()==null||entity.getState().trim().isEmpty()){
			entity.setState("etabli");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public DemandeFormation valide(HttpHeaders headers, DemandeFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDemandeur()==null){
			throw new KerenExecption("Le demandeur est obligatoire");
		}else if(entity.getDecision()==null||entity.getDecision().isEmpty()){
			throw new KerenExecption("Le décision de la direction est obligatoire");
		}else if(entity.getState().trim().equalsIgnoreCase("rejete")){
			throw new KerenExecption("Impossible de valider une demande de formation rejétée");
		}
		if(entity.getDate()==null){
			entity.setDate(new Date());
		}
		return manager.valide(entity);
	}

	@Override
	public DemandeFormation rejete(HttpHeaders headers, DemandeFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getDemandeur()==null){
			throw new KerenExecption("Le demandeur est obligatoire");
		}else if(entity.getState().trim().equalsIgnoreCase("valide")){
			throw new KerenExecption("Impossible de rejéter une demande de formation validée");
		}
		if(entity.getDate()==null){
			entity.setDate(new Date());
		}
		return manager.rejete(entity);
	}

}
