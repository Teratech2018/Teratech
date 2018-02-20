
package com.basaccount.core.ifaces.operations;

import com.basaccount.model.operations.ClotureExerciceComptable;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 28 12:13:51 WAT 2017
 * 
 */
public interface ClotureExerciceComptableManager
    extends GenericManager<ClotureExerciceComptable, Long>
{

    public final static String SERVICE_NAME = "ClotureExerciceComptableManager";

}
