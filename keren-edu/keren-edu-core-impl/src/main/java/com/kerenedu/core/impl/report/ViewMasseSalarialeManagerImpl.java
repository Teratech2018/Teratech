
package com.kerenedu.core.impl.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.core.ifaces.report.ViewMasseSalarialeManagerLocal;
import com.kerenedu.core.ifaces.report.ViewMasseSalarialeManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewMasseSalarialeDAOLocal;
import com.kerenedu.model.report.EdtMasseSalModal;
import com.kerenedu.model.report.ViewMasseSalariale;
import com.kerenedu.notes.BulletinDAOLocal;
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.LigneBulletinPaie;

@TransactionAttribute
@Stateless(mappedName = "ViewMasseSalarialeManager")
public class ViewMasseSalarialeManagerImpl
    extends AbstractGenericManager<ViewMasseSalariale, Long>
    implements ViewMasseSalarialeManagerLocal, ViewMasseSalarialeManagerRemote
{

    @EJB(name = "ViewMasseSalarialeDAO")
    protected ViewMasseSalarialeDAOLocal dao;
    
    @EJB(name = "BulletinDAO")
	protected BulletinDAOLocal daobul;

    public ViewMasseSalarialeManagerImpl() {
    }

    @Override
    public GenericDAO<ViewMasseSalariale, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<ViewMasseSalariale> getCriteres(EdtMasseSalModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<ViewMasseSalariale> datas = new ArrayList<ViewMasseSalariale>();
		
			if (critere != null) {
				container = RestrictionsContainer.newInstance();
				if (critere.getPeriode() != null) {
					container.addEq("periode.id", critere.getPeriode().getId());
				}
			}
			daobul.updateforce("scolarite");
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		

		return datas;
	}


}
