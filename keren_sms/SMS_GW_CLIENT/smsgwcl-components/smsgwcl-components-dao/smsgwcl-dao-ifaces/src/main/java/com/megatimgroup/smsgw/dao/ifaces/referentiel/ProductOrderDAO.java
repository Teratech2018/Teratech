
package com.megatimgroup.smsgw.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Oct 23 15:06:47 WAT 2017
 * 
 */
public interface ProductOrderDAO
    extends GenericDAO<ProductOrder, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ProductOrderDAO";

}
