
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.StructureManagerRemote;
import com.keren.posweb.jaxrs.ifaces.StructureRS;
import com.keren.posweb.model.Structure;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Sep 05 17:03:55 GMT+01:00 2018
 * 
 */
@Path("/structure")
public class StructureRSImpl
    extends AbstractGenericService<Structure, Long>
    implements StructureRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "StructureManagerImpl", interf = StructureManagerRemote.class)
    protected StructureManagerRemote manager;

    public StructureRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Structure, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
