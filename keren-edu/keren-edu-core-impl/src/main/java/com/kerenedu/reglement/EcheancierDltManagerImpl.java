
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
@Stateless(mappedName = "EcheancierDltManager")
public class EcheancierDltManagerImpl
    extends AbstractGenericManager<EcheancierDlt, Long>
    implements EcheancierDltManagerLocal, EcheancierDltManagerRemote
{

    @EJB(name = "EcheancierDltDAO")
    protected EcheancierDltDAOLocal dao;

    public EcheancierDltManagerImpl() {
    }

    @Override
    public GenericDAO<EcheancierDlt, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
	public List<EcheancierDlt> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<EcheancierDlt> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EcheancierDlt> result = new ArrayList<EcheancierDlt>();
   		for(EcheancierDlt elev:datas){
   			result.add(new EcheancierDlt(elev));
   		}
   		return result;
   	}

   	@Override
   	public EcheancierDlt find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EcheancierDlt data = super.find(propertyName, entityID);
   		EcheancierDlt result = new EcheancierDlt(data);		
	   	
 	return result;

   	}

   	@Override
   	public List<EcheancierDlt> findAll() {
   		// TODO Auto-generated method stub
   		List<EcheancierDlt> datas = super.findAll();
   		List<EcheancierDlt> result = new ArrayList<EcheancierDlt>();
   		for(EcheancierDlt elev:datas){
   			result.add(new EcheancierDlt(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public EcheancierDlt delete(Long id) {
   		// TODO Auto-generated method stub
   		EcheancierDlt elev = super.delete(id);
   		return new EcheancierDlt(elev);
   	}

	@Override
	public void processBeforeSave(EcheancierDlt entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	

}
