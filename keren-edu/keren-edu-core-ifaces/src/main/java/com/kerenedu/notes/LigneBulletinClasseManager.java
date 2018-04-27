
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 24 15:14:11 WAT 2018
 * 
 */
public interface LigneBulletinClasseManager
    extends GenericManager<LigneBulletinClasse, Long>
{

    public final static String SERVICE_NAME = "LigneBulletinClasseManager";

}
