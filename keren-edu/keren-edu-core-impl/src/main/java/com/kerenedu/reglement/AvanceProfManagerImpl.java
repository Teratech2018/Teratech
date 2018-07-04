
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
@Stateless(mappedName = "AvanceProfManager")
public class AvanceProfManagerImpl
    extends AbstractGenericManager<AvanceProf, Long>
    implements AvanceProfManagerLocal, AvanceProfManagerRemote
{

    @EJB(name = "AvanceProfDAO")
    protected AvanceProfDAOLocal dao;

    public AvanceProfManagerImpl() {
    }

    @Override
    public GenericDAO<AvanceProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<AvanceProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<AvanceProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<AvanceProf> result = new ArrayList<AvanceProf>();
   		for(AvanceProf elev:datas){
   			result.add(new AvanceProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public AvanceProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		AvanceProf elev = super.find(propertyName, entityID);
   		AvanceProf data = new AvanceProf(elev);
   		return data;
   	}

   	@Override
   	public List<AvanceProf> findAll() {
   		// TODO Auto-generated method stub
   		List<AvanceProf> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public AvanceProf delete(Long id) {
   		// TODO Auto-generated method stub
   		AvanceProf elev = super.delete(id);
   		return new AvanceProf(elev);
   	}


}
