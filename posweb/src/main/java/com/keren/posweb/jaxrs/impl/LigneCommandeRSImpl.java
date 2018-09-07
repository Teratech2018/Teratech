
package com.keren.posweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.core.ifaces.LigneCommandeManagerRemote;
import com.keren.posweb.jaxrs.ifaces.LigneCommandeRS;
import com.keren.posweb.model.LigneCommande;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 06 10:32:17 GMT+01:00 2018
 * 
 */
@Path("/lignecommande")
public class LigneCommandeRSImpl
    extends AbstractGenericService<LigneCommande, Long>
    implements LigneCommandeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "LigneCommandeManagerImpl", interf = LigneCommandeManagerRemote.class)
    protected LigneCommandeManagerRemote manager;

    public LigneCommandeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneCommande, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }

}
