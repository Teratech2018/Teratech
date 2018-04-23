
package com.keren.dao.ifaces.presences;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.presences.Absence;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sun Apr 22 11:44:26 GMT+01:00 2018
 * 
 */
public interface AbsenceDAO
    extends GenericDAO<Absence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "AbsenceDAO";

}
