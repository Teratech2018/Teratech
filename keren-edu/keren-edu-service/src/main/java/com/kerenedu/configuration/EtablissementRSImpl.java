
package com.kerenedu.configuration;

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
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.CoefMatiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 15:21:44 WAT 2018
 * 
 */
@Path("/etablissement")
public class EtablissementRSImpl
    extends AbstractGenericService<Etablissement, Long>
    implements EtablissementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EtablissementManagerImpl", interf = EtablissementManagerRemote.class)
    protected EtablissementManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
    protected AnneScolaireManagerRemote manageran;

    public EtablissementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Etablissement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new Etablissement(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

	@Override
	protected void processBeforeSave(Etablissement entity) {
		  if(entity.getCyles()==null&& entity.getCyles().size()==0){
              throw new KerenExecption("Renseigner les cycles de l'ecole");
		  }
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Etablissement entity) {
		if(entity.getCyles()==null&& entity.getCyles().size()==0){
            throw new KerenExecption("Renseigner les cycles de l'ecole");
		 }
		super.processBeforeUpdate(entity);
	}
	@Override
	public Etablissement delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
		Etablissement entity = manager.find("id", id);

		try {

			// on supprimme l'objet
			super.delete(headers, id);

		} catch (Exception ex) {
			throw new KerenExecption(
					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
		}

		return entity;
	}

	@Override
	public List<Etablissement> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		// set current anneescolaire
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("connected", true);
		List<AnneScolaire> annee = manageran.filter(container.getPredicats(), null, null, 0, -1);
		Etablissement etbl = getManager().findAll().get(0);
		
		CacheMemory.insert(id, TypeCacheMemory.ANNEESCOLAIRE, etbl.getAnneescolaire());
		 container = filterPredicatesBuilder(arg0,arg1,arg2);
		
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}

}
