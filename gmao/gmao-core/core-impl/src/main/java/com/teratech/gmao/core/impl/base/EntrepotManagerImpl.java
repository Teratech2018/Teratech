
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.EntrepotManagerLocal;
import com.teratech.gmao.core.ifaces.base.EntrepotManagerRemote;
import com.teratech.gmao.dao.ifaces.base.EntrepotDAOLocal;
import com.teratech.gmao.model.base.Contact;
import com.teratech.gmao.model.base.Entrepot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EntrepotManager")
public class EntrepotManagerImpl
    extends AbstractGenericManager<Entrepot, Long>
    implements EntrepotManagerLocal, EntrepotManagerRemote
{

    @EJB(name = "EntrepotDAO")
    protected EntrepotDAOLocal dao;

    public EntrepotManagerImpl() {
    }

    @Override
    public GenericDAO<Entrepot, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    
    @Override
    public List<Entrepot> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Entrepot> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Entrepot> result = new ArrayList<Entrepot>();
        for(Entrepot data:datas){
            result.add(new Entrepot(data));
        }
        return result;
    }

    @Override
    public List<Entrepot> findAll() {       
        List<Entrepot> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Entrepot> result = new ArrayList<Entrepot>();
        for(Entrepot data:datas){
            result.add(new Entrepot(data));
        }
        return result;
    }

    @Override
    public Entrepot find(String propertyName, Long entityID) {
        Entrepot data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Entrepot result = new Entrepot(data);
        for(Contact con:data.getContacts()){
            result.getContacts().add(con);
        }
        return result;
    }

    @Override
    public Entrepot delete(Long id) {
        Entrepot data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Entrepot(data);
    }
    
    
}
