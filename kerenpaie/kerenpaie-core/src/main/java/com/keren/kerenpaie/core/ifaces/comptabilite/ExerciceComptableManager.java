
package com.keren.kerenpaie.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.ExerciceComptable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
public interface ExerciceComptableManager
    extends GenericManager<ExerciceComptable, Long>
{

    public final static String SERVICE_NAME = "ExerciceComptableManager";

}
