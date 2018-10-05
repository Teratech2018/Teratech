
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.FichierLieTri;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Aug 31 11:17:44 WAT 2018
 * 
 */
public interface FichierLieTriManager
    extends GenericManager<FichierLieTri, Long>
{

    public final static String SERVICE_NAME = "FichierLieTriManager";

}
