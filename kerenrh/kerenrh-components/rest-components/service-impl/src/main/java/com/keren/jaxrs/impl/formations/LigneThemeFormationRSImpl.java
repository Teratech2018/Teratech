
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.LigneThemeFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.LigneThemeFormationRS;
import com.keren.model.formations.LigneThemeFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/lignethemeformation")
public class LigneThemeFormationRSImpl
    extends AbstractGenericService<LigneThemeFormation, Long>
    implements LigneThemeFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LigneThemeFormationManagerImpl", interf = LigneThemeFormationManagerRemote.class)
    protected LigneThemeFormationManagerRemote manager;

    public LigneThemeFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneThemeFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
