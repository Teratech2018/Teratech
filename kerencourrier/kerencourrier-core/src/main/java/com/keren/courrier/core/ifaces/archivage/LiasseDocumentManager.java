
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.LiasseDocument;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 28 09:06:49 WAT 2018
 * 
 */
public interface LiasseDocumentManager
    extends GenericManager<LiasseDocument, Long>
{

    public final static String SERVICE_NAME = "LiasseDocumentManager";

}
