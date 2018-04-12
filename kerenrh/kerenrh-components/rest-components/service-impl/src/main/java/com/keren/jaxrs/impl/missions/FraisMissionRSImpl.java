
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.missions.FraisMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.FraisMissionRS;
import com.keren.model.missions.FraisMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/fraismission")
public class FraisMissionRSImpl
    extends AbstractGenericService<FraisMission, Long>
    implements FraisMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FraisMissionManagerImpl", interf = FraisMissionManagerRemote.class)
    protected FraisMissionManagerRemote manager;

    public FraisMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FraisMission, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
