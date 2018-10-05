
package com.keren.courrier.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.others.CinterneSeqGeneratorManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.CinterneSeqGeneratorRS;
import com.keren.courrier.model.others.CinterneSeqGenerator;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
@Path("/cinterneseqgenerator")
public class CinterneSeqGeneratorRSImpl
    extends AbstractGenericService<CinterneSeqGenerator, Long>
    implements CinterneSeqGeneratorRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CinterneSeqGeneratorManagerImpl", interf = CinterneSeqGeneratorManagerRemote.class)
    protected CinterneSeqGeneratorManagerRemote manager;

    public CinterneSeqGeneratorRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CinterneSeqGenerator, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
