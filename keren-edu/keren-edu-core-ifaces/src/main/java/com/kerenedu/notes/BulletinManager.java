
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
public interface BulletinManager
    extends GenericManager<Bulletin, Long>
{

    public final static String SERVICE_NAME = "BulletinManager";

}
