
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
@Stateless(mappedName = "BanqueManager")
public class BanqueManagerImpl
    extends AbstractGenericManager<Banque, Long>
    implements BanqueManagerLocal, BanqueManagerRemote
{

    @EJB(name = "BanqueDAO")
    protected BanqueDAOLocal dao;

    public BanqueManagerImpl() {
    }

    @Override
    public GenericDAO<Banque, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Banque> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<Banque> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Banque> result = new ArrayList<Banque>();
   		for(Banque elev:datas){
   			result.add(new Banque(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(Banque entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public Banque find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Banque elev = super.find(propertyName, entityID);
   		Banque inscrip = new Banque(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<Banque> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<Banque> datas = super.findAll();
   		List<Banque> result = new ArrayList<Banque>();
   		for(Banque elev:datas){
   			result.add(new Banque(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Banque delete(Long id) {
   		// TODO Auto-generated method stub
   		Banque elev = super.delete(id);
   		return new Banque(elev);
   	}


}
