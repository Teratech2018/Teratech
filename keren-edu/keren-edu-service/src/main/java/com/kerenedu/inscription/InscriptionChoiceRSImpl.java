
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.notes.CoefMatiere;
import com.kerenedu.reglement.Moratoire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 13:51:28 WAT 2018
 * 
 */
@Path("/inscriptionchoice")
public class InscriptionChoiceRSImpl
    extends AbstractGenericService<InscriptionChoice, Long>
    implements InscriptionChoiceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptionChoiceManagerImpl", interf = InscriptionChoiceManagerRemote.class)
    protected InscriptionChoiceManagerRemote manager;

    public InscriptionChoiceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<InscriptionChoice, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new InscriptionChoice(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    
	@Override
	public List<InscriptionChoice> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		Classe classe = (Classe) CacheMemory.getValue(id, TypeCacheMemory.CLASSE);
		if(classe!=null){
			container.addEq("classe.id", classe.getId());	
		}//end if(filiere!=null){
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}

}
