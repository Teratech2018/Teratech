
package com.kerenedu.core.impl.report;

import java.util.ArrayList;
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
import com.kerenedu.core.ifaces.report.ViewPaiementJournalierManagerLocal;
import com.kerenedu.core.ifaces.report.ViewPaiementJournalierManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewPaiementJournalierDAOLocal;
import com.kerenedu.model.report.ViewPaiementJournalier;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.reglement.PaiementDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewPaiementJournalierManager")
public class ViewPaiementJournalierManagerImpl
    extends AbstractGenericManager<ViewPaiementJournalier, Long>
    implements ViewPaiementJournalierManagerLocal, ViewPaiementJournalierManagerRemote
{

    @EJB(name = "ViewPaiementJournalierDAO")
    protected ViewPaiementJournalierDAOLocal dao;
    
    @EJB(name = "PaiementDAO")
    protected PaiementDAOLocal daopaiement;


    public ViewPaiementJournalierManagerImpl() {
    }

    @Override
    public GenericDAO<ViewPaiementJournalier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ViewPaiementJournalier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
    	predicats.addAll(CacheMemory.defaultPredicatsCycleAnnee());
   		// TODO Auto-generated method stub
    	List<Paiement> listIns = daopaiement.filter(predicats, orders, properties, firstResult, maxResult);
    	List<ViewPaiementJournalier> result = new ArrayList<ViewPaiementJournalier>();
    	for(Paiement i :listIns){
    		result.add(new ViewPaiementJournalier(i));
    	}
   		return result;
   	}

   	@Override
   	public ViewPaiementJournalier find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Paiement ins= daopaiement.findByPrimaryKey("id", entityID);
   		//ViewAnniversaire elev = super.find(propertyName, entityID);
   		ViewPaiementJournalier inscrip = new ViewPaiementJournalier(ins);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<ViewPaiementJournalier> findAll() {
   		// TODO Auto-generated method stub
   		RestrictionsContainer container = RestrictionsContainer.newInstance();
    	String annnescolaire = CacheMemory.getCurrentannee();
		if (annnescolaire != null) {
			container.addEq("anneScolaire", annnescolaire);
		}
   		List<Paiement> inst = daopaiement.filter(container.getPredicats(), null, null, 0, 0);
   		List<ViewPaiementJournalier> result = new ArrayList<ViewPaiementJournalier>();
   		for(Paiement elev:inst){
   			result.add(new ViewPaiementJournalier(elev));
   		}
   		return result;
   	}
   	


//	@Override
//	public List<ViewPaiementJournalier> getCriteres(ViewPaiementJournalier critere) {
//		// To change body of generated methods, choose Tools | Templates.
//				RestrictionsContainer container = RestrictionsContainer.newInstance();
//				if (critere != null) {
//					container = RestrictionsContainer.newInstance();
////					if (critere.getDatInsfin() != null) {
////						container.addGe("eleve.dateNais", critere.getDatInsfin());
////					}
////					
////					if (critere.getDatInsdeb() != null) {
////						container.addLe("eleve.dateNais", critere.getDatInsdeb());
////					}
//
//					if (critere.getClasse() != null) {
//						container.addEq("classe.id", critere.getClasse().getId());
//					}
//
//				}
//				List<Inscription> datas = daoIns.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
//				List<ViewAnniversaire> result = new ArrayList<ViewAnniversaire>();
//				if (datas != null) {
//					for (Inscription aniv : datas) {;
//						result.add(new ViewAnniversaire(aniv));
//					}
//				} // fin if(datas!=null)
//				return result;
//	}


}
