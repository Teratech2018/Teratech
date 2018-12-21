
package com.megatimgroup.core.ifaces.parametres;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.model.parametres.Societe;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface SocieteManager
    extends GenericManager<Societe, Long>
{

    public final static String SERVICE_NAME = "com.megatimgroup.core.impl.parametres.SocieteManagerImpl";

}
