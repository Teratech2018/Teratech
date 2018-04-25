
package com.megatimgroup.smsgw.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatimgroup.smsgw.core.ifaces.referentiel.OrderManagerLocal;
import com.megatimgroup.smsgw.core.ifaces.referentiel.OrderManagerRemote;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.OrderDAOLocal;
import com.megatimgroup.smsgw.model.referentiel.Order;

@TransactionAttribute
@Stateless(mappedName = "OrderManager")
public class OrderManagerImpl
    extends AbstractGenericManager<Order, Long>
    implements OrderManagerLocal, OrderManagerRemote
{

    @EJB(name = "OrderDAO")
    protected OrderDAOLocal dao;

    public OrderManagerImpl() {
    }

    @Override
    public GenericDAO<Order, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
