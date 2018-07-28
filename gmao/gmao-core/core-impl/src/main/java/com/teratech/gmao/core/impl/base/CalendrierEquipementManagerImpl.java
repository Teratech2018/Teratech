
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.CalendrierEquipementManagerLocal;
import com.teratech.gmao.core.ifaces.base.CalendrierEquipementManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CalendrierEquipementDAOLocal;
import com.teratech.gmao.model.base.CalendrierEquipement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CalendrierEquipementManager")
public class CalendrierEquipementManagerImpl
    extends AbstractGenericManager<CalendrierEquipement, Long>
    implements CalendrierEquipementManagerLocal, CalendrierEquipementManagerRemote
{

    @EJB(name = "CalendrierEquipementDAO")
    protected CalendrierEquipementDAOLocal dao;

    public CalendrierEquipementManagerImpl() {
    }

    @Override
    public GenericDAO<CalendrierEquipement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<CalendrierEquipement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<CalendrierEquipement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<CalendrierEquipement> results = new ArrayList<CalendrierEquipement>();
        for(CalendrierEquipement data:datas){
            results.add(new CalendrierEquipement(data));
        }
        return results;
    }

    @Override
    public List<CalendrierEquipement> findAll() {
        List<CalendrierEquipement> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<CalendrierEquipement> results = new ArrayList<CalendrierEquipement>();
        for(CalendrierEquipement data:datas){
            results.add(new CalendrierEquipement(data));
        }
        return results;
    }

    @Override
    public CalendrierEquipement find(String propertyName, Long entityID) {
        CalendrierEquipement data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new CalendrierEquipement(data);
    }

    @Override
    public CalendrierEquipement delete(Long id) {
        CalendrierEquipement data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new CalendrierEquipement(data);
    }
    
     @Override
    public void processBeforeUpdate(CalendrierEquipement entity) {
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
    public void processBeforeSave(CalendrierEquipement entity) {
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
