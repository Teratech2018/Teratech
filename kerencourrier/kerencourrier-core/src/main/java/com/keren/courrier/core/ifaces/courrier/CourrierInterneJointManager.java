
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierInterneJoint;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 07 11:46:14 WAT 2018
 * 
 */
public interface CourrierInterneJointManager
    extends GenericManager<CourrierInterneJoint, Long>
{

    public final static String SERVICE_NAME = "CourrierInterneJointManager";

}
