
package com.teratech.vente.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.vente.core.ifaces.comptabilite.AcompteManagerRemote;
import com.teratech.vente.jaxrs.ifaces.comptabilite.AcompteRS;
import com.teratech.vente.model.comptabilite.Acompte;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jan 04 09:17:46 WAT 2019
 * 
 */
@Path("/acompte")
public class AcompteRSImpl
    extends AbstractGenericService<Acompte, Long>
    implements AcompteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
    protected AcompteManagerRemote manager;

    public AcompteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Acompte, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

}
