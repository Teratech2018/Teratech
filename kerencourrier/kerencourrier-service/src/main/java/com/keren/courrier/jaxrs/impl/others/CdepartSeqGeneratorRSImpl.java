
package com.keren.courrier.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.core.ifaces.others.CdepartSeqGeneratorManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.CdepartSeqGeneratorRS;
import com.keren.courrier.model.others.CdepartSeqGenerator;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
@Path("/cdepartseqgenerator")
public class CdepartSeqGeneratorRSImpl
    extends AbstractGenericService<CdepartSeqGenerator, Long>
    implements CdepartSeqGeneratorRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CdepartSeqGeneratorManagerImpl", interf = CdepartSeqGeneratorManagerRemote.class)
    protected CdepartSeqGeneratorManagerRemote manager;

    public CdepartSeqGeneratorRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CdepartSeqGenerator, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
