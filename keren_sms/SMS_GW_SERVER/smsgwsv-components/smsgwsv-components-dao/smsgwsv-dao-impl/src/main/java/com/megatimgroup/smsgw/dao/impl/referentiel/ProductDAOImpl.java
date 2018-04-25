
package com.megatimgroup.smsgw.dao.impl.referentiel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductDAOLocal;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductDAORemote;
import com.megatimgroup.smsgw.model.referentiel.Product;

@Stateless(mappedName = "ProductDAO")
public class ProductDAOImpl
    extends AbstractGenericDAO<Product, Long>
    implements ProductDAOLocal, ProductDAORemote
{

    @PersistenceContext(unitName = "smsgw")
    protected EntityManager em;

    public ProductDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Product> getManagedEntityClass() {
        return (Product.class);
    }

}
