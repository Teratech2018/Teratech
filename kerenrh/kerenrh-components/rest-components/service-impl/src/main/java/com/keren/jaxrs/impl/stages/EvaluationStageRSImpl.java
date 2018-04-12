
package com.keren.jaxrs.impl.stages;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.stages.EvaluationStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.EvaluationStageRS;
import com.keren.model.stages.EvaluationStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/evaluationstage")
public class EvaluationStageRSImpl
    extends AbstractGenericService<EvaluationStage, Long>
    implements EvaluationStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EvaluationStageManagerImpl", interf = EvaluationStageManagerRemote.class)
    protected EvaluationStageManagerRemote manager;

    public EvaluationStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EvaluationStage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
