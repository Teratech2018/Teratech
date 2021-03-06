
package com.kerenedu.solde;

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
@Stateless(mappedName = "RubriquePaieManager")
public class RubriquePaieManagerImpl
    extends AbstractGenericManager<RubriquePaie, Long>
    implements RubriquePaieManagerLocal, RubriquePaieManagerRemote
{

    @EJB(name = "RubriquePaieDAO")
    protected RubriquePaieDAOLocal dao;

    public RubriquePaieManagerImpl() {
    }

    @Override
    public GenericDAO<RubriquePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<RubriquePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<RubriquePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<RubriquePaie> result = new ArrayList<RubriquePaie>();
   		for(RubriquePaie elev:datas){
   			result.add(new RubriquePaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(RubriquePaie entity) {
   		if(entity.getBrutsal()==null){
   			entity.setBrutsal(false);
   		}
   		if(entity.getCotisablesal()==null){
   			entity.setCotisablesal(false);
   		}
		super.processBeforeSave(entity);
	}

	@Override
   	public RubriquePaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		RubriquePaie data = super.find(propertyName, entityID);
   		RubriquePaie rub = new RubriquePaie(data);
   		for (ForfaitCategorie forfait : data.getForfaitscat()) {
			rub.getForfaitscat().add(new ForfaitCategorie(forfait));
		}
		
		for (ForfaitCycle forfait : data.getForfaitscycle()) {
			rub.getForfaitscycle().add(new ForfaitCycle(forfait));
		}
		for (ForfaitPersonnel forfait : data.getForfaitsperso()) {
			rub.getForfaitsperso().add(new ForfaitPersonnel(forfait));
		}
   		return rub;
   	}

   	@Override
   	public List<RubriquePaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<RubriquePaie> datas = super.findAll();
   		List<RubriquePaie> result = new ArrayList<RubriquePaie>();
   		for(RubriquePaie elev:datas){
   			result.add(new RubriquePaie(elev));
   		}
   		return result;
   	}
   	
   	


}
