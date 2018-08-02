
package com.keren.courrier.jaxrs.impl.courrier;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.LigneBorderoCourrierRS;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jul 27 16:56:34 GMT+01:00 2018
 * 
 */
@Path("/ligneborderocourrier")
public class LigneBorderoCourrierRSImpl
    extends AbstractGenericService<LigneBorderoCourrier, Long>
    implements LigneBorderoCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "LigneBorderoCourrierManagerImpl", interf = LigneBorderoCourrierManagerRemote.class)
    protected LigneBorderoCourrierManagerRemote manager;

    public LigneBorderoCourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBorderoCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
