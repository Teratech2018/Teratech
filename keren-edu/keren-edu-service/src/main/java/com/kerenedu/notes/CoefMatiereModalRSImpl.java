
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
@Path("/coefmatieremodal")
public class CoefMatiereModalRSImpl extends AbstractGenericService<CoefMatiereModal, Long>
		implements CoefMatiereModalRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "CoefMatiereManagerImpl", interf = CoefMatiereManagerRemote.class)
	protected CoefMatiereManagerRemote manager;

	@Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
	protected CoefMatiereDetailManagerRemote managercoefDlt;

	@Manager(application = "kereneducation", name = "MatiereManagerImpl", interf = MatiereManagerRemote.class)
	protected MatiereManagerRemote managerMatiere;

	public CoefMatiereModalRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<CoefMatiereModal, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new CoefMatiereModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CoefMatiereModal save(@Context HttpHeaders headers, CoefMatiereModal entity) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.setFiliere(entity.getFiliere());
		CacheMemory.insert(id, TypeCacheMemory.FILLIERE, entity.getFiliere());
		List<Matiere> matieres = new ArrayList<Matiere>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("filiere.id", entity.getFiliere().getId());
		matieres = managerMatiere.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		if(matieres==null||matieres.isEmpty()){
			throw new KerenExecption(
					"Traitement Impossible : La filiere selectionné n'a aucune Matière !!!");
		}
		manager.generatecoefmat(entity);
		return entity;
	}
	
	

}
