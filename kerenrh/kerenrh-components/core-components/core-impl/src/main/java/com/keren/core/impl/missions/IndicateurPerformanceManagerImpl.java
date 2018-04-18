
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerLocal;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerRemote;
import com.keren.dao.ifaces.missions.IndicateurPerformanceDAOLocal;
import com.keren.model.missions.IndicateurPerformance;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "IndicateurPerformanceManager")
public class IndicateurPerformanceManagerImpl
    extends AbstractGenericManager<IndicateurPerformance, Long>
    implements IndicateurPerformanceManagerLocal, IndicateurPerformanceManagerRemote
{

    @EJB(name = "IndicateurPerformanceDAO")
    protected IndicateurPerformanceDAOLocal dao;

    public IndicateurPerformanceManagerImpl() {
    }

    @Override
    public GenericDAO<IndicateurPerformance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<IndicateurPerformance> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<IndicateurPerformance> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<IndicateurPerformance> results = new ArrayList<IndicateurPerformance>();
        for(IndicateurPerformance data:datas){
            results.add(new IndicateurPerformance(data));
        }
        return results;
    }

    @Override
    public List<IndicateurPerformance> findAll() {
        List<IndicateurPerformance> datas = super.findAll();
        List<IndicateurPerformance> results = new ArrayList<IndicateurPerformance>();

        for(IndicateurPerformance data:datas){
            results.add(new IndicateurPerformance(data));
        }
        return results;
    }

    @Override
    public IndicateurPerformance find(String propertyName, Long entityID) {
        IndicateurPerformance data = super.find(propertyName, entityID);
        IndicateurPerformance result = new IndicateurPerformance(data);


        return result;
    }

    @Override
    public void processAfterUpdate(IndicateurPerformance entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(IndicateurPerformance entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

}
/*

    @Override
    public List<IndicateurPerformance> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<IndicateurPerformance> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<IndicateurPerformance> results = new ArrayList<IndicateurPerformance>();
        for(IndicateurPerformance data:datas){
            results.add(new IndicateurPerformance(data));
        }
        return results;
    }

    @Override
    public List<IndicateurPerformance> findAll() {
        List<IndicateurPerformance> datas = super.findAll();
        List<IndicateurPerformance> results = new ArrayList<IndicateurPerformance>();

        for(IndicateurPerformance data:datas){
            results.add(new IndicateurPerformance(data));
        }
        return results;
    }

    @Override
    public IndicateurPerformance find(String propertyName, Long entityID) {
        IndicateurPerformance data = super.find(propertyName, entityID);
        IndicateurPerformance result = new IndicateurPerformance(data);


        return result;
    }

    @Override
    public void processAfterUpdate(IndicateurPerformance entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(IndicateurPerformance entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

    @Override
    public IndicateurPerformance valide(IndicateurPerformance entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        IndicateurPerformance data = dao.update(entity.getId(), entity);


        IndicateurPerformance result = new IndicateurPerformance(data);

        return result;

    @Override
    public IndicateurPerformance annule(IndicateurPerformance entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        IndicateurPerformance data = dao.update(entity.getId(), entity);
        return new IndicateurPerformance(data);
    }

*/
