
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.missions.GrilleFraisManagerRemote;
import com.keren.jaxrs.ifaces.missions.GrilleFraisRS;
import com.keren.model.missions.GrilleFrais;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/grillefrais")
public class GrilleFraisRSImpl
    extends AbstractGenericService<GrilleFrais, Long>
    implements GrilleFraisRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "GrilleFraisManagerImpl", interf = GrilleFraisManagerRemote.class)
    protected GrilleFraisManagerRemote manager;

    public GrilleFraisRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<GrilleFrais, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
