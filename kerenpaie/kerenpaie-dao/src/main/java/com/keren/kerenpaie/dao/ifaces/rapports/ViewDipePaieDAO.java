
package com.keren.kerenpaie.dao.ifaces.rapports;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Apr 19 10:00:58 WAT 2018
 * 
 */
public interface ViewDipePaieDAO
    extends GenericDAO<ViewDipePaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewDipePaieDAO";

}
