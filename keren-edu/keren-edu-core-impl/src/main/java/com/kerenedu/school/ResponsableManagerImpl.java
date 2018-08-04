
package com.kerenedu.school;

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
@Stateless(mappedName = "ResponsableManager")
public class ResponsableManagerImpl
    extends AbstractGenericManager<Responsable, Long>
    implements ResponsableManagerLocal, ResponsableManagerRemote
{

    @EJB(name = "ResponsableDAO")
    protected ResponsableDAOLocal dao;

    public ResponsableManagerImpl() {
    }

    @Override
    public GenericDAO<Responsable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Responsable> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Responsable> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Responsable> result = new ArrayList<Responsable>();
   		for(Responsable elev:datas){
   			result.add(new Responsable(elev));
   		}
   		return result;
   	}

   	@Override
   	public Responsable find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Responsable elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Responsable> findAll() {
   		// TODO Auto-generated method stub
   		List<Responsable> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Responsable delete(Long id) {
   		// TODO Auto-generated method stub
   		Responsable elev = super.delete(id);
   		return new Responsable(elev);
   	}
}
