
package com.kerenedu.solde;

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
import com.kerenedu.personnel.ProfesseurManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Sep 14 16:06:52 WAT 2018
 * 
 */
@Path("/eltsalaire")
public class EltSalaireRSImpl
    extends AbstractGenericService<EltSalaire, Long>
    implements EltSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EltSalaireManagerImpl", interf = EltSalaireManagerRemote.class)
    protected EltSalaireManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ProfesseurManagerImpl", interf = ProfesseurManagerRemote.class)
    protected ProfesseurManagerRemote managerpersonel;

    public EltSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EltSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new EltSalaire(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			e.printStackTrace();
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

	@Override
	public List<EltSalaireLigne> findpersonnel(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		return managerpersonel.getLigneSalaire(id);
	}

}
