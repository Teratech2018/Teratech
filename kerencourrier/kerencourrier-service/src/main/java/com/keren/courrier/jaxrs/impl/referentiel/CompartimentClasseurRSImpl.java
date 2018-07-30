
package com.keren.courrier.jaxrs.impl.referentiel;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.referentiel.CompartimentClasseurManagerRemote;
import com.keren.courrier.jaxrs.ifaces.referentiel.CompartimentClasseurRS;
import com.keren.courrier.model.referentiel.CompartimentClasseur;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Jul 27 09:35:27 GMT+01:00 2018
 * 
 */
@Path("/compartimentclasseur")
public class CompartimentClasseurRSImpl
    extends AbstractGenericService<CompartimentClasseur, Long>
    implements CompartimentClasseurRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CompartimentClasseurManagerImpl", interf = CompartimentClasseurManagerRemote.class)
    protected CompartimentClasseurManagerRemote manager;

    public CompartimentClasseurRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CompartimentClasseur, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
