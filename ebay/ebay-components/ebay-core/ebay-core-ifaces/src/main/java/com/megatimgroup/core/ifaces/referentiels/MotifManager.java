
package com.megatimgroup.core.ifaces.referentiels;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.model.referentiels.Motif;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface MotifManager
    extends GenericManager<Motif, String>
{

    public final static String SERVICE_NAME = "com.megatimgroup.core.impl.referentiels.MotifManagerImpl";

}
