
package com.kerenedu.jaxrs.dashboard;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.xml.bind.JAXBException;

import com.core.dashboard.DashboardContainer;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.kerem.core.DashboardUtil;
import com.kerenedu.dashboard.EducationDashboard;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/educationdashboard")
public class EducationDashboardRSImpl implements EducationDashboardRSLocal,EducationDashboardRSRemote{


	 @Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
	    protected DashboardRecordManagerRemote dashboardmanager;
	    
	    
	    public EducationDashboardRSImpl() {
	          AnnotationsProcessor processor = new AnnotationsProcessor();
	        try {
	            processor.process(this);
	        } catch (NamingException ex) {
	            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalArgumentException ex) {
	            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(AbstractGenericService.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    
	    
	    @Override
	    public DashboardContainer dashboard(Long templateID) {
	        try {
	            //To change body of generated methods, choose Tools | Templates.
	            DashboardRecord dashboard = dashboardmanager.find("id", templateID);
	            if(dashboard==null){
	                return null;
	            }
	            return DashboardUtil.dashboardBuilder(new EducationDashboard(), dashboard);
	        } catch (JAXBException ex) {
	            Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalArgumentException ex) {
	            Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(EducationDashboardRSImpl.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	        return null;
	    }



	    
}
