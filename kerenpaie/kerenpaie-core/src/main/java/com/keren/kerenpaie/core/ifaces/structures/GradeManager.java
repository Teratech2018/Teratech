
package com.keren.kerenpaie.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.structures.Grade;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 30 16:53:39 GMT+01:00 2018
 * 
 */
public interface GradeManager
    extends GenericManager<Grade, Long>
{

    public final static String SERVICE_NAME = "GradeManager";

}
