
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.CycleDAOLocal;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierManagerLocal;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewBilanFinancier;
import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;
import com.kerenedu.model.report.ViewBilanFinancierModal;
import com.kerenedu.model.report.ViewBilanServiceModal;
import com.kerenedu.model.report.ViewCouponsInformation;
import com.kerenedu.reglement.FichePaiement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewBilanFinancierManager")
public class ViewBilanFinancierManagerImpl
    extends AbstractGenericManager<ViewBilanFinancier, Long>
    implements ViewBilanFinancierManagerLocal, ViewBilanFinancierManagerRemote
{

    @EJB(name = "ViewBilanFinancierDAO")
    protected ViewBilanFinancierDAOLocal dao;
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal daoClasse;
    
    @EJB(name = "CycleDAO")
    protected CycleDAOLocal daocycle;


    public ViewBilanFinancierManagerImpl() {
    }

    @Override
    public GenericDAO<ViewBilanFinancier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
	public List<ViewBilanFinancier> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, Map<String, Object> hints, int firstResult, int maxResult) {
    	// TODO Auto-generated method stub
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	String annnescolaire = CacheMemory.getCurrentannee();
		if (annnescolaire != null) {
			container.addEq("anneScolaire", annnescolaire);
		}
		if (CacheMemory.getCurentcycle() != 0) {
			container.addEq("cycle.id", CacheMemory.getCurentcycle());
		}
		predicats.addAll(container.getPredicats());
		List<ViewBilanFinancier> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ViewBilanFinancier> result = new ArrayList<ViewBilanFinancier>();
		for(ViewBilanFinancier elev:datas){
			result.add(new ViewBilanFinancier(elev));
		}
		return result;
	}

	@Override
	public List<ViewBilanFinancier> getCriteres(ViewBilanFinancierModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();

			if (critere.getClasse() != null) {
					container.addEq("classe.id", critere.getClasse().getId());
					container.addEq("classe.section.id", critere.getClasse().getSection().getId());				
			}
			if (critere.getSection() != null) {
				container.addEq("classe.section.id",critere.getSection().getId());
			
			
		}

		}
		// force update inscription 
		daoIns.updateforce("m");
		System.out.println("ViewBilanFinancierManagerImpl.getCriteres() update force ok ======>>");
		
		List<ViewBilanFinancier> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanFinancier> result = new ArrayList<ViewBilanFinancier>();
		if (datas != null) {
			for (ViewBilanFinancier aniv : datas) {;
				result.add(new ViewBilanFinancier(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}
	
	@Override
	public List<ViewBilanFinancier> getCriteres(ViewBilanFinancierEcoleModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();

			if (critere.getTypecycle() != null&& !critere.getTypecycle().equals("3")) {
				Cycle cycle = daocycle.findByProperty("typecycle", critere.getTypecycle()).get(0);
				if(cycle!=null){
					container = RestrictionsContainer.newInstance();
					container.addEq("classe.filiere.cycle.id", cycle.getId());
				}
				
			}else{
				container = RestrictionsContainer.newInstance();
			}

		}
		// force update inscription 
		daoIns.updateforce("scolarite");
		System.out.println("ViewBilanFinancierManagerImpl.getCriteres() update force ok ======>>");
		List<ViewBilanFinancier> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanFinancier> result = new ArrayList<ViewBilanFinancier>();
		if (datas != null) {
			for (ViewBilanFinancier aniv : datas) {;
				result.add(new ViewBilanFinancier(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}
	

	@Override
	public List<ViewBilanFinancier> getCriteres(ViewBilanServiceModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();

			if (critere.getClasse() != null) {
				container = RestrictionsContainer.newInstance();
				container.addEq("classe.id", critere.getClasse().getId());
				
				
			}

		}
		List<ViewBilanFinancier> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanFinancier> result = new ArrayList<ViewBilanFinancier>();
		if (datas != null) {
			for (ViewBilanFinancier aniv : datas) {;
				result.add(new ViewBilanFinancier(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}
	
	
	public List<Inscription> getEleveElligible(ViewBilanServiceModal critere){
		List<Inscription> result = new ArrayList<Inscription>();
		List<Inscription> datas = new ArrayList<Inscription>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere.getClasse() != null) {
			container = RestrictionsContainer.newInstance();
			container.addEq("classe.id", critere.getClasse().getId());	
		}
		result = daoIns.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		
		if(result !=null&& result.size()!=0){
			for(Inscription ins : result){
				for(FichePaiement fp :ins.getService()){
					if(fp.getService().getType().equals(critere.getType())&& fp.getPayer()==true){
						datas.add(ins);
					}
				}
			}
		}
		
		
		return datas ;
	}




}
