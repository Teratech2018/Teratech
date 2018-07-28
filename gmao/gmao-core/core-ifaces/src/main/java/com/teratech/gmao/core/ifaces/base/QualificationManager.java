
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Qualification;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 11:42:34 GMT+01:00 2018
 * 
 */
public interface QualificationManager
    extends GenericManager<Qualification, Long>
{

    public final static String SERVICE_NAME = "QualificationManager";

}
