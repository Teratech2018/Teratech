
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.BonRetour;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 03 09:08:03 WAT 2019
 * 
 */
public interface BonRetourDAO
    extends GenericDAO<BonRetour, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BonRetourDAO";

}
