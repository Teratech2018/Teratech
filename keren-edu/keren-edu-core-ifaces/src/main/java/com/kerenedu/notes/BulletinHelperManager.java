
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 13 14:34:47 WAT 2018
 * 
 */
public interface BulletinHelperManager
    extends GenericManager<BulletinHelper, Long>
{

    public final static String SERVICE_NAME = "BulletinHelperManager";

}
