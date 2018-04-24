
package com.keren.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.presences.Absence;
import com.keren.model.presences.Retard;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Apr 22 11:44:26 GMT+01:00 2018
 * 
 */
public interface AbsenceManager
    extends GenericManager<Absence, Long>
{

    public final static String SERVICE_NAME = "AbsenceManager";
    
    /**
     * Justification d'un retard
     * @param entity
     * @return
     */
    public Absence justifie(Absence entity);
    
    /**
     * 
     * @param entity
     * @return
     */
    public Absence nonjustifie(Absence entity);


}
