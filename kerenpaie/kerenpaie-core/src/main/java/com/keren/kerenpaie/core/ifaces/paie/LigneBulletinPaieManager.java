
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface LigneBulletinPaieManager
    extends GenericManager<LigneBulletinPaie, Long>
{

    public final static String SERVICE_NAME = "LigneBulletinPaieManager";

}
