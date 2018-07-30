
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.LigneBorderoCourrierR;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 28 11:15:09 GMT+01:00 2018
 * 
 */
public interface LigneBorderoCourrierRManager
    extends GenericManager<LigneBorderoCourrierR, Long>
{

    public final static String SERVICE_NAME = "LigneBorderoCourrierRManager";

}
