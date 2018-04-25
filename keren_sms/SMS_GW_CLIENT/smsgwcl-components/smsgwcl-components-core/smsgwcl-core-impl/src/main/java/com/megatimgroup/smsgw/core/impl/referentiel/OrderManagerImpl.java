
package com.megatimgroup.smsgw.core.impl.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.Inject;
import com.megatim.common.annotations.Transaction;
import com.megatimgroup.smsgw.core.ifaces.referentiel.OrderManager;
import com.megatimgroup.smsgw.model.referentiel.Order;


/**
 * Classe d'implementation du manager
 * @since Mon Oct 23 15:06:47 WAT 2017
 * 
 */
@Transaction
public class OrderManagerImpl
    extends AbstractGenericManager<Order, Long>
    implements OrderManager
{

    /**
     * On injecte la DAO
     * 
     */
    @Inject("com.megatimgroup.smsgw.dao.impl.referentiel.OrderDAOImpl")
    protected GenericDAO dao;

    public OrderManagerImpl() {
    }

    /**
     * Methode permettant de retourner la DAO
     * 
     */
    @Override
    public GenericDAO<Order, Long> getDao() {
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
