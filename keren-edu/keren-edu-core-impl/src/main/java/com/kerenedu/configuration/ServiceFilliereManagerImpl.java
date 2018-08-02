
package com.kerenedu.configuration;

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
@Stateless(mappedName = "ServiceFilliereManager")
public class ServiceFilliereManagerImpl
    extends AbstractGenericManager<ServiceFilliere, Long>
    implements ServiceFilliereManagerLocal, ServiceFilliereManagerRemote
{

    @EJB(name = "ServiceFilliereDAO")
    protected ServiceFilliereDAOLocal dao;

    public ServiceFilliereManagerImpl() {
    }

    @Override
    public GenericDAO<ServiceFilliere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<ServiceFilliere> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<ServiceFilliere> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ServiceFilliere> result = new ArrayList<ServiceFilliere>();
   		for(ServiceFilliere elev:datas){
   			result.add(new ServiceFilliere(elev));
   		}
   		return result;
   	}

   	@Override
   	public ServiceFilliere find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ServiceFilliere elev = super.find(propertyName, entityID);
   		ServiceFilliere inscrip = new ServiceFilliere(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<ServiceFilliere> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<ServiceFilliere> datas = super.findAll();
   		List<ServiceFilliere> result = new ArrayList<ServiceFilliere>();
   		for(ServiceFilliere elev:datas){
   			result.add(new ServiceFilliere(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ServiceFilliere delete(Long id) {
   		// TODO Auto-generated method stub
   		ServiceFilliere elev = super.delete(id);
   		return new ServiceFilliere(elev);
   	}



}
