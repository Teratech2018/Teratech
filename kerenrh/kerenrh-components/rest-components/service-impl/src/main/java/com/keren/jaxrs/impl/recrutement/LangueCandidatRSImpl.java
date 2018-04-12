
package com.keren.jaxrs.impl.recrutement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.recrutement.LangueCandidatManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.LangueCandidatRS;
import com.keren.model.recrutement.LangueCandidat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/languecandidat")
public class LangueCandidatRSImpl
    extends AbstractGenericService<LangueCandidat, Long>
    implements LangueCandidatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "LangueCandidatManagerImpl", interf = LangueCandidatManagerRemote.class)
    protected LangueCandidatManagerRemote manager;

    public LangueCandidatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LangueCandidat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
