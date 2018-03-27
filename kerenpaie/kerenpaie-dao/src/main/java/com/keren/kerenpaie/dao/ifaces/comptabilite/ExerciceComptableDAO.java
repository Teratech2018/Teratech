
package com.keren.kerenpaie.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.comptabilite.ExerciceComptable;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Mar 06 12:50:47 GMT+01:00 2018
 * 
 */
public interface ExerciceComptableDAO
    extends GenericDAO<ExerciceComptable, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ExerciceComptableDAO";

}
