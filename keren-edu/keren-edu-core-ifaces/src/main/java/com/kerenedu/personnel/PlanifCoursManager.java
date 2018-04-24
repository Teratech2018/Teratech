
package com.kerenedu.personnel;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Jan 31 17:41:19 CET 2018
 * 
 */
public interface PlanifCoursManager
    extends GenericManager<PlanifCours, Long>
{

    public final static String SERVICE_NAME = "PlanifCoursManager";
    public List<JoursCours> findjourscours(Long id) ;

}
