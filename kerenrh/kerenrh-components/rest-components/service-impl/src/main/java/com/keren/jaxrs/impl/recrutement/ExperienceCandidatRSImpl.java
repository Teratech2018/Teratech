
package com.keren.jaxrs.impl.recrutement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.recrutement.ExperienceCandidatManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.ExperienceCandidatRS;
import com.keren.model.recrutement.ExperienceCandidat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/experiencecandidat")
public class ExperienceCandidatRSImpl
    extends AbstractGenericService<ExperienceCandidat, Long>
    implements ExperienceCandidatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ExperienceCandidatManagerImpl", interf = ExperienceCandidatManagerRemote.class)
    protected ExperienceCandidatManagerRemote manager;

    public ExperienceCandidatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ExperienceCandidat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
