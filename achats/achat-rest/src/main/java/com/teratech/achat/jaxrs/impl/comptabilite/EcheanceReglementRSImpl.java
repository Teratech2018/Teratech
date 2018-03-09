
package com.teratech.achat.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.comptabilite.EcheanceReglementManagerRemote;
import com.teratech.achat.jaxrs.ifaces.comptabilite.EcheanceReglementRS;
import com.teratech.achat.model.comptabilite.EcheanceReglement;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Mar 05 23:39:42 GMT+01:00 2018
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
    @Manager(application = "teratechachat", name = "EcheanceReglementManagerImpl", interf = EcheanceReglementManagerRemote.class)
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
        return ("teratechachat");
    }

}
