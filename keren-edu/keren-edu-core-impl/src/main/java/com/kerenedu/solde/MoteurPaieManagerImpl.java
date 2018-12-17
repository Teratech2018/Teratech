/**
 * 
 */
package com.kerenedu.solde;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		} else if (rubrique.getMode().trim().equalsIgnoreCase("4")) { // formulle
			result = evalFormule(rubrique, salarie);
		}

		return result;
	}

	private Double eval(RubriquePaie rubrique, Professeur salarie, PeriodePaie periode) {
		Double result = 0.0;
		if (rubrique.getMode().trim().equalsIgnoreCase("0")) {
			result = evalCategorie(rubrique, salarie,periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("1")) {
			result = (double) 0;// evalcycle(rubrique, salarie);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("2")) {// evalPersonnel(rubrique,
																		// salarie);
			result = evalPersonnel(rubrique, salarie,periode);
		} else if (rubrique.getMode().trim().equalsIgnoreCase("3")) {// fixe
			result = rubrique.getValFixe();
		} else if (rubrique.getMode().trim().equalsIgnoreCase("4")) { // formulle
			result = evalFormule(rubrique, salarie);
		}

		return result;
	}

	@Override
	public BulletinPaie eval(BulletinPaie bulletin) {
		System.out.println("MoteurPaieManagerImpl.eval() début évaluation rubrique "); // Traitement
																						// des
																						// rubrique
																						// de
																						// type
		Professeur salarie = employdao.findByPrimaryKey("id", bulletin.getEmploye().getId());
		Etablissement societe = this.getsociete();
		RubriquePaie rubrique = null;
		for (LigneBulletinPaie ligne : bulletin.getLignes()) {

			rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
			Double valeur = eval(rubrique, salarie, bulletin.getPeriode(), societe);
			System.out.println("MoteurPaieManagerImpl.eval() eval rubrique " + rubrique.getCode() + "mode"
					+ rubrique.getMode() + "valeur" + valeur);
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
			System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() tous les employes");
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addNotNull("profil", null);
			container.addNotNull("categorie", null);
			salaries.addAll(employdao.filter(container.getPredicats(), null, null, 0, -1));
		} else if (entity.getPorte().trim().equalsIgnoreCase("1")) {// Employes
																	// selectionnés
			System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() select employées");
			for (ProfesseurChoice prof : entity.getConcernes()) {
				salaries.add(new Professeur(prof));
			}
		}
		// creation du bulletin
		for (Professeur salarie : salaries) {
			Double valeur = 0.0;
			Double tp = 0.0;
			Double ts = 0.0;
			// Salaire de base brut
			Double salbasebrut = 0.0;
			// Charge patronal
			Double chargepat = 0.0;
			// Charge Sallarial
			Double chargeSal = 0.0;

			// Salaire de base brut
			Double csb = 0.0;
			// Charge patronal
			Double ccp = 0.0;
			// Charge Sallarial
			Double ccs = 0.0;

			// Cache des lignes du bulletion de paie
			HashMap<String, LigneBulletinPaie> datacache = new HashMap<String, LigneBulletinPaie>();
			if (salarie.getProfil() == null) {
				throw new KerenExecption("Le salarié " + salarie.getDesignation() + " n'a pas de Profil de Paie lié");
			} // end if(salarie.getProfilpaie()==null)

			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("employe.id", salarie.getId());
			container.addEq("periode", entity.getPeriode());
			List<BulletinPaie> bulletins = dao.filter(container.getPredicats(), null, null, 0, -1);
			BulletinPaie bulletin = null;
			if (bulletins != null && !bulletins.isEmpty()) {
				// Suppressions des anciens bulletins de paie
				for (BulletinPaie bul : bulletins) {
					dao.delete(bul.getId());
				} // end for(BulletinPaie bul:bulletins){
			} // end if(bulletins!=null&&!bulletins.isEmpty()){
			// Professeur prof= employdao.findByPrimaryKey("id",
			// salarie.getId());
			Etablissement societe = this.getsociete();
			bulletin = new BulletinPaie(salarie.getNom(), salarie, null, entity.getPeriode(), societe);
			ProfilPaie profil = profildao.findByPrimaryKey("id", salarie.getProfil().getId());
			for (RubriquePaie rubrique : profil.getRubriques()) {
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
				}
				if (rubrique.getType().equals("0")) {// Gain
					salbasebrut += ligne.getValeur();
				}

				if (!bulletin.getLignes().contains(ligne)) {
					bulletin.getLignes().add(ligne);
				} else {
					int index = bulletin.getLignes().indexOf(ligne);
					bulletin.getLignes().set(index, ligne);
				} // end if(!bulletin.getLignes().contains(ligne))

			} // end for(Rubrique rubrique:profil.getRubriques()){

			// Traitement des Elements variables(Prêt , avances,...)
			container = RestrictionsContainer.newInstance();
			container.addEq("salarie0", salarie);
			container.addEq("periode", entity.getPeriode());
			List<ElementVariable> eltsvariables = eltvariabledao.filter(container.getPredicats(), null, null, 0, -1);
			if (eltsvariables != null && !eltsvariables.isEmpty()) {
				ElementVariable eltvar = eltsvariables.get(0);
				// Remboursement avance

				// Acompte
				for (Acompte acompte : eltvar.getAcomptes()) {
					RubriquePaie rubrique = acompte.getRubrique();
					LigneBulletinPaie ligne = null;
					if (datacache.containsKey(rubrique.getCode())) {
						ligne = datacache.get(rubrique.getCode());
						ligne.setValeur(acompte.getMontant() + ligne.getValeur());
					} else {
						ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(), rubrique.getTauxpat());
						valeur = acompte.getMontant();
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
					} // end if(datacache.containsKey(rubrique.getCode())){

					chargepat += ligne.getTauxpat();
					if (rubrique.getType().equals("1")) {// Retenue
						chargeSal += ligne.getTauxsal();
					}
					if (rubrique.getType().equals("0")) {// Gain
						salbasebrut += ligne.getValeur();
					}
					if (!bulletin.getLignes().contains(ligne)) {
						bulletin.getLignes().add(ligne);
					} else {
						int index = bulletin.getLignes().indexOf(ligne);
						bulletin.getLignes().set(index, ligne);
					} // end if(!bulletin.getLignes().contains(ligne))
				} // end for(RemboursementAvance rem:eltvar.getAvances())
					// Remboursement Prèt
				for (RemboursementPret rem : eltvar.getPrets()) {
					RubriquePaie rubrique = rem.getPret().getRubrique();
					LigneBulletinPaie ligne = null;
					if (datacache.containsKey(rubrique.getCode())) {
						ligne = datacache.get(rubrique.getCode());
						ligne.setValeur(rem.getMontant() + ligne.getValeur());
					} else {
						ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(), rubrique.getTauxpat());
						// ligne = new
						// LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
						valeur = rem.getMontant();
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

					} // end if(datacache.containsKey(rubrique.getCode())){
					chargepat += ligne.getTauxpat();
					if (rubrique.getType().equals("1")) {// Retenue
						chargeSal += ligne.getTauxsal();
					}
					if (rubrique.getType().equals("0")) {// Gain
						salbasebrut += ligne.getValeur();
					}
					if (!bulletin.getLignes().contains(ligne)) {
						bulletin.getLignes().add(ligne);
					} else {
						int index = bulletin.getLignes().indexOf(ligne);
						bulletin.getLignes().set(index, ligne);
					} // end if(!bulletin.getLignes().contains(ligne))
				} // end for(RemboursementAvance rem:eltvar.getAvances())
					// Rappel Salaires container =
					// RestrictionsContainer.newInstance();

				container.addEq("salarie0", salarie);
				System.out.println("MoteurPaieManagerImpl.creationBulletinPaiePeriode() date "
						+ DateHelper.formatDate(entity.getPeriode().getDfin()));
				container.addGe("dfin", DateHelper.formatDate(entity.getPeriode().getDfin()));
				List<ElementVariable> eltsvariablesRappel = eltvariabledao.filter(container.getPredicats(), null, null,
						0, -1);

				if (eltsvariables != null && !eltsvariables.isEmpty() && eltsvariablesRappel.size() > 0) {
					ElementVariable eltvarrappel = eltsvariablesRappel.get(0);
					for (RappelSalaire rap : eltvarrappel.getRappels()) {
						for (LigneRappel lign : rap.getLignes()) {
							RubriquePaie rubrique = lign.getRubrique();
							LigneBulletinPaie ligne = null;
							if (datacache.containsKey(rubrique.getCode())) {
								ligne = datacache.get(rubrique.getCode());
								ligne.setValeur(lign.getMontant() + ligne.getValeur());
							} else {
								ligne = new LigneBulletinPaie(rubrique, 0.0, rubrique.getTauxsal(),
										rubrique.getTauxpat());
								// ligne = new
								// LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
								valeur = lign.getSolde();
								if (ligne.getRubrique().getTauxsal() != null && ligne.getRubrique().getTauxsal() != 0) {
									ts = valeur * ligne.getRubrique().getTauxsal() / 100;
								} // end
									// if(ligne.getRubrique().getTauxsal()!=null)
								if (ligne.getRubrique().getTauxpat() != null && ligne.getRubrique().getTauxpat() != 0) {
									tp = valeur * ligne.getRubrique().getTauxpat() / 100;
								} // end
									// if(ligne.getRubrique().getTauxpat()!=null){
								ligne.setValeur((valeur == null ? 0.0 : valeur));
								ligne.setTauxpat((tp == null ? 0.0 : tp));
								ligne.setTauxsal((ts == null ? 0.0 : ts));
								datacache.put(rubrique.getCode(), ligne);

							} // end
								// if(datacache.containsKey(rubrique.getCode())){
							chargepat += ligne.getTauxpat();
							if (rubrique.getType().equals("1")) {// Retenue
								chargeSal += ligne.getTauxsal();
							}
							if (rubrique.getType().equals("0")) {// Gain
								salbasebrut += ligne.getValeur();
							}
							if (!bulletin.getLignes().contains(ligne)) {
								bulletin.getLignes().add(ligne);
							} else {
								int index = bulletin.getLignes().indexOf(ligne);
								bulletin.getLignes().set(index, ligne);
							} // end if(!bulletin.getLignes().contains(ligne))
						} // end for(Rubrique rubrique:rap.getLignes()){
					}
				}
				// Traitement Acompte en cours

			} // end if(eltsvariables!=null&&!eltsvariables.isEmpty()){
			bulletin.setCongesAcquisPeriode((double) 0);
			bulletin.setCongesprisPeriode((double) 0);
			bulletin.setSalaireBrut(salbasebrut);
			bulletin.setChargePatronale(chargepat);
			bulletin.setChargeSalariale(chargeSal);
			bulletin.setNetapayer(bulletin.getSalaireBrut() - bulletin.getChargeSalariale());
			salarie.setSalaire(salbasebrut);
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

			if (bulletin.getId() > 0) {
				dao.update(bulletin.getId(), bulletin);
			} else {
				dao.save(bulletin);
				System.out.println(
						MoteurPaieManagerImpl.class.toString() + " ==================================== " + bulletin);
			} // end if(bulletin.getId()>0){
				// update salarié
			employdao.update(salarie.getId(), salarie);
		} // end for(ProfesseurChoice salarie : salaries){

		return null;

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
		if (salarie.getCategorie() == null) {
			return valeur;
		} // end if(salarie.getFonction()==null)
		for (ForfaitCategorie forfait : rubrique.getForfaitscat()) {
			if (forfait.getCategorie().compareTo(salarie.getCategorie()) == 0) {
				if (forfait.getMesure().equals("0")) {
					valeur = forfait.getValeur();
				} else {
					// get emargement période
					RestrictionsContainer container = RestrictionsContainer.newInstance();
					container.addEq("prof.id", salarie);
					container.addEq("periode.id", periode.getId());
					List<EmargementDtlPeriode> emarges = emargedao.filter(container.getPredicats(), null, null, 0, -1);
					if (emarges != null && !emarges.isEmpty()) {
						EmargementDtlPeriode emarge = emarges.get(0);
						valeur = emarge.getHeuretotal() * forfait.getValeur();
					}
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
		// if(salarie.getCategorie()==null){
		// return valeur;
		// }//end if(salarie.getFonction()==null)
		for (ForfaitPersonnel forfait : rubrique.getForfaitsperso()) {
			if (forfait.getPersonnel().getNom().compareTo(salarie.getNom()) == 0) {
				if (forfait.getMesure().equals("0")) {
					valeur = forfait.getValeur();
				} else {
					// get emargement période
					RestrictionsContainer container = RestrictionsContainer.newInstance();
					container.addEq("prof.id", salarie);
					container.addEq("periode.id", periode.getId());
					List<EmargementDtlPeriode> emarges = emargedao.filter(container.getPredicats(), null, null, 0, -1);
					if (emarges != null && !emarges.isEmpty()) {
						EmargementDtlPeriode emarge = emarges.get(0);
						valeur = emarge.getHeuretotal() * forfait.getValeur();
					}
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
	private Double evalFormule(RubriquePaie rubrique, Professeur salarie) {
		Double valeur = 0.0;

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
}
