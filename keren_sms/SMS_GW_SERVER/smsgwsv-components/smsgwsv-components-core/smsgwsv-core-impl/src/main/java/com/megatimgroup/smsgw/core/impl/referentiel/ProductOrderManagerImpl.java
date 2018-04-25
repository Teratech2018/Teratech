
package com.megatimgroup.smsgw.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManagerLocal;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManagerRemote;
import com.megatimgroup.smsgw.dao.ifaces.referentiel.ProductOrderDAOLocal;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;

@TransactionAttribute
@Stateless(mappedName = "ProductOrderManager")
public class ProductOrderManagerImpl
    extends AbstractGenericManager<ProductOrder, Long>
    implements ProductOrderManagerLocal, ProductOrderManagerRemote
{

    @EJB(name = "ProductOrderDAO")
    protected ProductOrderDAOLocal dao;

    public ProductOrderManagerImpl() {
    }

    @Override
    public GenericDAO<ProductOrder, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
