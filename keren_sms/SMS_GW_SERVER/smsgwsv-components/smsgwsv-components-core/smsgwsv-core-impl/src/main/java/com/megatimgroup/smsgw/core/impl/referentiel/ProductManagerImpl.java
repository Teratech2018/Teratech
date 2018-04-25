
package com.megatimgroup.smsgw.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductManagerLocal;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductManagerRemote;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductDAOLocal;
import com.megatimgroup.smsgw.model.referentiel.Product;

@TransactionAttribute
@Stateless(mappedName = "ProductManager")
public class ProductManagerImpl
    extends AbstractGenericManager<Product, Long>
    implements ProductManagerLocal, ProductManagerRemote
{

    @EJB(name = "ProductDAO")
    protected ProductDAOLocal dao;

    public ProductManagerImpl() {
    }

    @Override
    public GenericDAO<Product, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
