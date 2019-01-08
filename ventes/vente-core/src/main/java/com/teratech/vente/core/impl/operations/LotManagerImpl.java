
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.operations.LotManagerLocal;
import com.teratech.vente.core.ifaces.operations.LotManagerRemote;
import com.teratech.vente.dao.ifaces.operations.LotDAOLocal;
import com.teratech.vente.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "LotManager")
public class LotManagerImpl
    extends AbstractGenericManager<Lot, Long>
    implements LotManagerLocal, LotManagerRemote
{

    @EJB(name = "LotDAO")
    protected LotDAOLocal dao;

    public LotManagerImpl() {
    }

    @Override
    public GenericDAO<Lot, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lot> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addGt("disponible", 0.0);
        predicats.addAll(container.getPredicats());
        List<Lot> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Lot> result = new ArrayList<Lot>();
        for(Lot data:datas){
            result.add(new Lot(data));
        }
        return result;
    }

    @Override
    public Lot find(String propertyName, Long entityID) {
        Lot data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Lot entity = new Lot(data);
        return entity;
    }

    @Override
    public Lot delete(Long id) {
        Lot data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Lot(data);
    }
    
    

}
