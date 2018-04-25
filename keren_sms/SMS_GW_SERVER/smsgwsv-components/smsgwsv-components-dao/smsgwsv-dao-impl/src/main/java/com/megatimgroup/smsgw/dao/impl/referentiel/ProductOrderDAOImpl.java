
package com.megatimgroup.smsgw.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductOrderDAOLocal;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductOrderDAORemote;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;

@Stateless(mappedName = "ProductOrderDAO")
public class ProductOrderDAOImpl
    extends AbstractGenericDAO<ProductOrder, Long>
    implements ProductOrderDAOLocal, ProductOrderDAORemote
{

    @PersistenceContext(unitName = "smsgw")
    protected EntityManager em;

    public ProductOrderDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ProductOrder> getManagedEntityClass() {
        return (ProductOrder.class);
    }

}
