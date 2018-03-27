
package com.keren.kerenpaie.jaxrs.impl.paie;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LigneConvensionManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.LigneConvensionRS;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 06 14:40:10 GMT+01:00 2018
 * 
 */
@Path("/ligneconvension")
public class LigneConvensionRSImpl
    extends AbstractGenericService<LigneConvension, Long>
    implements LigneConvensionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "LigneConvensionManagerImpl", interf = LigneConvensionManagerRemote.class)
    protected LigneConvensionManagerRemote manager;

    public LigneConvensionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneConvension, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
