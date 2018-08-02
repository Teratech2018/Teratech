
package com.keren.courrier.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.referentiel.ClasseurCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 27 09:35:26 GMT+01:00 2018
 * 
 */
public interface ClasseurCourrierManager
    extends GenericManager<ClasseurCourrier, Long>
{

    public final static String SERVICE_NAME = "ClasseurCourrierManager";

}
