
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.CycleDAOLocal;
import com.kerenedu.configuration.EventEdu;
import com.kerenedu.configuration.EventEduDAOLocal;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.FiliereDAOLocal;
import com.kerenedu.configuration.RappelE;
import com.kerenedu.configuration.RappelEDAOLocal;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.configuration.SectionEDAOLocal;
import com.kerenedu.configuration.Service;
import com.kerenedu.configuration.ServiceDAOLocal;
import com.kerenedu.configuration.ServiceFilliere;
import com.kerenedu.configuration.UserEducation;
import com.kerenedu.configuration.UserEducationDAOLocal;
import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.FichePaiementDAOLocal;
import com.kerenedu.reglement.Moratoire;
import com.kerenedu.reglement.MoratoireDAOLocal;
import com.kerenedu.reglement.PaiementDAOLocal;
import com.kerenedu.reglement.ReglementDAOLocal;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.EleveDAOLocal;
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
	
	@EJB(name = "filiereDAO")
	protected FiliereDAOLocal filieredao;

	@EJB(name = "SectionEDAO")
	protected SectionEDAOLocal sectiondao;


	@EJB(name = "EventEduDAO")
	protected EventEduDAOLocal eventdao;
	
	@EJB(name = "UserEducationDAO")
	protected UserEducationDAOLocal userdao;
	
	@EJB(name = "RappelEDAO")
	protected RappelEDAOLocal rappeldao;
	
	@EJB(name = "FichePaiementDAO")
	protected FichePaiementDAOLocal fichedao;
	
	@EJB(name = "ServiceDAO")
	protected ServiceDAOLocal servicedao;
	
	@EJB(name = "PaiementDAO")
	protected PaiementDAOLocal paiementdao;
	
	@EJB(name = "ReglementDAO")
	protected ReglementDAOLocal rgldao;
	
	@EJB(name = "EleveDAO")
	protected EleveDAOLocal elevedao;
	
	@EJB(name = "MoratoireDAO")
	protected MoratoireDAOLocal moratoiredao;
	
	@EJB(name = "CycleDAO")
	protected CycleDAOLocal cycledao;

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
		
		List<Inscription> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
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
//		for (FichePaiementOptionel serv : elev.getServiceOpt()) {
//			inscrip.getServiceOpt().add(new FichePaiementOptionel(serv));
//		}
		return inscrip;
	}

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
//   		if (CacheMemory.getClasse() != null) {
//   			container.addEq("classe.id",  CacheMemory.getClasse().getId());
//   		}
   		List<Inscription> datas = super.findAll();// filter(container.getPredicats(), null, null, 0, -1);
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
//		// set annescolaire courante

		long apayer = (long) 0;
		long aremise = (long) 0;
		long aristourne = (long) 0;
		long atotal = (long) 0;
		for (FichePaiement fiche : entity.getService()) {
			apayer = apayer + fiche.getZtotal();
			aremise = aremise + fiche.getZremise();
			aristourne = aristourne + fiche.getZristourne();
			fiche.setMatricule(entity.getEleve().getMatricule());
			fiche.setAnneScolaire(entity.getAnneScolaire());
			
		
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
		entity.setMatricule(entity.getEleve().getMatricule());
		entity.setNom(entity.getEleve().getNom()+""+entity.getEleve().getPrenon());
		//entity.setStatus(false);
		Eleve eleve = elevedao.findByPrimaryKey("id", entity.getEleve().getId());
		if(eleve.getDatefirst()==null){
			eleve.setDatefirst(entity.getDatIns());;
		}
		if (eleve.getDatefirst() != null) {
			eleve.setAnciennte(Double.parseDouble(
					"" + DateHelper.numberOfyear(eleve.getDatefirst() , entity.getDatIns())));
		} // end if(contrat!=null){
		elevedao.update(eleve.getId(), eleve);
		
		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(Inscription entity) {
		// mettre a jour le nbre d'elève de la classe concerné
		Long effectifactuel ;
		Long effectif ;
		Classe cls = entity.getClasse();
		Filiere filiere = cls.getFiliere();
		SectionE sect= filiere.getSection();
		 effectifactuel = cls.getEffectif();
		 effectif = effectifactuel + new Long(1);
		cls.setEffectif(effectif);
		if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("1")){
			cls.setEfffille(cls.getEfffille()+ new Long(1));
		}
		if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("0")){
			cls.setEffGarcon(cls.getEffGarcon()+ new Long(1));
		}
		classedao.update(cls.getId(), cls);
		
		//filiere
		 effectifactuel = filiere.getCapacite();
		 effectif = effectifactuel + new Long(1);
		 filiere.setCapacite(effectif);
		 if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("1")){
			 filiere.setEfffille(filiere.getEfffille()+ new Long(1));
			}
			if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("0")){
				filiere.setEffGarcon(filiere.getEffGarcon()+ new Long(1));
			}
		filieredao.update(filiere.getId(), filiere);
		
		//section
		 effectifactuel = sect.getCapacite();
		 effectif = effectifactuel + new Long(1);
		 sect.setCapacite(effectif);
		 if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("1")){
			 sect.setEfffille(sect.getEfffille()+ new Long(1));
			}
			if(entity.getEleve().getSexe()!=null&&entity.getEleve().getSexe().equals("0")){
				sect.setEffGarcon(sect.getEffGarcon()+ new Long(1));
			}
		sectiondao.update(sect.getId(), sect);
		
		entity.setState("crée");
		Eleve eleve = elevedao.findByPrimaryKey("id", entity.getEleve().getId());
		if(eleve.getDatefirst()==null){
			eleve.setDatefirst(entity.getDatIns());;
		}
		eleve.setInscrit(true);
		elevedao.update(eleve.getId(), eleve);
		// generate allerte happybirthDay
		if(CacheMemory.getCurrentSchool()!=null&&CacheMemory.getCurrentSchool().getAllerteanniveleve()&&entity.getDatIns()!=null){
			this.createEventHappyBirtDay(entity);
		}
		entity.setMatricule(entity.getEleve().getMatricule());
		entity.setNom(entity.getEleve().getNom()+""+entity.getEleve().getPrenon());
	
		dao.update(entity.getId(), entity);
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
		Inscription old = dao.findByPrimaryKey("id", entity.getId());
		
		if(samefiliere(old, entity)==false){
			long apayer = (long) 0;
			long aremise = (long) 0;
			long aristourne = (long) 0;
			long atotal = (long) 0;
			// delete moratoire
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("eleve.id", entity.getId());
			List<Moratoire>moratoires = new ArrayList<Moratoire>();
			moratoires = moratoiredao.filter(container.getPredicats(), null, null, 0, -1);
			if(moratoires!=null){
				for(Moratoire m : moratoires){
					moratoiredao.delete(m.getId());
				}
			}
			for (FichePaiement fiche : entity.getService()) {
				apayer = apayer + fiche.getZtotal();
				aremise = aremise + fiche.getZremise();
				aristourne = aristourne + fiche.getZristourne();
				fiche.setMatricule(entity.getEleve().getMatricule());
				fiche.setAnneScolaire(entity.getAnneScolaire());
			}
			atotal = apayer - aremise - aristourne;
			// Initialiser les montants a zero
			entity.setzMnt(atotal);
			entity.setzTotal(atotal);
			entity.setzMntPaye((long) 0);
			entity.setzSolde(atotal);
			entity.setzRemise((long) 0);
			entity.setzRistourne((long) 0);
			Cycle cycle = cycledao.findByPrimaryKey("id", entity.getClasse().getCycle());
			entity.setCycle(cycle.getId());
		}
		entity.setMatricule(entity.getEleve().getMatricule());
		entity.setNom(entity.getEleve().getNom()+""+entity.getEleve().getPrenon());
		Eleve eleve = elevedao.findByPrimaryKey("id", entity.getEleve().getId());
		if(eleve.getDatefirst()==null){
			eleve.setDatefirst(entity.getDatIns());;
		}
		if (eleve.getDatefirst() != null) {
			eleve.setAnciennte(Double.parseDouble(
					"" + DateHelper.numberOfyear(eleve.getDatefirst() , entity.getDatIns())));
		} // end if(contrat!=null){
		elevedao.update(eleve.getId(), eleve);
