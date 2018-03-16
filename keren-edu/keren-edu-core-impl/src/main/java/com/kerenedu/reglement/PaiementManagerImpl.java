
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
@Stateless(mappedName = "PaiementManager")
public class PaiementManagerImpl
    extends AbstractGenericManager<Paiement, Long>
    implements PaiementManagerLocal, PaiementManagerRemote
{

    @EJB(name = "PaiementDAO")
    protected PaiementDAOLocal dao;

    public PaiementManagerImpl() {
    }

    @Override
    public GenericDAO<Paiement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Paiement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Paiement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Paiement> result = new ArrayList<Paiement>();
   		for(Paiement elev:datas){
   			result.add(new Paiement(elev));
   		}
   		return result;
   	}

   	@Override
   	public Paiement find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Paiement data = super.find(propertyName, entityID);
   		Paiement result = new Paiement(data);
   	
	   	
 	return result;

   	}

   	@Override
   	public List<Paiement> findAll() {
   		// TODO Auto-generated method stub
   		List<Paiement> datas = super.findAll();
   		List<Paiement> result = new ArrayList<Paiement>();
   		for(Paiement elev:datas){
   			result.add(new Paiement(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Paiement delete(Long id) {
   		// TODO Auto-generated method stub
   		Paiement elev = super.delete(id);
   		return new Paiement(elev);
   	}

	@Override
	public void processBeforeSave(Paiement entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	
}
