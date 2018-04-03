
package com.keren.kerenpaie.jaxrs.impl.paie;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LigneIndiceSoldeManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.LigneIndiceSoldeRS;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 30 15:55:03 GMT+01:00 2018
 * 
 */
@Path("/ligneindicesolde")
public class LigneIndiceSoldeRSImpl
    extends AbstractGenericService<LigneIndiceSolde, Long>
    implements LigneIndiceSoldeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "LigneIndiceSoldeManagerImpl", interf = LigneIndiceSoldeManagerRemote.class)
    protected LigneIndiceSoldeManagerRemote manager;

    public LigneIndiceSoldeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneIndiceSolde, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
