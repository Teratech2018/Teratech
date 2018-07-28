
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Compteur;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 13 17:11:00 GMT+01:00 2018
 * 
 */
public interface CompteurManager
    extends GenericManager<Compteur, Long>
{

    public final static String SERVICE_NAME = "CompteurManager";

}
