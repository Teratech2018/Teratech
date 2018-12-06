
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
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerLocal;
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewBulletinPaieHelperDAOLocal;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.LigneBulletinPaie;

@TransactionAttribute
@Stateless(mappedName = "ViewBulletinPaieHelperManager")
public class ViewBulletinPaieHelperManagerImpl
    extends AbstractGenericManager<ViewBulletinPaieHelper, Long>
    implements ViewBulletinPaieHelperManagerLocal, ViewBulletinPaieHelperManagerRemote
{

    @EJB(name = "ViewBulletinPaieHelperDAO")
    protected ViewBulletinPaieHelperDAOLocal dao;

    public ViewBulletinPaieHelperManagerImpl() {
    }

    @Override
    public GenericDAO<ViewBulletinPaieHelper, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    

	@Override
	public List<ViewBulletinPaieHelper> getCriteres(EdtPeriodeModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<ViewBulletinPaieHelper> datas = new ArrayList<ViewBulletinPaieHelper>();
		List<ViewBulletinPaieHelper> records = new ArrayList<ViewBulletinPaieHelper>();
		
		if(critere.getPorte().equals("0")){// tous les employes
			if (critere != null) {
				container = RestrictionsContainer.newInstance();
				if (critere.getPeriode() != null) {
					container.addEq("bulletin.periode.id", critere.getPeriode().getId());
				}
				container.addEq("bulletin.employe.modePaiement", "1");//virement
			}
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			
		}else if(critere.getPorte().equals("1")){ // employes select
			for(ProfesseurChoice pc : critere.getConcernes()){
				container = RestrictionsContainer.newInstance();
				container.addEq("bulletin.periode.id", critere.getPeriode().getId());
				container.addEq("bulletin.employe.id", pc.getId());
				container.addEq("bulletin.employe.modePaiement", "1");//virement
				records = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
				datas.addAll(records);
			}
			
		}
//			for (BulletinPaie b : datas) {
//				BulletinPaie result =  super.find("id", b.getId());
//				BulletinPaie data = new BulletinPaie(result);
//				for (LigneBulletinPaie ligne : result.getLignes()) {
//					data.getLignes().add(new LigneBulletinPaie(ligne));
//				} // end for(LigneBulletinPaie ligne:data.getLignes())
//
//				records.add(data);
//			}

		return datas;
	}

}
