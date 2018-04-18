
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.ResultatMissionManagerLocal;
import com.keren.core.ifaces.missions.ResultatMissionManagerRemote;
import com.keren.dao.ifaces.missions.ResultatMissionDAOLocal;
import com.keren.model.missions.ActionMission;
import com.keren.model.missions.ResultatMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ResultatMissionManager")
public class ResultatMissionManagerImpl
    extends AbstractGenericManager<ResultatMission, Long>
    implements ResultatMissionManagerLocal, ResultatMissionManagerRemote
{

    @EJB(name = "ResultatMissionDAO")
    protected ResultatMissionDAOLocal dao;

    public ResultatMissionManagerImpl() {
    }

    @Override
    public GenericDAO<ResultatMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

     @Override
    public List<ResultatMission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "encours");
        predicats.addAll(container.getPredicats());
    	List<ResultatMission> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<ResultatMission> results = new ArrayList<ResultatMission>();
        for(ResultatMission data:datas){
            results.add(new ResultatMission(data));
        }
        return results;
    }

    @Override
    public List<ResultatMission> findAll() {
        List<ResultatMission> datas = super.findAll();
        List<ResultatMission> results = new ArrayList<ResultatMission>();

        for(ResultatMission data:datas){
            results.add(new ResultatMission(data));
        }
        return results;
    }

    @Override
    public ResultatMission find(String propertyName, Long entityID) {
        ResultatMission data = super.find(propertyName, entityID);
        ResultatMission result = new ResultatMission(data);

        for(ActionMission aas:data.getActions()){
            result.getActions().add(new ActionMission(aas));
        }


        return result;
    }

    @Override
    public void processAfterUpdate(ResultatMission entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(ResultatMission entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

	@Override
	public ResultatMission cloture(ResultatMission entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("encours")){
			entity.setState("termine");
			entity = dao.update(entity.getId() , entity);
		}//end if(entity.getState().equalsIgnoreCase("encours")){
		return entity;
	}
    
}