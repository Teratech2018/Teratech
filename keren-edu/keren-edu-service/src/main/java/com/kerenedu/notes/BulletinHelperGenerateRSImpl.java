
package com.kerenedu.notes;

import javax.ws.rs.Path;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 25 00:23:28 WAT 2018
 * 
 */
@Path("/bulletinhelpergenerate")
public class BulletinHelperGenerateRSImpl
    extends AbstractGenericService<BulletinHelperGenerate, Long>
    implements BulletinHelperGenerateRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinHelperGenerateManagerImpl", interf = BulletinHelperGenerateManagerRemote.class)
    protected BulletinHelperGenerateManagerRemote manager;

    public BulletinHelperGenerateRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BulletinHelperGenerate, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
