
package com.teratech.gmao.core.ifaces.preventif;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.preventif.MiseAJourCompteur;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 16 20:45:16 GMT+01:00 2018
 * 
 */
public interface MiseAJourCompteurManager
    extends GenericManager<MiseAJourCompteur, Long>
{

    public final static String SERVICE_NAME = "MiseAJourCompteurManager";

}
