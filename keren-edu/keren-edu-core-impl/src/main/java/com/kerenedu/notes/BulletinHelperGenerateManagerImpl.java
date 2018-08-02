
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.model.report.ViewBulletin;

@TransactionAttribute
@Stateless(mappedName = "BulletinHelperGenerateManager")
public class BulletinHelperGenerateManagerImpl extends AbstractGenericManager<BulletinHelperGenerate, Long>
		implements BulletinHelperGenerateManagerLocal, BulletinHelperGenerateManagerRemote {

	@EJB(name = "BulletinHelperGenerateDAO")
	protected BulletinHelperGenerateDAOLocal dao;
	
	@EJB(name = "ExamenDAO")
	protected ExamenDAOLocal daoExamen;

	public BulletinHelperGenerateManagerImpl() {
	}

	@Override
	public GenericDAO<BulletinHelperGenerate, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<BulletinHelperGenerate> getCriteres(EdtBulletinModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGenerate> records = new ArrayList<BulletinHelperGenerate>();
				
		if (critere != null) {
			if (critere.getPorte().equals("1")) {
				for(Inscription ins : critere.getConcernes()){
					container.addEq("inscription.id", ins.getId());
					for (Examen examen : critere.getExamens()) {

						container.addEq("examen.id", examen.getId());

						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
								new HashSet<String>(), -1, 0);
						records.addAll(datas);
					}
				}

			} else {
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() tout les eléve de la classe !!!!");
				records = new ArrayList<BulletinHelperGenerate>();
				for (Examen examen : critere.getExamens()) {

					container.addEq("examen.id", examen.getId());

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}

					List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
							new HashSet<String>(), -1, 0);
					records.addAll(datas);
				}
			}

		}

		return records;
	}

}
