
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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SuiviStageManager")
public class SuiviStageManagerImpl
    extends AbstractGenericManager<SuiviStage, Long>
    implements SuiviStageManagerLocal, SuiviStageManagerRemote
{

    @EJB(name = "SuiviStageDAO")
    protected SuiviStageDAOLocal dao;

    public SuiviStageManagerImpl() {
    }

    @Override
    public GenericDAO<SuiviStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public SuiviStage confirmer(SuiviStage stage) {
    	stage.setState("encours");
  		dao.update(stage.getId(), stage);
  		return stage;
  	}
    
    @Override
  	public SuiviStage terminer(SuiviStage stage) {
    	stage.setState("terminer");
  		dao.update(stage.getId(), stage);
  		return stage;
  	}
      
      @Override
     	public List<SuiviStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
     			int firstResult, int maxResult) {
     		// TODO Auto-generated method stub
     		List<SuiviStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
     		List<SuiviStage> result = new ArrayList<SuiviStage>();
     		for(SuiviStage elev:datas){
     			result.add(new SuiviStage(elev));
     		}
     		return result;
     	}

     	@Override
     	public SuiviStage find(String propertyName, Long entityID) {
     		// TODO Auto-generated method stub
     		SuiviStage result = super.find(propertyName, entityID);
     		SuiviStage data = new SuiviStage(result);
     		
     		for(SuiviStageEleve el : result.getStagiaires()){
     			data.getStagiaires().add(new SuiviStageEleve(el));
     		}
     		return data;
     	}

     	@Override
     	public List<SuiviStage> findAll() {
     		// TODO Auto-generated method stub
     		List<SuiviStage> datas = super.findAll();
     		
     		return datas;
     	}
     	
     	

     	@Override
     	public SuiviStage delete(Long id) {
     		// TODO Auto-generated method stub
     		SuiviStage elev = super.delete(id);
     		return new SuiviStage(elev);
     	}



}
