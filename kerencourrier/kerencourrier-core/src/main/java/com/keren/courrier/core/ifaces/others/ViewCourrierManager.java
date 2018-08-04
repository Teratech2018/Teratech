
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.ViewCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Aug 01 14:46:37 GMT+01:00 2018
 * 
 */
public interface ViewCourrierManager
    extends GenericManager<ViewCourrier, Long>
{

    public final static String SERVICE_NAME = "ViewCourrierManager";

}
