
package com.keren.kerenpaie.core.ifaces.prets;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.prets.AvanceSalaire;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface AvanceSalaireManager
    extends GenericManager<AvanceSalaire, Long>
{

    public final static String SERVICE_NAME = "AvanceSalaireManager";
    
    public AvanceSalaire generereglement(AvanceSalaire entity);
    
    public AvanceSalaire confirme(AvanceSalaire entity);
    
    public AvanceSalaire annule(AvanceSalaire entity);

}
