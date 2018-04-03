
package com.keren.kerenpaie.jaxrs.impl.structures;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.structures.GradeManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.structures.GradeRS;
import com.keren.kerenpaie.model.structures.Grade;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 30 16:53:39 GMT+01:00 2018
 * 
 */
@Path("/grade")
public class GradeRSImpl
    extends AbstractGenericService<Grade, Long>
    implements GradeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "GradeManagerImpl", interf = GradeManagerRemote.class)
    protected GradeManagerRemote manager;

    public GradeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Grade, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
