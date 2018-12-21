
package com.megatimgroup.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.model.operations.DeclarationPP;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface DeclarationPPManager
    extends GenericManager<DeclarationPP, String>
{

    public final static String SERVICE_NAME = "com.megatimgroup.core.impl.operations.DeclarationPPManagerImpl";

}
