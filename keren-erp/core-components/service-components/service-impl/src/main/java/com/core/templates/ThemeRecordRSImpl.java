
package com.core.templates;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import java.util.List;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Mon Aug 06 16:38:13 GMT+01:00 2018
 * 
 */
@Path("/themerecord")
public class ThemeRecordRSImpl
    extends AbstractGenericService<ThemeRecord, Long>
    implements ThemeRecordRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "ThemeRecordManagerImpl", interf = ThemeRecordManagerRemote.class)
    protected ThemeRecordManagerRemote manager;

    public ThemeRecordRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ThemeRecord, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

    @Override
    public ThemeRecord getApplicationTheme() {
        //To change body of generated methods, choose Tools | Templates.
        ThemeRecord theme = manager.getApplicationTheme();
        if(theme!=null) return theme;
        throw new KerenExecption("No Theme find");
    }

}
