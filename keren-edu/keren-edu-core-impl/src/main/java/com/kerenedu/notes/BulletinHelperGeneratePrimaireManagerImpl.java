
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
import com.kerem.core.KerenExecption;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.EdtBulletinModal;

@TransactionAttribute
@Stateless(mappedName = "BulletinHelperGeneratePrimaireManager")
public class BulletinHelperGeneratePrimaireManagerImpl
    extends AbstractGenericManager<BulletinHelperGeneratePrimaire, Long>
    implements BulletinHelperGeneratePrimaireManagerLocal, BulletinHelperGeneratePrimaireManagerRemote
{

    @EJB(name = "BulletinHelperGeneratePrimaireDAO")
    protected BulletinHelperGeneratePrimaireDAOLocal dao;

    public BulletinHelperGeneratePrimaireManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinHelperGeneratePrimaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
	public List<BulletinHelperGeneratePrimaire> getCriteres(Bulletin critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGeneratePrimaire> records = new ArrayList<BulletinHelperGeneratePrimaire>();
				
		if (critere != null) {

			container.addEq("examen.id", critere.getModel().getId());

			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			container.addEq("inscription.id", critere.getInscription().getId());
			List<BulletinHelperGeneratePrimaire> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1,0);
			records.addAll(datas);
		}

		return records;
	}
	

	@Override
	public List<BulletinHelperGeneratePrimaire> getCriteres(EdtBulletinModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGeneratePrimaire> records = new ArrayList<BulletinHelperGeneratePrimaire>();
				
		if (critere != null) {
			if (critere.getPorte().equals("1")) {
				if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
					throw new KerenExecption("Sectionner les eleves concernes");
				}
				records = new ArrayList<BulletinHelperGeneratePrimaire>();
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() je suis ici nbre eleve select ====>"
						+ ""+critere.getConcernes().size());
				for(InscriptionChoice ins : critere.getConcernes()){
					System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() parcours eleve "+ins.getNom());
					container = RestrictionsContainer.newInstance();
					for (Examen examen : critere.getExamen()) {
						container = RestrictionsContainer.newInstance();
						container.addEq("examen.id", examen.getId());

						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						container.addEq("inscription.id", ins.getId());
						List<BulletinHelperGeneratePrimaire> datas = dao.filter(container.getPredicats(), null,
								new HashSet<String>(), -1, 0);
						records.addAll(datas);
					}
				}

			} else {
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() tout les eléve de la classe !!!!");
				records = new ArrayList<BulletinHelperGeneratePrimaire>();
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() examen ====>> "+critere.getExamen().size());
				for (Examen examen : critere.getExamen()) {
					System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() examen ====>> "+examen.getId());
					container = RestrictionsContainer.newInstance();
					container.addEq("examen.id", examen.getId());

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}

					List<BulletinHelperGeneratePrimaire> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					records.addAll(datas);
				}
			}

		}

		return records;
	}

}
