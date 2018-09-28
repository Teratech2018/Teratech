
package com.keren.posweb.jaxrs.impl;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.dashboard.DashboardContainer;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.keren.posweb.core.ifaces.PointVenteManagerRemote;
import com.keren.posweb.core.ifaces.PosWebDashboardManagerRemote;
import com.keren.posweb.jaxrs.ifaces.PosWebDashboardRS;
import com.keren.posweb.model.PosWebDashboard;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Sep 05 10:52:24 GMT+01:00 2018
 * 
 */
@Path("/poswebdashboard")
public class PosWebDashboardRSImpl
    extends AbstractGenericService<PosWebDashboard, Long>
    implements PosWebDashboardRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "posweb", name = "PosWebDashboardManagerImpl", interf = PosWebDashboardManagerRemote.class)
    protected PosWebDashboardManagerRemote manager;
    
     @Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
    protected DashboardRecordManagerRemote dashboardmanager;

     @Manager(application = "posweb", name = "PointVenteManagerImpl", interf = PointVenteManagerRemote.class)
    protected PointVenteManagerRemote posmanager;

    public PosWebDashboardRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PosWebDashboard, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("posweb");
    }
    
     @Override
    public DashboardContainer dashboard(HttpHeaders headers ,Long templateID) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            DashboardRecord dashboard = dashboardmanager.find("id", templateID);
            if(dashboard==null){
                return null;
            }
            PosWebDashboard entity = new PosWebDashboard();
//            entity.setCorbeilles(getUserCorbeilles(user));
            return DashboardUtil.dashboardBuilder(entity, dashboard);
        } catch (Exception ex) {
            Logger.getLogger(PosWebDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new KerenExecption(ex.getMessage());
        }
    }

    @Override
    public PosWebDashboard dashboard(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container =  RestrictionsContainer.newInstance();
        container.addEq("actif", Boolean.TRUE);
        PosWebDashboard entity = new PosWebDashboard();
        entity.setPostes(posmanager.filter(container.getPredicats(), null, null, 0, -1));
        return entity;
    }

}
