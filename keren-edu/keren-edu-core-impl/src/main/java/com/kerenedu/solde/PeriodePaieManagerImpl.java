
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieManager")
public class PeriodePaieManagerImpl
    extends AbstractGenericManager<PeriodePaie, Long>
    implements PeriodePaieManagerLocal, PeriodePaieManagerRemote
{

    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal dao;

    public PeriodePaieManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<PeriodePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<PeriodePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<PeriodePaie> result = new ArrayList<PeriodePaie>();
   		for(PeriodePaie elev:datas){
   			result.add(new PeriodePaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(PeriodePaie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public PeriodePaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		PeriodePaie elev = super.find(propertyName, entityID);
   		PeriodePaie inscrip = new PeriodePaie(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<PeriodePaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<PeriodePaie> datas = super.findAll();
   		List<PeriodePaie> result = new ArrayList<PeriodePaie>();
   		for(PeriodePaie elev:datas){
   			result.add(new PeriodePaie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public PeriodePaie delete(Long id) {
   		// TODO Auto-generated method stub
   		PeriodePaie elev = super.delete(id);
   		return new PeriodePaie(elev);
   	}



}
