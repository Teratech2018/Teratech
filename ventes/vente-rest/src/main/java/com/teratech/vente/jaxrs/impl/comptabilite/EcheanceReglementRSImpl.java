
package com.teratech.vente.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.vente.core.ifaces.comptabilite.EcheanceReglementManagerRemote;
import com.teratech.vente.jaxrs.ifaces.comptabilite.EcheanceReglementRS;
import com.teratech.vente.model.comptabilite.EcheanceReglement;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jan 04 08:13:40 WAT 2019
 * 
 */
@Path("/echeancereglement")
public class EcheanceReglementRSImpl
    extends AbstractGenericService<EcheanceReglement, Long>
    implements EcheanceReglementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "EcheanceReglementManagerImpl", interf = EcheanceReglementManagerRemote.class)
    protected EcheanceReglementManagerRemote manager;

    public EcheanceReglementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EcheanceReglement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

}