//		if(entity.getzSolde()==0){
//			entity.setStatus(true);
//		}
	
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
//		if(CacheMemory.getCurrentSchool()!=null&&CacheMemory.getCurrentSchool().getAllerteanniveleve()&&entity.getDatIns()!=null){
//			System.out.println("InscriptionManagerImpl.processBeforeUpdate() create anniv aller");
//			this.createEventHappyBirtDay(entity);
//		}
		super.processBeforeUpdate(entity);
	}
	
	public boolean samefiliere(Inscription old, Inscription nouveau){
		boolean value = false;
		//System.out.println("InscriptionRSImpl.samefiliere() old classe"+old.getClasse().getLibelle());
		//System.out.println("InscriptionRSImpl.samefiliere() nouveau classe"+nouveau.getClasse().getLibelle());
		if(old.getClasse().getFiliere().getId()==nouveau.getClasse().getFiliere().getId()){
			value=true;
		}else{
			value = false;
		}
		return value ;
	}

	@Override
	public List<Inscription> getCriteres(EleveSearch critere) {

		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			if (critere.getMatricule() != null) {
				container.addEq("eleve.matricule", critere.getMatricule());
			}
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
	
	@Override
	public List<Inscription> getCriteres(Inscription critere) {

		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {
			if (critere.getAnneScolaire() != null) {
				container.addEq("anneScolaire", critere.getAnneScolaire());
			}
			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}
			
			if (critere.getCycle() != 0&&critere.getClasse()==null) {
				container.addEq("classe.cycle", critere.getCycle());
			}
			
			if (critere.getSection() != null) {
				container.addEq("classe.section.id", critere.getSection().getId());
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

	@Override
	public Inscription changerClasse(ChangeClasse entity) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		Inscription incription = dao.findByPrimaryKey("id", entity.getIdIns());
		Inscription old = incription;
		List<FichePaiement> fiches= incription.getService();
		dao.deleteRadfiche(incription);
		System.out.println("InscriptionManagerImpl.changerClasse() delete fiche and paiement sucess !!!");
		// relement
		dao.deleteRadReglement(incription);
		System.out.println("InscriptionManagerImpl.changerClasse() delete sucess !!!");
		dao.delete(incription.getId());
	
		System.out.println("InscriptionManagerImpl.changerClasse() delete inscription  sucess !!!");
		
		// new service
		Inscription newincrt = new Inscription(incription.getEleve(),entity.getNewclasse(),incription);
		List<FichePaiement> newFiche = this.findfiche(entity.getClasse().getId());
		newincrt.setService(newFiche);
		dao.delete(incription.getId());
		System.out.println("InscriptionManagerImpl.changerClasse() je suis ici !!!");
		newincrt = dao.save(newincrt);
		Inscription i = dao.findByPrimaryKey("id", newincrt.getId());
		System.out.println("InscriptionManagerImpl.changerClasse() fichier service is "+ i.getService().size());
		// mis a jour montant fiche 
		ChangerWorker worker = buildWorker( i);
		if(old.getzSolde()==0){
			worker.setMontant(newincrt.getzMnt());
		}else{
			worker.setMontant(old.getzMntPaye());
		}
		
		worker.compute();
		dao.update(newincrt.getId() , newincrt);
		return newincrt;
	}
	
	private ChangerWorker buildWorker(Inscription insc) {
		Map<Integer, FichePaiement> map = new HashMap<Integer, FichePaiement>();
		for (FichePaiement fiche : insc.getService()) {
			if(fiche.getService().getExige()==true){
				map.put(fiche.getService().getRang(), fiche);
			}
			
		}
		List<Integer> keys = new ArrayList<Integer>();
		for (int key : map.keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);
		int plage = keys.size() - 1;
		ChangerWorker work0 = null;
		int key = plage;
		while (key >= 0) {
			if (key == plage) {
				work0 = new ChangerWorker(map.get(keys.get(key)), insc, null);
				System.out.println("PaiementManagerImpl.buildWorker() key valuer 0" + keys.get(key));
				System.out.println(
						"PaiementManagerImpl.buildWorker() map valuer 0" + map.get(keys.get(key)) + "map " + map);
			} else {
				ChangerWorker work = new ChangerWorker(map.get(keys.get(key)), insc, work0);
				work0 = work;
			} // end if(key==plage-1){
			key = key - 1;
		} // end for(int key=plage;key>=0;key--){
		return work0;
	}
	
	public List<FichePaiement>getFicheEleve(Inscription entity){
		List<FichePaiement>datas = new ArrayList<FichePaiement>();
		Inscription ins = find("id", entity.getId());
		for(FichePaiement fiche : ins.getService()){
			if(fiche.getPayer().equals("0")){
				datas.add(fiche);
			}
		}
		Collections.sort(datas);
		return datas ;
	}
	
	
	public List<FichePaiement> findfiche(long id) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Service> result = new ArrayList<Service>();
		List<FichePaiement>datas = new ArrayList<FichePaiement>();
		if (id > 0) {
			container = RestrictionsContainer.newInstance();
			container.addEq("id",id);
			Classe classe = classedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			//container.addEq("filiere.id",classe.getFiliere().getId());
			 result = servicedao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 
		if(result!=null&!result.isEmpty()){
			for(Service serice : result){
				for(ServiceFilliere filliere : serice.getFiliere()){
					if(filliere.getFiliere().getId()==classe.getFiliere().getId()){
						FichePaiement fiche = new FichePaiement(serice,filliere);
						fiche.setId(-1);
						fiche.setAnneScolaire(CacheMemory.getCurrentannee());
						datas.add(fiche);
					}
				}
				
			}
		}
		}
		return datas;
	}
	class ChangerWorker {
		private FichePaiement tranche;

		private Inscription inscription;

		private ChangerWorker next;

		private Long montant;

		/**
		 * 
		 * @param tranche
		 * @param inscription
		 */

		public ChangerWorker(FichePaiement tranche, Inscription inscription, ChangerWorker next) {
			super();
			this.tranche = tranche;
			this.inscription = inscription;
			this.next = next;
		}

		public ChangerWorker getNext() {
			return next;
		}

		public void setNext(ChangerWorker next) {
			this.next = next;
		}

		public Long getMontant() {
			return montant;
		}

		public void setMontant(Long montant) {
			this.montant = montant;
		}

		public FichePaiement getTranche() {
			return tranche;
		}

		public void setTranche(FichePaiement tranche) {
			this.tranche = tranche;
		}

		public Inscription getInscription() {
			return inscription;
		}

		public void setInscription(Inscription inscription) {
			this.inscription = inscription;
		}

		public ChangerWorker inversecompute() {
			
			if (tranche.getMntpayer() > 0) {
				System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis ici "+montant);
				if (montant >= tranche.getMntpayer()) { // montant>>
					long reste = montant - tranche.getMntpayer();
					System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis ici +++++"+montant);
					tranche.subtractMontant(tranche.getMntpayer());
					tranche.setPayer(Boolean.FALSE);
					if (next == null) {
						return this;
					} else {
						System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis reste "+reste);
						next.setMontant(reste);
						return next.inversecompute();
					}
				} else {
					if (montant >0 && montant < tranche.getMntpayer()) {
						tranche.subtractMontant(montant);
						tranche.setPayer(Boolean.FALSE);
						return this;
					} else {
						return this;
					}
				}
			} else {
				if (next == null) {
					return this;
				} else {
					System.out.println("PaiementManagerImpl.PaiementWorker.inversecompute() je suis reste "+montant);
					next.setMontant(montant);
					return next.inversecompute();
				}
			}
		}

		/**
		 * 
		 * @return
		 */
		public ChangerWorker compute() {
			if (tranche.getSolde() == 0) {// Solde
				if (next == null)
					return this;
				else {
					next.setMontant(montant);
					return next.compute();
				}
			} else {// solde>0
				if (tranche.getSolde() > montant) {
					tranche.addMontant(montant);
					return this;
				} else {
					long reste = montant - tranche.getSolde();
					tranche.addMontant(tranche.getSolde());
					tranche.setAnneScolaire(inscription.getAnneScolaire());
					tranche.setPayer(Boolean.TRUE);
					if (next == null)
						return this;
					else {
						next.setMontant(reste);
						return next.compute();
					}
				} // end if(tranche.getSolde()>montant){
			}
		}
	}

}
