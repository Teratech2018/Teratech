
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 15:21:44 WAT 2018
 * 
 */
@Path("/service")
public class ServiceRSImpl
    extends AbstractGenericService<Service, Long>
    implements ServiceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ServiceManagerImpl", interf = ServiceManagerRemote.class)
    protected ServiceManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "FiliereManagerImpl", interf = FiliereManagerRemote.class)
    protected FiliereManagerRemote managerfiliere;

    public ServiceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Service, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Service(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

	@Override
	public List<ServiceFilliere> findfiliere(HttpHeaders headers) {
		Gson gson = new Gson();
		String id =gson.fromJson(headers.getRequestHeader("type").get(0), String.class);
		List<ServiceFilliere> filieres = new ArrayList<ServiceFilliere>();
		System.out.println("ServiceRSImpl.findfiliere() valeur "+id);
		if(id!=null){
			int index = 0;
			List<Filiere> list = managerfiliere.findAll();
			for(Filiere f : list){
			ServiceFilliere serf = new ServiceFilliere(f);
			serf.setId(-index);
			index++;
			filieres.add(serf);
			}
		}
		return filieres;
	}

}
