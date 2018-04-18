
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.ActionMissionManagerLocal;
import com.keren.core.ifaces.missions.ActionMissionManagerRemote;
import com.keren.dao.ifaces.missions.ActionMissionDAOLocal;
import com.keren.model.missions.ActionMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ActionMissionManager")
public class ActionMissionManagerImpl
    extends AbstractGenericManager<ActionMission, Long>
    implements ActionMissionManagerLocal, ActionMissionManagerRemote
{

    @EJB(name = "ActionMissionDAO")
    protected ActionMissionDAOLocal dao;

    public ActionMissionManagerImpl() {
    }

    @Override
    public GenericDAO<ActionMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ActionMission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ActionMission> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<ActionMission> results = new ArrayList<ActionMission>();
        for(ActionMission data:datas){
            results.add(new ActionMission(data));
        }
        return results;
    }

    @Override
    public List<ActionMission> findAll() {
        List<ActionMission> datas = super.findAll();
        List<ActionMission> results = new ArrayList<ActionMission>();

        for(ActionMission data:datas){
            results.add(new ActionMission(data));
        }
        return results;
    }

    @Override
    public ActionMission find(String propertyName, Long entityID) {
        ActionMission data = super.find(propertyName, entityID);
        ActionMission result = new ActionMission(data);


        return result;
    }

    @Override
    public void processAfterUpdate(ActionMission entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(ActionMission entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

}
