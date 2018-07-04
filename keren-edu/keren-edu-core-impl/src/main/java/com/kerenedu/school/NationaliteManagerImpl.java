
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
@Stateless(mappedName = "NationaliteManager")
public class NationaliteManagerImpl
    extends AbstractGenericManager<Nationalite, Long>
    implements NationaliteManagerLocal, NationaliteManagerRemote
{

    @EJB(name = "NationaliteDAO")
    protected NationaliteDAOLocal dao;

    public NationaliteManagerImpl() {
    }

    @Override
    public GenericDAO<Nationalite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Nationalite> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Nationalite> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Nationalite> result = new ArrayList<Nationalite>();
   		for(Nationalite elev:datas){
   			result.add(new Nationalite(elev));
   		}
   		return result;
   	}

   	@Override
   	public Nationalite find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Nationalite elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Nationalite> findAll() {
   		// TODO Auto-generated method stub
   		List<Nationalite> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Nationalite delete(Long id) {
   		// TODO Auto-generated method stub
   		Nationalite elev = super.delete(id);
   		return new Nationalite(elev);
   	}

}
