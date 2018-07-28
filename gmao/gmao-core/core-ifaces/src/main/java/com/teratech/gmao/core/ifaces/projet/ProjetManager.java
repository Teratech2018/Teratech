
package com.teratech.gmao.core.ifaces.projet;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.projet.Projet;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 15:15:32 GMT+01:00 2018
 * 
 */
public interface ProjetManager
    extends GenericManager<Projet, Long>
{

    public final static String SERVICE_NAME = "ProjetManager";

}
