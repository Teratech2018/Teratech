
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.CompteManagerRemote;
import com.keren.posweb.jaxrs.ifaces.CompteRS;
import com.keren.posweb.model.Compte;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 06 10:32:17 GMT+01:00 2018
 * 
 */
@Path("/compte")
public class CompteRSImpl
    extends AbstractGenericService<Compte, Long>
    implements CompteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "CompteManagerImpl", interf = CompteManagerRemote.class)
    protected CompteManagerRemote manager;

    public CompteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Compte, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
