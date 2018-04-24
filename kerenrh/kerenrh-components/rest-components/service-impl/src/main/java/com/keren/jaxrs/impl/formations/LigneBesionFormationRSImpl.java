
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.LigneBesionFormationManagerRemote;
import com.keren.jaxrs.ifaces.formations.LigneBesionFormationRS;
import com.keren.model.formations.LigneBesionFormation;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/lignebesionformation")
public class LigneBesionFormationRSImpl
    extends AbstractGenericService<LigneBesionFormation, Long>
    implements LigneBesionFormationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LigneBesionFormationManagerImpl", interf = LigneBesionFormationManagerRemote.class)
    protected LigneBesionFormationManagerRemote manager;

    public LigneBesionFormationRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBesionFormation, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
