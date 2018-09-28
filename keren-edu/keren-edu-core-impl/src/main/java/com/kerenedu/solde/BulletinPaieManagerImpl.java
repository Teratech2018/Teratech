
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
@Stateless(mappedName = "BulletinPaieManager")
public class BulletinPaieManagerImpl
    extends AbstractGenericManager<BulletinPaie, Long>
    implements BulletinPaieManagerLocal, BulletinPaieManagerRemote
{

    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal dao;

    public BulletinPaieManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<BulletinPaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<BulletinPaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
   		for(BulletinPaie elev:datas){
   			result.add(new BulletinPaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(BulletinPaie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public BulletinPaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		BulletinPaie datas = super.find(propertyName, entityID);
   		BulletinPaie result = new BulletinPaie(datas);
   		for(LignePaie ligne: datas.getLignes()){
   			result.getLignes().add(new LignePaie(ligne));
   		}
   		return result;
   	}

   	@Override
   	public List<BulletinPaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<BulletinPaie> datas = super.findAll();
   		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
   		for(BulletinPaie elev:datas){
   			result.add(new BulletinPaie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public BulletinPaie delete(Long id) {
   		// TODO Auto-generated method stub
   		BulletinPaie elev = super.delete(id);
   		return new BulletinPaie(elev);
   	}


}
