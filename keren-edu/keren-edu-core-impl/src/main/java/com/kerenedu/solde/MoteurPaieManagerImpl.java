/**
 * 
 */
package com.kerenedu.solde;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.ibm.icu.impl.duration.impl.DataRecord.EUnitVariant;
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.configuration.EtablissementDAOLocal;
import com.kerenedu.personnel.EmargementDtlPeriode;
import com.kerenedu.personnel.EmargementDtlPeriodeDAOLocal;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.personnel.ProfesseurChoiceDAOLocal;
import com.kerenedu.personnel.ProfesseurDAOLocal;

/**
 * @author Nadege
 *
 */
@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class MoteurPaieManagerImpl extends AbstractGenericManager<BulletinPaie, Long>
		implements MoteurPaieManagerLocal, MoteurPaieManagerRemote {

	@EJB(name = "BulletinPaieDAO")
	protected BulletinPaieDAOLocal dao;

	@EJB(name = "RubriquePaieDAO")
	protected RubriquePaieDAOLocal rubriquedao;

	@EJB(name = "ProfesseurChoiceDAO")
	protected ProfesseurChoiceDAOLocal employedao;

	@EJB(name = "ProfesseurDAO")
	protected ProfesseurDAOLocal employdao;

	@EJB(name = "ProfilPaieDAO")
	protected ProfilPaieDAOLocal profildao;

	@EJB(name = "ElementVariableDAO")
	protected ElementVariableDAOLocal eltvariabledao;

	@EJB(name = "EtablissementDAO")
	protected EtablissementDAOLocal societedao;

	@EJB(name = "EmargementDtlPeriodeDAO")
	protected EmargementDtlPeriodeDAOLocal emargedao;

	@Override
	public Double eval(RubriquePaie rubrique, Professeur salarie, PeriodePaie periode, Etablissement structure) {
		Double result = 0.0;
		if (rubrique.getMode().trim().equalsIgnoreCase("0")) {
			result = evalCategorie(rubrique, salarie, periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("1")) {
			result = (double) 0;// evalcycle(rubrique, salarie);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("2")) {// evalPersonnel(rubrique,
																		// salarie);
			result = evalPersonnel(rubrique, salarie, periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("3")) {// fixe
			result = rubrique.getValFixe();
		}
//		} else if (rubrique.getMode().trim().equalsIgnoreCase("4")) { // formulle
//			result = evalFormule(rubrique, salarie);
//		}

		return result;
	}

	private Double eval(RubriquePaie rubrique, Professeur salarie, PeriodePaie periode) {
		Double result = 0.0;
		if (rubrique.getMode().trim().equalsIgnoreCase("0")) {
			result = evalCategorie(rubrique, salarie,periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("1")) {
			result = (double) 0;// evalcycle(rubrique, salarie);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("2")) {// evalPersonnel(rubrique, salarie);
			result = evalPersonnel(rubrique, salarie,periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("3")) {// fixe
			result = rubrique.getValFixe();
		} /*else if (rubrique.getMode().trim().equalsIgnoreCase("4")) { // formulle
			result = evalFormule(rubrique, salarie);
		}*/

		return result;
	}

	@Override
	public BulletinPaie eval(BulletinPaie bulletin) {
		//System.out.println("MoteurPaieManagerImpl.eval() début évaluation rubrique "); // Traitement													// type
		Professeur salarie = employdao.findByPrimaryKey("id", bulletin.getEmploye().getId());
		Etablissement societe = this.getsociete();
		RubriquePaie rubrique = null;
		for (LigneBulletinPaie ligne : bulletin.getLignes()) {

			rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
			Double valeur = eval(rubrique, salarie, bulletin.getPeriode(), societe);
		//	System.out.println("MoteurPaieManagerImpl.eval() eval rubrique " + rubrique.getCode() + "mode"+ rubrique.getMode() + "valeur" + valeur);
			ligne.setValeur((valeur == null ? 0.0 : valeur));
			if (ligne.getRubrique().getTauxsal() != null) {
				ligne.setTauxsal(ligne.getValeur() * ligne.getRubrique().getTauxsal() / 100);
			} // end if(ligne.getRubrique().getTauxsal()!=null)
			if (ligne.getRubrique().getTauxpat() != null) {
				ligne.setTauxpat(ligne.getValeur() * ligne.getRubrique().getTauxpat() / 100);
			} // end if(ligne.getRubrique().getTauxpat()!=null){
		}
		return bulletin;
	}

	@Override
	public PrepaSalaire preparerPaie(PrepaSalaire prepa) {
		/**
		 * Etape 1 - Generation des bulletion de paie pour la periode
		 */
		List<Professeur> salaries = creationBulletinPaiePeriode(prepa);

		/**
		 * Etape 2 - Evaluation des bulletin de paie générer
		 */
		// if(salaries!=null && !salaries.isEmpty()){
		// System.out.println("MoteurPaieManagerImpl.preparerPaie() début
		// evaluation ==== ");
		// for(Professeur salarie : salaries){
		// RestrictionsContainer container =
		// RestrictionsContainer.newInstance();
		// container.addEq("employe", salarie);
		// container.addEq("periode", prepa.getPeriode());
		// List<BulletinPaie> bulletins = dao.filter(container.getPredicats(),
		// null, null, 0, -1);
		// for(BulletinPaie bulletin : bulletins){
		// bulletin= eval(bulletin);
		// dao.update(bulletin.getId(), bulletin);
		// }//end for(BulletinPaie bulletin : bulletins){
		// }//end for(Employe salarie : salaries)
		// }//end if(salaries!=null && !salaries.isEmpty()){
		//
		return prepa;
	}

	@Override
	public GenericDAO<BulletinPaie, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public String getEntityIdName() {
		// TODO Auto-generated method stub
		return "id";
	}

	/**
	 * Permet- de creer les bulletin
	 * 
	 * @param entity
	 * @return
	 */

	private List<Professeur> creationBulletinPaiePeriode(PrepaSalaire entity) {
		
		List<Professeur> salaries = new ArrayList<Professeur>();
		if (entity.getPorte().trim().equalsIgnoreCase("0")) {// Tout les
																// employes
			//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() tous les employes");
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			//container.addNotNull("profil", null);
			container.addNotNull("categorie", null);
			container.addNotEq("state", "desactiver");	
			salaries.addAll(employdao.filter(container.getPredicats(), null, null, 0, -1));
		} else if (entity.getPorte().trim().equalsIgnoreCase("1")) {// Employes
																	// selectionnés
		//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() select employées");
			for (ProfesseurChoice prof : entity.getConcernes()) {
				salaries.add(new Professeur(prof));
			}
		}
		/**************************************************************************************************/
		/**========================= DEBUT TRAITEMENT BULLETIN====================================/
		/**************************************************************************************************/
		System.out.println("/**========================= DEBUT TRAITEMENT BULLETIN====================================/");
		// creation du bulletin
		for (Professeur salarie : salaries) {
			Professeur sal = employdao.findByPrimaryKey("id", salarie.getId());
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container = RestrictionsContainer.newInstance();
			container.addEq("employe.id", salarie.getId());
			container.addEq("periode", entity.getPeriode());
			List<BulletinPaie> bulletins = dao.filter(container.getPredicats(), null, null, 0, -1);
			if (bulletins != null && !bulletins.isEmpty()) {
				// Suppressions des anciens bulletins de paie
				for (BulletinPaie bul : bulletins) {
					dao.delete(bul.getId());
				} // end for(BulletinPaie bul:bulletins){
			} // end if(bulletins!=null&&!bulletins.isEmpty()){
			System.out.println("/**=======================DEBUT TRAITEMENT BULLETIN EMPLOYE=========/"+salarie.getNom());
			//is illegible
			if(iselligible(sal, entity.getPeriode())==true){
			//	System.out.println("/**=======================TRAITEMENT BULLETIN EMPLOYE=========/"+salarie.getNom()+" is elligible "+iselligible(sal, entity.getPeriode()));
			// Salaire de base brut
			Double valeur = 0.0;Double tp = 0.0; Double ts = 0.0;Double salbasebrut = 0.0;
			// Salaire cotisable 	// Charge patronal 	// Charge Sallarial
			Double salco = 0.0; Double chargepat = 0.0; Double chargeSal = 0.0;
			// Salaire de base brut		// Charge patronal		// Charge Sallarial
			Double csb = 0.0; 	Double ccp = 0.0; 	Double ccs = 0.0;
			// allo			// Gain employe
			Double allo = 0.0;	Double gainemp = 0.0;	
			// amicale 	// loyer employe			// loyer employe
			Double amicale = 0.0;	Double loyer = 0.0;	Double prime = 0.0;
			// loyer employe// retenue employe-pret avance..)
			Double indem = 0.0;Double retenue = 0.0;Double pret = 0.0;Double aco = 0.0;
			Double sbase = 0.0 ;double sommerem =0.0;double sommeacompte=0.0;
			
			// Cache des lignes du bulletion de paie
			HashMap<String, LigneBulletinPaie> datacache = new HashMap<String, LigneBulletinPaie>();
			container = RestrictionsContainer.newInstance();
			ProfilPaie profil = profildao.filter(container.getPredicats(), null, null, 0, -1).get(0);
			if (profil == null) {
				throw new KerenExecption("Le salarié " + salarie.getDesignation() + " n'a pas de Profil de Paie lié");
			} // end if(salarie.getProfilpaie()==null)
			
			
			// Professeur prof= employdao.findByPrimaryKey("id",
			// salarie.getId());
			BulletinPaie bulletin = null;
			Etablissement societe = this.getsociete();
			bulletin = new BulletinPaie(salarie.getNom(), salarie, null, entity.getPeriode(), societe);
			//ProfilPaie profil = profildao.findByPrimaryKey("id", salarie.getProfil().getId());
			for (RubriquePaie rubrique : profil.getRubriques()) {
			//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() debut rubrique "+rubrique.getDesc());
				LigneBulletinPaie ligne = null;
				if (datacache.containsKey(rubrique.getCode())) {
					ligne = datacache.get(rubrique.getCode());
					ligne.setValeur(eval(rubrique, salarie, entity.getPeriode()) + ligne.getValeur());
				} else {
					ligne = new LigneBulletinPaie(rubrique, 0.0, 0.0, 0.0);

					valeur = eval(rubrique, salarie, entity.getPeriode());
					if (ligne.getRubrique().getTauxsal() != null && ligne.getRubrique().getTauxsal() != 0) {
						ts = valeur * ligne.getRubrique().getTauxsal() / 100;
					} // end if(ligne.getRubrique().getTauxsal()!=null)
					if (ligne.getRubrique().getTauxpat() != null && ligne.getRubrique().getTauxpat() != 0) {
						tp = valeur * ligne.getRubrique().getTauxpat() / 100;
					} // end if(ligne.getRubrique().getTauxpat()!=null){
					ligne.setValeur((valeur == null ? 0.0 : valeur));
					ligne.setTauxpat((tp == null ? 0.0 : tp));
					ligne.setTauxsal((ts == null ? 0.0 : ts));
					datacache.put(rubrique.getCode(), ligne);
				} // end datacache Rubrique

					chargepat += ligne.getTauxpat();
				if (rubrique.getType().equals("1")) {// Retenue
					chargeSal += ligne.getTauxsal();
					retenue+=ligne.getTauxsal();
				}
				//salaire de base
				if (rubrique.getNature().equals("0")) {// loyer
					sbase += ligne.getValeur();
				}
				//Salaire;Prime;Indemnité;Allocations Familiales;Amicale;Loyer;Autres Retenues
				if (rubrique.getType().equals("0")&&rubrique.getBrutsal()==true) {// salaire brut
					salbasebrut += ligne.getValeur();
				}
				if (rubrique.getCotisablesal()==true) {// salaire cotisable
					salco += ligne.getValeur();
				//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() salco trouvé "+salco);
				}
				if (rubrique.getNature().equals("5")) {// loyer
					loyer += ligne.getValeur();
				}
				if (rubrique.getNature().equals("4")) {// amicale
					amicale += ligne.getValeur();
				}
//				if (rubrique.getNature().equals("6")) {// autreretenue
//					retenue += ligne.getValeur();
//				}
				if (rubrique.getNature().equals("1")) {// prime
					prime += ligne.getValeur();
				}
				if (rubrique.getNature().equals("2")) {// indemnité
					indem += ligne.getValeur();
				}
				if (rubrique.getNature().equals("3")) {// allocation
					allo += (ligne.getValeur()*ligne.getTauxsal())/100;
				}
				if (!bulletin.getLignes().contains(ligne)) {
					bulletin.getLignes().add(ligne);
				} else {
					int index = bulletin.getLignes().indexOf(ligne);
					bulletin.getLignes().set(index, ligne);
				} // end if(!bulletin.getLignes().contains(ligne))
			//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() mode "+rubrique.getMode()+" valeur "+valeur);
			//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() fin rubrique "+rubrique.getDesc()+" ts "+ts+"  tp"+tp);

			} // end for(Rubrique rubrique:profil.getRubriques()){
			
			/**************************************************************************************************/
			/**========================= DEBUT TRAITEMENt ELEMENT VARIABLES====================================/
			/**************************************************************************************************/
			System.out.println("/**========================= DEBUT TRAITEMENt ELEMENT VARIABLES====================================/"+salarie.getNom());
			// Traitement des Elements variables(Prêt , avances,...)
			Calendar cal = Calendar.getInstance();
			cal.setTime(entity.getPeriode().getDfin());
			int mois = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			//List<ElementVariable> eltsvariables = eltvariabledao.filter(container.getPredicats(), null, null, 0, -1);
			List<ElementVariable> eltsvariables = eltvariabledao.getListElt(mois, year,salarie);
			
			if (eltsvariables != null && !eltsvariables.isEmpty()) {
				//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() size "+eltsvariables.size());
			//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() nombre  element variable =="+eltsvariables.size());
				for(ElementVariable eltvar :eltsvariables){
					if(!eltvar.getState().equals("inactif")){
				//ElementVariable eltvar = eltsvariables.get(0);
				// Remboursement avance
				//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() je parcours par elt");
				// Acompte
				for (Acompte acompte : eltvar.getAcomptes()) {
				//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() debut acompte "+acompte.getEmploye().getNom());
					sommeacompte+= acompte.getMontant();
					System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode()total acompte  ==="+sommeacompte+"employe "+acompte.getEmploye().getNom());
					RubriquePaie rubrique = acompte.getRubrique();
					LigneBulletinPaie ligne = null;
					if (datacache.containsKey(rubrique.getCode())) {
						valeur = sommeacompte;
						ligne = datacache.get(rubrique.getCode());
						ligne.setValeur(valeur);
						if (rubrique.getTauxsal() != null && rubrique.getTauxsal() != 0) {
							ts = valeur * rubrique.getTauxsal() / 100;
						} // end if(ligne.getRubrique().getTauxsal()!=null)
						if (rubrique.getTauxpat() != null && rubrique.getTauxpat() != 0) {
							tp = valeur * rubrique.getTauxpat() / 100;
						} // end if(ligne.getRubrique().getTauxpat()!=null){
						ligne.setValeur((valeur == null ? 0.0 : valeur));
						ligne.setTauxpat((tp == null ? 0.0 : tp));
						ligne.setTauxsal((ts == null ? 0.0 : ts));
						chargepat += ligne.getTauxpat();
						if (rubrique.getType().equals("1")) {// Retenue
							chargeSal += acompte.getMontant();
							retenue+=acompte.getMontant();
							aco+=acompte.getMontant();
						}
					//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() ts 11 "+ts);
					} else {
						ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(), rubrique.getTauxpat());
						valeur = sommeacompte;
						if (rubrique.getTauxsal() != null && rubrique.getTauxsal() != 0) {
							ts = valeur * rubrique.getTauxsal() / 100;
						} // end if(ligne.getRubrique().getTauxsal()!=null)
						if (rubrique.getTauxpat() != null && rubrique.getTauxpat() != 0) {
							tp = valeur * rubrique.getTauxpat() / 100;
						} // end if(ligne.getRubrique().getTauxpat()!=null){
						ligne.setValeur((valeur == null ? 0.0 : valeur));
						ligne.setTauxpat((tp == null ? 0.0 : tp));
						ligne.setTauxsal((ts == null ? 0.0 : ts));
						chargepat += ligne.getTauxpat();
						if (rubrique.getType().equals("1")) {// Retenue
							chargeSal += acompte.getMontant();
							retenue+=acompte.getMontant();
							aco+=acompte.getMontant();
						}
					//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() ts 22 "+ts);
						datacache.put(rubrique.getCode(), ligne);
					} // end if(datacache.containsKey(rubrique.getCode())){
		
					if (!bulletin.getLignes().contains(ligne)) {
						bulletin.getLignes().add(ligne);
					} else {
						int index = bulletin.getLignes().indexOf(ligne);
						bulletin.getLignes().set(index, ligne);
					} // end if(!bulletin.getLignes().contains(ligne))
				//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() end acompte "+acompte.getEmploye().getNom()+"valeur "+valeur);
				} // end for(RemboursementAvance rem:eltvar.getAvances())
				
				
				// Remboursement Prèt ==========================
			
				for (RemboursementPret rem : eltvar.getPrets()) {
					 sommerem +=rem.getMontant();
					System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode()total Pret  ==="+sommerem+"employe "+rem.getDemande().getEmploye().getNom());
					//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() debut RemboursementPret "+rem.getDemande().getEmploye().getNom());
					RubriquePaie rubrique = rem.getPret().getRubrique();
					LigneBulletinPaie ligne = null;
					if (datacache.containsKey(rubrique.getCode())) {
						valeur = sommerem;
						ligne = datacache.get(rubrique.getCode());
						ligne.setValeur(valeur);
						if (rubrique.getTauxsal() != null && rubrique.getTauxsal() != 0) {
							ts = valeur * rubrique.getTauxsal() / 100;
						} // end if(ligne.getRubrique().getTauxsal()!=null)
						if (rubrique.getTauxpat() != null && rubrique.getTauxpat() != 0) {
							tp = valeur * rubrique.getTauxpat() / 100;
						} // end if(ligne.getRubrique().getTauxpat()!=null){
						//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() rubriqque "+rubrique.getDesc()+" valeur"+ts);
						ligne.setValeur((valeur == null ? 0.0 : valeur));
						ligne.setTauxpat((tp == null ? 0.0 : tp));
						ligne.setTauxsal((ts== null ? 0.0 : ts));
						chargepat += ligne.getTauxpat();
						if (rubrique.getType().equals("1")) {// Retenue
							chargeSal += rem.getMontant();
							retenue+=rem.getMontant();
							pret+=rem.getMontant();
						}
					} else {
						ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(), rubrique.getTauxpat());
						// ligne = new
						// LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
						valeur = sommerem;
						//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() montant pret "+valeur);
						if (rubrique.getTauxsal() != null && rubrique.getTauxsal() != 0) {
							ts = valeur * rubrique.getTauxsal() / 100;
						} // end if(ligne.getRubrique().getTauxsal()!=null)
						if (rubrique.getTauxpat() != null && rubrique.getTauxpat() != 0) {
							tp = valeur * rubrique.getTauxpat() / 100;
						} // end if(ligne.getRubrique().getTauxpat()!=null){
						//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() rubriqque "+rubrique.getDesc()+" valeur"+ts);
						ligne.setValeur((valeur == null ? 0.0 : valeur));
						ligne.setTauxpat((tp == null ? 0.0 : tp));
						ligne.setTauxsal((ts== null ? 0.0 : ts));
						chargepat += ligne.getTauxpat();
						if (rubrique.getType().equals("1")) {// Retenue
							chargeSal += rem.getMontant();
							retenue+=rem.getMontant();
							pret+=rem.getMontant();
						}
						datacache.put(rubrique.getCode(), ligne);

					} // end if(datacache.containsKey(rubrique.getCode())){
					if (!bulletin.getLignes().contains(ligne)) {
						bulletin.getLignes().add(ligne);
					} else {
						int index = bulletin.getLignes().indexOf(ligne);
						bulletin.getLignes().set(index, ligne);
					} // end if(!bulletin.getLignes().contains(ligne))
					//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() fin RemboursementPret " + ""+rem.getDemande().getEmploye().getNom()+" valeur " +valeur);
				} // end for(RemboursementAvance rem:eltvar.getAvances())
					// Rappel Salaires container =
					// RestrictionsContainer.newInstance();
			}// end if(!eltvar.getState().equals("inactif")){
			}//  end for(ElementVariable eltvar :eltsvariables){
			} // end if(eltsvariables!=null&&!eltsvariables.isEmpty()){
			// others elts varaible
			
			/**************************************************************************************************/
			/**========================= DEBUT TRAITEMENT AUTERES  ELEMENT VARIABLES====================================/
			/**************************************************************************************************/
			System.out.println("/**========================= DEBUT TRAITEMENT AUTERES  ELEMENT VARIABLES====================================/"+ DateHelper.formatDate(entity.getPeriode().getDfin()));
//			container.addEq("salarie0", salarie);
//			container.addGe("dfin", DateHelper.formatDate(entity.getPeriode().getDfin()));
//			container.addNotEq("state","inactif");
//			List<ElementVariable> eltsvariablesRappel = eltvariabledao.filter(container.getPredicats(), null, null,0, -1);
//
//			if (eltsvariables != null && !eltsvariables.isEmpty() && eltsvariablesRappel.size() > 0) {
//				ElementVariable eltvarrappel = eltsvariablesRappel.get(0);
//				for (RappelSalaire rap : eltvarrappel.getRappels()) {
//					for (LigneRappel lign : rap.getLignes()) {
//						RubriquePaie rubrique = lign.getRubrique();
//						LigneBulletinPaie ligne = null;
//						if (datacache.containsKey(rubrique.getCode())) {
//							ligne = datacache.get(rubrique.getCode());
//							ligne.setValeur(lign.getMontant() + ligne.getValeur());
//						} else {
//							ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(),
//									rubrique.getTauxpat());
//							// ligne = new
//							// LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//							valeur = lign.getSolde();
//							if (ligne.getRubrique().getTauxsal() != null && ligne.getRubrique().getTauxsal() != 0) {
//								ts = valeur * ligne.getRubrique().getTauxsal() / 100;
//							} // end
//								// if(ligne.getRubrique().getTauxsal()!=null)
//							if (ligne.getRubrique().getTauxpat() != null && ligne.getRubrique().getTauxpat() != 0) {
//								tp = valeur * ligne.getRubrique().getTauxpat() / 100;
//							} // end
//								// if(ligne.getRubrique().getTauxpat()!=null){
//							ligne.setValeur((valeur == null ? 0.0 : valeur));
//							ligne.setTauxpat((tp == null ? 0.0 : tp));
//							ligne.setTauxsal((ts == null ? 0.0 : ts));
//							datacache.put(rubrique.getCode(), ligne);
//
//						} // end
//							// if(datacache.containsKey(rubrique.getCode())){
//						chargepat += ligne.getTauxpat();
//						if (rubrique.getType().equals("1")) {// Retenue
//							chargeSal += ligne.getTauxsal();
//							retenue+=ligne.getTauxsal();
//						}
//						//salaire de base
//						if (rubrique.getNature().equals("0")) {// loyer
//							sbase += ligne.getValeur();
//						}
//						//Salaire;Prime;Indemnité;Allocations Familiales;Amicale;Loyer;Autres Retenues
//						if (rubrique.getType().equals("0")&&rubrique.getBrutsal()==true) {// salaire brut
//							salbasebrut += ligne.getValeur();
//						}
//						if (rubrique.getCotisablesal()==true) {// salaire cotisable
//							salco += ligne.getValeur();
//						}
//						if (rubrique.getNature().equals("5")) {// loyer
//							loyer += ligne.getValeur();
//						}
//						if (rubrique.getNature().equals("4")) {// amicale
//							amicale += ligne.getValeur();
//						}
////						if (rubrique.getNature().equals("6")) {// autreretenue
////							retenue += ligne.getValeur();
////						}
//						if (rubrique.getNature().equals("1")) {// prime
//							prime += ligne.getValeur();
//						}
//						if (rubrique.getNature().equals("2")) {// indemnité
//							indem += ligne.getValeur();
//						}
//						if (rubrique.getNature().equals("3")) {// allocation
//							allo += (ligne.getValeur()*ligne.getTauxsal())/100;
//						}
//						if (!bulletin.getLignes().contains(ligne)) {
//							bulletin.getLignes().add(ligne);
//						} else {
//							int index = bulletin.getLignes().indexOf(ligne);
//							bulletin.getLignes().set(index, ligne);
//						} // end if(!bulletin.getLignes().contains(ligne))
//					} // end for(Rubrique rubrique:rap.getLignes()){
//				}
//			}
//			
			/**************************************************************************************************/
			/**========================= DEBUT EVALUATION RUBRIQUE FORMULES====================================/
			/**************************************************************************************************/
			
			System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() debut évaluation des formule");
			
			bulletin.setSalaireCotisable(salco);			
			//evaluation des formules
			//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() evaluation des formule"+salco);
			for(LigneBulletinPaie lgn : bulletin.getLignes()){
				if(lgn.getRubrique().getMode()!=null&&lgn.getRubrique().getMode().equals("4")){
					Double value =0.0;
					bulletin.setSalaireCotisable(salco);
					//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() evaluation des formule"+salco);
					if(bulletin.getEmploye().getAllocationfamilliale()!=null&&bulletin.getEmploye().getAllocationfamilliale()==true){
						value = salco;//evalFormule(lgn.getRubrique(),bulletin,salco);
					}
					//System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() value evaluer "+value);
					//lgn.setValeur(value);
					if (lgn.getRubrique().getTauxsal() != null && lgn.getRubrique().getTauxsal() != 0) {
						ts = value * lgn.getRubrique().getTauxsal() / 100;
					} // end if(ligne.getRubrique().getTauxsal()!=null)
					if (lgn.getRubrique().getTauxpat() != null && lgn.getRubrique().getTauxpat() != 0) {
						tp = value * lgn.getRubrique().getTauxpat() / 100;
					} // end if(ligne.getRubrique().getTauxpat()!=null){
					lgn.setValeur((value == null ? 0.0 : value));
					lgn.setTauxpat((tp == null ? 0.0 : tp));
					lgn.setTauxsal((ts == null ? 0.0 : ts));
					
					
//					if (lgn.getRubrique().getNature().equals("6")) {// autreretenue
//						retenue += ts;
//					}
					chargepat += lgn.getTauxpat();
					if (lgn.getRubrique().getType().equals("1")) {// Retenue
						chargeSal += ts;
						retenue+=lgn.getTauxsal();
					}
					//salaire de base
					if (lgn.getRubrique().getNature().equals("0")) {// loyer
						sbase += lgn.getValeur();
					}
					if (lgn.getRubrique().getType().equals("0")&&lgn.getRubrique().getBrutsal()==true) {// salaire brut
						salbasebrut += ts;
					}
					if (lgn.getRubrique().getNature().equals("3")) {// allocation
						allo += ts;
					}
				}
				if (!bulletin.getLignes().contains(lgn)) {
					bulletin.getLignes().add(lgn);
				} else {
					int index = bulletin.getLignes().indexOf(lgn);
					bulletin.getLignes().set(index, lgn);
				} // end if(!bulletin.getLignes().contains(ligne))
			}
			bulletin.setCongesAcquisPeriode((double) 0);
			bulletin.setCongesprisPeriode((double) 0);
			bulletin.setSalaireBrut(salbasebrut);
			bulletin.setChargePatronale(chargepat);
		//	System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() chrge sal "+chargeSal);
			bulletin.setChargeSalariale(chargeSal);
			bulletin.setNetapayer(bulletin.getSalaireBrut() - bulletin.getChargeSalariale());
			bulletin.setAmical(amicale);
			bulletin.setLoyer(loyer);
			bulletin.setRetenue(retenue);
			bulletin.setAllocation(allo);
			bulletin.setIndemnite(indem);
			bulletin.setPrime(prime);
			bulletin.setPret(pret);
			bulletin.setAcom(aco);
			salarie.setSalaire(salbasebrut);
			bulletin.setSbase(sbase);
			
			// cumul
			Cumul cumul = getCumulbulletin(bulletin);
			bulletin.setCumulChargePatronale(cumul.getCumulChargePatronale());
			bulletin.setCumulChargeSalariale(cumul.getCumulChargeSalariale());
			bulletin.setCumulSalaireBrut(cumul.getCumulSalaireBrut());

			RuleBasedNumberFormat rbnf = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);

			BigDecimal bd = new BigDecimal(bulletin.getNetapayer());
			bd = bd.setScale(0, BigDecimal.ROUND_UP);
			Double netarond = bd.doubleValue();
			String mntEnlettre = rbnf.format(netarond);
			bulletin.setNetapayer(netarond);
			bulletin.setNetLettre(mntEnlettre);

			if (salarie != null && salarie.getDateembauche() != null) {
				bulletin.setAnciennite(Double.parseDouble(
						"" + DateHelper.numberOfMonth(salarie.getDateembauche(), bulletin.getPeriode().getDfin())));
			} // end if(contrat!=null){
			//set salaire brut employé
			salarie.setSalaire(bulletin.getNetapayer());
			bulletin.setDpayement(bulletin.getPeriode().getDfin());
			bulletin.setAnneScolaire(bulletin.getPeriode().getExercice().getCode());
			if (bulletin.getId() > 0) {
				dao.update(bulletin.getId(), bulletin);
			} else {
				dao.save(bulletin);
				//System.out.println(MoteurPaieManagerImpl.class.toString() + " ==================================== " + bulletin);
			} // end if(bulletin.getId()>0){
				// update salarié
			employdao.update(salarie.getId(), salarie);
			System.out.println("/**=======================FIN TRAITEMENT BULLETIN EMPLOYE=========/"+salarie.getNom());
		 }// end if iselligible
		} // end for(ProfesseurChoice salarie : salaries){

		return salaries;

	}

	/**
	 * Evaluation sur la base de la categorie
	 * 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalCategorie(RubriquePaie rubrique, Professeur salarie, PeriodePaie periode) {
		Double valeur = 0.0;
		Double presence = 0.0;
		Double retard = 0.0;
	//	System.out.println("MoteurPaieManagerImpl.evalCategorie() rubrique "+rubrique.getDesc());
		if (salarie.getCategorie() == null) {
			return valeur;
		} // end if(salarie.getFonction()==null)
		//System.out.println("MoteurPaieManagerImpl.evalCategorie() rubrique "+rubrique.getDesc());
		for (ForfaitCategorie forfait : rubrique.getForfaitscat()) {
		//	System.out.println("MoteurPaieManagerImpl.evalCategorie() forfait "+forfait.getValeur()+"salarie "+salarie.getNom());
			if (forfait.getCategorie().getCode().equals(salarie.getCategorie().getCode())) {
				if (forfait.getMesure().equals("0")) {
					valeur = forfait.getValeur();
					//System.out.println("MoteurPaieManagerImpl.evalCategorie() valeur forfait "+valeur+"salarie "+salarie.getNom());
				} else {
					// get emargement période
					valeur=this.evalCoutHoraire(forfait,salarie,periode);
				}

				// System.out.println(MoteurPaieManagerImpl.class.toString()+".evalCategorieProf(Rubrique
				// rubrique, Employe salarie) ========== forfait :
				// "+forfait.getCategorie()+" === salarie :
				// "+salarie.getFonction()+" == valeur :"+valeur);
				return valeur;
			}
		} // end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}

	/**
	 * Evaluation sur la base de la categorie
	 * 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalPersonnel(RubriquePaie rubrique, Professeur salarie, PeriodePaie periode) {
		Double valeur = 0.0;
		Double presence = 0.0;
		Double retard = 0.0;
		// if(salarie.getCategorie()==null){
		// return valeur;
		// }//end if(salarie.getFonction()==null)
		for (ForfaitPersonnel forfait : rubrique.getForfaitsperso()) {
			if (forfait.getPersonnel().getNom().compareTo(salarie.getNom()) == 0) {
				if (forfait.getMesure().equals("0")) {
					valeur = forfait.getValeur();
				} else {
					valeur=this.evalCoutHoraire(salarie,periode,forfait);
				}

				// System.out.println(MoteurPaieManagerImpl.class.toString()+".evalCategorieProf(Rubrique
				// rubrique, Employe salarie) ========== forfait :
				// "+forfait.getCategorie()+" === salarie :
				// "+salarie.getFonction()+" == valeur :"+valeur);
				return valeur;
			}
		} // end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}

	/**
	 * Evaluation sur la base de la categorie
	 * 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalFormule(RubriquePaie rubrique, BulletinPaie bulletin, double valeurd) {
		Double valeur = 0.0;
		//valeur allocation familliale
		if(bulletin.getEmploye().getAllocationfamilliale()!=null&&bulletin.getEmploye().getAllocationfamilliale()==true){
		if(rubrique.getFormule()!=null&&rubrique.getFormule().equals("SALCO")){
			valeur= valeurd;
		}
		}
		return valeur;
	}
	
	private Double evalFormule(RubriquePaie rubrique, BulletinPaie bulletin) {
		Double valeur = 0.0;
		//valeur allocation familliale
		if(bulletin.getEmploye().getAllocationfamilliale()!=null&&bulletin.getEmploye().getAllocationfamilliale()==true){
		if(rubrique.getFormule()!=null&&rubrique.getFormule().equals("SALCO")){
			valeur= bulletin.getSalaireCotisable();
		}
		}
		return valeur;
	}
	
	
	
	private Double evalCoutHoraire(ForfaitCategorie forfait, Professeur salarie,PeriodePaie periode){
		Double valeur =0.0;
		Double presence =0.0;
		Double retard =0.0;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("prof.id", salarie.getId());
		container.addEq("periode.id", periode.getId());
		List<EmargementDtlPeriode> emarges = emargedao.filter(container.getPredicats(), null, null, 0, -1);
		if (emarges != null && !emarges.isEmpty()) {
			for(EmargementDtlPeriode emarge:emarges ){
				presence =0.0;retard =0.0;
				presence = emarge.getPresence() * forfait.getValeur();
				retard = emarge.getRetard() * forfait.getValeur();
				valeur=valeur+(presence-retard);
			}
		}
		return valeur;
	}
	private Double evalCoutHoraire( Professeur salarie,PeriodePaie periode){
		Double valeur =0.0;
//		Double presence =0.0;
//		Double retard =0.0;
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		container.addEq("prof.id", salarie.getId());
//		container.addEq("periode.id", periode.getId());
//		List<EmargementDtlPeriode> emarges = emargedao.filter(container.getPredicats(), null, null, 0, -1);
//		if (emarges != null && !emarges.isEmpty()) {
//			for(EmargementDtlPeriode emarge:emarges ){
//				presence =0.0;retard =0.0;
//				presence = emarge.getPresence() * emarge.getCout().getCout();
//				retard = emarge.getRetard() * emarge.getCout().getCout();
//				valeur=valeur+(presence-retard);
//			}
//		}
//		System.out.println("MoteurPaieManagerImpl.evalCoutHoraire() valeur is ..."+valeur);
		return valeur;
	}
	
	private Double evalCoutHoraire( Professeur salarie,PeriodePaie periode,ForfaitPersonnel forfait){
		Double valeur =0.0;
		Double presence =0.0;
		Double retard =0.0;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("prof.id", salarie.getId());
		container.addEq("periode.id", periode.getId());
		List<EmargementDtlPeriode> emarges = emargedao.filter(container.getPredicats(), null, null, 0, -1);
		if (emarges != null && !emarges.isEmpty()) {
			for(EmargementDtlPeriode emarge:emarges ){
				presence =0.0;retard =0.0;
				presence = emarge.getPresence() * forfait.getValeur();
				retard = emarge.getRetard() * forfait.getValeur();
				valeur=valeur+(presence-retard);
			}
		}
		//System.out.println("MoteurPaieManagerImpl.evalCoutHoraire() valeur is ..."+valeur);
		return valeur;
	}

	private Etablissement getsociete() {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Etablissement> etbs = societedao.filter(container.getPredicats(), null, null, 0, -1);
		return etbs.get(0);
	}

	/**
	 * 
	 * @param periode
	 * @return
	 */
	private Cumul getCumulbulletin(BulletinPaie bulletion) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("periode.exercice.id", bulletion.getPeriode().getExercice().getId());
		container.addEq("employe.id", bulletion.getEmploye().getId());
		// container.addLt("periode.ddebut",
		// bulletion.getPeriode().getDdebut());
		Cumul cumul = new Cumul();
		List<BulletinPaie> bulletins = dao.filter(container.getPredicats(), null, null, 0, -1);
		// System.out.println(MoteurPaieManagerImpl.class.toString()+".getCumulSalaireBase(BulletinPaie
		// bulletion) ========= "+bulletins.size());
		for (BulletinPaie bul : bulletins) {
			if (bul.getPeriode().getDdebut().before(bulletion.getPeriode().getDdebut())) {
				cumul.setCumulChargePatronale(cumul.getCumulChargePatronale() + bul.getChargePatronale());
				cumul.setCumulChargeSalariale(cumul.getCumulChargeSalariale() + bul.getChargeSalariale());
				cumul.setCumulSalaireBrut(cumul.getCumulSalaireBrut() + bul.getSalaireBrut());

			} // end
				// if(bul.getPeriode().getDdebut().after(bulletion.getPeriode().getDdebut())){
		} // end for(BulletinPaie bul:bulletins){
		return cumul;
	}
	
	private boolean iselligible(Professeur salarie, PeriodePaie periode){
		boolean value = false;
		if(salarie.getAllperiode()!=null&&salarie.getAllperiode().equals("0")){
			value=true;
		}else{
			List<PeriodePaie>periodesalarie= salarie.getPeriodepaie();
			for(PeriodePaie p : periodesalarie){
				if(p.getId()==periode.getId()){
					value=true;
					break;
				}
			}
		}
		System.out.println("MoteurPaieManagerImpl.iselligible() is elligible is "+value);
		return value ;
	}

	private Date getDate(String date) {
		Date dated = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dated = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dated;

	}
}
