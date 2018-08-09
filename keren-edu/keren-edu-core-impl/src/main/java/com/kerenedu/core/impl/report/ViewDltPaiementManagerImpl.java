
package com.kerenedu.core.impl.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerLocal;
import com.kerenedu.core.ifaces.report.ViewDltPaiementManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewDltPaiementDAOLocal;
import com.kerenedu.model.report.ViewDltPaiement;
import com.kerenedu.model.report.ViewDltPaiementModal;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.reglement.PaiementDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewDltPaiementManager")
public class ViewDltPaiementManagerImpl extends AbstractGenericManager<ViewDltPaiement, Long>
		implements ViewDltPaiementManagerLocal, ViewDltPaiementManagerRemote {

	@EJB(name = "ViewDltPaiementDAO")
	protected ViewDltPaiementDAOLocal dao;

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
			container.getPredicats().addAll(CacheMemory.defaultPredicats());
//			if (critere.getClasse() != null) {
//				container.addEq("classe.id", critere.getClasse().getId());
//			}
			if (critere.getDatepaideb() != null) {
				container.addEq("datePaiement", DateHelper.formatDate(critere.getDatepaideb()));
			}
			container.addEq("state", "etabli");
//			if (critere.getDatepaifin() != null) {
//				System.out.println("ViewDltPaiementManagerImpl.getCriteres() fin "+critere.getDatepaifin());
//				container.addLe("datepai", critere.getDatepaifin());
//			}

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
