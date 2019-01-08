
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.LigneSortie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jan 03 09:08:04 WAT 2019
 * 
 */
public interface LigneSortieManager
    extends GenericManager<LigneSortie, Long>
{

    public final static String SERVICE_NAME = "LigneSortieManager";

}
