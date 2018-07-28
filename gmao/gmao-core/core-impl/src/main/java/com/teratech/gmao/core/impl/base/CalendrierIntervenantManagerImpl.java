
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.CalendrierIntervenantManagerLocal;
import com.teratech.gmao.core.ifaces.base.CalendrierIntervenantManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CalendrierIntervenantDAOLocal;
import com.teratech.gmao.model.base.CalendrierIntervenant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CalendrierIntervenantManager")
public class CalendrierIntervenantManagerImpl
    extends AbstractGenericManager<CalendrierIntervenant, Long>
    implements CalendrierIntervenantManagerLocal, CalendrierIntervenantManagerRemote
{

    @EJB(name = "CalendrierIntervenantDAO")
    protected CalendrierIntervenantDAOLocal dao;

    public CalendrierIntervenantManagerImpl() {
    }

    @Override
    public GenericDAO<CalendrierIntervenant, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<CalendrierIntervenant> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CalendrierIntervenant> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CalendrierIntervenant> results = new ArrayList<CalendrierIntervenant>();
        for(CalendrierIntervenant ca:datas){
            results.add(new CalendrierIntervenant(ca));
        }
        return results;
    }

    @Override
    public List<CalendrierIntervenant> findAll() {        
        List<CalendrierIntervenant> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<CalendrierIntervenant> results = new ArrayList<CalendrierIntervenant>();
        for(CalendrierIntervenant ca:datas){
            results.add(new CalendrierIntervenant(ca));
        }
        return results;
    }

    @Override
    public CalendrierIntervenant find(String propertyName, Long entityID) {
        CalendrierIntervenant data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CalendrierIntervenant result = new CalendrierIntervenant(data);
        return result;
    }

    @Override
    public CalendrierIntervenant delete(Long id) {
        CalendrierIntervenant data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new CalendrierIntervenant(data);
    }

    @Override
    public void processBeforeUpdate(CalendrierIntervenant entity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entity.getDay());
        calendar.set(Calendar.HOUR, 1+Integer.valueOf(entity.getHdebut().split(":")[0]));
        calendar.set(Calendar.MINUTE, 1+Integer.valueOf(entity.getHdebut().split(":")[1]));
        entity.setDebut(calendar.getTime());
        calendar.set(Calendar.HOUR, 1+Integer.valueOf(entity.getHfin().split(":")[0]));
        calendar.set(Calendar.MINUTE, 1+Integer.valueOf(entity.getHfin().split(":")[1]));
        entity.setFin(calendar.getTime());
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(CalendrierIntervenant entity) {
         Calendar calendar = Calendar.getInstance();
        calendar.setTime(entity.getDay());
        calendar.set(Calendar.HOUR, 1+Integer.valueOf(entity.getHdebut().split(":")[0]));
        calendar.set(Calendar.MINUTE, 1+Integer.valueOf(entity.getHdebut().split(":")[1]));
        entity.setDebut(calendar.getTime());
        calendar.set(Calendar.HOUR, 1+Integer.valueOf(entity.getHfin().split(":")[0]));
        calendar.set(Calendar.MINUTE, 1+Integer.valueOf(entity.getHfin().split(":")[1]));
        entity.setFin(calendar.getTime());
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
