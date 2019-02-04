
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 14:27:02 WAT 2018
 * 
 */
@Path("/periodepaieopen")
public class PeriodePaieOpenRSImpl
    extends AbstractGenericService<PeriodePaieOpen, Long>
    implements PeriodePaieOpenRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "PeriodePaieOpenManagerImpl", interf = PeriodePaieOpenManagerRemote.class)
    protected PeriodePaieOpenManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "PeriodePaieManagerImpl", interf = PeriodePaieManagerRemote.class)
    protected PeriodePaieManagerRemote managerperiode;

    public PeriodePaieOpenRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PeriodePaieOpen, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new PeriodePaieOpen(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    

	@Override
	public PeriodePaieOpen save(@Context HttpHeaders headers ,PeriodePaieOpen entity) {
		// TODO Auto-generated method stub
		entity.getPeriode().setState("ouvert");
		managerperiode.update(entity.getPeriode().getId(), entity.getPeriode());
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(id, TypeCacheMemory.PERIODE, entity.getPeriode());
		return entity;
	}

	
	
    @Override
    public PeriodePaieOpen delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
        PeriodePaieOpen entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }

}
