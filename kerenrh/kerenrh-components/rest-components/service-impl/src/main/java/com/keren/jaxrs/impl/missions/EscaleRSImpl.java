
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.missions.EscaleManagerRemote;
import com.keren.jaxrs.ifaces.missions.EscaleRS;
import com.keren.model.missions.Escale;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/escale")
public class EscaleRSImpl
    extends AbstractGenericService<Escale, Long>
    implements EscaleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "EscaleManagerImpl", interf = EscaleManagerRemote.class)
    protected EscaleManagerRemote manager;

    public EscaleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Escale, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
