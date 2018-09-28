
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
@Stateless(mappedName = "LignePaieManager")
public class LignePaieManagerImpl
    extends AbstractGenericManager<LignePaie, Long>
    implements LignePaieManagerLocal, LignePaieManagerRemote
{

    @EJB(name = "LignePaieDAO")
    protected LignePaieDAOLocal dao;

    public LignePaieManagerImpl() {
    }

    @Override
    public GenericDAO<LignePaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<LignePaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<LignePaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<LignePaie> result = new ArrayList<LignePaie>();
   		for(LignePaie elev:datas){
   			result.add(new LignePaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(LignePaie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public LignePaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		LignePaie elev = super.find(propertyName, entityID);
   		LignePaie inscrip = new LignePaie(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<LignePaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<LignePaie> datas = super.findAll();
   		List<LignePaie> result = new ArrayList<LignePaie>();
   		for(LignePaie elev:datas){
   			result.add(new LignePaie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public LignePaie delete(Long id) {
   		// TODO Auto-generated method stub
   		LignePaie elev = super.delete(id);
   		return new LignePaie(elev);
   	}


}
