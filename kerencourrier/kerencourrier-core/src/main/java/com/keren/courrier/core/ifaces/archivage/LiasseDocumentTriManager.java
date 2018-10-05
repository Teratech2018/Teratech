
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.LiasseDocumentTri;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 28 10:45:51 WAT 2018
 * 
 */
public interface LiasseDocumentTriManager
    extends GenericManager<LiasseDocumentTri, Long>
{

    public final static String SERVICE_NAME = "LiasseDocumentTriManager";

}
