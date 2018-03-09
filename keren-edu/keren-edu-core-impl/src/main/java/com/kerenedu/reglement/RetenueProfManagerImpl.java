
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
@Stateless(mappedName = "RetenueProfManager")
public class RetenueProfManagerImpl
    extends AbstractGenericManager<RetenueProf, Long>
    implements RetenueProfManagerLocal, RetenueProfManagerRemote
{

    @EJB(name = "RetenueProfDAO")
    protected RetenueProfDAOLocal dao;

    public RetenueProfManagerImpl() {
    }

    @Override
    public GenericDAO<RetenueProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<RetenueProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<RetenueProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<RetenueProf> result = new ArrayList<RetenueProf>();
   		for(RetenueProf elev:datas){
   			result.add(new RetenueProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public RetenueProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		RetenueProf elev = super.find(propertyName, entityID);
   		RetenueProf data = new RetenueProf(elev);
   		return data;
   	}

   	@Override
   	public List<RetenueProf> findAll() {
   		// TODO Auto-generated method stub
   		List<RetenueProf> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public RetenueProf delete(Long id) {
   		// TODO Auto-generated method stub
   		RetenueProf elev = super.delete(id);
   		return new RetenueProf(elev);
   	}

}
