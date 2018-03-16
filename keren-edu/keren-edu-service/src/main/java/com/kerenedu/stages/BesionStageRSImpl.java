
package com.kerenedu.stages;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
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
 * @since Thu Mar 08 15:07:05 CET 2018
 * 
 */
@Path("/besionstage")
public class BesionStageRSImpl
    extends AbstractGenericService<BesionStage, Long>
    implements BesionStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BesionStageManagerImpl", interf = BesionStageManagerRemote.class)
    protected BesionStageManagerRemote manager;
    

    public BesionStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BesionStage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
			MetaData meta = MetaDataUtil.getMetaData(new BesionStage(),new HashMap<String, MetaData>()
   					, new ArrayList<String>());
   			//Construction du workflow
   			MetaColumn workbtn = new MetaColumn("button", "work1", "valider", false, "workflow", null);
   			workbtn.setStates(new String[]{"etabli"});
   			workbtn.setValue("{'model':'kereneducation','entity':'besionstage','method':'valide'}");
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
   	protected void processBeforeSave(BesionStage entity) {
   		this._controlreView(entity);
   		
   		
   		super.processBeforeSave(entity);
   	}

   	@Override
   	protected void processBeforeUpdate(BesionStage entity) {
   		this._controlreView(entity);
   		
   		super.processBeforeUpdate(entity);
   	}
   	
   	private void _controlreView(BesionStage entity){
//   		 if(entity.getDebut().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getDebut().equals(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }else if(entity.getFin().after(entity.getFin())){
//   	            throw new KerenExecption("Saisie Date erronée !!!");
//   	        }
   	}

	@Override
	public BesionStage valide(HttpHeaders headers, BesionStage dmde) {
		// TODO Auto-generated method stub
		return manager.valide(dmde);
	}
   	

}
