
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierInterneJoint;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 07 11:46:14 WAT 2018
 * 
 */
public interface CourrierInterneJointDAO
    extends GenericDAO<CourrierInterneJoint, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierInterneJointDAO";

}
