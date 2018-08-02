
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.EmplacementManagerLocal;
import com.teratech.gmao.core.ifaces.base.EmplacementManagerRemote;
import com.teratech.gmao.dao.ifaces.base.EmplacementDAOLocal;
import com.teratech.gmao.model.base.Emplacement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EmplacementManager")
public class EmplacementManagerImpl
    extends AbstractGenericManager<Emplacement, Long>
    implements EmplacementManagerLocal, EmplacementManagerRemote
{

    @EJB(name = "EmplacementDAO")
    protected EmplacementDAOLocal dao;

    public EmplacementManagerImpl() {
    }

    @Override
    public GenericDAO<Emplacement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
    public List<Emplacement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Emplacement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Emplacement> result = new ArrayList<Emplacement>();
        for(Emplacement emp:datas){
            result.add(new Emplacement(emp));
        }
        return result;
    }

    @Override
    public List<Emplacement> findAll() {        
        List<Emplacement> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Emplacement> result = new ArrayList<Emplacement>();
        for(Emplacement emp:datas){
            result.add(new Emplacement(emp));
        }
        return result;
    }

    @Override
    public Emplacement find(String propertyName, Long entityID) {
        Emplacement data= super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Emplacement result = new Emplacement(data);        
        return result;
    }

    @Override
    public Emplacement delete(Long id) {
        Emplacement data= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Emplacement(data);
    }
    
    

}
