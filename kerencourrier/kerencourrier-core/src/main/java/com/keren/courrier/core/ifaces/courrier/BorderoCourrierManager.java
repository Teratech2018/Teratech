
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Jul 25 20:10:33 GMT+01:00 2018
 * 
 */
public interface BorderoCourrierManager
    extends GenericManager<BorderoCourrier, Long>
{

    public final static String SERVICE_NAME = "BorderoCourrierManager";

    /**
     * 
     * @param source:Service source 
     * @param cible:Service cible
     * @param type:0-interne , 1-Départ et 2-Confidentiel
     * @return 
     */
    public BorderoCourrier checkBordero(StructureCompany source,StructureCompany cible,String type);
    
    public BorderoCourrier distribuer(BorderoCourrier entity);
}
