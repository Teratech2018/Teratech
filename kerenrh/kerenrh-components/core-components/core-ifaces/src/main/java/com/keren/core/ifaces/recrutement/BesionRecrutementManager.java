
package com.keren.core.ifaces.recrutement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.recrutement.BesionRecrutement;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface BesionRecrutementManager
    extends GenericManager<BesionRecrutement, Long>
{

    public final static String SERVICE_NAME = "BesionRecrutementManager";
    
    public BesionRecrutement valide(BesionRecrutement entity);

    public BesionRecrutement annule(BesionRecrutement entity);

}

