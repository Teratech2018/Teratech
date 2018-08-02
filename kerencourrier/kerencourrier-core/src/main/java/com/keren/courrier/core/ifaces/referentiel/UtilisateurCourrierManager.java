
package com.keren.courrier.core.ifaces.referentiel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Thu Jul 26 09:18:55 GMT+01:00 2018
 * 
 */
public interface UtilisateurCourrierManager
    extends GenericManager<UtilisateurCourrier, Long>
{

    public final static String SERVICE_NAME = "UtilisateurCourrierManager";
    
    public UtilisateurCourrier getUserByAcompte(Long userid);

}
