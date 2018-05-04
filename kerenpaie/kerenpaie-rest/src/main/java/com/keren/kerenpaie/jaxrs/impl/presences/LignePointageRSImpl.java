
package com.keren.kerenpaie.jaxrs.impl.presences;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.presences.LignePointageManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.presences.LignePointageRS;
import com.keren.kerenpaie.model.presences.LignePointage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 24 13:58:37 GMT+01:00 2018
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
    @Manager(application = "kerenpaie", name = "LignePointageManagerImpl", interf = LignePointageManagerRemote.class)
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
        return ("kerenpaie");
    }

}
