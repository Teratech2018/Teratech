
package com.kerenedu.reglement;

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
@Stateless(mappedName = "RetardManager")
public class RetardManagerImpl
    extends AbstractGenericManager<Retard, Long>
    implements RetardManagerLocal, RetardManagerRemote
{

    @EJB(name = "RetardDAO")
    protected RetardDAOLocal dao;

    public RetardManagerImpl() {
    }

    @Override
    public GenericDAO<Retard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Retard> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Retard> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Retard> result = new ArrayList<Retard>();
   		for(Retard elev:datas){
   			result.add(new Retard(elev));
   		}
   		return result;
   	}

   	@Override
   	public Retard find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Retard data = super.find(propertyName, entityID);
   		Retard result = new Retard(data);
   		
	   	
 	return result;

   	}

   	@Override
   	public List<Retard> findAll() {
   		// TODO Auto-generated method stub
   		List<Retard> datas = super.findAll();
   		List<Retard> result = new ArrayList<Retard>();
   		for(Retard elev:datas){
   			result.add(new Retard(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Retard delete(Long id) {
   		// TODO Auto-generated method stub
   		Retard elev = super.delete(id);
   		return new Retard(elev);
   	}

	@Override
	public void processBeforeSave(Retard entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	

}
