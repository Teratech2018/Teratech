
package com.kerenedu.configuration;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.FichePaiementOptionel;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 09 15:21:42 WAT 2018
 * 
 */
public interface ServiceManager
    extends GenericManager<Service, Long>
{

    public final static String SERVICE_NAME = "ServiceManager";
    
    public List<FichePaiement> findmatierclasse(long id) ;
    

}
