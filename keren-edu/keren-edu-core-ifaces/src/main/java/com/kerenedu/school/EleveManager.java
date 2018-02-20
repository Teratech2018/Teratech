
package com.kerenedu.school;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.search.EleveSearch;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 28 15:02:40 WAT 2017
 * 
 */
public interface EleveManager
    extends GenericManager<Eleve, Long>
{

    public final static String SERVICE_NAME = "EleveManager";
    
    public List<Eleve> getCriteres(EleveSearch critere);

}
