
package com.keren.core.impl.stages;

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
import com.keren.core.ifaces.stages.SuiviStageManagerLocal;
import com.keren.core.ifaces.stages.SuiviStageManagerRemote;
import com.keren.dao.ifaces.stages.SuiviStageDAOLocal;
import com.keren.model.stages.EvaluationStage;
import com.keren.model.stages.LivrableStage;
import com.keren.model.stages.SuiviStage;
import com.keren.model.stages.TacheStage;
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
	public List<SuiviStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<SuiviStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<SuiviStage> results = new ArrayList<SuiviStage>();
		for(SuiviStage data:datas){
			results.add(new SuiviStage(data));
		}
		return results;
	}

	@Override
	public SuiviStage find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		SuiviStage data = super.find(propertyName, entityID);
		SuiviStage result = new SuiviStage(data);
		for(TacheStage tach:data.getTaches()){
			result.getTaches().add(new TacheStage(tach));
		}
		for(EvaluationStage tach:data.getEvaluations()){
			result.getEvaluations().add(new EvaluationStage(tach));
		}
		for(LivrableStage tach:data.getLivrables()){
			result.getLivrables().add(new LivrableStage(tach));
		}
		return result;
	}

	@Override
	public List<SuiviStage> findAll() {
		// TODO Auto-generated method stub		
		List<SuiviStage> datas = super.findAll();
		List<SuiviStage> results = new ArrayList<SuiviStage>();
		for(SuiviStage data:datas){
			results.add(new SuiviStage(data));
		}
		return results;
	}
    
    

}
