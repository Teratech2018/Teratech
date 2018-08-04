/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_p_paie")
public class Paiement extends BaseElement implements Serializable, Comparable<Paiement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "ElEVE_ID")
	@Predicate(label = "Elève", type = Inscription.class, target = "many-to-one", optional = false, search = true, sequence = 1, observable = true, colsequence = 2, searchfields = "eleve.matricule")
	private Inscription eleve;
	
	@Column(name = "NAT_PAI")
	@Predicate(label = "Mode Paiement", optional = false, updatable = false, search = false, target = "combobox", values = "Totalité;Partiel", sequence = 2, observable=true
			, hidden = "currentObject.eleve==null")
	protected String modePaiement = "0";
	

	@Column(name = "TYP_PAI")
	@Predicate(label = "Type Paiement", optional = false, updatable = false, search = false, target = "combobox", values = "especes;Espress Union", sequence = 3)
	protected String typePaiment = "0";

	@Column(name = "CODE", unique = true)
	private String code;

	@ManyToOne
	@JoinColumn(name = "F_ID")
	@Predicate(label = "SERVICE", updatable = false, type = FichePaiement.class, optional = true, target = "many-to-one", sequence = 5, observable = true, colsequence = 2, editable=false)
	protected FichePaiement service ;

	@Column(name = "DATE_PAI")
	@Predicate(label = "DATE PAIEMENT", optional = false, updatable = false, search = true, type = Date.class, sequence = 4, target = "date", colsequence = 4)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();

	@Column(name = "ZMNT_VERSER")
	@Predicate(label = "Versement ", optional = false, updatable = false, search = true, type = Long.class, sequence = 7, colsequence = 5)
	@Observer(observable = "modePaiement", source = "method:versement", parameters = "modePaiement,eleve")
	protected Long zMntverser;

	@Transient
	private String username;

	@Column(name = "ZMNT")
	@Predicate(label = " Montant Scolarité", optional = false, updatable = false, search = false, type = Long.class, sequence = 8, editable = false)
	@Observer(observable = "eleve", source = "field:zMnt")
	protected Long zMnt;
	
	@Transient
	@Predicate(label = " Montant Service", optional = true, updatable = false, search = false, type = Long.class, sequence = 11, editable = false,
			hidden = "currentObject.modePaiement==null||currentObject.modePaiement==0")
	@Observer(observable = "service", source = "field:ztotal")
	protected Long zMntservice;

	@Transient
	@Column(name = "ZSOLDE")
	@Predicate(label = "Reste Scolarité", search = false, type = Long.class, sequence = 10, editable = false)
	@Observer(observable = "eleve", source = "field:zSolde")
	protected Long zsolde;

	@Column(name = "ZREMISE")
	@Predicate(label = "Remise", optional = true, updatable = true, search = false, sequence = 9, type = Long.class, editable = true, hidden = "currentObject.modePaiement==null||currentObject.modePaiement==1")
	@Observer(observable = "modePaiement", source = "method:reduction", parameters = "modePaiement,eleve")
	protected Long zremise;

	@Transient
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "REMISE_ID")
	@Predicate(updatable = true, type = Remise.class, target = "many-to-many-list", search = true, hidden = "currentObject.modePaiement==null||currentObject.modePaiement==1", sequence = 2, group = true, groupLabel = "Attribution des Remises", groupName = "tab1")
	@Observer(observable = "modePaiement", source = "method:getremise", parameters = "modePaiement,eleve,datePaiement")
	protected List<Remise> listremise;

	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;

	private String state = "etabli";

	
	
	public Paiement(String modePaiement, Inscription eleve, String typePaiment, String code, FichePaiement service,
			Date datePaiement, Long zMntverser, List<Paiement> listPaiement, String username, Long zMnt, Long zsolde,
			Long zremise, List<Remise> listremise, Long totalapayer, Long totalpayer, String anneScolaire,
			String state) {
		super();
		this.modePaiement = modePaiement;
		this.eleve = eleve;
		this.typePaiment = typePaiment;
		this.code = code;
		this.service = service;
		this.datePaiement = datePaiement;
		this.zMntverser = zMntverser;
		this.username = username;
		this.zMnt = zMnt;
		this.zsolde = zsolde;
		this.zremise = zremise;
		this.listremise = listremise;
		this.anneScolaire = anneScolaire;
		this.state = state;
	}

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paiement(Paiement ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		this.datePaiement = ins.datePaiement;
		this.zMnt = ins.zMnt;
		this.zMntverser = ins.zMntverser;
		this.typePaiment = ins.typePaiment;
		if (ins.getService() != null) {
			this.service = new FichePaiement(ins.service);
			this.zMntservice = ins.service.getZtotal();
		}
		this.zremise=ins.zremise;
		this.zsolde = (ins.zMnt - ins.zMntverser-ins.getZremise());
		this.state = ins.state;
		this.modePaiement = ins.modePaiement;
		if (ins.getEleve() != null) {
			this.eleve = new Inscription(ins.getEleve());
		}

		this.code = ins.code;
		this.anneScolaire = ins.anneScolaire;
		this.username = ins.username;
		this.state = ins.state;
	
		this.listremise = new ArrayList<Remise>();

	}
	
	public Paiement(FichePaiement ins, Paiement p) {
		this.datePaiement = p.datePaiement;
		this.zMnt = ins.getSolde();
		this.typePaiment = p.typePaiment;
		this.service = ins;
		this.zsolde =(long) 0;
		this.state ="etabli";
		this.eleve = new Inscription(p.getEleve());
		this.modePaiement = p.modePaiement;
		this.anneScolaire = ins.anneScolaire;
		this.zremise= p.getZremise();
		this.zMntverser=p.getzMntverser();

	}

	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Paiement o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "p";
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypePaiment() {
		return typePaiment;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public FichePaiement getService() {
		return service;
	}

	public String getModePaiement() {
		return modePaiement;
	}



	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public void setService(FichePaiement service) {
		this.service = service;
	}

	public Long getzMnt() {
		return zMnt;
	}

	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}


	public Long getzMntverser() {
		return zMntverser;
	}

	public void setzMntverser(Long zMntverser) {
		this.zMntverser = zMntverser;
	}

	public Long getZsolde() {
		return zsolde;
	}

	public Long getzMntservice() {
		return zMntservice;
	}

	public void setzMntservice(Long zMntservice) {
		this.zMntservice = zMntservice;
	}

	public void setZsolde(Long zsolde) {
		this.zsolde = zsolde;
	}


	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public List<Remise> getListremise() {
		return listremise;
	}

	public void setListremise(List<Remise> listremise) {
		this.listremise = listremise;
	}

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getZremise() {
		return zremise;
	}

	public void setZremise(Long zremise) {
		this.zremise = zremise;
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Validé");
		states.add(state);
		state = new State("annuler", "Annulé");
		states.add(state);

		return states;
	}


}
