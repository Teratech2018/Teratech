
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
@Stateless(mappedName = "SuiviStageEleveManager")
public class SuiviStageEleveManagerImpl
    extends AbstractGenericManager<SuiviStageEleve, Long>
    implements SuiviStageEleveManagerLocal, SuiviStageEleveManagerRemote
{

    @EJB(name = "SuiviStageEleveDAO")
    protected SuiviStageEleveDAOLocal dao;

    public SuiviStageEleveManagerImpl() {
    }

    @Override
    public GenericDAO<SuiviStageEleve, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
 	public List<SuiviStageEleve> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<SuiviStageEleve> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<SuiviStageEleve> result = new ArrayList<SuiviStageEleve>();
 		for(SuiviStageEleve elev:datas){
 			result.add(new SuiviStageEleve(elev));
 		}
 		return result;
 	}

 	@Override
 	public SuiviStageEleve find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		SuiviStageEleve result = super.find(propertyName, entityID);
 		SuiviStageEleve data = new SuiviStageEleve(result);
 		
 		for(EvaluationStage eval : result.getEvaluation()){
 			data.getEvaluation().add(new EvaluationStage(eval));
 		}
 		for(TacheStage tache : result.getTaches()){
 			data.getTaches().add(new TacheStage(tache));
 		}
 		return data;
 	}

 	@Override
 	public List<SuiviStageEleve> findAll() {
 		// TODO Auto-generated method stub
 		List<SuiviStageEleve> datas = super.findAll();
 		
 		return datas;
 	}
 	
 	

 	@Override
 	public SuiviStageEleve delete(Long id) {
 		// TODO Auto-generated method stub
 		SuiviStageEleve elev = super.delete(id);
 		return new SuiviStageEleve(elev);
 	}

}
