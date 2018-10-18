
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
@Stateless(mappedName = "ProfilPaieManager")
public class ProfilPaieManagerImpl
    extends AbstractGenericManager<ProfilPaie, Long>
    implements ProfilPaieManagerLocal, ProfilPaieManagerRemote
{

    @EJB(name = "ProfilPaieDAO")
    protected ProfilPaieDAOLocal dao;

    public ProfilPaieManagerImpl() {
    }

    @Override
    public GenericDAO<ProfilPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<ProfilPaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<ProfilPaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ProfilPaie> result = new ArrayList<ProfilPaie>();
   		for(ProfilPaie elev:datas){
   			result.add(new ProfilPaie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(ProfilPaie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public ProfilPaie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ProfilPaie elev = super.find(propertyName, entityID);
   		ProfilPaie inscrip = new ProfilPaie(elev);
   		for(RubriquePaie serv: elev.getRubriques()){
   			inscrip.getRubriques().add(new RubriquePaie(serv));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<ProfilPaie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<ProfilPaie> datas = super.findAll();
   		List<ProfilPaie> result = new ArrayList<ProfilPaie>();
   		for(ProfilPaie elev:datas){
   			result.add(new ProfilPaie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ProfilPaie delete(Long id) {
   		// TODO Auto-generated method stub
   		ProfilPaie elev = super.delete(id);
   		return new ProfilPaie(elev);
   	}


}
