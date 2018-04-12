
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.ThemeFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.ThemeFormationRS;
import com.keren.model.formations.ThemeFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/themeformation")
public class ThemeFormationRSImpl
    extends AbstractGenericService<ThemeFormation, Long>
    implements ThemeFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ThemeFormationManagerImpl", interf = ThemeFormationManagerRemote.class)
    protected ThemeFormationManagerRemote manager;

    public ThemeFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ThemeFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
