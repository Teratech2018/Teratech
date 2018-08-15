
package com.core.templates;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Mon Aug 06 16:38:13 GMT+01:00 2018
 * 
 */
public interface ThemeRecordManager
    extends GenericManager<ThemeRecord, Long>
{

    public final static String SERVICE_NAME = "ThemeRecordManager";
    
    public ThemeRecord getApplicationTheme();

}
