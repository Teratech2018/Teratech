
package com.kerenedu.discipline;

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
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
@Path("/abscence")
public class AbscenceRSImpl extends AbstractGenericService<Abscence, Long> implements AbscenceRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "AbscenceManagerImpl", interf = AbscenceManagerRemote.class)
	protected AbscenceManagerRemote manager;

	@Manager(application = "kereneducation", name = "LigneAbscenceManagerImpl", interf = LigneAbscenceManagerRemote.class)
	protected LigneAbscenceManagerRemote managerlgn;

	public AbscenceRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<Abscence, Long> getManager() {
		return manager;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			//
			MetaData meta = MetaDataUtil.getMetaData(new Abscence(), new HashMap<String, MetaData>(),new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Valider", false, "workflow", null);
			workbtn.setStates(new String[] { "etabli" });
			workbtn.setValue("{'model':'kereneducation','entity':'abscence','method':'valider'}");
			meta.getHeader().add(workbtn);
			
			MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			meta.getHeader().add(stautsbar);

			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	@Override
	public List<LigneAbscence> findeleveclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		long idclasse = gson.fromJson(headers.getRequestHeader("classe").get(0), Long.class);
		return managerlgn.findeleve(idclasse);
	}

	@Override
	public Abscence valider(HttpHeaders headers, Abscence entity) {
		return manager.valider(entity);
	}

}
