
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
@Path("/dltbulletin")
public class DltBulletinRSImpl extends AbstractGenericService<DltBulletin, Long> implements DltBulletinRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */
	@Manager(application = "kereneducation", name = "BulletinManagerImpl", interf = BulletinManagerRemote.class)
	protected BulletinManagerRemote managerBul;

	@Manager(application = "kereneducation", name = "BulletinHelperGenerateManagerImpl", interf = BulletinHelperGenerateManagerRemote.class)
	protected BulletinHelperGenerateManagerRemote managerHelper;

	@Manager(application = "kereneducation", name = "ModelBulletinManagerImpl", interf = ModelBulletinManagerRemote.class)
	protected ModelBulletinManagerRemote managerModel;

	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote managerinscrit;

	@Manager(application = "kereneducation", name = "ViewNoteHelperManagerImpl", interf = ViewNoteHelperManagerRemote.class)
	protected ViewNoteHelperManagerRemote managerNoteHelper;
	
	@Manager(application = "kereneducation", name = "ExamenManagerImpl", interf = ExamenManagerRemote.class)
	protected ExamenManagerRemote managerxamen;

	public DltBulletinRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<DltBulletin, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {

			MetaData meta = MetaDataUtil.getMetaData(new DltBulletin(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			return meta;
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
	public DltBulletin save(@Context HttpHeaders headers,DltBulletin entity) {
		// To change body of generated methods, choose Tools | Templates.
		CacheMemory.setFiliere(entity.getFiliere());
		CacheMemory.setClasse(entity.getClasse());
		return entity;
	}



}
