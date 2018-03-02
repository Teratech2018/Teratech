
package com.teratech.stock.jaxrs.impl.invetaire;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.stock.core.ifaces.invetaire.LArticleEmplacementLotManagerRemote;
import com.teratech.stock.jaxrs.ifaces.invetaire.LArticleEmplacementLotRS;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Feb 24 11:54:50 GMT+01:00 2018
 * 
 */
@Path("/larticleemplacementlot")
public class LArticleEmplacementLotRSImpl
    extends AbstractGenericService<LArticleEmplacementLot, Long>
    implements LArticleEmplacementLotRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "LArticleEmplacementLotManagerImpl", interf = LArticleEmplacementLotManagerRemote.class)
    protected LArticleEmplacementLotManagerRemote manager;

    public LArticleEmplacementLotRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LArticleEmplacementLot, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

}
