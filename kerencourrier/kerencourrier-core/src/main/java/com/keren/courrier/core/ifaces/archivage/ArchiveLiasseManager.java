
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.ArchiveLiasse;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Aug 31 11:37:36 WAT 2018
 * 
 */
public interface ArchiveLiasseManager
    extends GenericManager<ArchiveLiasse, Long>
{

    public final static String SERVICE_NAME = "ArchiveLiasseManager";

}
