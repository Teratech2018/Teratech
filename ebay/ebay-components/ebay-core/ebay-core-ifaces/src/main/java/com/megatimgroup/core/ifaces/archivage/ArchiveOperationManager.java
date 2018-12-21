
package com.megatimgroup.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.model.archivage.ArchiveOperation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue May 02 14:26:30 WAT 2017
 * 
 */
public interface ArchiveOperationManager
    extends GenericManager<ArchiveOperation, String>
{

    public final static String SERVICE_NAME = "com.megatimgroup.core.impl.archivage.ArchiveOperationManagerImpl";

}
