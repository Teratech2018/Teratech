
package com.kerenedu.reglement;

import java.util.ArrayList;
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
		// TODO Auto-generated method stub
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
	public void processBeforeSave(Paiement entity) {
		// recuperer la classe
		if(CacheMemory.getReglement()!=null){
			entity.setEleve(CacheMemory.getReglement().getEleve());
		}
		
		if(CacheMemory.getIncription()!=null){
			entity.setEleve(CacheMemory.getIncription());
		}
		entity.setAnneScolaire(CacheMemory.getCurrentannee());
		entity.setId(-1);
		System.out.println("PaiementManagerImpl.processBeforeSave() test Alpha a vous l'ecoute ....");

		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(Paiement entity) {
		
		// mis a jous de la caisse
		this._mouvementCaise(entity);
				
		System.out.println("PaiementManagerImpl.processAfterSave() update table .update caisse ok .....");
		this._updateFiche(entity);
		System.out.println("PaiementManagerImpl.processAfterSave() update fiche ok ");
		
		this._updateInscription(entity);
		System.out.println("PaiementManagerImpl.processAfterSave() update inscription ok ");
		
		// mis à jour des fiche de paiement
		this._updateReglement_new(entity);
		System.out.println("PaiementManagerImpl.processAfterSave() update reglement o k ");
		
		
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(Paiement entity) {
		// TODO Auto-generated method stub
		super.processAfterUpdate(entity);
	}

	private void _mouvementCaise(Paiement entity) {
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
		if (caisselist == null || caisselist.isEmpty()) {
			Caisse caisse = new Caisse(entity);
			caisse.setAnneScolaire(CacheMemory.getCurrentannee());
			daocaisse.save(caisse);
		} else {
			for (Caisse c : caisselist) {
				daocaisse.update(c.getId(), c);
			}
		}

	}
	
	private void _updateReglement_new(Paiement entity) {
		List<Reglement> rglt= daorgl.findByProperty("eleve", entity.getEleve());
		Reglement reglement = new Reglement();
		if(rglt==null){
			Reglement rglmt = new Reglement(entity.getEleve());
			rglmt.setId(-1);
			reglement= daorgl.save(rglmt);
		}else{
			reglement = rglt.get(0);
		}
		Long oldPayer = reglement.getPayer();
		Long newPayer = entity.getzMntverser()+oldPayer;
		Long solde = reglement.getScolarite()-newPayer;
		reglement.setPayer(newPayer);
		reglement.setSolde(solde);
		daorgl.update(reglement.getId(),reglement );
	}
	
	private void _updateFiche(Paiement entity){
		//FichePaiement fiche = entity.getService();
		FichePaiement fichenew = daoFiche.findByPrimaryKey("id", entity.getService().getId());
		System.out.println("PaiementManagerImpl._updateFiche() service update  ===="+fichenew.getService().getDesignation());
		
		System.out.println("PaiementManagerImpl._updateFiche() montant regle  ==== "+entity.getzMntverser());
		Long oldPayer = fichenew.getMntpayer();
		Long newPayer = entity.getzMntverser()+oldPayer;
		Long solde = fichenew.getZtotal()-newPayer;
		fichenew.setMntpayer(newPayer);
		fichenew.setSolde(solde);
		fichenew.setPayer(true);
		daoFiche.update(fichenew.getId(), fichenew);
	}
	
	private void _updateInscription(Paiement entity){
		//Inscription ins = entity.getEleve();
		Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
		Long oldPayer = ins.getzMntPaye();
		Long newPayer = entity.getzMntverser()+oldPayer;
		Long solde = ins.getzMnt()-newPayer;
		ins.setzMntPaye(newPayer);
		ins.setzSolde(solde);
		daoIns.update(ins.getId(), ins);
	}
	
	private void _updateReglement(Paiement entity) {
		System.out.println("========= début update reglement ======");
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		Long payer = new Long(0);	Long solde = new Long(0);Long newrpayer ;
		List<FichePaiement> listfp = new ArrayList<FichePaiement>();
		List<Reglement> datas = new ArrayList<Reglement>();
			payer = entity.getzMntverser();
			// mouvementer la caisse pour chaque paiement

			container = RestrictionsContainer.newInstance();
			//container.addEq("eleve.id", entity.getService().getEleve().getId());
			datas = daorgl.filter(container.getPredicats(), null, null, 0, -1);
			System.out.println("========= Nombre de regelement" + datas);
			if (datas != null &&datas.size()>0) {
				Reglement r = datas.get(0);
				for (FichePaiement fiche : r.getService()) {
					if(fiche.getId()==entity.getService().getId()){
						Long oldPayer = fiche.getMntpayer();
						Long newPayer = oldPayer+payer;
						fiche.setMntpayer(newPayer);
						fiche.setSolde(fiche.getZtotal()-newPayer);
					}
					listfp.add(fiche);
				}
				Long oldrpayer = r.getPayer();
				 newrpayer = oldrpayer+payer;
				solde = r.getScolarite() - newrpayer;
				r.setPayer(newrpayer);
				r.setSolde(solde);
				daorgl.update(r.getId(), r);
				
				// mis a jour inscription
				Inscription ins = daoIns.findByPrimaryKey("id", entity.getEleve().getId());
				ins.setzMntPaye(r.getPayer());
				ins.setzMnt(r.getScolarite());
				ins.setzSolde(r.getSolde());
				daoIns.update(ins.getId(), ins);
				
				entity.setTotalapayer(r.getScolarite());
				entity.setTotalpayer(r.getPayer());
				dao.update(entity.getId(), entity);
			} 
			
		
	}
	@Override
	public List<Paiement> getCriteres(Paiement critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {

			if (critere.getEleve() != null) {
				container.addEq("eleve.id", CacheMemory.getReglement().getEleve().getId());
			}
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
