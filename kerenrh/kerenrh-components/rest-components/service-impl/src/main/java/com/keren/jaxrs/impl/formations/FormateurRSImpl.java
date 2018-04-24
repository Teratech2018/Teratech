
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.FormateurManagerRemote;
import com.keren.jaxrs.ifaces.formations.FormateurRS;
import com.keren.model.formations.Formateur;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/formateur")
public class FormateurRSImpl
    extends AbstractGenericService<Formateur, Long>
    implements FormateurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "FormateurManagerImpl", interf = FormateurManagerRemote.class)
    protected FormateurManagerRemote manager;

    public FormateurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Formateur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
