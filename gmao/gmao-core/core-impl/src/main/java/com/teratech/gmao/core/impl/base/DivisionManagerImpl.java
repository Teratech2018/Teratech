
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.DivisionManagerLocal;
import com.teratech.gmao.core.ifaces.base.DivisionManagerRemote;
import com.teratech.gmao.dao.ifaces.base.DivisionDAOLocal;
import com.teratech.gmao.model.base.Division;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "DivisionManager")
public class DivisionManagerImpl
    extends AbstractGenericManager<Division, Long>
    implements DivisionManagerLocal, DivisionManagerRemote
{

    @EJB(name = "DivisionDAO")
    protected DivisionDAOLocal dao;

    public DivisionManagerImpl() {
    }

    @Override
    public GenericDAO<Division, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Division> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Division> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Division> results = new ArrayList<Division>();
        for(Division data:datas){
            results.add(new Division(data));
        }
        return results;
    }

    @Override
    public List<Division> findAll() {
        List<Division> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Division> results = new ArrayList<Division>();
        for(Division data:datas){
            results.add(new Division(data));
        }
        return results;
    }

    @Override
    public Division find(String propertyName, Long entityID) {
        Division data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new Division(data);
    }

    @Override
    public Division delete(Long id) {
        Division data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Division(data);
    }
    
    

}
