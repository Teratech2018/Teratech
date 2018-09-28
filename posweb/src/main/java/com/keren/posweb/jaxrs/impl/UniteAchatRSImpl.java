
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.UniteAchatManagerRemote;
import com.keren.posweb.jaxrs.ifaces.UniteAchatRS;
import com.keren.posweb.model.UniteAchat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
 * 
 */
@Path("/uniteachat")
public class UniteAchatRSImpl
    extends AbstractGenericService<UniteAchat, Long>
    implements UniteAchatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "UniteAchatManagerImpl", interf = UniteAchatManagerRemote.class)
    protected UniteAchatManagerRemote manager;

    public UniteAchatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<UniteAchat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
