
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
@Stateless(mappedName = "StageEManager")
public class StageEManagerImpl
    extends AbstractGenericManager<StageE, Long>
    implements StageEManagerLocal, StageEManagerRemote
{

    @EJB(name = "StageEDAO")
    protected StageEDAOLocal dao;
    
    @EJB(name = "StageCLDAO")
    protected StageCLDAOLocal daocl;

    public StageEManagerImpl() {
    }

    @Override
    public GenericDAO<StageE, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public StageCL terminer(StageE stage) {
    	StageCL result = new StageCL(stage);		
  		result.setId(-1);
  		dao.delete(stage.getId());
  		daocl.save(result);
  		return result;
  	}
      
      @Override
     	public List<StageE> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
     			int firstResult, int maxResult) {
     		// TODO Auto-generated method stub
     		List<StageE> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
     		List<StageE> result = new ArrayList<StageE>();
     		for(StageE elev:datas){
     			result.add(new StageE(elev));
     		}
     		return result;
     	}

     	@Override
     	public StageE find(String propertyName, Long entityID) {
     		// TODO Auto-generated method stub
     		StageE elev = super.find(propertyName, entityID);
     		StageE data = new StageE(elev);
     		return data;
     	}

     	@Override
     	public List<StageE> findAll() {
     		// TODO Auto-generated method stub
     		List<StageE> datas = super.findAll();
     		
     		return datas;
     	}
     	
     	

     	@Override
     	public StageE delete(Long id) {
     		// TODO Auto-generated method stub
     		StageE elev = super.delete(id);
     		return new StageE(elev);
     	}


}
