
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.TraitementCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Thu Jul 19 10:36:24 GMT+01:00 2018
 * 
 */
public interface TraitementCourrierManager
    extends GenericManager<TraitementCourrier, Long>
{

    public final static String SERVICE_NAME = "TraitementCourrierManager";

    /**
     * 
     * @param courrier 
     * @return  
     */
    public Courrier traiterCourrier(Courrier courrier);
    
    /**
     * 
     * @param courrier 
     * @return  
     */
    public CourrierDepart traiterCourrier(CourrierDepart courrier);
    
    /**
     * 
     * @param courrier 
     * @return  
     */
    public CourrierInterne traiterCourrier(CourrierInterne courrier);
}
