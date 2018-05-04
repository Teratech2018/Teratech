
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.AnneScolaire;
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
	protected EcheancierDltDAOLocal daoecheance;

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
		Classe classe = CacheMemory.getClasse();

		RestrictionsContainer container = RestrictionsContainer.newInstance();

		if (classe != null) {
			container.addEq("eleve.classe.id", classe.getId());
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
		for (FichePaiement fiche : data.getService()) {
			result.getService().add(new FichePaiement(fiche));
		}

		for (Paiement paie : data.getPaiement()) {
			result.getPaiement().add(new Paiement(paie));
		}
		Echeancier echier = new Echeancier();
		for (Echeancier ech : data.getEcheance()) {
			echier = new Echeancier(ech);
			for (EcheancierDlt echdlt : ech.getEcheancedtl()) {
				echier.getEcheancedtl().add(new EcheancierDlt(echdlt));
			}
			result.getEcheance().add(echier);
		}
		// recherche des paiement ou echeance en retard
		result.setRetard(this.getRetardPaiement(data));;
		
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
	//	entity = this._afterSaveOperation(entity);
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(Reglement entity) {
		entity = this._afterUpdateOperation(entity);

		// Update solde
		
		// update caisse
		
		super.processBeforeUpdate(entity);
	}

//	private Reglement _afterSaveOperation(Reglement entity) {
//		List<FichePaiement> listFp = new ArrayList<FichePaiement>();
//		List<Echeancier> echeance = new ArrayList<Echeancier>();
//		Long scolarite = new Long(0);
//		Long payer = new Long(0);
//		Long solde = new Long(0);
//		Long total = new Long(0);
//		Double tva = new Double(0);
//		Double remise = new Double(0);
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		container.addEq("connected", true);
//		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0, -1);
//		if (annee == null || annee.size() == 0) {
//			RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
//			throw new WebApplicationException(excep, Response.Status.NOT_MODIFIED);
//		}
//		entity.setAnneScolaire(annee.get(0).getCode());
//
//		for (FichePaiement fp : entity.getService()) {
//			total = fp.getzQte() * fp.getzMntHt();
//			if (fp.getZtva() != null && fp.getZtva() != new Long(0)) {
//				tva = (fp.getZtva().doubleValue() / 100 * total);
//			}
//			if (fp.getZremise() != null && fp.getZremise() != new Long(0)) {
//				remise = (fp.getZremise().doubleValue() / 100 * total);
//			}
//			total = (total + tva.longValue()) - remise.longValue();
//			fp.setEleve(entity.getEleve());
//			fp.setZtotal(total);
//			scolarite = scolarite + fp.getZtotal();
//			listFp.add(fp);
//		}
//		for (Paiement p : entity.getPaiement()) {
//			payer = payer + p.getzMnt();
//			// mouvementer la caisse pour chaque paiement
//			Caisse caisse = new Caisse(p);
//			daocaisse.save(caisse);
//		}
//		// gestion des echeance
//		Long montantEch = (long) 0;
//		for (Echeancier ech : entity.getEcheance()) {
//			for (EcheancierDlt echdlt : ech.getEcheancedtl()) {
//				montantEch = montantEch + echdlt.getMnt();
//			}
//			ech.setMnttotal(montantEch);
//			ech.setEcheancedtl(ech.getEcheancedtl());
//			echeance.add(ech);
//		}
//		solde = scolarite - payer;
//		entity.setScolarite(scolarite);
//		entity.setService(listFp);
//		entity.setEcheance(echeance);
//		entity.setPayer(payer);
//		entity.setSolde(solde);
//		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
//		ins.setzMntPaye(entity.getPayer());
//		ins.setzMnt(entity.getScolarite());
//		ins.setzSolde(entity.getSolde());
//		daoIns.update(ins.getId(), ins);
//
//		return entity;
//
//	}

	private Reglement _afterUpdateOperation(Reglement entity) {
		List<FichePaiement> listFp = new ArrayList<FichePaiement>();
		List<Echeancier> echeance = new ArrayList<Echeancier>();
		List<Caisse> caisselist = new ArrayList<Caisse>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		Long payer = new Long(0);
		Long oldsolde = new Long(0);
		Long newsolde = new Long(0);
		
		List<EcheancierDlt> listechdlt = new ArrayList<EcheancierDlt>();
		List<Echeancier> listech = new ArrayList<Echeancier>();
		Long scolarite = new Long(0);;
		Long solde = new Long(0);
		Long total = new Long(0);
		Double tva = new Double(0);
		Double remise = new Double(0);
		String annee = CacheMemory.getCurrentannee();
		if (annee == null) {
			RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
			throw new WebApplicationException(excep, Response.Status.NOT_MODIFIED);
		}
		entity.setAnneScolaire(annee);

		for (FichePaiement fp : entity.getService()) {
			total = fp.getzQte() * fp.getzMntHt();
			if (fp.getZtva() != null && fp.getZtva() != new Long(0)) {
				tva = (fp.getZtva().doubleValue() / 100 * total);
			}
			if (fp.getZremise() != null && fp.getZremise() != new Long(0)) {
				remise = (fp.getZremise().doubleValue() / 100 * total);
			}
			total = (total + tva.longValue()) - remise.longValue();
			fp.setEleve(entity.getEleve());
			fp.setZtotal(total);
			scolarite = scolarite + fp.getZtotal();
			listFp.add(fp);
		}
		
//		for(Paiement p :entity.getPaiement()){
//
//			payer = payer + p.getzMnt();
//			// mouvementer la caisse pour chaque paiement
//			
//			container = RestrictionsContainer.newInstance();
//			container.addEq("paiement.id", p.getId());
//			caisselist = daocaisse.filter(container.getPredicats(), null, null, 0, -1);
//			System.out.println("ReglementManagerImpl._updateMontant() caisse trouvées"+caisselist);
//			if (caisselist == null||caisselist.isEmpty()) {
//				System.out.println("ReglementManagerImpl._updateMontant() i want to save opération de  caisse");
//				Caisse caisse = new Caisse(p);
//				daocaisse.save(caisse);
//			} else {
//				for (Caisse c : caisselist) {
//					daocaisse.update(c.getId(), c);
//				}
//			}
//		}
//		
		// gestion des echeance
		Long montantEch = (long) 0;
		for (Echeancier ech : entity.getEcheance()) {
			for (EcheancierDlt echdlt : ech.getEcheancedtl()) {
				montantEch = montantEch + echdlt.getMnt();
			}
			ech.setMnttotal(montantEch);
			ech.setEcheancedtl(ech.getEcheancedtl());
			ech.setZnbreEch((long) ech.getEcheancedtl().size());
			echeance.add(ech);

		}
		// GESTION DES SOLDESS
	
		solde = scolarite - payer;
		entity.setScolarite(scolarite);
		entity.setService(listFp);
		entity.setEcheance(echeance);
		entity.setPayer(payer);
		entity.setSolde(solde);
		
	
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		ins.setzMntPaye(entity.getPayer());
		ins.setzMnt(entity.getScolarite());
		ins.setzSolde(entity.getSolde());
		daoIns.update(ins.getId(), ins);
		
//		this._updateMontant(entity);
		
	
		
//		for (Paiement p : entity.getPaiement()) {
//			payer = payer + p.getzMnt();
//			// mouvementer la caisse pour chaque paiement
//			Caisse caisse = new Caisse(p);
//			daocaisse.save(caisse);
//		}

		return entity;

	}
	
	private Reglement _updateMontant(Reglement entity){
		Long payer = new Long(0);
		Long oldsolde = new Long(0);
		Long newsolde = new Long(0);
		
		List<EcheancierDlt> listechdlt = new ArrayList<EcheancierDlt>();
		List<Echeancier> listech = new ArrayList<Echeancier>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		System.out.println("ReglementManagerImpl._updateMontant() paiement is "+entity.getPaiement().size());
		for (Paiement p : entity.getPaiement()) {
			
			System.out.println("ReglementManagerImpl._updateMontant() paiement is "+p.getzMntverser());
			// update montant payer fiche paie
			oldsolde = new Long(0);
			newsolde = new Long(0);
			p.getService().setMntpayer(p.zMntverser);
			oldsolde= p.getService().getSolde();
			newsolde=oldsolde+p.zMntverser ;
			p.getService().setSolde(newsolde);
			entity.getPaiement().add(p);
			
			// update montant payer echeance
			if(p.getEcheancedlt()!=null){
				
				for(Echeancier ech : entity.getEcheance()){
					for(EcheancierDlt echdlt : ech.getEcheancedtl()){
						if(p.getEcheancedlt().getId()==echdlt.getId()){
							echdlt.setMntpayer(p.getzMntverser());
							oldsolde = new Long(0);
							oldsolde= echdlt.getSolde();
							newsolde = new Long(0);
							newsolde= oldsolde+p.getzMntverser();
							echdlt.setSolde(newsolde);
						}
						listechdlt.add(echdlt);
						ech.setEcheancedtl(listechdlt);
					}
					listech.add(ech);
				}
				entity.setEcheance(listech);
			}
			

		}
		return entity;
	}

	@Override
	public List<Retard> getRetardPaiement(Reglement entity) {
		List<Retard> retards = new ArrayList<Retard>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (entity != null) {
			container.addEq("eleve.id", entity.getEleve().getId());
		}
		List<FichePaiement> ficheP = daofp.filter(container.getPredicats(), null, null, 0, -1);

		if (ficheP != null) {
			for (FichePaiement fiche : ficheP) {
				container = RestrictionsContainer.newInstance();
				container.addEq("fiche.id", fiche.getId());
				container.addLe("dateEch", new Date());
				container.addNotEq("solde", new Long(0));
				List<EcheancierDlt> listech = daoecheance.filter(container.getPredicats(), null, null, 0, -1);
				if (listech != null && listech.size() > 0) {
					for (EcheancierDlt eche : listech) {
						retards.add(new Retard(eche));
					}
				} else if ((listech == null || listech.isEmpty())
						&&( fiche.getService().getDelai().before(new Date())
						&& fiche.getSolde()!=new Long(0))) {
					retards.add(new Retard(fiche));
				}

			}
		}
		return retards;
	}

}
