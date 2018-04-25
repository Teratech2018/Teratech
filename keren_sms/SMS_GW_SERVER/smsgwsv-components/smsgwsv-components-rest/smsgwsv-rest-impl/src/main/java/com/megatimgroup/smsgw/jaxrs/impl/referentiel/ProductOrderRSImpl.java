
package com.megatimgroup.smsgw.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductOrderManagerRemote;
import com.megatimgroup.smsgw.jaxrs.ifaces.referentiel.ProductOrderRS;
import com.megatimgroup.smsgw.model.referentiel.ProductOrder;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Oct 23 15:06:50 WAT 2017
 * 
 */
@Path("/productorder")
public class ProductOrderRSImpl
    extends AbstractGenericService<ProductOrder, Long>
    implements ProductOrderRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "smsgwsv-packaging-ear-1.0-SNAPSHOT", module = "smsgwsv-core-impl-1.0-SNAPSHOT", name = "ProductOrderManagerImpl", interf = ProductOrderManagerRemote.class)
    protected ProductOrderManagerRemote manager;

    public ProductOrderRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ProductOrder, Long> getManager() {
        return manager;
    }

}
