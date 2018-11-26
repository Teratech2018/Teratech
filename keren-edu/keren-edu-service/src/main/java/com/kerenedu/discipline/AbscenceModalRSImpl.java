
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
@Path("/abscencemodal")
public class AbscenceModalRSImpl extends AbstractGenericService<AbscenceModal, Long> implements AbscenceModalRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "AbscenceManagerImpl", interf = AbscenceManagerRemote.class)
	protected AbscenceManagerRemote manager;

	@Manager(application = "kereneducation", name = "LigneAbscenceManagerImpl", interf = LigneAbscenceManagerRemote.class)
	protected LigneAbscenceManagerRemote managerlgn;

	public AbscenceModalRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<AbscenceModal, Long> getManager() {
		return null;
	}


	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			//
			MetaData meta = MetaDataUtil.getMetaData(new AbscenceModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
			workbtn.setStates(new String[] { "etabli" });
			workbtn.setValue("{'model':'kereneducation','entity':'abscence','method':'valider'}");
			//meta.getHeader().add(workbtn);
			
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			//meta.getHeader().add(stautsbar);

			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}
	
	
	@Override
	public AbscenceModal save(HttpHeaders headers, AbscenceModal entity) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		CacheMemory.insert(id, TypeCacheMemory.EXAMEN, entity.getPeriode());
		return entity;
	}

	

	

}
