
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
 * @since Thu Mar 08 21:14:59 CET 2018
 * 
 */
@Path("/stagee")
public class StageERSImpl
    extends AbstractGenericService<StageE, Long>
    implements StageERS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "StageEManagerImpl", interf = StageEManagerRemote.class)
    protected StageEManagerRemote manager;

    public StageERSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<StageE, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
			MetaData meta = MetaDataUtil.getMetaData(new StageE(),new HashMap<String, MetaData>()
   					, new ArrayList<String>());
   			//Construction du workflow
   			MetaColumn workbtn = new MetaColumn("button", "work1", "Terminer", false, "workflow", null);
   			workbtn.setStates(new String[]{"encours"});
   			workbtn.setValue("{'model':'kereneducation','entity':'stagee','method':'terminer'}");
   			meta.getHeader().add(workbtn);
   			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
   			meta.getHeader().add(stautsbar);
   			return  meta;
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
   	}

  

   	@Override
   	protected void processBeforeSave(StageE entity) {
   		this._controlreView(entity);
   		
   		
   		super.processBeforeSave(entity);
   	}

   	@Override
   	protected void processBeforeUpdate(StageE entity) {
   		this._controlreView(entity);
   		
   		super.processBeforeUpdate(entity);
   	}
   	
   	@Override
	public StageCL terminer(@Context HttpHeaders headers,StageE dmde) {
		// TODO Auto-generated method stub
		return manager.terminer(dmde);
	}
   	
   	private void _controlreView(StageE entity){
//   		 if(entity.getDebut().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getDebut().equals(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getFin().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }
   	}

}
