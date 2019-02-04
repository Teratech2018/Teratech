
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
import com.kerenedu.core.ifaces.report.ViewEtatPretManagerLocal;
import com.kerenedu.core.ifaces.report.ViewEtatPretManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewEtatPretDAOLocal;
import com.kerenedu.model.report.ViewEtatPret;
import com.kerenedu.model.report.ViewPeriodeModal;
import com.kerenedu.solde.RemboursementPretDAOLocal;

@TransactionAttribute
@Stateless(mappedName = "ViewEtatPretManager")
public class ViewEtatPretManagerImpl
    extends AbstractGenericManager<ViewEtatPret, Long>
    implements ViewEtatPretManagerLocal, ViewEtatPretManagerRemote
{

    @EJB(name = "ViewEtatPretDAO")
    protected ViewEtatPretDAOLocal dao;
    
    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal daoRem;

    public ViewEtatPretManagerImpl() {
    }

    @Override
    public GenericDAO<ViewEtatPret, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    

	@Override
	public List<ViewEtatPret> getCriteres(ViewPeriodeModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<ViewEtatPret> datas = new ArrayList<ViewEtatPret>();
		List<ViewEtatPret> records = new ArrayList<ViewEtatPret>();
		
		
//			if (critere != null) {
//				container = RestrictionsContainer.newInstance();
//				if (critere.getPeriode() != null) {
//					container.addEq("bulletin.periode.id", critere.getPeriode().getId());
//				}
//				
//				if (critere.getType() != null) {
//					container.addEq("lignes.rubrique.type", critere.getType());
//				}
//			}
			// force update inscription 
			daoRem.updateforce("m");
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			

		return datas;
	}

}
