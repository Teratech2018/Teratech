
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.ModuleFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.ModuleFormationRS;
import com.keren.model.formations.ModuleFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/moduleformation")
public class ModuleFormationRSImpl
    extends AbstractGenericService<ModuleFormation, Long>
    implements ModuleFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ModuleFormationManagerImpl", interf = ModuleFormationManagerRemote.class)
    protected ModuleFormationManagerRemote manager;

    public ModuleFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ModuleFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
