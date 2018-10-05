
package com.keren.courrier.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.others.CaSeqGeneratorManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.CaSeqGeneratorRS;
import com.keren.courrier.model.others.CaSeqGenerator;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
@Path("/caseqgenerator")
public class CaSeqGeneratorRSImpl
    extends AbstractGenericService<CaSeqGenerator, Long>
    implements CaSeqGeneratorRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CaSeqGeneratorManagerImpl", interf = CaSeqGeneratorManagerRemote.class)
    protected CaSeqGeneratorManagerRemote manager;

    public CaSeqGeneratorRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CaSeqGenerator, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
