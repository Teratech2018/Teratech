
package com.keren.jaxrs.impl.stages;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.stages.LivrableStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.LivrableStageRS;
import com.keren.model.stages.LivrableStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/livrablestage")
public class LivrableStageRSImpl
    extends AbstractGenericService<LivrableStage, Long>
    implements LivrableStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LivrableStageManagerImpl", interf = LivrableStageManagerRemote.class)
    protected LivrableStageManagerRemote manager;

    public LivrableStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LivrableStage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
