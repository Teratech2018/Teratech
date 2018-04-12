
package com.keren.jaxrs.impl.structures;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.structures.VilleManagerRemote;
import com.keren.jaxrs.ifaces.structures.VilleRS;
import com.keren.model.structures.Ville;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/ville")
public class VilleRSImpl
    extends AbstractGenericService<Ville, Long>
    implements VilleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "VilleManagerImpl", interf = VilleManagerRemote.class)
    protected VilleManagerRemote manager;

    public VilleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Ville, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
