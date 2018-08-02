
package com.keren.courrier.core.ifaces.traitement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.traitement.AnnotationAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 26 18:30:42 GMT+01:00 2018
 * 
 */
public interface AnnotationActionManager
    extends GenericManager<AnnotationAction, Long>
{

    public final static String SERVICE_NAME = "AnnotationActionManager";

}
