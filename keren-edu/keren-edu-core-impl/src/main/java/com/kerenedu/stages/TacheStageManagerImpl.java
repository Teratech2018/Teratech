
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
@Stateless(mappedName = "TacheStageManager")
public class TacheStageManagerImpl
    extends AbstractGenericManager<TacheStage, Long>
    implements TacheStageManagerLocal, TacheStageManagerRemote
{

    @EJB(name = "TacheStageDAO")
    protected TacheStageDAOLocal dao;

    public TacheStageManagerImpl() {
    }

    @Override
    public GenericDAO<TacheStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<TacheStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<TacheStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<TacheStage> result = new ArrayList<TacheStage>();
   		for(TacheStage elev:datas){
   			result.add(new TacheStage(elev));
   		}
   		return result;
   	}

   	@Override
   	public TacheStage find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		TacheStage result = super.find(propertyName, entityID);
   		TacheStage data = new TacheStage(result);
   		
   		return data;
   	}

   	@Override
   	public List<TacheStage> findAll() {
   		// TODO Auto-generated method stub
   		List<TacheStage> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public TacheStage delete(Long id) {
   		// TODO Auto-generated method stub
   		TacheStage elev = super.delete(id);
   		return new TacheStage(elev);
   	}

}
