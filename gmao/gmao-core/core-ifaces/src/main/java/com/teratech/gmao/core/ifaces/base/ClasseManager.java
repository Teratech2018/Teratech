
package com.teratech.gmao.core.ifaces.base;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.gmao.model.base.Classe;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 14 12:31:43 GMT+01:00 2018
 * 
 */
public interface ClasseManager
    extends GenericManager<Classe, Long>
{

    public final static String SERVICE_NAME = "ClasseManager";

}
