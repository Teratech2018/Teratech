
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
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
@Path("/edtbulletin")
public class EdtBulletinRSImpl extends AbstractGenericService<EdtBulletin, Long> implements EdtBulletinRS {

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
	public EdtBulletin update(Long id, EdtBulletin entity) {
		CacheMemory.setFiliere(entity.getFiliere());
		CacheMemory.setClasse(entity.getClasse());
		CacheMemory.setModelBulletin(entity.getModel());
		return entity; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public EdtBulletin save(EdtBulletin entity) {
		// To change body of generated methods, choose Tools | Templates.
		CacheMemory.setFiliere(entity.getFiliere());
		CacheMemory.setClasse(entity.getClasse());
		CacheMemory.setModelBulletin(entity.getModel());
		
		ModelBulletin model = managerModel.find("id", entity.getModel().getId());
		entity.setModel(model);

		// generate bulletin
		System.out.println("EdtBulletinRSImpl.save() ============ Début genration des bulletins ===== de la classe de :::======"+entity.getClasse().getLibelle());
		this.generateBulletin(entity);
		System.out.println("EdtBulletinRSImpl.save() ============ Fin de la generation des bulletins =======de la classe de :::======"+entity.getClasse().getLibelle());
		// affectation des rangs enfonction des moyennes
		return entity;
	}

	private void generateBulletin(EdtBulletin critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Bulletin> datas = new ArrayList<Bulletin>();
		if (critere.getClasse() != null) {
			container.addEq("classe.id", critere.getClasse().getId());
		}
		if (critere.getModel() != null) {
			container.addEq("model.id", critere.getModel().getId());
		}
		if (critere.getFiliere() != null) {
			container.addEq("classe.filiere.id", critere.getFiliere().getId());
		}
		datas = managerBul.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		System.out.println("EdtBulletinRSImpl.generateBulletin() Buletin dejà generé trouvée "+datas);
		if (datas == null || datas.isEmpty()|| datas.size()==0) {
			container = new RestrictionsContainer();
			List<BulletinHelperGenerate> listNote = new ArrayList<BulletinHelperGenerate>();
			List<Inscription> inscritClasse = new ArrayList<Inscription>();
			List<Examen> examenlist = critere.getModel().getSequence();
			container = new RestrictionsContainer();
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			inscritClasse = managerinscrit.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			System.out.println("EdtBulletinRSImpl.generateBulletin() nombre eleve de la classe ============== "+inscritClasse.size());
			if(inscritClasse==null||inscritClasse.isEmpty()){
				throw new KerenExecption("Aucun Eleve inscrit dans la classe choisit !!!");
			}
			
			for(Inscription inscrit : inscritClasse){
				Bulletin bulletin = new Bulletin();
				List<LigneBulletinClasse> lignelist = new ArrayList<LigneBulletinClasse>();
				container = new RestrictionsContainer();
				for (Examen examen : examenlist) {
					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}
					if (critere.getModel() != null) {
						container.addEq("matiere.examen.id", examen.getId());
					}
					System.out.println("EdtBulletinRSImpl.generateBulletin()   Debut Traitement Bulettin eleve===== "+inscrit.getEleve().getNom());

					container.addEq("eleve.id", inscrit.getEleve().getId());
					listNote = managerHelper.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
					System.out.println("EdtBulletinRSImpl.generateBulletin()  notes enregistrées pour eleve==== "+inscrit.getEleve().getNom()+" est de ===" +listNote.size());
					if (listNote != null ||listNote.size()!=0) {

						for (BulletinHelperGenerate h : listNote) {
							 bulletin = new Bulletin(h, critere.getModel());
							LigneBulletinClasse ligne = new LigneBulletinClasse();
							ligne= new LigneBulletinClasse(h);
							ligne.setId(-1);
							lignelist.add(ligne);
						}// fin for (BulletinHelperGenerate h : listNote)
						
					}//fin if (listNote != null || !listNote.isEmpty())
				}//fin for (Examen examen : examenlist)
				bulletin.setId(-1);
				bulletin.setLignes(lignelist);
				managerBul.save(bulletin);
				System.out.println("EdtBulletinRSImpl.generateBulletin()  Fin Traitement Bulettin eleve============= "+inscrit.getEleve().getNom());
			}//fin for(Inscription inscrit : inscritClasse)
			
		}//if (datas == null || datas.isEmpty())
	}

}
