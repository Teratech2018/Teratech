/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.keren.model.structures.TypeDemande;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEEXRH")
public class DemandeExplication extends BaseElement implements Serializable, Comparable<DemandeExplication> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021374204191064777L;
	
	@Predicate(label="Référence",optional=false,nullable=false,search=true)
	private String reference ;
	
        @ManyToOne
	@JoinColumn(name="AUT_ID")
	@Predicate(label="Auteur",type=Employe.class,target="many-to-one",optional=false,nullable=false,search=true)
	private Employe auteur ;
        
	@ManyToOne
	@JoinColumn(name="DES_ID")
	@Predicate(label="Employé concerné",type=Employe.class,target="many-to-one",optional=false,nullable=false,search=true)
	private Employe destinataire ;
	
	@ManyToOne
	@JoinColumn(name="TYDE_ID")
	@Predicate(label="Type de demande",type=TypeDemande.class,target="many-to-one",search=true)
	private TypeDemande type ;
	
	@Predicate(label="Date de notification",type=Date.class,target="date",search=true,optional=false)
	@Temporal(TemporalType.DATE)
	private Date daten ;
	
	@Predicate(label="Date de décharge",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date dated;
	
	@OneToOne(mappedBy="demande")
	@Predicate(label="Sanction",type=Sanction.class,target="many-to-one",group=true,groupName="group4",groupLabel="Sanction",editable=false)
	private Sanction sanction ;
	
	@OneToOne(mappedBy="demande")
	private LigneResolution resolution ;
	
	@Predicate(target="textarea",group=true,groupName="group1",groupLabel="Motif")
	@Lob
	private String motif ;
	
	@OneToMany(mappedBy="demande",fetch=FetchType.LAZY)
	@Predicate(label="Reponses",type=ReponseDE.class,target="one-to-many",editable=false,updatable=false,group=true,groupName="group2",groupLabel="Réponses")
	private List<ReponseDE> reponses = new ArrayList<ReponseDE>();
	
	@OneToMany(mappedBy="demande",fetch=FetchType.LAZY)
	@Predicate(label="Avis de la hierachie",type=TraitementDE.class,target="one-to-many",editable=false,updatable=false,group=true,groupName="group3",groupLabel="Avis de la hierachie")
	private List<TraitementDE> traitements = new ArrayList<TraitementDE>();
	
	private String state ="etabli";

	/**
	 * 
	 */
	public DemandeExplication() {
		// TODO Auto-generated constructor stub
		state ="etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeExplication(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
		state ="etabli";
	}
	
	
    /**
     * 
     * @param id
     * @param designation
     * @param moduleName
     * @param auteur
     * @param reference
     * @param destinataire
     * @param type
     * @param daten
     * @param dated
     * @param motif
     */
	public DemandeExplication(long id, String designation, String moduleName, Employe auteur, String reference,
			Employe destinataire, TypeDemande type, Date daten, Date dated, String motif) {
		super(id, designation, moduleName);
		this.auteur = auteur;
		this.reference = reference;
		this.destinataire = destinataire;
		this.type = type;
		this.daten = daten;
		this.dated = dated;
		this.motif = motif;
		state ="etabli";
	}
	
	/**
	 * 
	 * @param dmde
	 */
	public DemandeExplication(DemandeExplication dmde) {
		super(dmde.id, dmde.designation, dmde.moduleName);
		if(dmde.auteur!=null){
			this.auteur = new Employe(dmde.auteur);
		}
		this.reference = dmde.reference;
		if(dmde.destinataire!=null){
			this.destinataire = new Employe(dmde.destinataire);
		}

		this.type = dmde.type;
		this.daten = dmde.daten;
		this.dated = dmde.dated;
		this.motif = dmde.motif;
		this.state =dmde.state;

	}
	
	

	public Employe getAuteur() {
		return auteur;
	}

	public void setAuteur(Employe auteur) {
		this.auteur = auteur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Employe getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Employe destinataire) {
		this.destinataire = destinataire;
	}

	public TypeDemande getType() {
		return type;
	}

	public void setType(TypeDemande type) {
		this.type = type;
	}

	public Date getDaten() {
		return daten;
	}

	public void setDaten(Date daten) {
		this.daten = daten;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}	
	

	public LigneResolution getResolution() {
		return resolution;
	}

	public void setResolution(LigneResolution resolution) {
		this.resolution = resolution;
	}

	public Sanction getSanction() {
		return sanction;
	}

	public void setSanction(Sanction sanction) {
		this.sanction = sanction;
	}

	public List<TraitementDE> getTraitements() {
		return traitements;
	}

	public void setTraitements(List<TraitementDE> traitements) {
		this.traitements = traitements;
	}

	public List<ReponseDE> getReponses() {
		return reponses;
	}

	public void setReponses(List<ReponseDE> reponses) {
		this.reponses = reponses;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "DEMANDE D'EXPLICATION";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "DEMANDES D'EXPLICATION";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return reference;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}
	
	

	

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}	
	

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State etat = new State("etabli", "Etabli");
		states.add(etat);
		etat = new State("reponse", "Reponse recue");
		states.add(etat);
		etat = new State("encours", "En cours");
		states.add(etat);
		etat = new State("traite", "Traité");
		states.add(etat);
		return states;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DemandeExplication o) {
		// TODO Auto-generated method stub
		return reference.compareTo(o.reference);
	}

}
