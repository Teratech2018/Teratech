
package com.kerenedu.notes;

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
@Stateless(mappedName = "BulletinManager")
public class BulletinManagerImpl
    extends AbstractGenericManager<Bulletin, Long>
    implements BulletinManagerLocal, BulletinManagerRemote
{

    @EJB(name = "BulletinDAO")
    protected BulletinDAOLocal dao;

    public BulletinManagerImpl() {
    }

    @Override
    public GenericDAO<Bulletin, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Bulletin> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Bulletin> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Bulletin> result = new ArrayList<Bulletin>();
   		for(Bulletin elev:datas){
   			result.add(new Bulletin(elev));
   		}
   		return result;
   	}

   	@Override
   	public Bulletin find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Bulletin elev = super.find(propertyName, entityID);
   		Bulletin data = new Bulletin(elev);
   		for(Examen seq:elev.getSequence()){
   			data.getSequence().add(new Examen(seq));
   		}
   		return data;
   	}

   	@Override
   	public List<Bulletin> findAll() {
   		// TODO Auto-generated method stub
   		List<Bulletin> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Bulletin delete(Long id) {
   		// TODO Auto-generated method stub
   		Bulletin elev = super.delete(id);
   		return new Bulletin(elev);
   	}


}
