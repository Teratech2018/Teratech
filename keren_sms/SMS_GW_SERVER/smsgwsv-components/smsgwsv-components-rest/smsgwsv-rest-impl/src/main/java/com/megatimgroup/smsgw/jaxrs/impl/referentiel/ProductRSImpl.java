
package com.megatimgroup.smsgw.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.smsgw.core.ifaces.referentiel.ProductManagerRemote;
import com.megatimgroup.smsgw.jaxrs.ifaces.referentiel.ProductRS;
import com.megatimgroup.smsgw.model.referentiel.Product;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Oct 23 15:06:50 WAT 2017
 * 
 */
@Path("/product")
public class ProductRSImpl
    extends AbstractGenericService<Product, Long>
    implements ProductRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "smsgwsv-packaging-ear-1.0-SNAPSHOT", module = "smsgwsv-core-impl-1.0-SNAPSHOT", name = "ProductManagerImpl", interf = ProductManagerRemote.class)
    protected ProductManagerRemote manager;

    public ProductRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Product, Long> getManager() {
        return manager;
    }

}
