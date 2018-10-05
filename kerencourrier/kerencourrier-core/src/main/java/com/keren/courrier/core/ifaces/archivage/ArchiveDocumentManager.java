
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.ArchiveDocument;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Aug 23 09:56:39 WAT 2018
 * 
 */
public interface ArchiveDocumentManager
    extends GenericManager<ArchiveDocument, Long>
{

    public final static String SERVICE_NAME = "ArchiveDocumentManager";

}
