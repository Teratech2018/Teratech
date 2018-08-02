
package com.kerenedu.core.impl.report;

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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.core.ifaces.report.ViewRetardPaiementManagerLocal;
import com.kerenedu.core.ifaces.report.ViewRetardPaiementManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewRetardPaiementDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewDltPaiement;
import com.kerenedu.model.report.ViewDltPaiementModal;
import com.kerenedu.model.report.ViewRetardPaiement;
import com.kerenedu.reglement.FichePaiement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewRetardPaiementManager")
public class ViewRetardPaiementManagerImpl
    extends AbstractGenericManager<ViewRetardPaiement, Long>
    implements ViewRetardPaiementManagerLocal, ViewRetardPaiementManagerRemote
{

    @EJB(name = "ViewRetardPaiementDAO")
    protected ViewRetardPaiementDAOLocal dao;
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;


    public ViewRetardPaiementManagerImpl() {
    }

    @Override
    public GenericDAO<ViewRetardPaiement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ViewRetardPaiement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	predicats.addAll(CacheMemory.defaultPredicatsCycleAnnee());
    	List<Inscription> listIns = daoIns.filter(predicats, orders, properties, firstResult, maxResult);
    	List<ViewRetardPaiement> result = new ArrayList<ViewRetardPaiement>();
    	for(Inscription i :listIns){
    		for(FichePaiement fiche : i.getService()){
    			if((fiche.getService().getDelai().before(new Date()))&(fiche.getSolde()!=0)){
        			result.add(new ViewRetardPaiement(i,fiche));
    			}
	
    		}
    	}
   		return result;
   	}

   	@Override
   	public ViewRetardPaiement find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Inscription ins= daoIns.findByPrimaryKey("id", entityID);
   		//ViewRetardPaiement elev = super.find(propertyName, entityID);
   		ViewRetardPaiement inscrip = new ViewRetardPaiement(ins);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<ViewRetardPaiement> findAll() {
   		// TODO Auto-generated method stub
   		List<Inscription> inst = daoIns.filter(null, null, null, 0, 0);
   		List<ViewRetardPaiement> datas = super.findAll();
   		List<ViewRetardPaiement> result = new ArrayList<ViewRetardPaiement>();
   		for(Inscription elev:inst){
   			for(FichePaiement fiche : elev.getService()){
    			result.add(new ViewRetardPaiement(elev,fiche));	
    		}
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ViewRetardPaiement delete(Long id) {
   		// TODO Auto-generated method stub
   		ViewRetardPaiement elev = super.delete(id);
   		return new ViewRetardPaiement(elev);
   	}
   	@Override
	public List<ViewRetardPaiement> getCriteres(ViewRetardPaiement critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			System.out.println("ViewRetardPaiementManagerImpl.getCriteres() classe"+critere.getClasse().getLibelle());
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			 //container.addEq("anneScolaire", CacheMemory.getCurrentannee());
			
			

		}
		List<Inscription> listIns = daoIns.filter(container.getPredicats(),null, new HashSet<String>(), -1, 0);
		System.out.println("ViewRetardPaiementManagerImpl.getCriteres() size records found ..."+listIns.size());
    	List<ViewRetardPaiement> result = new ArrayList<ViewRetardPaiement>();
    	for(Inscription i :listIns){
    		for(FichePaiement fiche : i.getService()){
    			if((fiche.getService().getDelai().before(new Date()))&(fiche.getSolde()!=0)){
        			result.add(new ViewRetardPaiement(i,fiche));
    			}
	
    		}
    	}
		
		return result;
	}


}
