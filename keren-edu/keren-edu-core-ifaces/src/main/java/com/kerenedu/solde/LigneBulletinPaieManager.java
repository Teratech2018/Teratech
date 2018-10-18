
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 15:46:58 WAT 2018
 * 
 */
public interface LigneBulletinPaieManager
    extends GenericManager<LigneBulletinPaie, Long>
{

    public final static String SERVICE_NAME = "LigneBulletinPaieManager";

}
