
package com.kerenedu.stages;

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
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "StageManager")
public class StageManagerImpl
    extends AbstractGenericManager<Stage, Long>
    implements StageManagerLocal, StageManagerRemote
{

    @EJB(name = "StageDAO")
    protected StageDAOLocal dao;
    

    public StageManagerImpl() {
    }

    @Override
    public GenericDAO<Stage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public Stage confirmer(Stage stage) {
    	stage.setState("encours");
  		dao.update(stage.getId(), stage);
  		return stage;
  	}
    
    @Override
  	public Stage terminer(Stage stage) {
    	stage.setState("terminer");
  		dao.update(stage.getId(), stage);
  		return stage;
  	}
      
      @Override
     	public List<Stage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
     			int firstResult, int maxResult) {
     		// TODO Auto-generated method stub
     		List<Stage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
     		List<Stage> result = new ArrayList<Stage>();
     		for(Stage elev:datas){
     			result.add(new Stage(elev));
     		}
     		return result;
     	}

     	@Override
     	public Stage find(String propertyName, Long entityID) {
     		// TODO Auto-generated method stub
     		Stage elev = super.find(propertyName, entityID);
     		Stage data = new Stage(elev);
     		
     		for(Inscription el : elev.getElevelist()){
     			data.getElevelist().add(new Inscription(el));
     		}
     		return data;
     	}

     	@Override
     	public List<Stage> findAll() {
     		// TODO Auto-generated method stub
     		List<Stage> datas = super.findAll();
     		
     		return datas;
     	}
     	
     	

     	@Override
     	public Stage delete(Long id) {
     		// TODO Auto-generated method stub
     		Stage elev = super.delete(id);
     		return new Stage(elev);
     	}


}
