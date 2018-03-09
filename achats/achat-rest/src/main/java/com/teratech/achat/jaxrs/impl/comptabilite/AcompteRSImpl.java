
package com.teratech.achat.jaxrs.impl.comptabilite;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.comptabilite.AcompteManagerRemote;
import com.teratech.achat.jaxrs.ifaces.comptabilite.AcompteRS;
import com.teratech.achat.model.comptabilite.Acompte;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Mar 05 23:39:42 GMT+01:00 2018
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
    @Manager(application = "teratechachat", name = "AcompteManagerImpl", interf = AcompteManagerRemote.class)
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
        return ("teratechachat");
    }

}
