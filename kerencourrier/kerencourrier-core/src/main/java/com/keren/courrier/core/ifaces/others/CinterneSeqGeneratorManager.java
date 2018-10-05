
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.CinterneSeqGenerator;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
public interface CinterneSeqGeneratorManager
    extends GenericManager<CinterneSeqGenerator, Long>
{

    public final static String SERVICE_NAME = "CinterneSeqGeneratorManager";

}
