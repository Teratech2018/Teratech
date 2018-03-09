
package com.teratech.achat.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.comptabilite.ModeReglementManagerRemote;
import com.teratech.achat.jaxrs.ifaces.comptabilite.ModeReglementRS;
import com.teratech.achat.model.comptabilite.ModeReglement;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Mar 05 23:39:42 GMT+01:00 2018
 * 
 */
@Path("/modereglement")
public class ModeReglementRSImpl
    extends AbstractGenericService<ModeReglement, Long>
    implements ModeReglementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "ModeReglementManagerImpl", interf = ModeReglementManagerRemote.class)
    protected ModeReglementManagerRemote manager;

    public ModeReglementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ModeReglement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

}
