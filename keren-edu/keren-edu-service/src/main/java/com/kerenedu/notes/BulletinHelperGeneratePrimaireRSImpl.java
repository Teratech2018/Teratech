
package com.kerenedu.notes;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Dec 06 02:40:56 WAT 2018
 * 
 */
@Path("/bulletinhelpergenerateprimaire")
public class BulletinHelperGeneratePrimaireRSImpl
    extends AbstractGenericService<BulletinHelperGeneratePrimaire, Long>
    implements BulletinHelperGeneratePrimaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinHelperGeneratePrimaireManagerImpl", interf = BulletinHelperGeneratePrimaireManagerRemote.class)
    protected BulletinHelperGeneratePrimaireManagerRemote manager;

    public BulletinHelperGeneratePrimaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BulletinHelperGeneratePrimaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
