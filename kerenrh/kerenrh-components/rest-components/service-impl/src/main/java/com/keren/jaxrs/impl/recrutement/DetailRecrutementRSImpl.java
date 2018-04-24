
package com.keren.jaxrs.impl.recrutement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.recrutement.DetailRecrutementManagerRemote;
import com.keren.jaxrs.ifaces.recrutement.DetailRecrutementRS;
import com.keren.model.recrutement.DetailRecrutement;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
@Path("/detailrecrutement")
public class DetailRecrutementRSImpl
    extends AbstractGenericService<DetailRecrutement, Long>
    implements DetailRecrutementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "DetailRecrutementManagerImpl", interf = DetailRecrutementManagerRemote.class)
    protected DetailRecrutementManagerRemote manager;

    public DetailRecrutementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DetailRecrutement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
