
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Collections;
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
import com.kerem.commons.DateHelper;
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
		// TODO Auto-generated method stub
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		container.getPredicats().addAll(CriteriaFactory.defaultPredicats());
//		container.addEq("state", "etabli");
//		if (CacheMemory.getClasse() != null) {
//			container.addEq("eleve.classe.id", CacheMemory.getClasse().getId());
//		}
//		if (CacheMemory.getCurrentMatricule() != null && !CacheMemory.getCurrentMatricule().isEmpty()
//				&& !CacheMemory.getCurrentMatricule().equals("")) {
//			container.addEq("eleve.eleve.matricule", CacheMemory.getCurrentMatricule());
//		}
//		if (CacheMemory.getCurrentNameStudent() != null && !CacheMemory.getCurrentNameStudent().isEmpty()
//				&& !CacheMemory.getCurrentNameStudent().equals("")) {
//			container.addEq("eleve.eleve.nom", CacheMemory.getCurrentNameStudent());
//		}
//		predicats.addAll(container.getPredicats());
		List<Paiement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Paiement> result = new ArrayList<Paiement>();
		for (Paiement elev : datas) {
			result.add(new Paiement(elev));
		}
		return result;
	}

	@Override
	public Paiement find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Paiement data = super.find(propertyName, entityID);
		Paiement result = new Paiement(data);

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
		Paiement oldentity =entity ;
		List<FichePaiement> fiches = 	this.getFicheEleve(entity.getEleve());
		if (CacheMemory.getReglement() != null) {
			entity.setEleve(CacheMemory.getReglement().getEleve());
		}

		if (CacheMemory.getIncription() != null) {
			entity.setEleve(CacheMemory.getIncription());
		}
			long montantsaisie= entity.getzMntverser();
			long montanttotalverser= entity.getzMntverser()+entity.getZremise();
			System.out.println("PaiementManagerImpl.processAfterSave() update reglement o k ");
			System.out.println("PaiementManagerImpl.processBeforeSave()  montantsaisie"+montantsaisie);
			System.out.println("PaiementManagerImpl.processBeforeSave()  montanttotalverser ok"+montanttotalverser);
			
			System.out.println("PaiementManagerImpl.processBeforeSave() become update inscription and reglement ok"+entity.getEleve().getEleve().getMatricule());
			this._updateInscription(entity);
			System.out.println("PaiementManagerImpl.processAfterSave() update inscription ok ");
			// mis à jour des fiche de paiement
			this._updateReglement_new(entity);
			// caisse
			this._mouvementCaise(entity);

			System.out.println("PaiementManagerImpl.processBeforeSave()  nombre de service ===="+fiches.size());
		  int i =1;
		  if(fiches!=null&&fiches.size()>0){
			for(FichePaiement fp :fiches){
				
				System.out.println("PaiementManagerImpl.processBeforeSave() fiche numero ============= "+fp.getService().getRang());
				long diff= montanttotalverser- fp.getSolde();
				System.out.println("PaiementManagerImpl.processBeforeSave()  valeur difference ok"+diff);
				if(diff>=0){
					System.out.println("PaiementManagerImpl.save() cas 1++++ la diff est >= 0"+diff);
					entity.setzMntverser(fp.getSolde());
					Paiement p = new Paiement(fp, entity);
					p.setAnneScolaire(entity.getEleve().getAnneScolaire());
					p.setId(-1);
					dao.save(p);
					this._updatefiche(fp, entity,1);
					System.out.println("PaiementManagerImpl.processBeforeSave()=========  update fiche ok");
					montanttotalverser =diff;
				}else if(diff<0&&montanttotalverser!=0){
					System.out.println("PaiementManagerImpl.save() cas 2+++++ la diff est< 0 et mnt verser !=0 "+diff+" mnt versr"+montanttotalverser);
					long payernow = fp.getMntpayer()+montanttotalverser;
					fp.setMntpayer(payernow);
					entity.setzMntverser(montanttotalverser);
					Paiement p = new Paiement(fp, entity);
					p.setId(-1);
					dao.save(p);
					this._updatefiche(fp, entity,2);
					break;
				}else{
					System.out.println("PaiementManagerImpl.save() cas 3 aucune traitement ");
					break;
				}
				System.out.println("PaiementManagerImpl.save() nombre de tour==== +++"+i);
				i++;
				
			}		
	
	    entity = dao.findByPrimaryKey("id", entity.getId());
		 }
			System.out.println("PaiementManagerImpl.processAfterSave() finish.... ");
		return entity;
	}


	
	private void _updatefiche(FichePaiement fp, Paiement entity, int position){
		Long oldPayer = (long) 0;	
		entity.setCode(entity.getEleve().getEleve().getMatricule() + "/" + entity.getId() + "/"+ DateHelper.convertToString(entity.getDatePaiement(), "dd/MM/yy"));
		entity.setAnneScolaire(entity.getEleve().getAnneScolaire());
		dao.update(entity.getId(), entity);
		dao.update(entity.getId(), entity);
		fp.setAnneScolaire(entity.getEleve().getAnneScolaire());
		if(position==2){
			Long newPayer = fp.getMntpayer() + oldPayer;
			Long solde = fp.getZtotal() - newPayer;
			fp.setMntpayer(newPayer);
			fp.setSolde(solde);
			if (solde == 0) {
				fp.setPayer(true);
			}
			daoFiche.update(fp.getId(), fp);
		}else{
			fp.setMntpayer(fp.getZtotal());
			fp.setSolde((long) 0);
			fp.setPayer(true);
			daoFiche.update(fp.getId(), fp);
		}
		
	}

