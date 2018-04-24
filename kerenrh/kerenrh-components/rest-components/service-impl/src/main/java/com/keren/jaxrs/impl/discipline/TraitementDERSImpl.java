
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
import com.keren.core.ifaces.discipline.TraitementDEManagerRemote;
import com.keren.jaxrs.ifaces.discipline.TraitementDERS;
import com.keren.model.discipline.TraitementDE;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
@Path("/traitementde")
public class TraitementDERSImpl
    extends AbstractGenericService<TraitementDE, Long>
    implements TraitementDERS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "TraitementDEManagerImpl", interf = TraitementDEManagerRemote.class)
    protected TraitementDEManagerRemote manager;

    public TraitementDERSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitementDE, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new TraitementDE()
					,new HashMap<String, MetaData>()
					,new ArrayList<String>());
		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		}
	}

	@Override
	protected void processBeforeDelete(Object entity) {
		// TODO Auto-generated method stub
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(TraitementDE entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande concerné est obligatoire");
		}else if(entity.getSuperieur()==null){
			throw new KerenExecption("Le supérieur concerné est obligatoire");
		}else if(entity.getDateavis()==null){
			throw new KerenExecption("La Date d'avis est obligatoire");
		}else if(entity.getSanction()==null||entity.getSanction().trim().isEmpty()){
			throw new KerenExecption("La Sanction décidée est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(TraitementDE entity) {
		// TODO Auto-generated method stub
		if(entity.getDemande()==null){
			throw new KerenExecption("La demande concerné est obligatoire");
		}else if(entity.getSuperieur()==null){
			throw new KerenExecption("Le supérieur concerné est obligatoire");
		}else if(entity.getDateavis()==null){
			throw new KerenExecption("La Date d'avis est obligatoire");
		}else if(entity.getSanction()==null||entity.getSanction().trim().isEmpty()){
			throw new KerenExecption("La Sanction décidée est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}
    
    

}
