
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
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.kerenedu.model.report.ViewNoteClasseModal;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.MatiereNote;
import com.kerenedu.notes.NoteDetail;
import com.kerenedu.notes.NoteDetailDAOLocal;

@TransactionAttribute
@Stateless(mappedName = "ViewNoteHelperManager")
public class ViewNoteHelperManagerImpl
    extends AbstractGenericManager<ViewNoteHelper, Long>
    implements ViewNoteHelperManagerLocal, ViewNoteHelperManagerRemote
{

    @EJB(name = "ViewNoteHelperDAO")
    protected ViewNoteHelperDAOLocal dao;
    
    @EJB(name = "NoteDetailDAO")
    protected NoteDetailDAOLocal daonote;

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
		List<ViewNoteHelper> records = new ArrayList<ViewNoteHelper>();
		List<ViewNoteHelper> datas = new ArrayList<ViewNoteHelper>();
		if (critere != null) {
		
			/*if(critere.getEleve()!=null){
				for(InscriptionChoice i : critere.getEleve()){
					records = new ArrayList<ViewNoteHelper>();
					container = RestrictionsContainer.newInstance();
					container.addEq("eleve.id", i.getId());
					container.addEq("classe.id", critere.getClasse().getId());
					container.addEq("examen.id", critere.getExamen().getId());
					records = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					datas.addAll(records);
				}
				
			/*}else{*/
				container = RestrictionsContainer.newInstance();
				if (critere.getClasse() != null) {
					container.addEq("classe.id", critere.getClasse().getId());
				}
				
				if (critere.getExamen() != null) {
					container.addEq("examen.id", critere.getExamen().getId());
				}
				records = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
				datas.addAll(records);
			//}
		

		}
//		List<ViewNoteHelper> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewNoteHelper> result = new ArrayList<ViewNoteHelper>();
		for (ViewNoteHelper ins : datas) {
			ViewNoteHelper inscription = new ViewNoteHelper(ins);
			result.add(inscription);
		}
		return result;
	}
	
	@Override
	public List<NoteDetail> getCriterenote(ViewNoteClasseModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<NoteDetail> records = new ArrayList<NoteDetail>();
		List<NoteDetail> datas = new ArrayList<NoteDetail>();
		if (critere != null) {
			if (critere.getEleve() != null && !critere.getEleve().isEmpty() && critere.getEleve().size() != 0) {
				for (InscriptionChoice i : critere.getEleve()) {
					container = RestrictionsContainer.newInstance();

					container.addEq("matricule", i.getMatricule());

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}

					if (critere.getExamen() != null) {
						container.addEq("typeexamen", critere.getExamen().getTypesequence());
					}
					datas = daonote.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					records.addAll(datas);
				}
			} else {
				container = RestrictionsContainer.newInstance();
				if (critere.getClasse() != null) {
					container.addEq("classe.id", critere.getClasse().getId());
				}

				if (critere.getExamen() != null) {
					container.addEq("typeexamen", critere.getExamen().getTypesequence());
				}
				records = daonote.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			}

		}
		return records;
	}
}
