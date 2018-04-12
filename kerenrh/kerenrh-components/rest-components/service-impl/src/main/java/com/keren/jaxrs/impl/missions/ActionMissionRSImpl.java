
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.missions.ActionMissionManagerRemote;
import com.keren.jaxrs.ifaces.missions.ActionMissionRS;
import com.keren.model.missions.ActionMission;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/actionmission")
public class ActionMissionRSImpl
    extends AbstractGenericService<ActionMission, Long>
    implements ActionMissionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "ActionMissionManagerImpl", interf = ActionMissionManagerRemote.class)
    protected ActionMissionManagerRemote manager;

    public ActionMissionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ActionMission, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
