
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.LotManagerLocal;
import com.teratech.stock.core.ifaces.operations.LotManagerRemote;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.model.operations.Lot;
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
    public List<Lot> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addIsFalse("vide");
        predicats.addAll(container.getPredicats());
        return super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
