
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.ControleQualite;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Sat Dec 29 13:22:55 WAT 2018
 * 
 */
public interface ControleQualiteManager
    extends GenericManager<ControleQualite, Long>
{

    public final static String SERVICE_NAME = "ControleQualiteManager";
    
    public ControleQualite traiter(ControleQualite entity);

}
