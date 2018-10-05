
package com.keren.courrier.core.ifaces.others;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.others.CaSeqGenerator;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
public interface CaSeqGeneratorManager
    extends GenericManager<CaSeqGenerator, Long>
{

    public final static String SERVICE_NAME = "CaSeqGeneratorManager";

}
