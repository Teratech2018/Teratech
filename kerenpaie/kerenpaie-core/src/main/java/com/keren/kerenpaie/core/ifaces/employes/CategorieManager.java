
package com.keren.kerenpaie.core.ifaces.employes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.employes.Categorie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
public interface CategorieManager
    extends GenericManager<Categorie, Long>
{

    public final static String SERVICE_NAME = "CategorieManager";

}
