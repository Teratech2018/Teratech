
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.UniteGestionManagerRemote;
import com.keren.posweb.jaxrs.ifaces.UniteGestionRS;
import com.keren.posweb.model.UniteGestion;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
 * 
 */
@Path("/unitegestion")
public class UniteGestionRSImpl
    extends AbstractGenericService<UniteGestion, Long>
    implements UniteGestionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "UniteGestionManagerImpl", interf = UniteGestionManagerRemote.class)
    protected UniteGestionManagerRemote manager;

    public UniteGestionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<UniteGestion, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
