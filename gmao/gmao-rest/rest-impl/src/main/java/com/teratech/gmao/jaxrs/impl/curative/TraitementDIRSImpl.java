
package com.teratech.gmao.jaxrs.impl.curative;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.curative.TraitementDIRS;
import com.teratech.gmao.model.curative.TraitementDI;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jul 17 13:56:42 GMT+01:00 2018
 * 
 */
@Path("/traitementdi")
public class TraitementDIRSImpl
    extends AbstractGenericService<TraitementDI, Long>
    implements TraitementDIRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "TraitementDIManagerImpl", interf = TraitementDIManagerRemote.class)
    protected TraitementDIManagerRemote manager;

    public TraitementDIRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitementDI, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

}
