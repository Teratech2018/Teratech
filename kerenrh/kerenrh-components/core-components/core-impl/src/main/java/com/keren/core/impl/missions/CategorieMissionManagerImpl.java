
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.CategorieMissionManagerLocal;
import com.keren.core.ifaces.missions.CategorieMissionManagerRemote;
import com.keren.dao.ifaces.missions.CategorieMissionDAOLocal;
import com.keren.model.missions.CategorieMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CategorieMissionManager")
public class CategorieMissionManagerImpl
    extends AbstractGenericManager<CategorieMission, Long>
    implements CategorieMissionManagerLocal, CategorieMissionManagerRemote
{

    @EJB(name = "CategorieMissionDAO")
    protected CategorieMissionDAOLocal dao;

    public CategorieMissionManagerImpl() {
    }

    @Override
    public GenericDAO<CategorieMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<CategorieMission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CategorieMission> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<CategorieMission> results = new ArrayList<CategorieMission>();
        for(CategorieMission data:datas){
            results.add(new CategorieMission(data));
        }
        return results;
    }

    @Override
    public List<CategorieMission> findAll() {
        List<CategorieMission> datas = super.findAll();
        List<CategorieMission> results = new ArrayList<CategorieMission>();

        for(CategorieMission data:datas){
            results.add(new CategorieMission(data));
        }
        return results;
    }

    @Override
    public CategorieMission find(String propertyName, Long entityID) {
        CategorieMission data = super.find(propertyName, entityID);
        CategorieMission result = new CategorieMission(data);


        return result;
    }

    @Override
    public void processAfterUpdate(CategorieMission entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(CategorieMission entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

}