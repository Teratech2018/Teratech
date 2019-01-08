
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.LigneReponseDP;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Dec 22 14:01:06 WAT 2018
 * 
 */
public interface LigneReponseDPManager
    extends GenericManager<LigneReponseDP, Long>
{

    public final static String SERVICE_NAME = "LigneReponseDPManager";

}
