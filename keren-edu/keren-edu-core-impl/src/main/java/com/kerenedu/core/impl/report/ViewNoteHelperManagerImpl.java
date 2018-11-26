
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
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerLocal;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewNoteHelperDAOLocal;
import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.kerenedu.model.report.ViewNoteClasseModal;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.MatiereNote;

@TransactionAttribute
@Stateless(mappedName = "ViewNoteHelperManager")
public class ViewNoteHelperManagerImpl
    extends AbstractGenericManager<ViewNoteHelper, Long>
    implements ViewNoteHelperManagerLocal, ViewNoteHelperManagerRemote
{

    @EJB(name = "ViewNoteHelperDAO")
    protected ViewNoteHelperDAOLocal dao;

    public ViewNoteHelperManagerImpl() {
    }

    @Override
    public GenericDAO<ViewNoteHelper, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<ViewNoteHelper> getCriteres(ViewMatiereClasseModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			
			if (critere.getSection() != null) {
				container.addEq("classe.section.id", critere.getSection().getId());
			}

		}
		List<ViewNoteHelper> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewNoteHelper> result = new ArrayList<ViewNoteHelper>();
		for (ViewNoteHelper ins : datas) {
			ViewNoteHelper inscription = new ViewNoteHelper(ins);
			result.add(inscription);
		}
		return result;
	}
	
	@Override
	public List<ViewNoteHelper> getCriteres(ViewNoteClasseModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			
			if (critere.getExamen() != null) {
				container.addEq("examen.id", critere.getExamen().getId());
			}
			
			if (critere.getEleve() != null) {
				container.addEq("eleve.id", critere.getEleve().getId());
			}

		}
		List<ViewNoteHelper> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewNoteHelper> result = new ArrayList<ViewNoteHelper>();
		for (ViewNoteHelper ins : datas) {
			ViewNoteHelper inscription = new ViewNoteHelper(ins);
			result.add(inscription);
		}
		return result;
	}
}
