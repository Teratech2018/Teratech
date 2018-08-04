/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_RELGC")
public class RelanceAction extends BaseElement implements Serializable, Comparable<RelanceAction> {

	@ManyToOne
	@JoinColumn(name = "COU_ID")
	@Predicate(label = "Courrier à Relancer", type = CourrierClone.class, optional = false, target = "many-to-one", search = true, editable = false)
	private CourrierClone courrier;

	@ManyToOne
	@JoinColumn(name = "QUOT_ID")
	@Predicate(label = "Quoteur", type = UtilisateurCourrier.class, optional = true, target = "many-to-one", search = true, editable = false)
	private UtilisateurCourrier quoteur;

	@ManyToOne
	@JoinColumn(name = "SQUOT_ID")
	@Predicate(label = "Service Du Quoteur", type = StructureCompany.class, target = "many-to-one", editable = false)
	@Observer(observable = "quoteur", source = "field:service")
	private StructureCompany service;

	@ManyToOne
	@JoinColumn(name = "SDEST_ID")
	@Predicate(label = "Service Quoté", type = StructureCompany.class, target = "many-to-one", search = true, editable = false)
	private StructureCompany squote;

	@Predicate(label = "Date", type = Date.class, target = "date", optional = false, search = true, editable = false)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date doldlimite;

	@Predicate(label = "nouvelle Date butoir", type = Date.class, optional = false, target = "date", search = true)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date limite;

	@ManyToOne
	@JoinColumn(name = "DEST_ID")
	@Predicate(label = "Quoté", type = UtilisateurCourrier.class, target = "many-to-one", search = true, editable = false)
	private UtilisateurCourrier quote;

	@Lob
	@Predicate(label = "Instruction", target = "textarea", optional = false, group = true, groupName = "group1", groupLabel = "")
	private String note;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "REL_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
	
	@Transient
	private CourrierInterne courrierinterne;

	// @OneToMany
	// @Predicate(label = "",type = LigneDiffusion.class,target =
	// "one-to-many",group = true,groupName = "group2",groupLabel =
	// "Diffusions",search = true)
	// private List<LigneDiffusion> intervenants = new
	// ArrayList<LigneDiffusion>();
	// @OneToMany
	// @Predicate(label ="",type = DetailQuotation.class,target =
	// "one-to-many",group = true,groupName = "group1",groupLabel =
	// "Informations sur la Quotation")
	// private List<DetailQuotation> lignes = new ArrayList<DetailQuotation>();

	public RelanceAction() {
	}

	/**
	 * 
	 * @param entity
	 */
	public RelanceAction(RelanceAction entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		if (entity.courrier != null) {
			this.courrier = new CourrierClone(entity.courrier);
		}
		this.doldlimite = entity.doldlimite;
		if (entity.quoteur != null) {
			this.quoteur = new UtilisateurCourrier(entity.quoteur);
		}
		if (entity.service != null) {
			this.service = new StructureCompany(entity.service);
		}
		if (entity.squote != null) {
			this.squote = new StructureCompany(entity.squote);
		}
		this.limite = entity.limite;
		if (entity.quote != null) {
			this.quote = new UtilisateurCourrier(entity.quote);
		}
		this.note = entity.note;
		this.piecesjointes= new ArrayList<FichierLie>();
	}

	public CourrierClone getCourrier() {
		return courrier;
	}

	public void setCourrier(CourrierClone courrier) {
		this.courrier = courrier;
	}

	public UtilisateurCourrier getQuoteur() {
		return quoteur;
	}

	public void setQuoteur(UtilisateurCourrier quoteur) {
		this.quoteur = quoteur;
	}


	public StructureCompany getService() {
		return service;
	}

	public void setService(StructureCompany service) {
		this.service = service;
	}

	public StructureCompany getSquote() {
		return squote;
	}

	public void setSquote(StructureCompany squote) {
		this.squote = squote;
	}

	public Date getDoldlimite() {
		return doldlimite;
	}

	public void setDoldlimite(Date doldlimite) {
		this.doldlimite = doldlimite;
	}

	public Date getLimite() {
		return limite;
	}

	public void setLimite(Date limite) {
		this.limite = limite;
	}

	public UtilisateurCourrier getQuote() {
		return quote;
	}

	public void setQuote(UtilisateurCourrier quote) {
		this.quote = quote;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String getModuleName() {
		return "kerencourrier"; // To change body of generated methods, choose
								// Tools | Templates.
	}

	@Override
	public String getEditTitle() {
		return "Relance du Courrier"; // To change body of generated methods,
										// choose Tools | Templates.
	}

	@Override
	public String getDesignation() {
		return courrier.getDesignation(); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public String getListTitle() {
		return "Relance du Courrier"; // To change body of generated methods, choose Tools |
							// Templates.
	}

	public List<FichierLie> getPiecesjointes() {
		return piecesjointes;
	}

	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}

	public CourrierInterne getCourrierinterne() {
		return courrierinterne;
	}

	public void setCourrierinterne(CourrierInterne courrierinterne) {
		this.courrierinterne = courrierinterne;
	}

	@Override
	public int compareTo(RelanceAction o) {
		return 0; // To change body of generated methods, choose Tools |
					// Templates.
	}

}
