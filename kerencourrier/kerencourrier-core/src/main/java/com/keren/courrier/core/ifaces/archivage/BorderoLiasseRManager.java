
package com.keren.courrier.core.ifaces.archivage;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.archivage.BorderoLiasseR;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Aug 28 09:06:49 WAT 2018
 * 
 */
public interface BorderoLiasseRManager
    extends GenericManager<BorderoLiasseR, Long>
{

    public final static String SERVICE_NAME = "BorderoLiasseRManager";
    
    public BorderoLiasseR accuserreception(BorderoLiasseR entity,UtilisateurCourrier user);

}
