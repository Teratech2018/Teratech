
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
@Stateless(mappedName = "EvaluationStageManager")
public class EvaluationStageManagerImpl
    extends AbstractGenericManager<EvaluationStage, Long>
    implements EvaluationStageManagerLocal, EvaluationStageManagerRemote
{

    @EJB(name = "EvaluationStageDAO")
    protected EvaluationStageDAOLocal dao;

    public EvaluationStageManagerImpl() {
    }

    @Override
    public GenericDAO<EvaluationStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<EvaluationStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<EvaluationStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EvaluationStage> result = new ArrayList<EvaluationStage>();
   		for(EvaluationStage elev:datas){
   			result.add(new EvaluationStage(elev));
   		}
   		return result;
   	}

   	@Override
   	public EvaluationStage find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EvaluationStage result = super.find(propertyName, entityID);
   		EvaluationStage data = new EvaluationStage(result);
   		
   		return data;
   	}

   	@Override
   	public List<EvaluationStage> findAll() {
   		// TODO Auto-generated method stub
   		List<EvaluationStage> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public EvaluationStage delete(Long id) {
   		// TODO Auto-generated method stub
   		EvaluationStage elev = super.delete(id);
   		return new EvaluationStage(elev);
   	}

}
