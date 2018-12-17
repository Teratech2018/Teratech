/**
 * 
 */
package com.kerenedu.notes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.kerenedu.dao.ifaces.report.ViewNoteHelperDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewNoteHelper;

/**
 * @author Nadege
 *
 */
@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class MoteurBulletinManagerImpl extends AbstractGenericManager<Bulletin, Long>
		implements MoteurBulletinManagerLocal, MoteurBulletinManagerRemote {

	@EJB(name = "BulletinDAO")
	protected BulletinDAOLocal dao;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoinscription;
	
	@EJB(name = "ExamenDAO")
	protected ExamenDAOLocal daoexamen;
	
	@EJB(name = "ViewNoteHelperDAO")
	protected ViewNoteHelperDAOLocal daoviewnotehelper;
	

    @EJB(name = "BulletinHelperDAO")
    protected BulletinHelperDAOLocal daobullhelper;
    
    @EJB(name = "LigneHelperDAO")
    protected LigneHelperDAOLocal daolignehelper;
    
    @EJB(name = "LigneBulletinClasseDAO")
    protected LigneBulletinClasseDAOLocal daoligne;
	
	

	

	@Override
	public GenericDAO<Bulletin, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public String getEntityIdName() {
		// TODO Auto-generated method stub
		return "id";
	}

	

	private Date getDate(String date) {
		Date dated = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dated = formatter.parse(date);
			System.out.println("MoteurPaieManagerImpl.getDate() Date fin is " + dated);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dated;

	}

	@Override
	public EdtBulletin preparerNotes(EdtBulletin prepa) {
		this.generateBulletin(prepa);
		System.out.println("MoteurBulletinManagerImpl.preparerNotes() ============= FIN PARACOURS==============="+prepa.getClasse().getLibelle());
		return prepa;
	}
	/**
	 * 
	 * @param critere
	 */

	private void generateBulletin(EdtBulletin critere) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Bulletin> datas = new ArrayList<Bulletin>();
		List<Bulletin> datasdlt = new ArrayList<Bulletin>();
		List<Inscription> eleves = new ArrayList<Inscription>();
		List<Inscription> elevesdlt = new ArrayList<Inscription>();
		
		Double cumulPoint =0.0;
		Long cumulCoef =(long) 0;
		
		
		// verifier porte
		if (critere.getPorte().equals("0")) {
			// tous les eleve de la classe
			container = RestrictionsContainer.newInstance();
			container.addEq("model.id", critere.getSeq().getId());
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			datas= new ArrayList<Bulletin>();
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			
			container = RestrictionsContainer.newInstance();
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			//recherche les élèves inscrit de la classe
			eleves = daoinscription.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		}else{
			//les eleve selectionné
			if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
				throw new KerenExecption("Sectionner les eleves concernes");
			}
			for(InscriptionChoice ins :critere.getConcernes()){
				datas= new ArrayList<Bulletin>();
				container = RestrictionsContainer.newInstance();
				container.addEq("model.id", critere.getSeq().getId());
				container.addEq("inscription.id", ins.getId());
				if (critere.getClasse() != null) {
					container.addEq("classe.id", critere.getClasse().getId());
				}
				datasdlt = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				datas.addAll(datasdlt);
				
				container = RestrictionsContainer.newInstance();
				container.addEq("id", ins.getId());
				container.addEq("classe.id", critere.getClasse().getId());
				elevesdlt = daoinscription.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				// eleve inscrit 
				eleves.addAll(elevesdlt);
				
			}	
		}
//		
//		System.out.println("EdtBulletinRSImpl.generateBulletin() Buletin dejà generé trouvée " + datas.size());
//		System.out.println("EdtBulletinRSImpl.generateBulletin()eleve size" + eleves.size());
		
		// 0- supprimer les bulletin trouvé et regenerer
		for (Bulletin b : datas) {
			dao.delete(b.getId());
		} // end for(Bulletin b : datas) to delete

