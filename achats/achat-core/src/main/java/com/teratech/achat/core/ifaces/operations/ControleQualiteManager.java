
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.ControleQualite;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Feb 24 14:57:21 WAT 2018
 * 
 */
public interface ControleQualiteManager
    extends GenericManager<ControleQualite, Long>
{

    public final static String SERVICE_NAME = "ControleQualiteManager";

}
