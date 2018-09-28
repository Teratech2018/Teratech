
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.UserManagerRemote;
import com.keren.posweb.jaxrs.ifaces.UserRS;
import com.keren.posweb.model.User;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Sep 05 17:03:55 GMT+01:00 2018
 * 
 */
@Path("/user")
public class UserRSImpl
    extends AbstractGenericService<User, Long>
    implements UserRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "UserManagerImpl", interf = UserManagerRemote.class)
    protected UserManagerRemote manager;

    public UserRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<User, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
