
package com.kerenedu.discipline;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Oct 12 12:04:35 WAT 2018
 * 
 */
@Path("/lignepointage")
public class LignePointageRSImpl
    extends AbstractGenericService<LignePointage, Long>
    implements LignePointageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "LignePointageManagerImpl", interf = LignePointageManagerRemote.class)
    protected LignePointageManagerRemote manager;

    public LignePointageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LignePointage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
