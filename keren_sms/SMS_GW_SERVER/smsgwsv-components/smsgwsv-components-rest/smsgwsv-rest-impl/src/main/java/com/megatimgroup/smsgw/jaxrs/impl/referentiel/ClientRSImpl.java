
package com.megatimgroup.smsgw.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ClientManagerRemote;
import com.megatimgroup.smsgw.jaxrs.ifaces.referentiel.ClientRS;
import com.megatimgroup.smsgw.model.referentiel.Client;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Oct 23 15:06:50 WAT 2017
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
    @Manager(application = "smsgwsv-packaging-ear-1.0-SNAPSHOT", module = "smsgwsv-core-impl-1.0-SNAPSHOT", name = "ClientManagerImpl", interf = ClientManagerRemote.class)
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

}
