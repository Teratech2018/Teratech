/**
 * 
 */
package com.keren.courrier.model.courrier;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.courrier.model.archivage.BoiteArchivage;
import com.keren.courrier.model.others.UtilisateurClone;
import com.keren.courrier.model.referentiel.ClasseurCourrier;
import com.keren.courrier.model.referentiel.CompartimentClasseur;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_TRACOGC")
public class TraitementCourrier extends BaseElement implements Serializable, Comparable<TraitementCourrier> {

	private static final long serialVersionUID = -12411984333486963L;

	private TypeTraitement type;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date doperation;

	@ManyToOne
	@JoinColumn(name = "OPER_ID")
	private UtilisateurCourrier operateur;

	@ManyToOne
	@JoinColumn(name = "CIBL_ID")
	private UtilisateurCourrier destinataire;

	@ManyToOne
	@JoinColumn(name = "OWSERV_ID")
	private StructureCompany sowner;

	@ManyToOne
	@JoinColumn(name = "SCIBLE_ID")
	private StructureCompany cible;

	@ManyToOne
	@JoinColumn(name = "BDR_ID")
	private BorderoCourrier bordero;
	
	@ManyToOne
	@JoinColumn(name = "COU_ID")
	private CourrierClone courrier ;

	@Lob
	private String avis;

	@ManyToOne
	@JoinColumn(name = "CLCO_ID")
	private ClasseurCourrier classeur;

	@ManyToOne
	@JoinColumn(name = "COCL_ID")
	private CompartimentClasseur compartiment;
	
	@ManyToOne
	@JoinColumn(name = "BOIARCH_ID")
	private BoiteArchivage boite;

	/**
	* 
	*/
	public TraitementCourrier() {
		// TODO Auto-generated constructor stub
	}

	public TraitementCourrier(TypeTraitement type, Date doperation, UtilisateurCourrier operateur,
			StructureCompany sowner, StructureCompany dsowner) {
		super();
		this.type = type;
		this.doperation = doperation;
		this.operateur = operateur;
		this.sowner = sowner;

	}

	/**
	 * 
	 * @param dep
	 */
	public TraitementCourrier(TraitementCourrier dep) {
		super(dep.id, dep.designation, dep.moduleName, dep.compareid);
		this.type = dep.type;
		this.doperation = dep.doperation;
		if (dep.operateur != null) {
			this.operateur = new UtilisateurCourrier(dep.operateur);
		}
		if (dep.sowner != null) {
			this.sowner = new StructureCompany(dep.sowner);
		}

		if (dep.cible != null) {
			this.cible = new StructureCompany(dep.cible);
		}

		if (dep.bordero != null) {
			this.bordero = new BorderoCourrier(dep.bordero);
		}
		this.avis = dep.avis;
		if (dep.classeur != null) {
			this.classeur = new ClasseurCourrier(dep.classeur);
		}
		if (dep.compartiment != null) {
			this.compartiment = new CompartimentClasseur(dep.compartiment);
		}
		if (dep.destinataire != null) {
			this.destinataire = new UtilisateurCourrier(dep.destinataire);
		}
		if(dep.courrier!=null){
			this.courrier= new CourrierClone(dep.courrier);
		}
		
		if(dep.boite!=null){
			this.boite= new BoiteArchivage(dep.boite);
		}
		
	}

	/**
	 * 
	 * @param dep
	 */
	public TraitementCourrier(CourrierDepart courrier, TypeTraitement type) {
		super(-1, null, null, 0L);
		this.type = type;
		this.doperation = courrier.getDcourrier();
		this.operateur = new UtilisateurCourrier(courrier.getSource());
		if (courrier.getSowner() != null) {
			this.sowner = new StructureCompany(courrier.getSowner());
		}
		if (courrier.getBordero() != null) {
			this.bordero = new BorderoCourrier(courrier.getBordero());
		}

	}
	
	public TraitementCourrier(CourrierAArchiver courrier, TypeTraitement type) {
		super(-1, null, null, 0L);
		this.type = type;
		this.doperation = courrier.getDcourrier();
		this.operateur = new UtilisateurCourrier(courrier.getSource());
		if (courrier.getSowner() != null) {
			this.sowner = new StructureCompany(courrier.getSowner());
		}
		if (courrier.getBordero() != null) {
			this.bordero = new BorderoCourrier(courrier.getBordero());
		}

	}


	/**
	 * 
	 * @param dep
	 */
	public TraitementCourrier(CourrierClone courrier, TypeTraitement type) {
		super(-1, null, null, 0L);
		this.type = type;
		this.doperation = courrier.getDcourrier();
		this.operateur = new UtilisateurCourrier(courrier.getSource());
		if (courrier.getSowner() != null) {
			this.sowner = new StructureCompany(courrier.getSowner());
		}
		if (courrier.getBordero() != null) {
			this.bordero = new BorderoCourrier(courrier.getBordero());
		}
		if(courrier!=null)
		this.courrier=new CourrierClone(courrier);

	}

	

	public TypeTraitement getType() {
		return type;
	}

	public void setType(TypeTraitement type) {
		this.type = type;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public UtilisateurCourrier getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(UtilisateurCourrier destinataire) {
		this.destinataire = destinataire;
	}

	public Date getDoperation() {
		return doperation;
	}

	public void setDoperation(Date doperation) {
		this.doperation = doperation;
	}

	public UtilisateurCourrier getOperateur() {
		return operateur;
	}

	public void setOperateur(UtilisateurCourrier operateur) {
		this.operateur = operateur;
	}

	public StructureCompany getSowner() {
		return sowner;
	}

	public StructureCompany getCible() {
		return cible;
	}

	public void setCible(StructureCompany cible) {
		this.cible = cible;
	}

	public void setSowner(StructureCompany sowner) {
		this.sowner = sowner;
	}

	public BorderoCourrier getBordero() {
		return bordero;
	}

	public void setBordero(BorderoCourrier bordero) {
		this.bordero = bordero;
	}

	public ClasseurCourrier getClasseur() {
		return classeur;
	}

	public void setClasseur(ClasseurCourrier classeur) {
		this.classeur = classeur;
	}

	public CompartimentClasseur getCompartiment() {
		return compartiment;
	}

	public CourrierClone getCourrier() {
		return courrier;
	}

	public void setCourrier(CourrierClone courrier) {
		this.courrier = courrier;
	}

	public void setCompartiment(CompartimentClasseur compartiment) {
		this.compartiment = compartiment;
	}

	public BoiteArchivage getBoite() {
		return boite;
	}

	public void setBoite(BoiteArchivage boite) {
		this.boite = boite;
	}

	@Override
	public int compareTo(TraitementCourrier o) {
		// To change body of generated methods, choose Tools | Templates.
		return Long.valueOf(id).compareTo(Long.valueOf(o.id));
	}

}
