
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
@Stateless(mappedName = "TypeDepenseManager")
public class TypeDepenseManagerImpl
    extends AbstractGenericManager<TypeDepense, Long>
    implements TypeDepenseManagerLocal, TypeDepenseManagerRemote
{

    @EJB(name = "TypeDepenseDAO")
    protected TypeDepenseDAOLocal dao;

    public TypeDepenseManagerImpl() {
    }

    @Override
    public GenericDAO<TypeDepense, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<TypeDepense> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<TypeDepense> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<TypeDepense> result = new ArrayList<TypeDepense>();
   		for(TypeDepense elev:datas){
   			result.add(new TypeDepense(elev));
   		}
   		return result;
   	}

   	@Override
   	public TypeDepense find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		TypeDepense elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<TypeDepense> findAll() {
   		// TODO Auto-generated method stub
   		List<TypeDepense> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public TypeDepense delete(Long id) {
   		// TODO Auto-generated method stub
   		TypeDepense elev = super.delete(id);
   		return new TypeDepense(elev);
   	}

}
