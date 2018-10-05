
package com.keren.courrier.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.referentiel.StructureCompany;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Aug 28 09:06:49 WAT 2018
 * 
 */
public interface BorderoLiasseDAO
    extends GenericDAO<BorderoLiasse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BorderoLiasseDAO";
    
    /**
     * 
     * @param source:Service source 
     * @param cible:Service cible
     * @param type:0-interne , 1-Départ et 2-Confidentiel
     * @return 
     */
    public BorderoLiasse checkBordero(StructureCompany source,StructureCompany cible);

}
