
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
@Stateless(mappedName = "DepenseManager")
public class DepenseManagerImpl
    extends AbstractGenericManager<Depense, Long>
    implements DepenseManagerLocal, DepenseManagerRemote
{

    @EJB(name = "DepenseDAO")
    protected DepenseDAOLocal dao;

    public DepenseManagerImpl() {
    }

    @Override
    public GenericDAO<Depense, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Depense> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Depense> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Depense> result = new ArrayList<Depense>();
   		for(Depense elev:datas){
   			result.add(new Depense(elev));
   		}
   		return result;
   	}

   	@Override
   	public Depense find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Depense elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Depense> findAll() {
   		// TODO Auto-generated method stub
   		List<Depense> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Depense delete(Long id) {
   		// TODO Auto-generated method stub
   		Depense elev = super.delete(id);
   		return new Depense(elev);
   	}

}
