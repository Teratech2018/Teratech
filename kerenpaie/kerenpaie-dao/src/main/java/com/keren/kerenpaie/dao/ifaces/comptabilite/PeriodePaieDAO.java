
package com.keren.kerenpaie.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface PeriodePaieDAO
    extends GenericDAO<PeriodePaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PeriodePaieDAO";

}
