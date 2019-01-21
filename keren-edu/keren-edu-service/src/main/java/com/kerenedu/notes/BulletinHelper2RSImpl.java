
package com.kerenedu.notes;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jan 11 14:06:49 WAT 2019
 * 
 */
@Path("/bulletinhelper2")
public class BulletinHelper2RSImpl
    extends AbstractGenericService<BulletinHelper2, Long>
    implements BulletinHelper2RS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinHelper2ManagerImpl", interf = BulletinHelper2ManagerRemote.class)
    protected BulletinHelper2ManagerRemote manager;

    public BulletinHelper2RSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BulletinHelper2, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
