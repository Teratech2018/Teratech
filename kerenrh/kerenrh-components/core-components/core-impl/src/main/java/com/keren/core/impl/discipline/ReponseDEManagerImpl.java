
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
import com.keren.core.ifaces.discipline.ReponseDEManagerLocal;
import com.keren.core.ifaces.discipline.ReponseDEManagerRemote;
import com.keren.dao.ifaces.discipline.ReponseDEDAOLocal;
import com.keren.model.discipline.ReponseDE;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReponseDEManager")
public class ReponseDEManagerImpl
    extends AbstractGenericManager<ReponseDE, Long>
    implements ReponseDEManagerLocal, ReponseDEManagerRemote
{

    @EJB(name = "ReponseDEDAO")
    protected ReponseDEDAOLocal dao;

    public ReponseDEManagerImpl() {
    }

    @Override
    public GenericDAO<ReponseDE, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    
    @Override
  	public ReponseDE delete(Long id) {
  		// TODO Auto-generated method stub
  		ReponseDE data= super.delete(id);
  		return new ReponseDE(data);
  	}

  	@Override
  	public List<ReponseDE> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<ReponseDE> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<ReponseDE> result = new ArrayList<ReponseDE>();
  		for(ReponseDE data:datas){
  			result.add(new ReponseDE(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public ReponseDE find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		ReponseDE data = super.find(propertyName, entityID);
  		ReponseDE result = new ReponseDE(data);		
  		return result;
  	}

  	@Override
  	public List<ReponseDE> findAll() {
  		// TODO Auto-generated method stub
  		List<ReponseDE> datas = super.findAll();
  		List<ReponseDE> result = new ArrayList<ReponseDE>();
  		for(ReponseDE data:datas){
  			result.add(new ReponseDE(data));
  		}
  		return result;
  	}

}
