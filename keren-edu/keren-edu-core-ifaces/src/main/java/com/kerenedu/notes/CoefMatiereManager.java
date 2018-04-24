
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
public interface CoefMatiereManager
    extends GenericManager<CoefMatiere, Long>
{

    public final static String SERVICE_NAME = "CoefMatiereManager";
    
    public List<CoefMatiereDetail> findMatiereFiliere(Long id) ;

}
