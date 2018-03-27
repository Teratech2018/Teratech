
package com.keren.kerenpaie.jaxrs.impl.paie;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LignePonderationTypeContratManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.LignePonderationTypeContratRS;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
@Path("/ligneponderationtypecontrat")
public class LignePonderationTypeContratRSImpl
    extends AbstractGenericService<LignePonderationTypeContrat, Long>
    implements LignePonderationTypeContratRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "LignePonderationTypeContratManagerImpl", interf = LignePonderationTypeContratManagerRemote.class)
    protected LignePonderationTypeContratManagerRemote manager;

    public LignePonderationTypeContratRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LignePonderationTypeContrat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
