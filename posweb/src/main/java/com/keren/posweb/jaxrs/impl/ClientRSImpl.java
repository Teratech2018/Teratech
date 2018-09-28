
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.ClientManagerRemote;
import com.keren.posweb.jaxrs.ifaces.ClientRS;
import com.keren.posweb.model.Client;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 06 10:58:46 GMT+01:00 2018
 * 
 */
@Path("/client")
public class ClientRSImpl
    extends AbstractGenericService<Client, Long>
    implements ClientRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "ClientManagerImpl", interf = ClientManagerRemote.class)
    protected ClientManagerRemote manager;

    public ClientRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Client, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
