
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
@Stateless(mappedName = "CycleManager")
public class CycleManagerImpl
    extends AbstractGenericManager<Cycle, Long>
    implements CycleManagerLocal, CycleManagerRemote
{

    @EJB(name = "CycleDAO")
    protected CycleDAOLocal dao;

    public CycleManagerImpl() {
    }

    @Override
    public GenericDAO<Cycle, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Cycle> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Cycle> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Cycle> result = new ArrayList<Cycle>();
   		for(Cycle elev:datas){
   			result.add(new Cycle(elev));
   		}
   		return result;
   	}

   	@Override
   	public Cycle find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Cycle elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Cycle> findAll() {
   		// TODO Auto-generated method stub
   		List<Cycle> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Cycle delete(Long id) {
   		// TODO Auto-generated method stub
   		Cycle elev = super.delete(id);
   		return new Cycle(elev);
   	}


}
