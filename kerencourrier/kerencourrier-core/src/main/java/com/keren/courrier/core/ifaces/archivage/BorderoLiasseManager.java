
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 28 09:06:49 WAT 2018
 * 
 */
public interface BorderoLiasseManager
    extends GenericManager<BorderoLiasse, Long>
{

    public final static String SERVICE_NAME = "BorderoLiasseManager";
    
    public BorderoLiasse distribuer(BorderoLiasse entity);
    
    public BorderoLiasse checkBordero(StructureCompany source, StructureCompany cible) ;

}
