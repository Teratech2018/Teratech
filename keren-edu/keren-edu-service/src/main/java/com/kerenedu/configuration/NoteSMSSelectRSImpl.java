
package com.kerenedu.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Thu Feb 08 11:01:57 CET 2018
 * 
 */
@Path("/notesmsselect")
public class NoteSMSSelectRSImpl extends AbstractGenericService<NoteSMSSelect, Long> implements NoteSMSSelectRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "NoteSMSManagerImpl", interf = NoteSMSManagerRemote.class)
	protected NoteSMSManagerRemote manager;

	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote managerins;

	public NoteSMSSelectRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<NoteSMSSelect, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {

			MetaData meta = MetaDataUtil.getMetaData(new NoteSMSSelect(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	@Override
	public NoteSMSSelect save(@Context HttpHeaders headers ,NoteSMSSelect entity) {
		if (entity.getConcerne().equals("0")) {
			List<Classe> classelist = new ArrayList<Classe>();
			List<Inscription> datas = new ArrayList<Inscription>();
			List<Inscription> result = new ArrayList<Inscription>();
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			classelist = entity.getClasseList();
			for (Classe classe : classelist) {
				datas = new ArrayList<Inscription>();
				 container = RestrictionsContainer.newInstance();
				if (classe != null) {
					container.addEq("classe.id", classe.getId());
				}
				datas = managerins.filter(container.getPredicats(), null,null, -1, 0);
				result.addAll(datas);
			}
			CacheMemory.setListdestinataire(result);
		} else if (entity.getConcerne().equals("1")) {
			CacheMemory.setListdestinataire(entity.getEleveList());
		} else {

		}
		return entity;
	}

}
