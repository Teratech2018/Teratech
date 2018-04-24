
package com.keren.jaxrs.impl.formations;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.formations.BesionFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.BesionFormationRS;
import com.keren.model.formations.BesionFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/besionformation")
public class BesionFormationRSImpl
    extends AbstractGenericService<BesionFormation, Long>
    implements BesionFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "BesionFormationManagerImpl", interf = BesionFormationManagerRemote.class)
    protected BesionFormationManagerRemote manager;

    public BesionFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BesionFormation, Long> getManager() {
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
   			meta = MetaDataUtil.getMetaData(new BesionFormation(), new HashMap<String, MetaData>()
   			, new ArrayList<String>());
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
   	        workbtn.setValue("{'model':'kerenrh','entity':'besionformation','method':'valide'}");
   	        workbtn.setStates(new String[]{"etabli"});
   	        workbtn.setPattern("btn btn-success");
   	        meta.getHeader().add(workbtn);  
//   	        workbtn = new MetaColumn("button", "work1", "Annuler", false, "workflow", null);
//   	        workbtn.setValue("{'model':'kerenrh','entity':'besionformation','method':'rejete'}");
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
		BesionFormation entity = manager.find("id", (Long) id);
		if(!entity.getState().equalsIgnoreCase("etabli")){
			throw new KerenExecption("Le Beseion en Formation est déjà en cours de traitement");
		}
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(BesionFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du Besion est obligatoire");
		}
		if(entity.getDate()==null){
			entity.setDate(new Date());
		}
		entity.setState("etabli");
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(BesionFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du Besion est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public BesionFormation valide(HttpHeaders headers, BesionFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("La reference du Besion est obligatoire");
		}else if(entity.getLignes()==null||entity.getLignes().isEmpty()){
			throw new KerenExecption("Veuillez saisir au moins un détail");
		}
		return manager.valide(entity);
	}

}
