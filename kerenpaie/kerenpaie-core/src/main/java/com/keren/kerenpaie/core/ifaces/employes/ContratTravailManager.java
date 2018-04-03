
package com.keren.kerenpaie.core.ifaces.employes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.employes.ContratTravail;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Mar 14 10:28:05 GMT+01:00 2018
 * 
 */
public interface ContratTravailManager
    extends GenericManager<ContratTravail, Long>
{

    public final static String SERVICE_NAME = "ContratTravailManager";

    public ContratTravail cloture(ContratTravail contrat);
    
    public ContratTravail demarrer(ContratTravail contrat);
}
