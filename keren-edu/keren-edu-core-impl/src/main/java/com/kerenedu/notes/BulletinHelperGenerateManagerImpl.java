
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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.EdtBulletinAnnModal;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.model.report.EdtBulletinTrimModal;
import com.kerenedu.model.report.ViewRecapMoyenneModal;

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
				if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
					throw new KerenExecption("Sectionner les eleves concernes");
				}
				for(InscriptionChoice ins : critere.getConcernes()){
					container = RestrictionsContainer.newInstance();
					for (Examen examen : critere.getExamen()) {

						container.addEq("examen.id", examen.getId());

						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						container.addEq("inscription.id", ins.getId());
						List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
								new HashSet<String>(), -1, 0);
						records.addAll(datas);
					}
				}

			} else {
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() tout les eléve de la classe !!!!");
				records = new ArrayList<BulletinHelperGenerate>();
				for (Examen examen : critere.getExamen()) {
					container = RestrictionsContainer.newInstance();
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
	
	@Override
	public List<BulletinHelperGenerate> getCriteres(Bulletin critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGenerate> records = new ArrayList<BulletinHelperGenerate>();
				
		if (critere != null) {

			container.addEq("examen.id", critere.getModel().getId());

			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			container.addEq("inscription.id", critere.getInscription().getId());
			List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1,0);
			records.addAll(datas);
		}

		return records;
	}
	

	@Override
	public List<BulletinHelperGenerate> getCriteres(EdtBulletinTrimModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGenerate> records = new ArrayList<BulletinHelperGenerate>();
				
		if (critere != null) {
			if (critere.getPorte().equals("1")) {
				if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
					throw new KerenExecption("Sectionner les eleves concernes");
				}
				records = new ArrayList<BulletinHelperGenerate>();
				//System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() je suis ici nbre eleve select ====>"
					//	+ ""+critere.getConcernes().size());
				for(InscriptionChoice ins : critere.getConcernes()){
					//System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() parcours eleve "+ins.getNom());
					container = RestrictionsContainer.newInstance();
					for (Examen examen : critere.getExamen()) {
						container = RestrictionsContainer.newInstance();
						container.addEq("examen.id", examen.getId());

						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						container.addEq("inscription.id", ins.getId());
						List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
								new HashSet<String>(), -1, 0);
						records.addAll(datas);
					}
				}

			} else {
				//System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() tout les eléve de la classe !!!!");
				records = new ArrayList<BulletinHelperGenerate>();
			//	System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() examen ====>> "+critere.getExamen().size());
				for (Examen examen : critere.getExamen()) {
			//		System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() examen ====>> "+examen.getId());
					container = RestrictionsContainer.newInstance();
					container.addEq("examen.id", examen.getId());

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}

					List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					records.addAll(datas);
				}
			}

		}

		return records;
	}
	
	@Override
	public List<BulletinHelperGenerate> getCriteres(EdtBulletinAnnModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinHelperGenerate> records = new ArrayList<BulletinHelperGenerate>();
				
		if (critere != null) {
			if (critere.getPorte().equals("1")) {
				if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
					throw new KerenExecption("Sectionner les eleves concernes");
				}
				for(Inscription ins : critere.getConcernes()){
					container.addEq("inscription.id", ins.getId());
					
						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
								new HashSet<String>(), -1, 0);
						records.addAll(datas);
				}

			} else {
				System.out.println("BulletinHelperGenerateManagerImpl.getCriteres() tout les eléve de la classe !!!!");
				records = new ArrayList<BulletinHelperGenerate>();

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}
					List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null,
							new HashSet<String>(), -1, 0);
					records.addAll(datas);
				}
			}


		return records;
	}
	
	@Override
	public List<BulletinHelperGenerate> getCriteres(ViewRecapMoyenneModal critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			
//			if (critere.getCycle() != null) {
//				container.addEq("classe.cycle", critere.getCycle().getId());
//			}

		}
		List<BulletinHelperGenerate> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		//SList<BulletinHelperGenerate> result = new ArrayList<BulletinHelperGenerate>();
//		for (BulletinHelperGenerate ins : datas) {
//			BulletinHelperGenerate inscription = new BulletinHelperGenerate(ins);
//			result.add(inscription);
//		}
		return datas;
	}

}
