
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.ReponseFournisseur;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Dec 22 14:01:06 WAT 2018
 * 
 */
public interface ReponseFournisseurManager
    extends GenericManager<ReponseFournisseur, Long>
{

    public final static String SERVICE_NAME = "ReponseFournisseurManager";

}
