
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface UtilisateurConnectManager
    extends GenericManager<UtilisateurConnect, Long>
{

    public final static String SERVICE_NAME = "UtilisateurConnectManager";
    public UtilisateurConnect getUserByAcompte(Long userid);

}