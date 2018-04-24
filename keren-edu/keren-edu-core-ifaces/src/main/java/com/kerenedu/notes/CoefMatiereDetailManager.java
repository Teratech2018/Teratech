
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 09:44:41 CET 2018
 * 
 */
public interface CoefMatiereDetailManager
    extends GenericManager<CoefMatiereDetail, Long>
{

    public final static String SERVICE_NAME = "CoefMatiereDetailManager";
    
    public List<CoefMatiereDetail> findMatiereFiliere(Long id) ;
    
    public List<CoefMatiereDetail> findprofclasse(Long id);

}
