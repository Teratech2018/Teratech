
package com.kerenedu.inscription;

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
import com.kerenedu.configuration.ServiceManagerRemote;
import com.kerenedu.reglement.FichePaiement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/inscription")
public class InscriptionRSImpl
    extends AbstractGenericService<Inscription, Long>
    implements InscriptionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
    protected InscriptionManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ServiceManagerImpl", interf = ServiceManagerRemote.class)
    protected ServiceManagerRemote managerService;


    public InscriptionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Inscription, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			MetaColumn col = new MetaColumn("button", "paiementfrais", "Paiement des frais", false, "action", null);
			col.setValue("{'name':'keren_education_paie_limit','template':{'eleve':'object'}}");

			MetaColumn col2 = new MetaColumn("button", "abscence", "Abscence", false, "action", null);
			col2.setValue("{'name':'keren_education_abs','template':{'eleveList':'object'}}");
			
			MetaData meta =  MetaDataUtil.getMetaData(new Inscription(), new HashMap<String, MetaData>(),new ArrayList<String>());
			meta.getHeader().add(col);
//			meta.getHeader().add(col2);
  			return meta ;
  		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
  	}

	@Override
	public List<Inscription> getEtudiantsInscrits() {
		// TODO Auto-generated method stub
		return findAll();
	}

	@Override
	public List<FichePaiement> findmatierclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		
		return managerService.findmatierclasse(id);
	}

}
