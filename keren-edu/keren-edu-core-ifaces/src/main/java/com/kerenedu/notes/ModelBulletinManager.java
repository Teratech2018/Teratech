
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 24 13:23:41 WAT 2018
 * 
 */
public interface ModelBulletinManager
    extends GenericManager<ModelBulletin, Long>
{

    public final static String SERVICE_NAME = "ModelBulletinManager";

}
