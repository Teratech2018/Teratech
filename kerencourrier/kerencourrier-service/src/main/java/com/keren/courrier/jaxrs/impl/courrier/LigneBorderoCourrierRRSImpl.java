
package com.keren.courrier.jaxrs.impl.courrier;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierRManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.LigneBorderoCourrierRRS;
import com.keren.courrier.model.courrier.LigneBorderoCourrierR;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Jul 28 11:15:11 GMT+01:00 2018
 * 
 */
@Path("/ligneborderocourrierr")
public class LigneBorderoCourrierRRSImpl
    extends AbstractGenericService<LigneBorderoCourrierR, Long>
    implements LigneBorderoCourrierRRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "LigneBorderoCourrierRManagerImpl", interf = LigneBorderoCourrierRManagerRemote.class)
    protected LigneBorderoCourrierRManagerRemote manager;

    public LigneBorderoCourrierRRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBorderoCourrierR, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
