
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.FraisMissionManagerLocal;
import com.keren.core.ifaces.missions.FraisMissionManagerRemote;
import com.keren.dao.ifaces.missions.FraisMissionDAOLocal;
import com.keren.model.missions.FraisMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FraisMissionManager")
public class FraisMissionManagerImpl
    extends AbstractGenericManager<FraisMission, Long>
    implements FraisMissionManagerLocal, FraisMissionManagerRemote
{

    @EJB(name = "FraisMissionDAO")
    protected FraisMissionDAOLocal dao;

    public FraisMissionManagerImpl() {
    }

    @Override
    public GenericDAO<FraisMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<FraisMission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<FraisMission> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<FraisMission> results = new ArrayList<FraisMission>();
        for(FraisMission data:datas){
            results.add(new FraisMission(data));
        }
        return results;
    }

    @Override
    public List<FraisMission> findAll() {
        List<FraisMission> datas = super.findAll();
        List<FraisMission> results = new ArrayList<FraisMission>();

        for(FraisMission data:datas){
            results.add(new FraisMission(data));
        }
        return results;
    }

    @Override
    public FraisMission find(String propertyName, Long entityID) {
        FraisMission data = super.find(propertyName, entityID);
        FraisMission result = new FraisMission(data);


        return result;
    }

    @Override
    public void processAfterUpdate(FraisMission entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(FraisMission entity) {
         entity = dao.findByPrimaryKey("categorie", entity.getCategorie());

        super.processAfterSave(entity);
    }
}

