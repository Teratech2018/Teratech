
package com.kerenedu.discipline;

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
@Stateless(mappedName = "TypeAbscenceManager")
public class TypeAbscenceManagerImpl
    extends AbstractGenericManager<TypeAbscence, Long>
    implements TypeAbscenceManagerLocal, TypeAbscenceManagerRemote
{

    @EJB(name = "TypeAbscenceDAO")
    protected TypeAbscenceDAOLocal dao;

    public TypeAbscenceManagerImpl() {
    }

    @Override
    public GenericDAO<TypeAbscence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
   	public List<TypeAbscence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<TypeAbscence> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<TypeAbscence> result = new ArrayList<TypeAbscence>();
   		for(TypeAbscence elev:datas){
   			result.add(new TypeAbscence(elev));
   		}
   		return result;
   	}

   	@Override
   	public TypeAbscence find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		TypeAbscence elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<TypeAbscence> findAll() {
   		// TODO Auto-generated method stub
   		List<TypeAbscence> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public TypeAbscence delete(Long id) {
   		// TODO Auto-generated method stub
   		TypeAbscence elev = super.delete(id);
   		return new TypeAbscence(elev);
   	}


}
