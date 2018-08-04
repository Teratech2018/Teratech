
package com.kerenedu.jaxrs.dashboard;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.xml.bind.JAXBException;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.core.dashboard.DashboardContainer;
import com.core.views.DashboardRecord;
import com.core.views.DashboardRecordManagerRemote;
import com.kerem.core.DashboardUtil;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.dashboard.EducationDashboard;
import com.kerenedu.dashboard.ViewDashboard;
import com.kerenedu.dashboard.ViewDashboardManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;

/**
 * Classe d'implementation du Web Service JAX-RS
 * 
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
@Path("/educationdashboard")
public class EducationDashboardRSImpl implements EducationDashboardRSLocal, EducationDashboardRSRemote {

	@Manager(application = "kerencore", name = "DashboardRecordManagerImpl", interf = DashboardRecordManagerRemote.class)
	protected DashboardRecordManagerRemote dashboardmanager;

	@Manager(application = "kereneducation", name = "ViewDashboardManagerImpl", interf = ViewDashboardManagerRemote.class)
	protected ViewDashboardManagerRemote manager;

	@Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
	protected AnneScolaireManagerRemote managerAnne;

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
			// To change body of generated methods, choose Tools | Templates.
			DashboardRecord dashboard = dashboardmanager.find("id", templateID);

			// select l'anné encours
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("connected", true);
			List<AnneScolaire> annee = managerAnne.filter(container.getPredicats(), null, null, 0, -1);
			if (annee == null || annee.size() == 0) {
				throw new KerenExecption("Aucune Année Scolaire disponible !!!");
			}
			// initi cache memory
			CacheMemory.init();
			AnneScolaire codeAnne = annee.get(0);
			CacheMemory.setCurrentannee(codeAnne.getCode());
			ViewDashboard view = new ViewDashboard();
			if (dashboard == null) {
				return null;
			}
			List<ViewDashboard> list = manager.getdashboarddata();
			if (list != null && list.size() != 0) {
				view = list.get(0);
			}

			return DashboardUtil.dashboardBuilder(new EducationDashboard(view), dashboard);
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
