
package com.keren.kerenpaie.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 15:05:27 GMT+01:00 2018
 * 
 */
public interface PeriodePaieOpenDAO
    extends GenericDAO<PeriodePaieOpen, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PeriodePaieOpenDAO";

}
