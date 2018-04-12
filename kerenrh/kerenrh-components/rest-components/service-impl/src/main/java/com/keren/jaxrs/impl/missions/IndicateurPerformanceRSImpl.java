
package com.keren.jaxrs.impl.missions;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.core.ifaces.missions.IndicateurPerformanceManagerRemote;
import com.keren.jaxrs.ifaces.missions.IndicateurPerformanceRS;
import com.keren.model.missions.IndicateurPerformance;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
@Path("/indicateurperformance")
public class IndicateurPerformanceRSImpl
    extends AbstractGenericService<IndicateurPerformance, Long>
    implements IndicateurPerformanceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenrh", name = "IndicateurPerformanceManagerImpl", interf = IndicateurPerformanceManagerRemote.class)
    protected IndicateurPerformanceManagerRemote manager;

    public IndicateurPerformanceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<IndicateurPerformance, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenrh");
    }

}