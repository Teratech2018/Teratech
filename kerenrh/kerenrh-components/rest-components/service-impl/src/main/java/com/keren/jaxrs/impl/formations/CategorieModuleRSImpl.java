
package com.keren.jaxrs.impl.formations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.formations.CategorieModuleManagerRemote;
import com.keren.jaxrs.ifaces.formations.CategorieModuleRS;
import com.keren.model.formations.CategorieModule;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
@Path("/categoriemodule")
public class CategorieModuleRSImpl
    extends AbstractGenericService<CategorieModule, Long>
    implements CategorieModuleRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "CategorieModuleManagerImpl", interf = CategorieModuleManagerRemote.class)
    protected CategorieModuleManagerRemote manager;

    public CategorieModuleRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CategorieModule, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}
