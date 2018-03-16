
package com.kerenedu.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 09 15:56:31 CET 2018
 * 
 */
@Path("/suivistage")
public class SuiviStageRSImpl
    extends AbstractGenericService<SuiviStage, Long>
    implements SuiviStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "SuiviStageManagerImpl", interf = SuiviStageManagerRemote.class)
    protected SuiviStageManagerRemote manager;

    public SuiviStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SuiviStage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
			MetaData meta = MetaDataUtil.getMetaData(new SuiviStage(),new HashMap<String, MetaData>()
   					, new ArrayList<String>());
   			//Construction du workflow
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Confimer", false, "workflow", null);
   			workbtn.setStates(new String[]{"etabli"});
   			workbtn.setValue("{'model':'kereneducation','entity':'suivistage','method':'confirmer'}");
   			
   			MetaColumn workbtn1 = new MetaColumn("button", "work2", "Terminer", false, "workflow", null);
   			workbtn1.setStates(new String[]{"encours"});
   			workbtn1.setValue("{'model':'kereneducation','entity':'suivistage','method':'terminer'}");
   			
   			meta.getHeader().add(workbtn);   			
   			meta.getHeader().add(workbtn1);
   			
   			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
   			meta.getHeader().add(stautsbar);
   			return  meta;
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}

}
    
    @Override
   	protected void processBeforeSave(SuiviStage entity) {
   		this._controlreView(entity);
   		
   		
   		super.processBeforeSave(entity);
   	}

   	@Override
   	protected void processBeforeUpdate(SuiviStage entity) {
   		this._controlreView(entity);
   		
   		super.processBeforeUpdate(entity);
   	}
   	
   	@Override
	public SuiviStage confirmer(HttpHeaders headers, SuiviStage dmde) {
		// TODO Auto-generated method stub
		return manager.confirmer(dmde);
	}
   	
	@Override
	public SuiviStage terminer(@Context HttpHeaders headers,SuiviStage dmde) {
		// TODO Auto-generated method stub
		return manager.terminer(dmde);
	}
   	
   	private void _controlreView(SuiviStage entity){
//   		 if(entity.getDebut().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getDebut().equals(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getFin().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }
   	}
}
