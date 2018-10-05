
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.ArchiveDossier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Aug 23 09:56:40 WAT 2018
 * 
 */
public interface ArchiveDossierManager
    extends GenericManager<ArchiveDossier, Long>
{

    public final static String SERVICE_NAME = "ArchiveDossierManager";

}
