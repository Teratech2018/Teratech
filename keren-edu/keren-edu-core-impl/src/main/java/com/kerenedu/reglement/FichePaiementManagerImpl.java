
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "FichePaiementManager")
public class FichePaiementManagerImpl
    extends AbstractGenericManager<FichePaiement, Long>
    implements FichePaiementManagerLocal, FichePaiementManagerRemote
{

    @EJB(name = "FichePaiementDAO")
    protected FichePaiementDAOLocal dao;

    public FichePaiementManagerImpl() {
    }

    @Override
    public GenericDAO<FichePaiement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<FichePaiement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
    	Inscription ins = CacheMemory.getIncription();
    	List<FichePaiement> datas = new ArrayList<FichePaiement>();
    	if(ins!=null&&ins.getService().size()!=0){
    		for(FichePaiement fiche : ins.getService()){
    			if(fiche.getSolde()!=0){
    				datas.add(fiche);
    			}
    		}
//    		datas= ins.getService();
    	}else{
    		datas = super.filter(predicats, orders, properties, firstResult, maxResult);
    	}
   		List<FichePaiement> result = new ArrayList<FichePaiement>();
   		for(FichePaiement elev:datas){
   			result.add(new FichePaiement(elev));
   		}
   		return result;
   	}

   	@Override
   	public FichePaiement find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		FichePaiement data = super.find(propertyName, entityID);
   		FichePaiement result = new FichePaiement(data);		
	   	
 	return result;

   	}

   	@Override
   	public List<FichePaiement> findAll() {
   		// TODO Auto-generated method stub
   		List<FichePaiement> datas = super.findAll();
   		List<FichePaiement> result = new ArrayList<FichePaiement>();
   		for(FichePaiement elev:datas){
   			result.add(new FichePaiement(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public FichePaiement delete(Long id) {
   		// TODO Auto-generated method stub
   		FichePaiement elev = super.delete(id);
   		return new FichePaiement(elev);
   	}

	@Override
	public void processBeforeSave(FichePaiement entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	
}
