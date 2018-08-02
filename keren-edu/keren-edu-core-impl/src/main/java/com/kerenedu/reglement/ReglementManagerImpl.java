
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Date;
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
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReglementManager")
public class ReglementManagerImpl extends AbstractGenericManager<Reglement, Long>
		implements ReglementManagerLocal, ReglementManagerRemote {

	@EJB(name = "ReglementDAO")
	protected ReglementDAOLocal dao;

	@EJB(name = "AnneScolaireDAO")
	protected AnneScolaireDAOLocal annedao;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoIns;

	@EJB(name = "CaisseDAO")
	protected CaisseDAOLocal daocaisse;

	@EJB(name = "FichePaiementDAO")
	protected FichePaiementDAOLocal daofp;

	@EJB(name = "EcheancierDltDAO")
	protected EcheancierDltDAOLocal daoecheancedlt;

	@EJB(name = "EcheancierDAO")
	protected EcheancierDAOLocal daoecheance;
	
	@EJB(name = "PaiementDAO")
	protected PaiementDAOLocal daopaiement;

	public ReglementManagerImpl() {
	}

	@Override
	public GenericDAO<Reglement, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Reglement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Reglement> listrglt = new ArrayList<Reglement>();
		container.getPredicats().addAll(CriteriaFactory.defaultPredicats());
		if (CacheMemory.getClasse() != null) {
			container.addEq("eleve.classe.id", CacheMemory.getClasse().getId());
		}
		if (CacheMemory.getCurrentMatricule()!= null&&!CacheMemory.getCurrentMatricule().isEmpty()&&!CacheMemory.getCurrentMatricule().equals("")) {
			container.addEq("eleve.eleve.matricule",CacheMemory.getCurrentMatricule());
		}
		if (CacheMemory.getCurrentNameStudent()!= null&&!CacheMemory.getCurrentNameStudent().isEmpty()&&!CacheMemory.getCurrentNameStudent().equals("")) {
			container.addEq("eleve.eleve.nom", CacheMemory.getCurrentNameStudent());
		}
		predicats.addAll(container.getPredicats());

		List<Reglement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Reglement> result = new ArrayList<Reglement>();
		for (Reglement elev : datas) {
			result.add(new Reglement(elev));
		}
		return result;
	}

	@Override
	public Reglement find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Reglement data = super.find(propertyName, entityID);
		Reglement result = new Reglement(data);
		CacheMemory.setReglement(data);
		CacheMemory.setIncription(data.getEleve());
