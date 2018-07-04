
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
@Stateless(mappedName = "PaiementProfManager")
public class PaiementProfManagerImpl
    extends AbstractGenericManager<PaiementProf, Long>
    implements PaiementProfManagerLocal, PaiementProfManagerRemote
{

    @EJB(name = "PaiementProfDAO")
    protected PaiementProfDAOLocal dao;

    public PaiementProfManagerImpl() {
    }

    @Override
    public GenericDAO<PaiementProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<PaiementProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<PaiementProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<PaiementProf> result = new ArrayList<PaiementProf>();
   		for(PaiementProf elev:datas){
   			result.add(new PaiementProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public PaiementProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		PaiementProf elev = super.find(propertyName, entityID);
   		PaiementProf data = new PaiementProf(elev);
   		return data;
   	}

   	@Override
   	public List<PaiementProf> findAll() {
   		// TODO Auto-generated method stub
   		List<PaiementProf> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public PaiementProf delete(Long id) {
   		// TODO Auto-generated method stub
   		PaiementProf elev = super.delete(id);
   		return new PaiementProf(elev);
   	}


}
