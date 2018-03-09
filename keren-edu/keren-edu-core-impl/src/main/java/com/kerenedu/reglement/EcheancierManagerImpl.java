
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
@Stateless(mappedName = "EcheancierManager")
public class EcheancierManagerImpl
    extends AbstractGenericManager<Echeancier, Long>
    implements EcheancierManagerLocal, EcheancierManagerRemote
{

    @EJB(name = "EcheancierDAO")
    protected EcheancierDAOLocal dao;

    public EcheancierManagerImpl() {
    }

    @Override
    public GenericDAO<Echeancier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Echeancier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Echeancier> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Echeancier> result = new ArrayList<Echeancier>();
   		for(Echeancier elev:datas){
   			result.add(new Echeancier(elev));
   		}
   		return result;
   	}

   	@Override
   	public Echeancier find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Echeancier data = super.find(propertyName, entityID);
   		Echeancier result = new Echeancier(data);
   			for(EcheancierDlt echdlt : data.getEcheancedtl()){
   				result.getEcheancedtl().add(new EcheancierDlt(echdlt));
   			}
		
	   	
 	return result;

   	}

   	@Override
   	public List<Echeancier> findAll() {
   		// TODO Auto-generated method stub
   		List<Echeancier> datas = super.findAll();
   		List<Echeancier> result = new ArrayList<Echeancier>();
   		for(Echeancier elev:datas){
   			result.add(new Echeancier(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Echeancier delete(Long id) {
   		// TODO Auto-generated method stub
   		Echeancier elev = super.delete(id);
   		return new Echeancier(elev);
   	}

	@Override
	public void processBeforeSave(Echeancier entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	


}
