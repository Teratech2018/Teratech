
package com.keren.portailweb.jaxrs.impl;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.dashboard.DashboardContainer;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.keren.portailweb.core.ifaces.PortailWebDashboardManagerRemote;
import com.keren.portailweb.jaxrs.ifaces.PortailWebDashboardRS;
import com.keren.portailweb.model.PortailWebDashboard;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Aug 25 07:54:04 GMT+01:00 2018
 * 
 */
@Path("/portailwebdashboard")
public class PortailWebDashboardRSImpl
    extends AbstractGenericService<PortailWebDashboard, Long>
    implements PortailWebDashboardRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "portailweb", name = "PortailWebDashboardManagerImpl", interf = PortailWebDashboardManagerRemote.class)
    protected PortailWebDashboardManagerRemote manager;
    
    @Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
    protected DashboardRecordManagerRemote dashboardmanager;

    public PortailWebDashboardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PortailWebDashboard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("portailweb");
    }

    @Override
    public DashboardContainer dashboard(HttpHeaders headers ,Long templateID) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            DashboardRecord dashboard = dashboardmanager.find("id", templateID);
            if(dashboard==null){
                return null;
            }
            PortailWebDashboard entity = new PortailWebDashboard();
//            entity.setCorbeilles(getUserCorbeilles(user));
            return DashboardUtil.dashboardBuilder(entity, dashboard);
        } catch (Exception ex) {
            Logger.getLogger(PortailWebDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new KerenExecption(ex.getMessage());
        }
    }

    @Override
    public PortailWebDashboard dashboard(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        PortailWebDashboard entity = new PortailWebDashboard();
        return entity;
    }

}
