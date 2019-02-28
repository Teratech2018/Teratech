/**
 * 
 */
package com.kerenedu.inscription;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.model.report.ViewBadgeModal;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_inscription")
public class Inscription extends BaseElement implements Serializable, Comparable<Inscription> {


	@Column(name = "MATRICULE")
	@Predicate(label = "MATRICULE", optional = true, updatable = false, search = true, type = String.class, hide = true, colsequence = 1, searchfields = "eleve.matricule")
	protected String matricule;
	
	
	@Column(name = "NOM")
	@Predicate(label = "NOM", optional = true, updatable = false, search = true, type = String.class, hide = true, colsequence = 2, searchfields = "eleve.nom")
	protected String nom;
	
	@ManyToOne
	@JoinColumn(name = "SECTION_ID")
	@Predicate(label = "SECTION", type = SectionE.class, target = "many-to-one", optional = false, sequence = 1, observable = true, updatable=true)
	private SectionE section;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "CLASSE", updatable = true, type = Classe.class, target = "many-to-one", search = true, sequence = 2, observable = true, searchfields = "libelle", colsequence = 4)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	//@Filter(value = "[{\"fieldName\":\"section\",\"value\":\"section.id\"}]")
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "ELEVE", updatable = true, type = Eleve.class, target = "many-to-one", search = false, sequence = 3, searchfields = "matricule", colsequence = 3,optional = false)
	protected Eleve eleve;

	@Column(name = "STATUT")
	@Predicate(label = "STATUT ELEVE", optional = false, updatable = true, search = false, target = "combobox", values = "Redoublant(e);Non Redoublant(e)", sequence = 3)
	protected String satut = "0";

	@Column(name = "DATE_INS")
	@Predicate(label = "DATE INSCRIPTION", optional = false, updatable = true, search = true, type = Date.class, sequence = 4, target = "date", colsequence = 5)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datIns;

	@Column(name = "MNT")
	@Predicate(label = "SCOLARITE", optional = true, updatable = false, search = true, type = BigDecimal.class, sequence = 5, editable = false, colsequence = 6)
	protected Long zMnt;

	@Column(name = "MNT_PAYE")
	@Predicate(label = "PAYER", optional = true, updatable = false, search = true, type = BigDecimal.class, sequence = 7, editable = false, colsequence = 7)
	protected Long zMntPaye;

	@Column(name = "SOLDE")
	@Predicate(label = "SOLDE ", optional = true, updatable = false, search = true, type = BigDecimal.class, sequence = 8, colsequence = 8,editable = false)
	protected Long zSolde;

	@Column(name = "REMISE")
	@Predicate(label = "REMISE", optional = true, updatable = false, search = true, type = BigDecimal.class, sequence = 9, editable = false, colsequence = 9)
	protected Long zRemise;

	@Column(name = "RISTOURNE")
	@Predicate(label = "RISTOURNE", optional = true, updatable = false, search = false, type = BigDecimal.class, sequence = 10,editable = false)
	protected Long zRistourne;

	@Column(name = "TOTAL")
	@Predicate(label = "TOTAL Frais", optional = true, updatable = false, search = false, type = BigDecimal.class, hide = true, sequence = 9)
	protected Long zTotal;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FICHE_PAIE_ID")
	@Predicate(label = " ", updatable = true, type = FichePaiement.class, target = "one-to-many", search = true, sequence = 2,
	group = true, groupLabel = "Profil Financier élève", groupName = "tab1")
	@Observer(observable = "classe", source = "method:findserviceclasse")
	protected List<FichePaiement> service;
