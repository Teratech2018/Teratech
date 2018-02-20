
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
@Stateless(mappedName = "CaisseManager")
public class CaisseManagerImpl
    extends AbstractGenericManager<Caisse, Long>
    implements CaisseManagerLocal, CaisseManagerRemote
{

    @EJB(name = "CaisseDAO")
    protected CaisseDAOLocal dao;

    public CaisseManagerImpl() {
    }

    @Override
    public GenericDAO<Caisse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Caisse> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Caisse> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Caisse> result = new ArrayList<Caisse>();
   		for(Caisse elev:datas){
   			result.add(new Caisse(elev));
   		}
   		return result;
   	}

   	@Override
   	public Caisse find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Caisse elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Caisse> findAll() {
   		// TODO Auto-generated method stub
   		List<Caisse> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Caisse delete(Long id) {
   		// TODO Auto-generated method stub
   		Caisse elev = super.delete(id);
   		return new Caisse(elev);
   	}


}
