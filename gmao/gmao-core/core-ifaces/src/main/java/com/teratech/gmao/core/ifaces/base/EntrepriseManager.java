
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Entreprise;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 13 14:45:38 GMT+01:00 2018
 * 
 */
public interface EntrepriseManager
    extends GenericManager<Entreprise, Long>
{

    public final static String SERVICE_NAME = "EntrepriseManager";

}
