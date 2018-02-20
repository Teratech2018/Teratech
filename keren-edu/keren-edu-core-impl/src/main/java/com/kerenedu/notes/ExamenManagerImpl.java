
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
@Stateless(mappedName = "ExamenManager")
public class ExamenManagerImpl
    extends AbstractGenericManager<Examen, Long>
    implements ExamenManagerLocal, ExamenManagerRemote
{

    @EJB(name = "ExamenDAO")
    protected ExamenDAOLocal dao;

    public ExamenManagerImpl() {
    }

    @Override
    public GenericDAO<Examen, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Examen> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Examen> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Examen> result = new ArrayList<Examen>();
   		for(Examen elev:datas){
   			result.add(new Examen(elev));
   		}
   		return result;
   	}

   	@Override
   	public Examen find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Examen elev = super.find(propertyName, entityID);
   		Examen data = new Examen(elev);
   		return data;
   	}

   	@Override
   	public List<Examen> findAll() {
   		// TODO Auto-generated method stub
   		List<Examen> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Examen delete(Long id) {
   		// TODO Auto-generated method stub
   		Examen elev = super.delete(id);
   		return new Examen(elev);
   	}


}
