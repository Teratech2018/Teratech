
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
@Stateless(mappedName = "PrimeProfManager")
public class PrimeProfManagerImpl
    extends AbstractGenericManager<PrimeProf, Long>
    implements PrimeProfManagerLocal, PrimeProfManagerRemote
{

    @EJB(name = "PrimeProfDAO")
    protected PrimeProfDAOLocal dao;

    public PrimeProfManagerImpl() {
    }

    @Override
    public GenericDAO<PrimeProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<PrimeProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<PrimeProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<PrimeProf> result = new ArrayList<PrimeProf>();
   		for(PrimeProf elev:datas){
   			result.add(new PrimeProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public PrimeProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		PrimeProf elev = super.find(propertyName, entityID);
   		PrimeProf data = new PrimeProf(elev);
   		return data;
   	}

   	@Override
   	public List<PrimeProf> findAll() {
   		// TODO Auto-generated method stub
   		List<PrimeProf> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public PrimeProf delete(Long id) {
   		// TODO Auto-generated method stub
   		PrimeProf elev = super.delete(id);
   		return new PrimeProf(elev);
   	}


}
