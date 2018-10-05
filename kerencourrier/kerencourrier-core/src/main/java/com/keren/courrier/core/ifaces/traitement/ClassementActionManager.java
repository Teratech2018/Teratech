
package com.keren.courrier.core.ifaces.traitement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.traitement.ClassementAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 27 09:58:14 GMT+01:00 2018
 * 
 */
public interface ClassementActionManager
    extends GenericManager<ClassementAction, Long>
{

    public final static String SERVICE_NAME = "ClassementActionManager";
    
    public void declasserAction(CourrierClone courrier,ClassementAction entity);

}
