
package com.keren.jaxrs.impl.stages;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.stages.TacheStageManagerRemote;
import com.keren.jaxrs.ifaces.stages.TacheStageRS;
import com.keren.model.stages.TacheStage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/tachestage")
public class TacheStageRSImpl
    extends AbstractGenericService<TacheStage, Long>
    implements TacheStageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "TacheStageManagerImpl", interf = TacheStageManagerRemote.class)
    protected TacheStageManagerRemote manager;

    public TacheStageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TacheStage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
