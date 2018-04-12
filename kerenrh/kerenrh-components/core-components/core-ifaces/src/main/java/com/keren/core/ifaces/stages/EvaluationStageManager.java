
package com.keren.core.ifaces.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.stages.EvaluationStage;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Apr 10 17:59:56 GMT+01:00 2018
 * 
 */
public interface EvaluationStageManager
    extends GenericManager<EvaluationStage, Long>
{

    public final static String SERVICE_NAME = "EvaluationStageManager";

}
