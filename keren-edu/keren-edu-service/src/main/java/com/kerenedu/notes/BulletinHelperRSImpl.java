
package com.kerenedu.notes;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Dec 13 14:34:47 WAT 2018
 * 
 */
@Path("/bulletinhelper")
public class BulletinHelperRSImpl
    extends AbstractGenericService<BulletinHelper, Long>
    implements BulletinHelperRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinHelperManagerImpl", interf = BulletinHelperManagerRemote.class)
    protected BulletinHelperManagerRemote manager;

    public BulletinHelperRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BulletinHelper, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
