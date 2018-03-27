/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.keren.model.employes.Poste;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_TRDE")
public class TraitementDE extends BaseElement implements Serializable, Comparable<TraitementDE> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8209695008370443980L;
	
	@ManyToOne
	@JoinColumn(name="DE_ID")
	@Predicate(label="Demande" ,type=DemandeExplication.class,target="many-to-one",optional=false,nullable=false,search=true)
	private DemandeExplication demande ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date avis" , type=Date.class,target="date",optional=false,nullable=false,search=true)
	private Date dateavis ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Supérieur" ,type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe superieur ;
	
	@ManyToOne
	@JoinColumn(name="POS_ID")
	@Predicate(label="Poste" ,type=Poste.class,target="many-to-one",optional=false,search=true)
	private Poste poste ;
	
	@Predicate(label="Sanction proposée",target="combobox",values="Classer;Avertissement;Lettre d'observation;Blâme;Mise à pied;Licenciement;Convoquer le conseil",search=true)
	private String sanction = "0";
	
	@Predicate(label="Motivation",target="textarea",group=true,groupName="group1",groupLabel="MOTIVATION")
    private String motivation;
	/**
	 * 
	 */
	public TraitementDE() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TraitementDE(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param demande
	 * @param dateavis
	 * @param superieur
	 * @param poste
	 * @param sanction
	 * @param motivation
	 */
	public TraitementDE(long id, String designation, String moduleName, DemandeExplication demande, Date dateavis,
			Employe superieur, Poste poste, String sanction, String motivation) {
		super(id, designation, moduleName);
		this.demande = demande;
		this.dateavis = dateavis;
		this.superieur = superieur;
		this.poste = poste;
		this.sanction = sanction;
		this.motivation = motivation;
	}

	public TraitementDE(TraitementDE trait) {
		super(trait.id, trait.designation, trait.moduleName);
		if(trait.demande!=null){
			this.demande = new DemandeExplication(trait.demande);
		}
		this.dateavis = trait.dateavis;
		if(trait.superieur!=null){
			this.superieur = new Employe(trait.superieur);
		}
		if(trait.poste!=null){
			this.poste = new Poste(trait.poste);
		}
		this.sanction = trait.sanction;
		this.motivation = trait.motivation;
	}
	
	

	public DemandeExplication getDemande() {
		return demande;
	}

	public void setDemande(DemandeExplication demande) {
		this.demande = demande;
	}

	public Date getDateavis() {
		return dateavis;
	}

	public void setDateavis(Date dateavis) {
		this.dateavis = dateavis;
	}

	public Employe getSuperieur() {
		return superieur;
	}

	public void setSuperieur(Employe superieur) {
		this.superieur = superieur;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "AVIS HIERARCHIE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "AVIS HIERARCHIE";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return demande.getDesignation();
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TraitementDE o) {
		// TODO Auto-generated method stub
		return demande.compareTo(o.demande);
	}

}
