
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.PortionSequence;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Sep 24 14:52:56 WAT 2018
 * 
 */
public interface PortionSequenceManager
    extends GenericManager<PortionSequence, Long>
{

    public final static String SERVICE_NAME = "PortionSequenceManager";

}
