
package com.kerenedu.discipline;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 20 20:36:57 WAT 2018
 * 
 */
public interface LigneAbscenceManager
    extends GenericManager<LigneAbscence, Long>
{

    public final static String SERVICE_NAME = "LigneAbscenceManager";
    
    public List<LigneAbscence> findeleve(long idclasse) ;

}
