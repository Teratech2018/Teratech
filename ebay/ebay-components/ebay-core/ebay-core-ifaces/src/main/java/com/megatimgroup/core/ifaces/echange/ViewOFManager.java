
package com.megatimgroup.core.ifaces.echange;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.model.echange.ViewOperationFinanciere;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface ViewOFManager
    extends GenericManager<ViewOperationFinanciere, String>
{

    public final static String SERVICE_NAME = "com.megatimgroup.core.impl.echange.ViewOFManagerImpl";

}
