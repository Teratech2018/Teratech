
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.ElementSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 23 14:48:53 GMT+01:00 2018
 * 
 */
public interface ElementSalaireManager
    extends GenericManager<ElementSalaire, Long>
{

    public final static String SERVICE_NAME = "ElementSalaireManager";

    
    public ElementSalaire actif(ElementSalaire entity);
	
	
    public ElementSalaire inactif(ElementSalaire entity);
}
