
package com.teratech.vente.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.base.Civilite;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:36 WAT 2019
 * 
 */
public interface CiviliteManager
    extends GenericManager<Civilite, Long>
{

    public final static String SERVICE_NAME = "CiviliteManager";

}
