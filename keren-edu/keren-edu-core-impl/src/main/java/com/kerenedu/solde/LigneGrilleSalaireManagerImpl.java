
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
@Stateless(mappedName = "LigneGrilleSalaireManager")
public class LigneGrilleSalaireManagerImpl
    extends AbstractGenericManager<LigneGrilleSalaire, Long>
    implements LigneGrilleSalaireManagerLocal, LigneGrilleSalaireManagerRemote
{

    @EJB(name = "LigneGrilleSalaireDAO")
    protected LigneGrilleSalaireDAOLocal dao;

    public LigneGrilleSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<LigneGrilleSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
   	public List<LigneGrilleSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<LigneGrilleSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<LigneGrilleSalaire> result = new ArrayList<LigneGrilleSalaire>();
   		for(LigneGrilleSalaire elev:datas){
   			result.add(new LigneGrilleSalaire(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(LigneGrilleSalaire entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public LigneGrilleSalaire find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		LigneGrilleSalaire elev = super.find(propertyName, entityID);
   		LigneGrilleSalaire inscrip = new LigneGrilleSalaire(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<LigneGrilleSalaire> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<LigneGrilleSalaire> datas = super.findAll();
   		List<LigneGrilleSalaire> result = new ArrayList<LigneGrilleSalaire>();
   		for(LigneGrilleSalaire elev:datas){
   			result.add(new LigneGrilleSalaire(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public LigneGrilleSalaire delete(Long id) {
   		// TODO Auto-generated method stub
   		LigneGrilleSalaire elev = super.delete(id);
   		return new LigneGrilleSalaire(elev);
   	}

}