//
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "FICHE_PAIE_ID_OPT")
//	@Predicate(label = "Service Optionnel", updatable = true, type = FichePaiementOptionel.class, target = "one-to-many", search = true, sequence = 2, group = true, groupLabel = "Service élève"
//	, groupName = "tab1")
//	protected List<FichePaiementOptionel> serviceOpt;

	// @ManyToOne
	// @JoinColumn(name ="SERVICE_ID")
	// @Predicate(label = "Services",group = true,groupName = "tab1",groupLabel
	// = "Fras de Scolarité",target = "many-to-one",type = Service.class,search
	// = false)
	// private Service serviceList ;
	//

	@Column(name = "ANNEE_ID")
	protected String anneScolaire;

	@Column(name = "CYCLE_ID")
	protected long cycle;
	

	private String state = "crée";
	
	@Transient
	private byte[] photo ;
	
	
	@Transient
	private InputStream photostream ;

	//
	// public Service getServiceList() {
	// return serviceList;
	// }
	//
	//
	// public void setService(Service serviceList) {
	// this.serviceList = serviceList;
	// }

	public Inscription() {
		// TODO Auto-generated constructor stub
	}

	public Inscription(Inscription ins) {
		super(ins.id, ins.designation, ins.moduleName, ins.compareid);
		this.zMnt = ins.zMnt;
		if (ins.eleve != null) {
			this.eleve = new Eleve(ins.eleve);
			this.matricule=ins.eleve.getMatricule();
			this.nom=ins.eleve.getNom()+" "+ins.eleve.getPrenon();
		}

		this.zMnt = ins.zMnt;
		this.zMntPaye = ins.zMntPaye;
		this.zSolde = ins.zSolde;
		this.zRemise = ins.zRemise;
		this.zRistourne = ins.zRistourne;
		this.zTotal = ins.zTotal;
		if (ins.classe != null) {
			this.classe = new Classe(ins.classe);
			// this.cycle=ins.getClasse().getCycle();
			this.section = new SectionE(ins.getClasse().getSection());
		}
		this.datIns = ins.getDatIns();
		this.anneScolaire = ins.anneScolaire;
		this.service = new ArrayList<FichePaiement>();
		this.satut = ins.satut;
		this.state = ins.state;

		/*
		 * for(Service service:ins.serviceList){ serviceList.add(new
		 * Service(service)); }
		 */

	}
	
	public Inscription(ViewBadgeModal ins) {
		if (ins.getClasse() != null) {
			this.classe = new Classe(ins.getClasse());
			
		}
		if(ins.getCycle()!=null){
			this.cycle = ins.getCycle().getId();
		}
		if (ins.getSection() != null) {
			this.section = ins.getClasse().getSection();
		}
	}

	public Inscription(Eleve eleve, Classe classe, Inscription entity) {
		super(-1, null, null, 0L);
		this.eleve = new Eleve(eleve);
		this.classe = new Classe(classe);
		this.section = classe.getSection();
		this.datIns = entity.getDatIns();
		this.anneScolaire = entity.anneScolaire;
		this.service = new ArrayList<FichePaiement>();
//		this.serviceOpt = new ArrayList<FichePaiementOptionel>();
		this.satut = entity.satut;
		this.state = entity.state;

		/*
		 * for(Service service:ins.serviceList){ serviceList.add(new
		 * Service(service)); }
		 */

	}

	/**
	 * @return the zMnt
	 */
	public Long getzMnt() {

		return zMnt;
	}

	/**
	 * @param zMnt
	 *            the zMnt to set
	 */
	public void setzMnt(Long zMnt) {

		this.zMnt = zMnt;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Long getzMntPaye() {
		return zMntPaye;
	}

	public void setzMntPaye(Long zMntPaye) {
		this.zMntPaye = zMntPaye;
	}

	public Long getzSolde() {
		return zSolde;
	}

	public void setzSolde(Long zSolde) {
		this.zSolde = zSolde;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Inscriptions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves Inscrits";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}


	@Override
	public String getOwnermodule() {
		// TODO Auto-generated method stub
		return "scolarite";
	}


	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getNom() + " " + eleve.getPrenon()+"     ("+eleve.getAnciennte() +" ) Ancienneté(s)";
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public String getSatut() {
		return satut;
	}

	public InputStream getPhotostream() {
		return photostream;
	}

	public void setPhotostream(InputStream photostream) {
		this.photostream = photostream;
	}

	public List<FichePaiement> getService() {
		return service;
	}

	public void setService(List<FichePaiement> service) {
		this.service = service;
	}

	public Long getzRemise() {
		return zRemise;
	}

//	public List<FichePaiementOptionel> getServiceOpt() {
//		return serviceOpt;
//	}
//
//	public void setServiceOpt(List<FichePaiementOptionel> serviceOpt) {
//		this.serviceOpt = serviceOpt;
//	}

	public void setzRemise(Long zRemise) {
		this.zRemise = zRemise;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Long getzRistourne() {
		return zRistourne;
	}

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

	public Date getDatIns() {
		return datIns;
	}

	public void setDatIns(Date datIns) {
		this.datIns = datIns;
	}

	public void setzRistourne(Long zRistourne) {
		this.zRistourne = zRistourne;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setSatut(String satut) {
		this.satut = satut;
	}

	public Long getzTotal() {
		return zTotal;
	}

	public SectionE getSection() {
		return section;
	}

	public void setSection(SectionE section) {
		this.section = section;
	}

	public void setzTotal(Long zTotal) {
		this.zTotal = zTotal;
	}

//	@Override
//	public List<State> getStates() {
//		// TODO Auto-generated method stub
//		List<State> states = new ArrayList<State>();
//		State state = new State("crée", "Crée");
//		states.add(state);
//		return states;
//	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		this.searchkeys=matricule+", "+nom+","+classe.getLibelle()+" , " +zSolde+" , " +anneScolaire;
		return matricule+", "+nom+","+classe.getLibelle()+" , " +zSolde+" , " +anneScolaire;
	}
	

	public int compareTo(Inscription o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}

}
