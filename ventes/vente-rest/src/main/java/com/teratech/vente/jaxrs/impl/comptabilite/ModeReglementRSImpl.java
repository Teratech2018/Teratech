
package com.teratech.vente.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.vente.core.ifaces.comptabilite.ModeReglementManagerRemote;
import com.teratech.vente.jaxrs.ifaces.comptabilite.ModeReglementRS;
import com.teratech.vente.model.comptabilite.ModeReglement;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jan 04 08:13:40 WAT 2019
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
    @Manager(application = "teratechvente", name = "ModeReglementManagerImpl", interf = ModeReglementManagerRemote.class)
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
        return ("teratechvente");
    }

}
