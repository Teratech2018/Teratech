
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Sep 10 15:39:10 WAT 2018
 * 
 */
public interface CategorieManager
    extends GenericManager<Categorie, Long>
{

    public final static String SERVICE_NAME = "CategorieManager";

}
