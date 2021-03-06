
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 10:23:04 WAT 2018
 * 
 */
@Path("/retardpaiementmodal")
public class RetardPaiementModalRSImpl
    extends AbstractGenericService<RetardPaiementModal, Long>
    implements RetardPaiementModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "RetardPaiementModalManagerImpl", interf = RetardPaiementModalManagerRemote.class)
    protected RetardPaiementModalManagerRemote manager;

    public RetardPaiementModalRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RetardPaiementModal, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new RetardPaiementModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    
    @Override
    public RetardPaiementModal save(@Context HttpHeaders headers,RetardPaiementModal entity) {
	 
    	// passer en paramètre les paramètre saisies
    	
	  
        return entity; 
    }

	@Override
	public List<RetardPaiementModal> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		   AnneScolaire annee = (AnneScolaire) CacheMemory.getValue(id, TypeCacheMemory.ANNEESCOLAIRE);
	         if(annee!=null){
	         	 container.addEq("service.anneScolaire", annee.getCode());
	         }
	         System.out.println("InscriptionRSImpl.filter() année scolaire is "+annee.getCode());
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	
	

}