//		// 1- recherche des élève inscrit dans la classe
//		container = new RestrictionsContainer();
//		if (critere.getClasse() != null) {
//			container.addEq("classe.id", critere.getClasse().getId());
//		}
//		 eleves = managerinscrit.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
//		System.out.println(
//				"EdtBulletinRSImpl.generateBulletin() nombre eleve de la classe ============== " + eleves.size());
		if (eleves == null || eleves.isEmpty()) {
			throw new KerenExecption("Aucun Eleve inscrit dans la classe choisis !!!");
		}
		//find examen 
		Examen examen = daoexamen.findByPrimaryKey("id", critere.getSeq().getId());
			for (Inscription inscrit : eleves) {
				container = RestrictionsContainer.newInstance();
				container.addEq("classe.id", critere.getClasse().getId());
				container.addEq("eleve.id", inscrit.getId());
				container.addEq("examen.id", examen.getId());
				List<ViewNoteHelper> noteeleves = daoviewnotehelper.filter(container.getPredicats(), null,
						new HashSet<String>(), 0, -1);
			//	System.out.println("EdtBulletinRSImpl.generateBulletin() nobre note"+noteeleves.size());
				List<LigneBulletinClasse> lignelist = new ArrayList<LigneBulletinClasse>();
				Bulletin bulletin = new Bulletin();
				for (ViewNoteHelper h : noteeleves) {
					bulletin = new Bulletin(h,examen);
					LigneBulletinClasse ligne = new LigneBulletinClasse(h);
					ligne.setId(-1);
					lignelist.add(ligne);
				} // fin for (ViewNoteHelper h : noteeleves) {
				bulletin.setId(-1);
				bulletin.setLignes(lignelist);
				// set les cummul des 
//				for(LigneBulletinClasse lgn : bulletin.getLignes()){
//					cumulCoef+=lgn.getCoef();
//					cumulPoint=cumulPoint+lgn.getNote()*lgn.getCoef();
//				}
				//Double moy = cumulPoint/cumulCoef;
//				BigDecimal moybid = new BigDecimal(moy);
//				BigDecimal moytruncate = moybid.setScale(2, RoundingMode.DOWN);
//				bulletin.setMoyenne(moytruncate.doubleValue());
				bulletin=dao.save(bulletin);
			
				System.out.println("EdtBulletinRSImpl.generateBulletin()  Fin Traitement Bulettin eleve============= "+ inscrit.getEleve().getNom());
			} // fin for(Inscription inscrit : eleves)

	}// fin

	@Override
	public EdtBulletin aggregateNote(EdtBulletin critere) {
		// set moyenne trimestre
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Bulletin> datas = new ArrayList<Bulletin>();
		List<Bulletin> datasdlt = new ArrayList<Bulletin>();
		container = RestrictionsContainer.newInstance();
		//find examen 
				Examen examen = daoexamen.findByPrimaryKey("id", critere.getSeq().getId());
		// verifier porte
				if (critere.getPorte().equals("0")) {
					// tous les eleve de la classe
					container = RestrictionsContainer.newInstance();
					container.addEq("model.id", examen.getId());
					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
					}
					datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				}else{
					//les eleve selectionné
					if(critere.getConcernes()==null||critere.getConcernes().isEmpty()){
						throw new KerenExecption("Sectionner les eleves concernes");
					}
					for(InscriptionChoice ins :critere.getConcernes()){
						container = RestrictionsContainer.newInstance();
						container.addEq("inscription.id", ins.getId());
						if (critere.getClasse() != null) {
							container.addEq("classe.id", critere.getClasse().getId());
						}
						container.addEq("model.id", examen.getId());
						datasdlt = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
						datas.addAll(datasdlt);
					}	
				}
		for(Bulletin bulletin : datas){
			System.out.println("EdtBulletinRSImpl.processAfterSave()************* DEBUT CUMMUL MOYENNE TRIMESTRIEL  eleve**********"+bulletin.getInscription().getNom());
			Bulletin entity = dao.findByPrimaryKey("id", bulletin.getId());
			container = RestrictionsContainer.newInstance();
			container.addEq("bulletin.id", entity.getId());
			BulletinHelper helper = daobullhelper.filter(container.getPredicats(), null,new HashSet<String>(), 0, -1).get(0);
			System.out.println("bulletin helper id ******:  "+helper.getId());
		//	System.out.println("MoteurBulletinManagerImpl.generateBulletin() helper is *******:  "+helper.toString());
			entity.setMoyt1(helper.getMoyt1());
			entity.setMoyt2(helper.getMoyt2());
			entity.setMoyt3(helper.getMoyt3());
			entity.setMoyan(helper.getMoyan());
			dao.update(entity.getId(), entity);
			List<LigneBulletinClasse> dataslignes = entity.getLignes();
		
			for(LigneBulletinClasse ligne :dataslignes){
				container = RestrictionsContainer.newInstance();
				LigneBulletinClasse lgn = daoligne.findByPrimaryKey("id", ligne.getId());
				container.addEq("ligne.id", lgn.getId());
				List<LigneHelper>list =daolignehelper.filter(container.getPredicats(), null,new HashSet<String>(), 0, -1);
				System.out.println("MoteurBulletinManagerImpl.aggregateNote() size "+list.size());
				LigneHelper helperligne =list.get(0);
				//System.out.println("MoteurBulletinManagerImpl.generateBulletin() helperligne is *******:  "+helperligne.toString());
				System.out.println("ligne bulletin ******:  "+helperligne.getLigne().getId());
				System.out.println("ligne ******:  "+ligne.getId());
				System.out.println("ligne helper id ******:  "+helperligne.getId());
				System.out.println("MoteurBulletinManagerImpl.generateBulletin()  helperligne.getNotet1()******:  "+helperligne.getNotet1());
				System.out.println("MoteurBulletinManagerImpl.generateBulletin()  helperligne.getNotet2()******:  "+helperligne.getNotet2());
				System.out.println("MoteurBulletinManagerImpl.generateBulletin()  helperligne.getNotet3()******:  "+helperligne.getNotet3());
				lgn.setNotet1(helperligne.getNotet1());
				lgn.setNotet2(helperligne.getNotet2());
				lgn.setNotet3(helperligne.getNotet3());
				lgn.setNotean(helperligne.getNotean());
				daoligne.update(lgn.getId(), lgn);
				//break;
			}
		
		
			System.out.println("EdtBulletinRSImpl.processAfterSave() ***** FIN CUMMUL MOYENNE TRIMESTRIEL  eleve ******"+bulletin.getInscription().getNom());
		}
		
		return critere;
	}
}
