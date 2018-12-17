
package com.kerenedu.notes;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Dec 14 14:50:33 WAT 2018
 * 
 */
@Path("/lignehelper")
public class LigneHelperRSImpl
    extends AbstractGenericService<LigneHelper, Long>
    implements LigneHelperRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "LigneHelperManagerImpl", interf = LigneHelperManagerRemote.class)
    protected LigneHelperManagerRemote manager;

    public LigneHelperRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneHelper, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
