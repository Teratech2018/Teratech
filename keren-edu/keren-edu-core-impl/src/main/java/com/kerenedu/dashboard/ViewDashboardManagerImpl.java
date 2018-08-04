
package com.kerenedu.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.reglement.CriteriaFactory;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewDashboardManager")
public class ViewDashboardManagerImpl
    extends AbstractGenericManager<ViewDashboard, Long>
    implements ViewDashboardManagerLocal, ViewDashboardManagerRemote
{

    @EJB(name = "ViewDashboardDAO")
    protected ViewDashboardDAOLocal dao;
    
    @Resource
    SessionContext context ;

    public ViewDashboardManagerImpl() {
    }

    @Override
    public GenericDAO<ViewDashboard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
	@Override
	public List<ViewDashboard> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		predicats= CriteriaFactory.defaultPredicats();

		predicats.addAll(container.getPredicats());

		List<ViewDashboard> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ViewDashboard> result = new ArrayList<ViewDashboard>();
		for (ViewDashboard elev : datas) {
			result.add(new ViewDashboard(elev));
		}
		return result;
	}

	@Override
	public List<ViewDashboard> getdashboarddata() {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.getPredicats().addAll(CacheMemory.defaultPredicats());

		List<ViewDashboard> datas = super.filter(container.getPredicats(), null, null, 0, 1);
//		   System.out.println("ViewDashboardManagerImpl.scheduleEventManager() datas trouvéé ......");
		return datas;
	}

//	@Override
//	public void ejbTimeout(Timer arg0) {
////		   System.out.println("ViewDashboardManagerImpl.scheduleEventManager()  je cherche mes datas......");
//		this.getdashboarddata();
//		
//	}
	
	  @Override
	    public void scheduleEventManager(Date initialExpiration, long duration) {
//	      System.out.println("ViewDashboardManagerImpl.scheduleEventManager()  je suis encore entrez ......");
	        context.getTimerService().createTimer(initialExpiration, duration, "Event schulder ...");
	    }


}