//	private void afterSave(Paiement entity) {
//		System.out.println("PaiementManagerImpl.processAfterSave() je suis ici !!!" + entity.getService());
//		// set numero piece to paiement
//		entity.setCode(entity.getEleve().getEleve().getMatricule() + "/" + entity.getId() + "/"
//				+ DateHelper.convertToString(entity.getDatePaiement(), "dd/MM/yy"));
//		entity.setAnneScolaire(entity.getEleve().getAnneScolaire());
//		dao.update(entity.getId(), entity);
//		// mis a jous de la caisse
//		this._mouvementCaise(entity);
//
//		System.out.println("PaiementManagerImpl.processAfterSave() update table .update caisse ok .....");
//	//	this._updateFiche(entity);
//		System.out.println("PaiementManagerImpl.processAfterSave() update fiche ok ");
//
//	}


	@Override
	public void processBeforeUpdate(Paiement entity) {
		entity.setzMntverser(-entity.getzMntverser());
		entity.setState("annulé");
		super.processBeforeUpdate(entity);
	}

	@Override
	public void processAfterUpdate(Paiement entity) {
		// mis a jous de la caisse
		this._apmouvementCaise(entity);

		System.out.println("PaiementManagerImpl.processAfterUpdate() annulation table .update caisse ok .....");
		this._apupdateFiche(entity);
		System.out.println("PaiementManagerImpl.processAfterUpdate() annulation fiche ok ");

		this._apupdateInscription(entity);
		System.out.println("PaiementManagerImpl.processAfterUpdate() annulation inscription ok ");

		// mis à jour des fiche de paiement
		this._apupdateReglement_new(entity);
		System.out.println("PaiementManagerImpl.processAfterUpdate() annulation reglement o k ");
		super.processBeforeUpdate(entity);
	}

	private void _mouvementCaise(Paiement entity) {
		System.out.println("========= début mouvement de caisse ======");
		Caisse caisse = new Caisse();
		Long payer = new Long(0);
		payer = entity.getzMntverser();
		caisse = new Caisse(entity);
		caisse.setAnneScolaire(entity.getAnneScolaire());
		caisse = daocaisse.save(caisse);

	}

	private void _apmouvementCaise(Paiement entity) {
		System.out.println("========= début mouvement de caisse ======");
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Caisse> caisselist = new ArrayList<Caisse>();
		Long payer = new Long(0);
		payer = entity.getzMntverser();
		// mouvementer la caisse pour chaque paiement

		container = RestrictionsContainer.newInstance();
		container.addEq("paiement", entity.getId());
		caisselist = daocaisse.filter(container.getPredicats(), null, null, 0, -1);
		System.out.println("========= Nombre caisse trouvées  =====" + caisselist);
		if (caisselist != null || !caisselist.isEmpty()) {
			Caisse caisse = new Caisse(entity, "");
			caisse.setAnneScolaire(entity.getAnneScolaire());
			daocaisse.save(caisse);
		}
		// } else {
		// for (Caisse c : caisselist) {
		// daocaisse.update(c.getId(), c);
		// }
		// }

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
		Long solde = reglement.getScolarite()-entity.getZremise() - newPayer;
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

//	private void _updateFiche(Paiement entity) {
//		// FichePaiement fiche = entity.getService();
//		if (entity.getModePaiement().equals("1")) {
//			System.out.println("PaiementManagerImpl._updateFiche() id service " + entity.getService().getId());
//			FichePaiement fichenew = daoFiche.findByPrimaryKey("id", entity.getService().getId());
//			Long oldPayer = (long) 0;
//			Long newPayer = entity.getzMntverser() + oldPayer;
//			Long solde = fichenew.getZtotal() - newPayer;
//			fichenew.setMntpayer(newPayer);
//			fichenew.setSolde(solde);
//			if (solde == 0) {
//				fichenew.setPayer(true);
//			}
//
//			daoFiche.update(fichenew.getId(), fichenew);
//		} else {
//			Inscription eleve = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
//			if (eleve != null) {
//				for (FichePaiement fichenew : eleve.getService()) {
//					fichenew.setMntpayer(fichenew.getZtotal());
//					fichenew.setSolde((long) 0);
//					fichenew.setPayer(true);
//					daoFiche.update(fichenew.getId(), fichenew);
//				}
//			}
//		}
//
//	}

	// traitement annulation du paiement
	private void _apupdateFiche(Paiement entity) {
		// FichePaiement fiche = entity.getService();
		FichePaiement fichenew = daoFiche.findByPrimaryKey("id", entity.getService().getId());
		System.out.println(
				"PaiementManagerImpl._updateFiche() service update  ====" + fichenew.getService().getDesignation());

		System.out.println("PaiementManagerImpl._updateFiche() montant regle  ==== " + entity.getzMntverser());
		Long oldPayer = fichenew.getMntpayer();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = fichenew.getZtotal() - newPayer;
		fichenew.setMntpayer(newPayer);
		fichenew.setSolde(solde);
		fichenew.setZremise((long) 0);
		if (solde == 0) {
			fichenew.setPayer(true);
		} else {
			fichenew.setPayer(false);
		}

		daoFiche.update(fichenew.getId(), fichenew);
	}

	private void _updateInscription(Paiement entity) {
		// Inscription ins = entity.getEleve();
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		Long oldPayer = (long) 0;
		System.out.println("PaiementManagerImpl._updateInscription() versement is "+entity.getzMntverser());
		oldPayer = ins.getzMntPaye();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = ins.getzMnt()-entity.getZremise() - newPayer;
		ins.setzMntPaye(newPayer);
		ins.setzSolde(solde);
		ins.setzRemise(entity.getZremise());
		daoIns.update(ins.getId(), ins);
	}

	// traitemnt annulation paiement
	private void _apupdateInscription(Paiement entity) {
		// Inscription ins = entity.getEleve();
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		Long oldPayer = ins.getzMntPaye();
		Long newPayer = entity.getzMntverser() + oldPayer;
		Long solde = ins.getzMnt() - newPayer;
		ins.setzMntPaye(newPayer);
		ins.setzSolde(solde);
		ins.setzRemise((long) 0);
		daoIns.update(ins.getId(), ins);
	}
	

	public List<FichePaiement>getFicheEleve(Inscription entity){
		System.out.println("PaiementManagerImpl.getFicheEleve() eleve select "+entity.getEleve().getMatricule());
		List<FichePaiement>datas = new ArrayList<FichePaiement>();
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getId());
		System.out.println("PaiementManagerImpl.getFicheEleve() fiche trouvé is "+ins.getService().size());
		for(FichePaiement fiche : ins.getService()){
			if(fiche.getPayer()==false){
				datas.add(fiche);
			}
		}
		Collections.sort(datas);
		return datas ;
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
			container.addEq("state", "etabli");
			// if (critere.getService() != null) {
			// container.addEq("service.id", critere.getService().getId());
			// }
		}
		List<Paiement> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<Paiement> result = new ArrayList<Paiement>();
		if (datas != null) {
			for (Paiement bull : datas) {
				Paiement newBull = find("id", bull.getId());
				result.add(newBull);
			}
		} // fin if(datas!=null)
		return result;
	}
}
