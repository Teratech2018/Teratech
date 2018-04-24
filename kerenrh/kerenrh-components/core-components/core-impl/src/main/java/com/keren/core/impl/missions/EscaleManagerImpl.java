
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.EscaleManagerLocal;
import com.keren.core.ifaces.missions.EscaleManagerRemote;
import com.keren.dao.ifaces.missions.EscaleDAOLocal;
import com.keren.model.missions.Escale;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EscaleManager")
public class EscaleManagerImpl
    extends AbstractGenericManager<Escale, Long>
    implements EscaleManagerLocal, EscaleManagerRemote
{

    @EJB(name = "EscaleDAO")
    protected EscaleDAOLocal dao;

    public EscaleManagerImpl() {
    }

    @Override
    public GenericDAO<Escale, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Escale> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Escale> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Escale> results = new ArrayList<Escale>();
        for(Escale data:datas){
            results.add(new Escale(data));
        }
        return results;
    }

    @Override
    public List<Escale> findAll() {
        List<Escale> datas = super.findAll();
        List<Escale> results = new ArrayList<Escale>();

        for(Escale data:datas){
            results.add(new Escale(data));
        }
        return results;
    }

    @Override
    public Escale find(String propertyName, Long entityID) {
        Escale data = super.find(propertyName, entityID);
        Escale result = new Escale(data);
        return result;
    }

    @Override
    public void processAfterUpdate(Escale entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Escale entity) {
         entity = dao.findByPrimaryKey("source", entity.getSource());

        super.processAfterSave(entity);
    }

}