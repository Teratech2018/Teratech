
package com.keren.jaxrs.impl.carrieres;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.carrieres.CessationManagerRemote;
import com.keren.jaxrs.ifaces.carrieres.CessationRS;
import com.keren.model.carrieres.Cessation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/cessation")
public class CessationRSImpl
    extends AbstractGenericService<Cessation, Long>
    implements CessationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CessationManagerImpl", interf = CessationManagerRemote.class)
    protected CessationManagerRemote manager;

    public CessationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Cessation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new Cessation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'cessation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'cessation','method':'annule'}");
//   	        workbtn.setStates(new String[]{"etabli"});
//   	        workbtn.setPattern("btn btn-danger");
//   	        meta.getHeader().add(workbtn);   
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
		Cessation entity = manager.find("id", (Long) id);
		if(entity.getState().trim().equalsIgnoreCase("valide")){
			throw new KerenExecption("Impossible de supprimer une effactation validée");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(Cessation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference de la Cessation est obligatoire");
		}else if(entity.getCause()==null||entity.getCause().trim().isEmpty()){
			throw new KerenExecption("La Type de Cessation est obligatoire");
		}else if(entity.getSalarie()==null){
			throw new KerenExecption("Le Salarié concerné par Cessation est obligatoire");
		}else if(entity.getDecision()==null){
			throw new KerenExecption("La Date de la Cessation est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Lype de Cessation est obligatoire");
		}
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Cessation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference de la Cessation est obligatoire");
		}else if(entity.getCause()==null||entity.getCause().trim().isEmpty()){
			throw new KerenExecption("La Type de Cessation est obligatoire");
		}else if(entity.getSalarie()==null){
			throw new KerenExecption("Le Salarié concerné par Cessation est obligatoire");
		}else if(entity.getDecision()==null){
			throw new KerenExecption("La Date de la Cessation est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Lype de Cessation est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Cessation valide(HttpHeaders headers, Cessation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La Reference de la Cessation est obligatoire");
		}else if(entity.getCause()==null||entity.getCause().trim().isEmpty()){
			throw new KerenExecption("La Type de Cessation est obligatoire");
		}else if(entity.getSalarie()==null){
			throw new KerenExecption("Le Salarié concerné par Cessation est obligatoire");
		}else if(entity.getDecision()==null){
			throw new KerenExecption("La Date de la Cessation est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Lype de Cessation est obligatoire");
		}
		return manager.valide(entity);
	}

	@Override
	public Cessation annule(HttpHeaders headers, Cessation entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
