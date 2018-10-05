
package com.keren.courrier.core.ifaces.courrier;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 27 15:52:41 GMT+01:00 2018
 * 
 */
public interface CourrierCloneManager
    extends GenericManager<CourrierClone, Long>
{

    public final static String SERVICE_NAME = "CourrierCloneManager";
    
    public List<CourrierClone> findcourrier(long id );
    
    public List<FichierLie> findfichier(long id );

}
