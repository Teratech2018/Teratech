
package com.core.views;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 14 12:34:05 GMT+01:00 2018
 * 
 */
public interface KabanRecordManager
    extends GenericManager<KabanRecord, Long>
{

    public final static String SERVICE_NAME = "KabanRecordManager";

}
