
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
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.CycleDAOLocal;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierEcoleManagerLocal;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierEcoleManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewBilanFinancierEcoleDAOLocal;
import com.kerenedu.model.report.ViewBilanFinancierEcole;
import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewBilanFinancierEcoleManager")
public class ViewBilanFinancierEcoleManagerImpl
    extends AbstractGenericManager<ViewBilanFinancierEcole, Long>
    implements ViewBilanFinancierEcoleManagerLocal, ViewBilanFinancierEcoleManagerRemote
{

    @EJB(name = "ViewBilanFinancierEcoleDAO")
    protected ViewBilanFinancierEcoleDAOLocal dao;
    
    @EJB(name = "CycleDAO")
    protected CycleDAOLocal daocycle;

    public ViewBilanFinancierEcoleManagerImpl() {
    }

    @Override
    public GenericDAO<ViewBilanFinancierEcole, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ViewBilanFinancierEcole> filter(List<Predicat> predicats, Map<String, OrderType> orders,
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
   		List<ViewBilanFinancierEcole> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		return datas;
   	}


	@Override
	public List<ViewBilanFinancierEcole> getCriteres(ViewBilanFinancierEcoleModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();

			if (critere.getTypecycle() != null) {
				Cycle cycle = daocycle.findByProperty("typecycle", critere.getTypecycle()).get(0);
				if(cycle!=null){
					container = RestrictionsContainer.newInstance();
					container.addEq("cycle.id", cycle.getId());
				}
				
			}

		}
		List<ViewBilanFinancierEcole> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanFinancierEcole> result = new ArrayList<ViewBilanFinancierEcole>();
		if (datas != null) {
			for (ViewBilanFinancierEcole aniv : datas) {;
				result.add(new ViewBilanFinancierEcole(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}

}
