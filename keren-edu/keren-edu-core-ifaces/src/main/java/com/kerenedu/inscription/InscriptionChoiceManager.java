
package com.kerenedu.inscription;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Sep 04 13:51:28 WAT 2018
 * 
 */
public interface InscriptionChoiceManager
    extends GenericManager<InscriptionChoice, Long>
{

    public final static String SERVICE_NAME = "InscriptionChoiceManager";

}
