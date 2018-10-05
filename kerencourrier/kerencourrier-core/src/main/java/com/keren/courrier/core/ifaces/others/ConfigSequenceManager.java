
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.ConfigSequence;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Sep 24 14:52:56 WAT 2018
 * 
 */
public interface ConfigSequenceManager
    extends GenericManager<ConfigSequence, Long>
{

    public final static String SERVICE_NAME = "ConfigSequenceManager";

}
