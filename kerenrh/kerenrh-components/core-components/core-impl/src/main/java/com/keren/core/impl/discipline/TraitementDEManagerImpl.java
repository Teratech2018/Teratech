
package com.keren.core.impl.discipline;

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
import com.keren.core.ifaces.discipline.TraitementDEManagerLocal;
import com.keren.core.ifaces.discipline.TraitementDEManagerRemote;
import com.keren.dao.ifaces.discipline.TraitementDEDAOLocal;
import com.keren.model.discipline.TraitementDE;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "TraitementDEManager")
public class TraitementDEManagerImpl
    extends AbstractGenericManager<TraitementDE, Long>
    implements TraitementDEManagerLocal, TraitementDEManagerRemote
{

    @EJB(name = "TraitementDEDAO")
    protected TraitementDEDAOLocal dao;

    public TraitementDEManagerImpl() {
    }

    @Override
    public GenericDAO<TraitementDE, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    

  	@Override
  	public List<TraitementDE> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<TraitementDE> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<TraitementDE> result = new ArrayList<TraitementDE>();
  		for(TraitementDE data:datas){
  			result.add(new TraitementDE(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public TraitementDE find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		TraitementDE data = super.find(propertyName, entityID);
  		TraitementDE result = new TraitementDE(data);		
  		return result;
  	}

  	@Override
  	public List<TraitementDE> findAll() {
  		// TODO Auto-generated method stub
  		List<TraitementDE> datas = super.findAll();
  		List<TraitementDE> result = new ArrayList<TraitementDE>();
  		for(TraitementDE data:datas){
  			result.add(new TraitementDE(data));
  		}
  		return result;
  	}

}
