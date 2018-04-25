
package com.megatimgroup.smsgw.core.impl.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManager;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;


/**
 * Classe d'implementation du manager
 * @since Mon Oct 23 15:06:48 WAT 2017
 * 
 */
@Transaction
public class ProductOrderManagerImpl
    extends AbstractGenericManager<ProductOrder, Long>
    implements ProductOrderManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.smsgw.dao.impl.referentiel.ProductOrderDAOImpl")
    protected GenericDAO dao;

    public ProductOrderManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<ProductOrder, Long> getDao() {
        return dao;
    }

    /**
     * Methode permettant de retourner l'id de l'entite
     * 
     */
    @Override
    public String getEntityIdName() {
        return "id";
    }

}
