
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
@Stateless(mappedName = "CoefMatiereDetailManager")
public class CoefMatiereDetailManagerImpl
    extends AbstractGenericManager<CoefMatiereDetail, Long>
    implements CoefMatiereDetailManagerLocal, CoefMatiereDetailManagerRemote
{

    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal dao;

    public CoefMatiereDetailManagerImpl() {
    }

    @Override
    public GenericDAO<CoefMatiereDetail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<CoefMatiereDetail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<CoefMatiereDetail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<CoefMatiereDetail> result = new ArrayList<CoefMatiereDetail>();
   		for(CoefMatiereDetail elev:datas){
   			result.add(new CoefMatiereDetail(elev));
   		}
   		return result;
   	}

   	@Override
   	public CoefMatiereDetail find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		CoefMatiereDetail elev = super.find(propertyName, entityID);
   		CoefMatiereDetail data = new CoefMatiereDetail(elev);
   		return data;
   	}

   	@Override
   	public List<CoefMatiereDetail> findAll() {
   		// TODO Auto-generated method stub
   		List<CoefMatiereDetail> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public CoefMatiereDetail delete(Long id) {
   		// TODO Auto-generated method stub
   		CoefMatiereDetail elev = super.delete(id);
   		return new CoefMatiereDetail(elev);
   	}
}