//
//		for (FichePaiement fiche : data.getService()) {
//			result.getService().add(new FichePaiement(fiche));
//		}
		// set les service de l'eleve
		result.setService(this.getFichePaiement(data));
		// recherche des paiement éffectué
		result.setPaiement(this.getPaiement(data));
		// recherche des echéance éffectué
		//result.setEcheance(this.getEcheance(data));
		// recherche des paiement ou echeance en retard
		result.setRetard(this.getRetardPaiement(data));

		return result;

	}

	@Override
	public List<Reglement> findAll() {
		// TODO Auto-generated method stub
		List<Reglement> datas = super.findAll();
		List<Reglement> result = new ArrayList<Reglement>();
		for (Reglement elev : datas) {
			result.add(new Reglement(elev));
		}
		return result;
	}

	@Override
	public Reglement delete(Long id) {
		// TODO Auto-generated method stub
		Reglement elev = super.delete(id);
		return new Reglement(elev);
	}

	@Override
	public void processBeforeSave(Reglement entity) {
		// entity = this._afterSaveOperation(entity);
		entity.setAnneScolaire(CacheMemory.getCurrentannee());
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(Reglement entity) {
		entity = this._afterUpdateOperation(entity);
		super.processBeforeUpdate(entity);
	}

	@Override
	public void processAfterUpdate(Reglement entity) {
		// recherche de l'entite
		Reglement reglement = find("id", entity.getId());
		// Update solde
		this._updateSodle(reglement);
		// update caisse
		//this._mouvementCaise(reglement);
		super.processAfterUpdate(reglement);
	}

	private Reglement _afterUpdateOperation(Reglement entity) {
//		List<FichePaiement> listFp = new ArrayList<FichePaiement>();
//		List<Echeancier> echeance = new ArrayList<Echeancier>();
//		Long payer = new Long(0);Long scolarite = new Long(0);	Long solde = new Long(0);
//		Long total = new Long(0);Double tva = new Double(0);Double remise = new Double(0);
//		String annee = CacheMemory.getCurrentannee();
//		if (annee == null) {
//			RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
//			throw new WebApplicationException(excep, Response.Status.NOT_MODIFIED);
//		}
//		entity.setAnneScolaire(annee);
//
//		for (FichePaiement fp : entity.getService()) {
//			total = fp.getzQte() * fp.getzMntHt();
////			if (fp.getZtva() != null && fp.getZtva() != new Long(0)) {
////				tva = (fp.getZtva().doubleValue() / 100 * total);
////			}
////			if (fp.getZremise() != null && fp.getZremise() != new Long(0)) {
////				remise = (fp.getZremise().doubleValue() / 100 * total);
////			}
//			total = entity.getEleve().getzTotal();
//			//fp.setEleve(entity.getEleve());
//			fp.setZtotal(total);
//			scolarite = scolarite + fp.getZtotal();
//			fp.setAnneScolaire(annee);
//			listFp.add(fp);
//		}
//
//		
//		solde = scolarite - payer;
//		entity.setScolarite(scolarite);
//		entity.setService(listFp);
//		entity.setPayer(payer);
//		entity.setSolde(solde);

		return entity;

	}

	private void _updateSodle(Reglement entity) {

		Long oldsolde = new Long(0);Long newsolde = new Long(0);
		Long payer = new Long(0);Long solde = new Long(0);
//
//		// recherche de l'entite
//		Reglement reglement = find("id", entity.getId());
//		List<EcheancierDlt> listechdlt = new ArrayList<EcheancierDlt>();
//		List<Echeancier> listech = new ArrayList<Echeancier>();
//		Reglement rgl = new Reglement();
//		rgl = entity;
//		List<Paiement> listpaiement = new ArrayList<Paiement>();
//		System.out.println("ReglementManagerImpl._updateSodle() ECHEANCE ...."+rgl.getEcheance());
//		for (Paiement p : rgl.getPaiement()) {
//			Paiement paiement = new Paiement();
//			paiement = p;
//			// update montant payer fiche paie
//			oldsolde = (long) 0;
//			newsolde =(long) 0;
//			paiement.getService().setMntpayer(p.zMntverser);
//			oldsolde = paiement.getService().getSolde();
//			newsolde = oldsolde - p.zMntverser;
//			// get montant payer 
//			payer=payer+p.getzMntverser();
//		
//			//metre a jour les fiche de paiement 
//			
//			paiement.getService().setSolde(newsolde);
//			listpaiement.add(paiement);
//			// update echeancier
//			RestrictionsContainer container = RestrictionsContainer.newInstance();
//			container.addEq("service.id", paiement.getService().getId());
//			List<Echeancier> listecheance = daoecheance.filter(container.getPredicats(), null, null, 0, -1);
//			if(listecheance==null||listecheance.isEmpty()){
//				rgl.setEcheance(rgl.getEcheance());
//			}else{
//				for (Echeancier echeance : listecheance) {
//					Echeancier ech =daoecheance.findByPrimaryKey("id", echeance.getId());
//					ech.setMnttotal(ech.getMnttotal()+p.getzMntverser());
//					if (ech.getMnttotal() == ech.getZtotal()) {
//						for (EcheancierDlt echdlt : ech.getEcheancedtl()) {
//							echdlt.setState("Payé");
//							listechdlt.add(echdlt);
//						}
//						ech.getEcheancedtl().addAll(listechdlt);
//					}
//					listech.add(ech);
//				}
//				rgl.setEcheance(listech);
//			}
//
//		}
//		solde= rgl.getScolarite()-payer;
//		rgl.setPaiement(listpaiement);
//		
//		entity.setPayer(payer);
//		entity.setSolde(solde);
//		dao.update(rgl.getId(), rgl);
		// update inscription
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		ins.setzMntPaye(entity.getPayer());
		ins.setzMnt(entity.getScolarite());
		ins.setzSolde(entity.getSolde());
		daoIns.update(ins.getId(), ins);
	}



	@Override
	public List<Retard> getRetardPaiement(Reglement entity) {
		List<Retard> retards = new ArrayList<Retard>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		if (entity != null) {
//			container.addEq("eleve.id", entity.getEleve().getId());
//		}
		List<FichePaiement> ficheP = CacheMemory.getIncription().getService();//daofp.filter(container.getPredicats(), null, null, 0, -1);

		if (ficheP != null) {
			for (FichePaiement fiche : ficheP) {
//				container = RestrictionsContainer.newInstance();
//				container.addEq("idPaie", fiche.getId());
//				container.addLe("dateEch", new Date());
//				container.addNotEq("solde", new Long(0));
				List<EcheancierDlt> listech = new ArrayList<EcheancierDlt>();//daoecheancedlt.filter(container.getPredicats(), null, null, 0, -1);
				if (listech != null && listech.size() > 0) {
					for (EcheancierDlt eche : listech) {
					//	retards.add(new Retard(eche,fiche));
					}
				} else if ((listech == null || listech.isEmpty())
						& (fiche.getService().getDelai().before(new Date()) & fiche.getSolde() != new Long(0))) {
					retards.add(new Retard(fiche, CacheMemory.getIncription()));
				}

			}
		}
		return retards;
	}
	
	
	public List<ConsultationPaie> getPaiement(Reglement entity) {
		List<ConsultationPaie> datas = new ArrayList<ConsultationPaie>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
				container = RestrictionsContainer.newInstance();
				container.addEq("eleve.id", entity.getEleve().getId());
				List<Paiement> 	result = daopaiement.filter(container.getPredicats(), null, null, 0, -1);
				if (result != null && result.size() > 0) {
					for (Paiement eche : result) {
						datas.add(new ConsultationPaie(eche));
					}
				}

		return datas;
	}
	
	public List<FichePaiement> getFichePaiement(Reglement entity){
		List<FichePaiement> fiches = new ArrayList<FichePaiement>();
		Inscription eleve = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		for(FichePaiement fiche : eleve.getService()){
			fiches.add(new FichePaiement(fiche));
		}
		return fiches ;
	}
	
	public List<ConsultationEch> getEcheance(Reglement entity) {
		List<ConsultationEch> datas = new ArrayList<ConsultationEch>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
				container = RestrictionsContainer.newInstance();
				container.addEq("eleve.id", entity.getEleve().getId());
				List<Echeancier> 	result = daoecheance.filter(container.getPredicats(), null, null, 0, -1);
				if (result != null && result.size() > 0) {
					for (Echeancier eche : result) {
						datas.add(new ConsultationEch(eche));
					}
				}

		return datas;
	}


}
