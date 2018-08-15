
package com.core.views;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Aug 14 12:34:06 GMT+01:00 2018
 * 
 */
@Path("/kabanrecord")
public class KabanRecordRSImpl
    extends AbstractGenericService<KabanRecord, Long>
    implements KabanRecordRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "KabanRecordManagerImpl", interf = KabanRecordManagerRemote.class)
    protected KabanRecordManagerRemote manager;

    public KabanRecordRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<KabanRecord, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

}
