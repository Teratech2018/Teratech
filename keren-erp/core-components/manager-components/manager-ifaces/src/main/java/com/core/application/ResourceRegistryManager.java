
package com.core.application;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue Jan 22 08:53:31 WAT 2019
 * 
 */
public interface ResourceRegistryManager
    extends GenericManager<ResourceRegistry, Long>
{

    public final static String SERVICE_NAME = "ResourceRegistryManager";
    
   /**
    * 
    * @param srcnmae
    * @param entity
    * @param modele
    * @return 
    */
    public ResourceRegistry getRegistryEntry(String srcnmae,String entity,String modele,long _instance);

}
