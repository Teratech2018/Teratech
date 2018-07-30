
package com.keren.courrier.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.others.UtilisateurCloneManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.UtilisateurCloneRS;
import com.keren.courrier.model.others.UtilisateurClone;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Jul 26 12:15:37 GMT+01:00 2018
 * 
 */
@Path("/utilisateurclone")
public class UtilisateurCloneRSImpl
    extends AbstractGenericService<UtilisateurClone, Long>
    implements UtilisateurCloneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "UtilisateurCloneManagerImpl", interf = UtilisateurCloneManagerRemote.class)
    protected UtilisateurCloneManagerRemote manager;

    public UtilisateurCloneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<UtilisateurClone, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
