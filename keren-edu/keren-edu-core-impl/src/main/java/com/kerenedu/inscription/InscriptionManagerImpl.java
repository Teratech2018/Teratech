
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.configuration.EventEdu;
import com.kerenedu.configuration.EventEduDAOLocal;
import com.kerenedu.configuration.RappelE;
import com.kerenedu.configuration.RappelEDAOLocal;
import com.kerenedu.configuration.UserEducation;
import com.kerenedu.configuration.UserEducationDAOLocal;
import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.reglement.FichePaiement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "InscriptionManager")
public class InscriptionManagerImpl extends AbstractGenericManager<Inscription, Long>
		implements InscriptionManagerLocal, InscriptionManagerRemote {

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal dao;

	@EJB(name = "AnneScolaireDAO")
	protected AnneScolaireDAOLocal annedao;

	@EJB(name = "ClasseDAO")
	protected ClasseDAOLocal classedao;

	@EJB(name = "EventEduDAO")
	protected EventEduDAOLocal eventdao;
	
	@EJB(name = "UserEducationDAO")
	protected UserEducationDAOLocal userdao;
	
	@EJB(name = "RappelEDAO")
	protected RappelEDAOLocal rappeldao;

	public InscriptionManagerImpl() {
	}

	@Override
	public GenericDAO<Inscription, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Inscription> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
   		if (CacheMemory.getClasse() != null) {
   			container.addEq("classe.id",  CacheMemory.getClasse().getId());
   		}

		List<Inscription> datas = super.filter(container.getPredicats(), orders, properties, firstResult, maxResult);
		List<Inscription> result = new ArrayList<Inscription>();
		for (Inscription elev : datas) {
			result.add(new Inscription(elev));
		}
		return result;
	}

	@Override
	public Inscription find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Inscription elev = super.find(propertyName, entityID);
		CacheMemory.setIncription(elev);
		Inscription inscrip = new Inscription(elev);
		for (FichePaiement serv : elev.getService()) {
			inscrip.getService().add(new FichePaiement(serv));
		}
		return inscrip;
	}

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
   		if (CacheMemory.getClasse() != null) {
   			container.addEq("classe.id",  CacheMemory.getClasse().getId());
   		}
   		List<Inscription> datas = super.filter(container.getPredicats(), null, null, 0, -1);
		List<Inscription> result = new ArrayList<Inscription>();
		for (Inscription elev : datas) {
			result.add(new Inscription(elev));
		}
		return result;
	}

	@Override
	public Inscription delete(Long id) {
		// TODO Auto-generated method stub
		Inscription elev = super.delete(id);
		return new Inscription(elev);
	}

	@Override
	public void processBeforeSave(Inscription entity) {
		System.out.println("InscriptionManagerImpl.processBeforeSave() je suis ici ");
		// set annescolaire courante
		// Creation des journaux de saisie
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0, -1);
		if (annee == null || annee.size() == 0) {
			throw new KerenExecption("Aucune Année Scolaire disponible !!!");
		}
		entity.setAnneScolaire(CacheMemory.getCurrentannee());
		// verifier si l'étudiant a déjà été inscit
		container = RestrictionsContainer.newInstance();
		container.addEq("eleve.matricule", entity.getEleve().getMatricule());
		container.addEq("anneScolaire", entity.getAnneScolaire());
		List<Inscription> inscit = dao.filter(container.getPredicats(), null, null, 0, -1);
		if ((inscit != null && inscit.size() != 0)) {
			throw new KerenExecption("Eléve déjà Inscrit !!!");
		}
		long apayer = (long) 0;
		long aremise = (long) 0;
		long aristourne = (long) 0;
		long atotal = (long) 0;
		for (FichePaiement fiche : entity.getService()) {
			apayer = apayer + fiche.getZtotal();
			aremise = aremise + fiche.getZremise();
			aristourne = aristourne + fiche.getZristourne();
		}
		atotal = apayer - aremise - aristourne;
		// Initialiser les montants a zero
		entity.setzMnt(atotal);
		entity.setzTotal(atotal);
		entity.setzMntPaye((long) 0);
		entity.setzSolde(atotal);
		entity.setzRemise((long) 0);
		entity.setzRistourne((long) 0);
		entity.setCycle(entity.getClasse().getFiliere().getCycle().getId());
		// System.out.println("InscriptionManagerImpl.processBeforeSave()"+inscit.get(0).getEleve().getMatricule());

		// montant total à payer
		// BigDecimal total = BigDecimal.ZERO;
		// if(entity.getServiceList()!=null){
		// for(Service service : entity.getServiceList()){
		// total= total.add(service.getzMnt());
		// }
		// entity.setzMnt(entity.getServiceList().getzMnt());
		// }

		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(Inscription entity) {
		// mettre a jour le nbre d'elève de la classe concerné
		Classe cls = entity.getClasse();
		Long effectifactuel = cls.getEffectif();
		Long effectif = effectifactuel + new Long(1);
		cls.setEffectif(effectif);
		classedao.update(cls.getId(), cls);

		// generate allerte happybirthDay
		if(CacheMemory.getCurrentSchool()!=null&&CacheMemory.getCurrentSchool().isAllerteanniveleve()){
			this.createEventHappyBirtDay(entity);
		}
		
		super.processAfterSave(entity);
	}

	public void createEventHappyBirtDay(Inscription entity) {
		EventEdu evt = new EventEdu();
		evt.setId(-1);
		evt.setTitle(" Mr/Mlle " + entity.getEleve().getNom() + "  Elève en classe de "
				+ entity.getClasse().getLibelle() + " Aura 1 an de plus le  " +DateHelper.getdateAnniversaire(entity.getEleve().getDateNais()));
		evt.setDescription(" Joyeux Anniversaire   " + entity.getEleve().getNom() +  "   "  + entity.getEleve().getPrenon());
		evt.setStart(DateHelper.getdateAnniversaire(entity.getEleve().getDateNais(), 3));
		evt.setEnd(DateHelper.getdateAnniversaire(entity.getEleve().getDateNais(), 0));
		evt.setDuree("01:00");
		evt.setRecurrent(false);
		evt.setConfidentialite((short) 0);
		evt.setDisponibilite((short) 0);
		evt.setLieu("Yaoundé");
		evt.setAllDay(true);
		UserEducation user = userdao.findByPrimaryKey("id", CacheMemory.getCurrentuser());
		evt.setOwner(user);
		evt.getParticipants().add(user);
		evt.setNotify(false);
		RappelE rappel = rappeldao.findByPrimaryKey("id", (long)1);
		evt.setRappel(rappel);
		eventdao.save(evt);

	}

	@Override
	public void processBeforeUpdate(Inscription entity) {
		// verifier si l'étudiant a déjà été inscit
		/*
		 * Inscription inscit =
		 * dao.getInscriptionEtudiantByAnnee(entity.getEleve(),
		 * entity.getAnneScolaire()); if(inscit!=null){ RuntimeException excep =
		 * new RuntimeException("Eléve déjà Inscrit !!!"); throw new
		 * WebApplicationException(excep,Response.Status.NOT_MODIFIED); }
		 */
		// generate allerte happybirthDay
		//System.out.println("InscriptionManagerImpl.processBeforeUpdate() create anniv aller"+CacheMemory.getCurrentSchool().isAllerteanniveleve());
	//	if(CacheMemory.getCurrentSchool()!=null&&CacheMemory.getCurrentSchool().isAllerteanniveleve()){
			System.out.println("InscriptionManagerImpl.processBeforeUpdate() create anniv aller");
			this.createEventHappyBirtDay(entity);
		//}
		super.processBeforeUpdate(entity);
	}

	@Override
	public List<Inscription> getCriteres(EleveSearch critere) {

		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			if (critere.getMatricule() != null) {
				container.addEq("eleve.matricule", critere.getMatricule());
			}

		}
		List<Inscription> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<Inscription> result = new ArrayList<Inscription>();
		for (Inscription ins : datas) {
			Inscription inscription = new Inscription(ins);
			result.add(inscription);
		}
		return result;
	}

}
