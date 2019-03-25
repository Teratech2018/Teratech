
package com.kerenedu.core.impl.report;

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
import com.core.tools.DateHelper;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerLocal;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewDltPaiementDAOLocal;
import com.kerenedu.model.report.ViewDltPaiement;
import com.kerenedu.model.report.ViewDltPaiementModal;
import com.kerenedu.model.report.ViewListingPModal;
import com.kerenedu.reglement.PaiementDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewDltPaiementManager")
public class ViewDltPaiementManagerImpl extends AbstractGenericManager<ViewDltPaiement, Long>
		implements ViewDltPaiementManagerLocal, ViewDltPaiementManagerRemote {

	@EJB(name = "ViewDltPaiementDAO")
	protected ViewDltPaiementDAOLocal dao;
	
	 @EJB(name = "AnneScolaireDAO")
	    protected AnneScolaireDAOLocal daoanne;

	@EJB(name = "PaiementDAO")
	protected PaiementDAOLocal daopaiement;

	public ViewDltPaiementManagerImpl() {
	}

	@Override
	public GenericDAO<ViewDltPaiement, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<ViewDltPaiement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		predicats.addAll(CacheMemory.defaultPredicatsCycleAnnee());
		List<ViewDltPaiement> datas = dao.filter(predicats, orders, properties, firstResult, maxResult);
		List<ViewDltPaiement> result = new ArrayList<ViewDltPaiement>();
		 for(ViewDltPaiement p:datas){
		 result.add(new ViewDltPaiement(p));
		 }
		return result;
	}

	@Override
	public ViewDltPaiement find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ViewDltPaiement elev = super.find(propertyName, entityID);
		ViewDltPaiement inscrip = new ViewDltPaiement(elev);
		// for(Eleve serv: elev.getElevelist()){
		// inscrip.getElevelist().add(new Eleve(serv));
		// }
		return inscrip;
	}

	@Override
	public List<ViewDltPaiement> findAll() {
		// TODO Auto-generated method stub
		List<ViewDltPaiement> datas = super.findAll();
		List<ViewDltPaiement> result = new ArrayList<ViewDltPaiement>();
		for (ViewDltPaiement elev : datas) {
			result.add(new ViewDltPaiement(elev));
		}
		return result;
	}

	@Override
	public ViewDltPaiement delete(Long id) {
		// TODO Auto-generated method stub
		ViewDltPaiement elev = super.delete(id);
		return new ViewDltPaiement(elev);
	}

	@Override
	public List<ViewDltPaiement> getCriteres(ViewDltPaiementModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			String annescolaire ="";
			container.addEq("connected", true);
			List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
			annescolaire =annee.get(0).getCode();
			
			
			container = RestrictionsContainer.newInstance();
			if (critere.getDatepaideb() != null) {
				container.addEq("datePaiement", DateHelper.formatDate(critere.getDatepaideb()));
			}
			container.addEq("state", "etabli");
			container.addEq("anneScolaire",annescolaire);

		}
		List<ViewDltPaiement> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewDltPaiement> result = new ArrayList<ViewDltPaiement>();
		if (datas != null) {
			for (ViewDltPaiement p : datas) {
				result.add(new ViewDltPaiement(p));
			}
		} // fin if(datas!=null)
		return result;
	}
	
	@Override
	public List<ViewDltPaiement> getCriteres(ViewListingPModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			String annescolaire ="";
			container.addEq("connected", true);
			List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
			annescolaire =annee.get(0).getCode();
			
			container = RestrictionsContainer.newInstance();
			if (critere.getClasse() != null) {
				container.addEq("eleve.classe.id", critere.getClasse().getId());
			}
			if (critere.getTypePaiment() != null) {
				container.addEq("typePaiment", critere.getTypePaiment());
			}
			container.addEq("state", "etabli");
			container.addEq("anneScolaire",annescolaire);

		}
		List<ViewDltPaiement> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewDltPaiement> result = new ArrayList<ViewDltPaiement>();
		if (datas != null) {
			for (ViewDltPaiement p : datas) {
				result.add(new ViewDltPaiement(p));
			}
		} // fin if(datas!=null)
		return result;
	}

}
