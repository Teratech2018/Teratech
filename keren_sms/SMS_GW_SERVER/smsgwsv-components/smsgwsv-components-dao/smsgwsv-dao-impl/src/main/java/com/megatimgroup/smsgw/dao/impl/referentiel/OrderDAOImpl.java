
package com.megatimgroup.smsgw.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.OrderDAOLocal;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.OrderDAORemote;
import com.megatimgroup.smsgw.model.referentiel.Order;

@Stateless(mappedName = "OrderDAO")
public class OrderDAOImpl
    extends AbstractGenericDAO<Order, Long>
    implements OrderDAOLocal, OrderDAORemote
{

    @PersistenceContext(unitName = "smsgw")
    protected EntityManager em;

    public OrderDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Order> getManagedEntityClass() {
        return (Order.class);
    }

}
