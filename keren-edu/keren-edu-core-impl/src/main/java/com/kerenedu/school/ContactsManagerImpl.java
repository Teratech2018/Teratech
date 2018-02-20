
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
@Stateless(mappedName = "ContactsManager")
public class ContactsManagerImpl
    extends AbstractGenericManager<Contacts, Long>
    implements ContactsManagerLocal, ContactsManagerRemote
{

    @EJB(name = "ContactsDAO")
    protected ContactsDAOLocal dao;

    public ContactsManagerImpl() {
    }

    @Override
    public GenericDAO<Contacts, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Contacts> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Contacts> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Contacts> result = new ArrayList<Contacts>();
   		for(Contacts elev:datas){
   			result.add(new Contacts(elev));
   		}
   		return result;
   	}

   	@Override
   	public Contacts find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Contacts elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<Contacts> findAll() {
   		// TODO Auto-generated method stub
   		List<Contacts> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Contacts delete(Long id) {
   		// TODO Auto-generated method stub
   		Contacts elev = super.delete(id);
   		return new Contacts(elev);
   	}
}
