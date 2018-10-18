
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
@Stateless(mappedName = "GrilleSalaireManager")
public class GrilleSalaireManagerImpl
    extends AbstractGenericManager<GrilleSalaire, Long>
    implements GrilleSalaireManagerLocal, GrilleSalaireManagerRemote
{

    @EJB(name = "GrilleSalaireDAO")
    protected GrilleSalaireDAOLocal dao;

    public GrilleSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<GrilleSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<GrilleSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<GrilleSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<GrilleSalaire> result = new ArrayList<GrilleSalaire>();
   		for(GrilleSalaire elev:datas){
   			result.add(new GrilleSalaire(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(GrilleSalaire entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public GrilleSalaire find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		GrilleSalaire datas = super.find(propertyName, entityID);
   		GrilleSalaire result = new GrilleSalaire(datas);
   		for(LigneGrilleSalaire ligne: datas.getIndicessolde()){
   			result.getIndicessolde().add(new LigneGrilleSalaire(ligne));
   		}
   		return result;
   	}

   	@Override
   	public List<GrilleSalaire> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<GrilleSalaire> datas = super.findAll();
   		List<GrilleSalaire> result = new ArrayList<GrilleSalaire>();
   		for(GrilleSalaire elev:datas){
   			result.add(new GrilleSalaire(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public GrilleSalaire delete(Long id) {
   		// TODO Auto-generated method stub
   		GrilleSalaire elev = super.delete(id);
   		return new GrilleSalaire(elev);
   	}



}
