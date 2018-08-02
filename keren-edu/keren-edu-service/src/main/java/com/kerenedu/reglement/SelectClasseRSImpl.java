
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.school.Eleve;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Wed Jan 31 17:41:20 CET 2018
 * 
 */
@Path("/selectclasse")
public class SelectClasseRSImpl extends AbstractGenericService<SelectClasse, Long> implements SelectClasseRS {

	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote manager;

	@Manager(application = "kereneducation", name = "ReglementManagerImpl", interf = ReglementManagerRemote.class)
	protected ReglementManagerRemote managerrglt;

	@Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
	protected InscriptionManagerRemote managerIns;

	public SelectClasseRSImpl() {
		super();
	}

	/**
	 * Methode permettant de retourner le gestionnaire d'entites
	 * 
	 */
	@Override
	public GenericManager<SelectClasse, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return ("kereneducation");
	}

	@Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			return MetaDataUtil.getMetaData(new SelectClasse(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SelectClasse update(@Context HttpHeaders headers,Long id, SelectClasse entity) {
		CacheMemory.setClasse(entity.getClasse());
		return entity; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public SelectClasse save(@Context HttpHeaders headers,SelectClasse entity) {
		CacheMemory.setClasse(entity.getClasse());
		CacheMemory.setCurrentMatricule(entity.getMatricule());
		CacheMemory.setCurrentNameStudent(entity.getNom());

		this.createReglement(entity);
		return entity;
	}

	private void createReglement(SelectClasse classe) {
		List<Inscription> datas = new ArrayList<Inscription>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Reglement> listrglt = new ArrayList<Reglement>();
		container.getPredicats().addAll(CriteriaFactory.defaultPredicats());

		System.out.println("SelectClasseRSImpl.createReglement() value " + CacheMemory.getCurrentannee() + " nom"
				+ classe.getNom() + " matricule " + classe.getMatricule());
		if (classe.getClasse() != null) {
			container.addEq("classe.id", classe.getClasse().getId());
		}
		if (classe.getMatricule()!= null&&!classe.getMatricule().isEmpty()&&!classe.getMatricule().equals("")) {
			System.out.println("SelectClasseRSImpl.createReglement()Matricule renseigné "+classe.getMatricule());
			container.addEq("eleve.matricule", classe.getMatricule());
		}
		if (classe.getNom()!= null&&!classe.getNom().isEmpty()&&!classe.getNom().equals("")) {
			container.addEq("eleve.nom", classe.getNom());
		}
//		if (classe.getNom() != null || !classe.getNom().equals("")) {
//			container.addEq("eleve.matricule", classe.getNom());
//		}
//		if (classe.getMatricule() != null || !classe.getMatricule().equals("")) {
//			container.addEq("eleve.nom", classe.getMatricule());
//		}

		datas = manager.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		System.out.println("SelectClasseRSImpl.createReglement() Nombre Inscrits ....." + datas.size());
		if (datas != null) {
			for (Inscription ins : datas) {
				container = RestrictionsContainer.newInstance();
				container.addEq("eleve.id", ins.getId());
				listrglt = managerrglt.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				System.out.println("SelectClasseRSImpl.createReglement() reglement trouvé is" + listrglt);
				if (listrglt == null || listrglt.isEmpty()) {
					Reglement rglmt = new Reglement(ins);
					rglmt.setId(-1);
					managerrglt.save(rglmt);
				}

			}
		}
	}

}
