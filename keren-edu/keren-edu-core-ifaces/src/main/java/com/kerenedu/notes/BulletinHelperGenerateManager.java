
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 25 00:23:27 WAT 2018
 * 
 */
public interface BulletinHelperGenerateManager
    extends GenericManager<BulletinHelperGenerate, Long>
{

    public final static String SERVICE_NAME = "BulletinHelperGenerateManager";

}
