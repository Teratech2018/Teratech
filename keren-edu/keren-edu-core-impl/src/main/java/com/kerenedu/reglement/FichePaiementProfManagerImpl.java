
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
@Stateless(mappedName = "FichePaiementProfManager")
public class FichePaiementProfManagerImpl
    extends AbstractGenericManager<FichePaiementProf, Long>
    implements FichePaiementProfManagerLocal, FichePaiementProfManagerRemote
{

    @EJB(name = "FichePaiementProfDAO")
    protected FichePaiementProfDAOLocal dao;

    public FichePaiementProfManagerImpl() {
    }

    @Override
    public GenericDAO<FichePaiementProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<FichePaiementProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<FichePaiementProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<FichePaiementProf> result = new ArrayList<FichePaiementProf>();
   		for(FichePaiementProf elev:datas){
   			result.add(new FichePaiementProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public FichePaiementProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		FichePaiementProf elev = super.find(propertyName, entityID);
   		FichePaiementProf data = new FichePaiementProf(elev);
   		return data;
   	}

   	@Override
   	public List<FichePaiementProf> findAll() {
   		// TODO Auto-generated method stub
   		List<FichePaiementProf> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public FichePaiementProf delete(Long id) {
   		// TODO Auto-generated method stub
   		FichePaiementProf elev = super.delete(id);
   		return new FichePaiementProf(elev);
   	}


}
