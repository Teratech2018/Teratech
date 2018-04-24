
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.ParticipantSeanceManagerRemote;
import com.keren.jaxrs.ifaces.formations.ParticipantSeanceRS;
import com.keren.model.formations.ParticipantSeance;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:15 GMT+01:00 2018
 * 
 */
@Path("/participantseance")
public class ParticipantSeanceRSImpl
    extends AbstractGenericService<ParticipantSeance, Long>
    implements ParticipantSeanceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ParticipantSeanceManagerImpl", interf = ParticipantSeanceManagerRemote.class)
    protected ParticipantSeanceManagerRemote manager;

    public ParticipantSeanceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ParticipantSeance, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
