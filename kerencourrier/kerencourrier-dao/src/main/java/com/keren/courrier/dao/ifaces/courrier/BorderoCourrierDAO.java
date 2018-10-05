
package com.keren.courrier.dao.ifaces.courrier;

import java.util.List;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.StructureCompany;


/**
 * Interface etendue par les interfaces locale et remote de la DAO

 * @since Wed Jul 25 20:10:32 GMT+01:00 2018
 * 
 */
public interface BorderoCourrierDAO
    extends GenericDAO<BorderoCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BorderoCourrierDAO";

     /**
     * 
     * @param source:Service source 
     * @param cible:Service cible
     * @param type:0-interne , 1-Départ et 2-Confidentiel
     * @return 
     */
    public BorderoCourrier checkBordero(StructureCompany source,StructureCompany cible,String type);
    
    public BorderoCourrier checkBordero(StructureCompany source, List<Correspondant> cible,String type);
}
