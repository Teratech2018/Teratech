
package com.teratech.achat.dao.ifaces.comptabilite;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.comptabilite.ExerciceComptable;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 27 14:29:37 GMT+01:00 2018
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
