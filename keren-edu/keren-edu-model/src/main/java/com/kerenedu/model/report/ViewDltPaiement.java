/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.NetworkInterface;
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.reglement.Remise;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_p_paie")
public class ViewDltPaiement extends BaseElement implements Serializable, Comparable<ViewDltPaiement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "ElEVE_ID")
	@Predicate(label = "Elève", type = Inscription.class, target = "many-to-one", optional = false, search = true, sequence = 1, observable = true, colsequence = 2, searchfields = "eleve.nom")
	private Inscription eleve;
	
	
	@Column(name = "NAT_PAI")
	@Predicate(label = "Mode Paiement", optional = false, updatable = false, search = false, target = "combobox", values = "Totalité;Partiel", sequence = 2, observable = true, hidden = "currentObject.eleve==null")
	protected String modePaiement = "0";
	
	
	@Column(name = "TYP_PAI")
	@Predicate(label = "Type Paiement", optional = false, updatable = false, search = false, target = "combobox", values = "especes;Espress Union", sequence = 3)
	protected String typePaiment = "0";
	
	
	@Column(name = "CODE", unique = true)
	private String code;
	
	@Column(name = "DATE_PAI")
	@Predicate(label = "DATE PAIEMENT", optional = true, updatable = false, search = true, type = Date.class, sequence = 4, target = "date", colsequence = 4)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();
	
	@Column(name = "ZMNT_VERSER")
	@Predicate(label = "Versement ", optional = true, updatable = false, search = true, type = Long.class, sequence = 5, colsequence = 6, hidden = "currentObject.modePaiement==0")
	@Observer(observable = "modePaiement", source = "method:versement", parameters = "modePaiement,eleve")
	protected Long zMntverser;

	@Transient
	@Column(name = "ZMNT")
	@Predicate(label = " Montant Scolarité", optional = false, updatable = false, search = false, type = Long.class, sequence = 6, editable = false ,colsequence = 5)
	@Observer(observable = "eleve", source = "field:zMnt")
	protected Long zMnt;


	@Transient
	@Column(name = "ZSOLDE")
	@Predicate(label = " Solde ", search = true, type = Long.class, sequence = 7, editable = false,colsequence = 9)
	@Observer(observable = "eleve", source = "field:zSolde")
	protected Long zsolde;

	@Column(name = "ZREMISE")
	@Predicate(label = "Remise", optional = true, updatable = true, search = true, sequence = 8, type = Long.class, editable = false, 
	hidden = "currentObject.modePaiement==null||currentObject.modePaiement==1" ,colsequence = 7)
	@Observer(observable = "modePaiement", source = "method:reduction", parameters = "modePaiement,eleve")
	protected Long zremise;

	@Column(name = "ZRISTOURNE")
	@Predicate(label = "Ristourne", optional = true, updatable = true, search = true, sequence = 9, type = Long.class,
			hidden = "currentObject.modePaiement==null||currentObject.modePaiement==0",colsequence = 8)
	protected Long zristourne;

	@Transient
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "REMISE_ID")
	@Predicate(updatable = true, type = Remise.class, target = "many-to-many-list", search = true, hidden = "currentObject.modePaiement==null||currentObject.modePaiement==1", sequence = 2, group = true, groupLabel = "Attribution des Remises", groupName = "tab1")
	@Observer(observable = "modePaiement", source = "method:getremise", parameters = "modePaiement,eleve,datePaiement")
	protected List<Remise> listremise;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	@Transient
	@Column(name = "CYCLE")
	protected long cycle;

	private String state = "etabli";


	public ViewDltPaiement(Inscription eleve, String modePaiement, String typePaiment, String code,
			FichePaiement service, Date datePaiement, Long zMntverser, Long zMntversertotal, String username, Long zMnt,
			Long zMntservice, Long zsolde, Long zremise, Long zristourne, List<Remise> listremise, String anneScolaire,
			long cycle) {
		super();
		this.eleve = eleve;
		this.modePaiement = modePaiement;
		this.typePaiment = typePaiment;
		this.code = code;
		this.datePaiement = datePaiement;
		this.zMntverser = zMntverser;
		this.zMnt = zMnt;
		this.zsolde = zsolde;
		this.zremise = zremise;
		this.zristourne = zristourne;
		this.listremise = listremise;
		this.anneScolaire = anneScolaire;
		this.cycle = cycle;
		
	}

	public ViewDltPaiement() {
		// TODO Auto-generated constructor stub
	}

	public ViewDltPaiement(ViewDltPaiement ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		this.eleve = new Inscription(ins.eleve) ;
		this.modePaiement = ins.modePaiement;
		this.typePaiment = ins.typePaiment;
		this.code = ins.code;
		this.datePaiement = ins.datePaiement;
		this.zMntverser = ins.zMntverser;
		this.zMnt = ins.zMnt;
		this.zsolde = ins.zsolde;
		this.zremise = ins.zremise;
		this.zristourne = ins.zristourne;
		this.anneScolaire =ins.anneScolaire;
		this.cycle = ins.cycle;
		this.state=ins.state;
		this.zsolde= ins.eleve.getzSolde();
		

	}
	
	public ViewDltPaiement(Paiement ins) {
		this.eleve = new Inscription(ins.getEleve()) ;
		this.modePaiement = ins.getModePaiement();
		this.typePaiment = ins.getTypePaiment();
		this.code = ins.getCode();
		this.datePaiement = ins.getDatePaiement();
		this.zMntverser = ins.getzMntverser();
		this.zMnt = ins.getzMnt();
		this.zsolde = ins.getZsolde();
		this.zremise = ins.getZremise();
		this.zristourne = ins.getZristourne();
		this.anneScolaire =ins.getAnneScolaire();
		this.cycle = ins.getEleve().getCycle();
		this.state=ins.getState();
		this.zsolde= ins.getZsolde();

	}




	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewDltPaiement o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Journal des Paiements";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Journal des Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return " Journal des Paiements";
	}


	//
	@Override
	public boolean isCreateonfield() {
		return true;
	}


	@Override
	public boolean isDesablecreate() {
		return true;
	}


	@Override
	public boolean isDesableupdate() {
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		return true;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}



	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getTypePaiment() {
		return typePaiment;
	}

	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Long getzMntverser() {
		return zMntverser;
	}

	public void setzMntverser(Long zMntverser) {
		this.zMntverser = zMntverser;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getzMnt() {
		return zMnt;
	}

	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}

	
	public Long getZsolde() {
		return zsolde;
	}

	public void setZsolde(Long zsolde) {
		this.zsolde = zsolde;
	}

	public Long getZremise() {
		return zremise;
	}

	public void setZremise(Long zremise) {
		this.zremise = zremise;
	}

	public Long getZristourne() {
		return zristourne;
	}

	public void setZristourne(Long zristourne) {
		this.zristourne = zristourne;
	}

	public List<Remise> getListremise() {
		return listremise;
	}

	public void setListremise(List<Remise> listremise) {
		this.listremise = listremise;
	}

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

}
