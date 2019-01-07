
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.model.report.ViewNoteHelper;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
@Path("/edtbulletin")
public class EdtBulletinRSImpl extends AbstractGenericService<EdtBulletin, Long> implements EdtBulletinRS {

	/**
	 * On injecte un Gestionnaire d'entites
	 * 
	 */

    @Manager(application = "kereneducation", name = "ClasseManagerImpl", interf = ClasseManagerRemote.class)
    protected ClasseManagerRemote managerClasse;
    
    @Manager(application = "kereneducation", name = "MoteurBulletinManagerImpl", interf = MoteurBulletinManagerRemote.class)
    protected MoteurBulletinManagerRemote moteurmanager;
	

	public EdtBulletinRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<EdtBulletin, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {

			MetaData meta = MetaDataUtil.getMetaData(new EdtBulletin(), new HashMap<String, MetaData>(),
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
	public EdtBulletin update(@Context HttpHeaders headers,Long id, EdtBulletin entity) {
//		CacheMemory.setFiliere(entity.getFiliere());
//		CacheMemory.setClasse(entity.getClasse());
		Gson gson = new Gson();
		long iduser = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(iduser, TypeCacheMemory.FILLIERE, entity.getClasse().getFiliere());
		CacheMemory.insert(iduser, TypeCacheMemory.CLASSE, entity.getClasse());
		CacheMemory.insert(iduser, TypeCacheMemory.EXAMEN, entity.getSeq());
		return entity; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public EdtBulletin save(@Context HttpHeaders headers,EdtBulletin entity) {
		System.out.println("EdtBulletinRSImpl.save() =================Début traitement des notes ========= ");
		Gson gson = new Gson();
		long iduser = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		CacheMemory.insert(iduser, TypeCacheMemory.FILLIERE, entity.getClasse().getFiliere());
		CacheMemory.insert(iduser, TypeCacheMemory.CLASSE, entity.getClasse());
		CacheMemory.insert(iduser, TypeCacheMemory.EXAMEN, entity.getSeq());
	//	System.out.println("EdtBulletinRSImpl.save() set cache memory ok .... audit .....");
		moteurmanager.preparerNotes(entity);
		
		System.out.println("EdtBulletinRSImpl.processAfterSave() ====== DEBUT CUMMUL MOYENNE TRIMESTRIEL ====================");
//		if(entity.getSeq().getTypesequence().equals("1")||entity.getSeq().getTypesequence().equals("3")||
//				entity.getSeq().getTypesequence().equals("5")){
		moteurmanager.aggregateNote(entity);
		//}
		System.out.println("EdtBulletinRSImpl.processAfterSave() ====== FIN CUMMUL MOYENNE TRIMESTRIEL ====================");
		
		

//		// generate bulletin
//		System.out.println(
//				"EdtBulletinRSImpl.save() ============ Début genration des bulletins ===== de la classe de :::======"+ entity.getClasse().getLibelle());
//		this.generateBulletin(entity);
		// affectation des rangs enfonction des moyennes
		return entity;
	}
	


	
	@Override
	protected void processAfterSave(EdtBulletin entity) {
		
		
	}

	@Override
	public List<InscriptionChoice> getidclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		long iduser = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
		if(id>0){
			Classe cls = managerClasse.find("id", id);
			CacheMemory.insert(iduser, TypeCacheMemory.CLASSE, cls);
		}
		return new ArrayList<InscriptionChoice>();
	}
	

}
