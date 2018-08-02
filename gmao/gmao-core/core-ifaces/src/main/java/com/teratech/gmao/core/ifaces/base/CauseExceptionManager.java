
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.CauseException;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 13:40:51 GMT+01:00 2018
 * 
 */
public interface CauseExceptionManager
    extends GenericManager<CauseException, Long>
{

    public final static String SERVICE_NAME = "CauseExceptionManager";

}
