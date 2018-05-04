
package com.keren.jaxrs.impl.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.core.ifaces.discipline.ReponseDEManagerRemote;
import com.keren.jaxrs.ifaces.discipline.ReponseDERS;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.ReponseDE;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
@Path("/reponsede")
public class ReponseDERSImpl
    extends AbstractGenericService<ReponseDE, Long>
    implements ReponseDERS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ReponseDEManagerImpl", interf = ReponseDEManagerRemote.class)
    protected ReponseDEManagerRemote manager;

    public ReponseDERSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ReponseDE, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new ReponseDE(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
	}

	@Override
	protected void processBeforeDelete(Object id) {
		// TODO Auto-generated method stub
		ReponseDE entity = manager.find("id", (Long) id);
                
		if(entity.getDemande().getState().equalsIgnoreCase("reponse")){
			throw new KerenExecption("La reponse est dejà prise en compte pour la suite du traitement de la demande");
		}//end if(!entity.getDemande().getState().equalsIgnoreCase("reponse")){
		super.processBeforeDelete(id);
	}

	@Override
	protected void processBeforeSave(ReponseDE entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La Demande concernee est obligatoire");
		}else if(entity.getDater()==null){
			throw new KerenExecption("La Date de la reponse est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(ReponseDE entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La Demande concernee est obligatoire");
		}else if(entity.getDater()==null){
			throw new KerenExecption("La Date de la reponse est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}
    
    

}
