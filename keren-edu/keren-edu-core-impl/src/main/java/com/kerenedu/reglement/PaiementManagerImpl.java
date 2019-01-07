
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PaiementManager")
public class PaiementManagerImpl extends AbstractGenericManager<Paiement, Long>
		implements PaiementManagerLocal, PaiementManagerRemote {

	@EJB(name = "PaiementDAO")
	protected PaiementDAOLocal dao;

	@EJB(name = "CaisseDAO")
	protected CaisseDAOLocal daocaisse;

	@EJB(name = "ReglementDAO")
	protected ReglementDAOLocal daorgl;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoIns;

	@EJB(name = "FichePaiementDAO")
	protected FichePaiementDAOLocal daoFiche;

	public PaiementManagerImpl() {
	}

	@Override
	public GenericDAO<Paiement, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Paiement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {

		List<Paiement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Paiement> result = new ArrayList<Paiement>();
		for (Paiement elev : datas) {
			Paiement p = new Paiement(elev);
			if (elev.service != null) {
				p.service = new FichePaiement(elev.service);
				p.zMntservice = elev.service.getZtotal();
				//p.zsolde = (elev.service.getZtotal() - elev.zMntverser);
			}
			result.add(p);
		}
		return result;
	}

	@Override
	public Paiement find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Paiement data = super.find(propertyName, entityID);
		Paiement result = new Paiement(data);
		if (data.service != null) {
			result.service = new FichePaiement(data.service);
			result.zMntservice = data.service.getZtotal();
			//result.zsolde = (data.service.getZtotal() - data.zMntverser);
		}

		return result;

	}

	@Override
	public List<Paiement> findAll() {
		// TODO Auto-generated method stub
		List<Paiement> datas = super.findAll();
		List<Paiement> result = new ArrayList<Paiement>();
		for (Paiement elev : datas) {
			result.add(new Paiement(elev));
		}
		return result;
	}

	@Override
	public Paiement delete(Long id) {
		// TODO Auto-generated method stub
		Paiement elev = super.delete(id);
		return new Paiement(elev);
	}

	@Override
	public Paiement save(Paiement entity) {
		// TODO Auto-generated method stub
		Inscription inscription = entity.getEleve();
		inscription = daoIns.findByPrimaryKey("id", inscription.getId());
		long montantsaisie = entity.getzMntverser();
		long montanttotalverser = entity.getzMntverser() + entity.getZremise() + entity.getZristourne();
		entity.setAnneScolaire(inscription.getAnneScolaire());
		PaiementWorker worker = buildWorker(inscription);
		worker.setMontant(montanttotalverser);
		worker.compute();
		// mias à jour de l'inscription
		this._updateInscription(entity,inscription);
	//	System.out.println("PaiementManagerImpl.processAfterSave() update inscription ok ");
		// mis à jour des fiche de paiement
		this._updateReglement_new(entity);
		return super.save(entity);
	}

	@Override
	public Paiement update(Long id, Paiement entity) {
		return super.update(id, entity);
	}
	
	@Override
	public Paiement annuler(Paiement entity) {
		Inscription inscription = entity.getEleve();
		inscription = daoIns.findByPrimaryKey("id", inscription.getId());
		long montanttotalverser = entity.getzMntverser() + entity.getZremise() + entity.getZristourne();
		entity.setzMntverser(-entity.getzMntverser());
		entity.setState("annulé");
		entity.setZremise(-entity.getZremise());
		entity.setZristourne(-entity.getZristourne());
		// update fiche
		PaiementWorker worker = buildWorkerInverse(inscription);
		System.out.println("PaiementManagerImpl.update() montant worker inverse "+montanttotalverser);
		worker.setMontant(montanttotalverser);
		worker.inversecompute();
		// mis à jour de l'inscription
		this._apupdateInscription(entity,inscription);
		System.out.println("PaiementManagerImpl.processAfterSave() update inscription ok ");
		// mis à jour des fiche de paiement
		this._apupdateReglement_new(entity);
		this.update(entity.getId(), entity);
		return entity;
	}

	private PaiementWorker buildWorker(Inscription insc) {
		Map<Integer, FichePaiement> map = new HashMap<Integer, FichePaiement>();
		for (FichePaiement fiche : insc.getService()) {
			if(fiche.getService().getExige()==true){
				map.put(fiche.getService().getRang(), fiche);
			}
			
		}
		List<Integer> keys = new ArrayList<Integer>();
		for (int key : map.keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);
		int plage = keys.size() - 1;
		PaiementWorker work0 = null;
		int key = plage;
		while (key >= 0) {
			if (key == plage) {
				work0 = new PaiementWorker(map.get(keys.get(key)), insc, null);
				System.out.println("PaiementManagerImpl.buildWorker() key valuer 0" + keys.get(key));
				System.out.println(
						"PaiementManagerImpl.buildWorker() map valuer 0" + map.get(keys.get(key)) + "map " + map);
			} else {
				PaiementWorker work = new PaiementWorker(map.get(keys.get(key)), insc, work0);
				work0 = work;
			} // end if(key==plage-1){
			key = key - 1;
		} // end for(int key=plage;key>=0;key--){
		return work0;
	}

	private PaiementWorker buildWorkerInverse(Inscription insc) {
		Map<Integer, FichePaiement> map = new HashMap<Integer, FichePaiement>();
		for (FichePaiement fiche : insc.getService()) {
			if(fiche.getService().getExige()==true){
				map.put(fiche.getService().getRang(), fiche);
			}
		}
		List<Integer> keys = new ArrayList<Integer>();
		for (int key : map.keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);
		PaiementWorker work0 = null;
		for (int key = 0; key < keys.size(); key++) {
			if (key == 0) {
				work0 = new PaiementWorker(map.get(keys.get(key)), insc, null);
				// System.out.println("PaiementManagerImpl.buildWorker() key
				// valuer 0"+keys.get(key));
				// System.out.println("PaiementManagerImpl.buildWorker() map
				// valuer 0"+map.get(keys.get(key))+"map "+map);
			} else {
				PaiementWorker work = new PaiementWorker(map.get(keys.get(key)), insc, work0);
				work0 = work;
			} // end if(key==plage-1){

		} // end for(int key=plage;key>=0;key--){
		return work0;
	}

	@Override
	public void processAfterSave(Paiement entity) {
		Paiement p = dao.findByPrimaryKey("id", entity.getId());
		p.setCode(p.getEleve().getEleve().getMatricule() + "/" + p.getId() + "/" + entity.getAnneScolaire());
		p.setMatricule(entity.getEleve().getMatricule());
		p.setNom(entity.getEleve().getNom());
		p.setClasse(entity.getEleve().getClasse().getLibelle());
		dao.update(p.getId(), p);
		this._mouvementCaise(p);
		super.processAfterSave(entity);
	}
	
	@Override
	public void processAfterUpdate(Paiement entity) {
		Paiement p = dao.findByPrimaryKey("id", entity.getId());
		dao.update(p.getId(), p);
		this._apmouvementCaise(p);
		super.processAfterSave(entity);
	}

	private void _mouvementCaise(Paiement entity) {
		System.out.println("========= début mouvement de caisse ======");
		Caisse caisse = new Caisse();
		caisse = new Caisse(entity);
		caisse.setAnneScolaire(entity.getAnneScolaire());
		caisse = daocaisse.save(caisse);

	}

	private void _apmouvementCaise(Paiement entity) {
		System.out.println("========= annuler  mouvement de caisse ======");
		Caisse caisse = new Caisse(entity, "");
		caisse.setAnneScolaire(entity.getAnneScolaire());
		daocaisse.save(caisse);
	}

	private void _updateReglement_new(Paiement entity) {
		List<Reglement> rglt = daorgl.findByProperty("eleve", entity.getEleve());
		Reglement reglement = new Reglement();
		if (rglt == null || rglt.size() == 0) {
			Reglement rglmt = new Reglement(entity.getEleve());
			rglmt.setId(-1);
			rglmt.setAnneScolaire(entity.getEleve().getAnneScolaire());
			reglement = daorgl.save(rglmt);
		} else {
			reglement = rglt.get(0);
			CacheMemory.setReglement(reglement);
		}
		Long oldPayer = reglement.getPayer();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = reglement.getScolarite() - entity.getZremise() - entity.getZristourne() - newPayer;
		reglement.setPayer(newPayer);
		reglement.setSolde(solde);

		daorgl.update(reglement.getId(), reglement);
	}

	// annulation d'un paiement
	private void _apupdateReglement_new(Paiement entity) {
		List<Reglement> rglt = daorgl.findByProperty("eleve", entity.getEleve());
		Reglement reglement = new Reglement();
		if (rglt != null || rglt.size() != 0) {
			reglement = rglt.get(0);
			CacheMemory.setReglement(reglement);
			Long oldPayer = reglement.getPayer();
			Long newPayer = entity.getzMntverser() + oldPayer;
			Long solde = reglement.getScolarite() - newPayer;
			reglement.setPayer(newPayer);
			reglement.setSolde(solde);
			daorgl.update(reglement.getId(), reglement);
		}
	}

	private void _updateInscription(Paiement entity, Inscription inscription) {
		// Inscription ins = entity.getEleve();
		Inscription ins =inscription;//daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		Long oldPayer = (long) 0;
		oldPayer = ins.getzMntPaye();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = ins.getzMnt() - entity.getZremise() - entity.getZristourne() - newPayer;
		ins.setzMntPaye(newPayer);
		ins.setzSolde(solde);
		ins.setzRemise(inscription.getzRemise()+entity.getZremise());
		ins.setzRistourne(inscription.getzRistourne()+entity.getZristourne());
		daoIns.update(ins.getId(), ins);
	}

	// traitemnt annulation paiement
	private void _apupdateInscription(Paiement entity, Inscription inscription) {
		// Inscription ins = entity.getEleve();
//		Inscription ins = //daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		Inscription ins = inscription;
		Long oldPayer = ins.getzMntPaye();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = ins.getzMnt() - newPayer;
		ins.setzMntPaye(newPayer);
		ins.setzSolde(solde);
		ins.setzRemise(ins.getzRemise() + entity.getZremise());
		ins.setzRistourne(ins.getzRistourne() + entity.getZristourne());
		daoIns.update(ins.getId(), ins);
	}

	public List<FichePaiement> getFicheEleve(Inscription entity) {
		System.out.println("PaiementManagerImpl.getFicheEleve() eleve select " + entity.getEleve().getMatricule());
		List<FichePaiement> datas = new ArrayList<FichePaiement>();
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getId());
		System.out.println("PaiementManagerImpl.getFicheEleve() fiche trouvé is " + ins.getService().size());
		for (FichePaiement fiche : ins.getService()) {
			if (fiche.getPayer() == false) {
				datas.add(fiche);
			}
		}
		Collections.sort(datas);
		return datas;
	}

	@Override
	public List<Paiement> getCriteres(Paiement critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		System.out.println("PaiementManagerImpl.getCriteres() je suis ici////" + critere.getEleve());
		if (critere != null) {
			container.addEq("state", "etabli");
			if (critere.getEleve() != null) {
				container.addEq("eleve.id", critere.getEleve().getId());
			}
		}
		List<Paiement> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<Paiement> result = new ArrayList<Paiement>();
		if (datas != null) {
			for (Paiement bull : datas) {
				Paiement newBull = find("id", bull.getId());
				Inscription ins = daoIns.findByPrimaryKey("id", bull.getEleve().getId());
				newBull.setLignes(new ArrayList<FichePaiement>());
				newBull.setLignes(ins.getService());
				System.out.println("PaiementManagerImpl.getCriteres() list " + newBull.getLignes());
				result.add(newBull);
			}
		} // fin if(datas!=null)
		return result;
	}

	class PaiementWorker {
		private FichePaiement tranche;

		private Inscription inscription;

		private PaiementWorker next;

		private Long montant;

		/**
		 * 
		 * @param tranche
		 * @param inscription
		 */

		public PaiementWorker(FichePaiement tranche, Inscription inscription, PaiementWorker next) {
			super();
			this.tranche = tranche;
			this.inscription = inscription;
			this.next = next;
		}

		public PaiementWorker getNext() {
			return next;
		}

		public void setNext(PaiementWorker next) {
			this.next = next;
		}

		public Long getMontant() {
			return montant;
		}

		public void setMontant(Long montant) {
			this.montant = montant;
		}

		public FichePaiement getTranche() {
			return tranche;
		}

		public void setTranche(FichePaiement tranche) {
			this.tranche = tranche;
		}

		public Inscription getInscription() {
			return inscription;
		}

		public void setInscription(Inscription inscription) {
			this.inscription = inscription;
		}

		public PaiementWorker inversecompute() {
			
			if (tranche.getMntpayer() > 0) {
				System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis ici "+montant);
				if (montant >= tranche.getMntpayer()) { // montant>>
					long reste = montant - tranche.getMntpayer();
					System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis ici +++++"+montant);
					tranche.subtractMontant(tranche.getMntpayer());
					tranche.setPayer(Boolean.FALSE);
					if (next == null) {
						return this;
					} else {
						System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis reste "+reste);
						next.setMontant(reste);
						return next.inversecompute();
					}
				} else {
					if (montant >0 && montant < tranche.getMntpayer()) {
						tranche.subtractMontant(montant);
						tranche.setPayer(Boolean.FALSE);
						return this;
					} else {
						return this;
					}
				}
			} else {
				if (next == null) {
					return this;
				} else {
					System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis reste "+montant);
					next.setMontant(montant);
					return next.inversecompute();
				}
			}
		}

		/**
		 * 
		 * @return
		 */
		public PaiementWorker compute() {
			if (tranche.getSolde() == 0) {// Solde
				if (next == null)
					return this;
				else {
					next.setMontant(montant);
					return next.compute();
				}
			} else {// solde>0
				if (tranche.getSolde() > montant) {
					tranche.addMontant(montant);
					return this;
				} else {
					long reste = montant - tranche.getSolde();
					tranche.addMontant(tranche.getSolde());
					tranche.setAnneScolaire(inscription.getAnneScolaire());
					tranche.setPayer(Boolean.TRUE);
					if (next == null)
						return this;
					else {
						next.setMontant(reste);
						return next.compute();
					}
				} // end if(tranche.getSolde()>montant){
			}
		}
	}

	
}
