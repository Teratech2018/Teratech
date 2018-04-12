
package com.keren.jaxrs.impl.recrutement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.recrutement.FormationCandidatManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.FormationCandidatRS;
import com.keren.model.recrutement.FormationCandidat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/formationcandidat")
public class FormationCandidatRSImpl
    extends AbstractGenericService<FormationCandidat, Long>
    implements FormationCandidatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FormationCandidatManagerImpl", interf = FormationCandidatManagerRemote.class)
    protected FormationCandidatManagerRemote manager;

    public FormationCandidatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FormationCandidat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
