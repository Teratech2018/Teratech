
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
@Stateless(mappedName = "ProfessionManager")
public class ProfessionManagerImpl
    extends AbstractGenericManager<Profession, Long>
    implements ProfessionManagerLocal, ProfessionManagerRemote
{

    @EJB(name = "ProfessionDAO")
    protected ProfessionDAOLocal dao;

    public ProfessionManagerImpl() {
    }

    @Override
    public GenericDAO<Profession, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Profession> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Profession> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Profession> result = new ArrayList<Profession>();
   		for(Profession elev:datas){
   			result.add(new Profession(elev));
   		}
   		return result;
   	}

   	@Override
   	public Profession find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Profession elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Profession> findAll() {
   		// TODO Auto-generated method stub
   		List<Profession> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Profession delete(Long id) {
   		// TODO Auto-generated method stub
   		Profession elev = super.delete(id);
   		return new Profession(elev);
   	}
}
