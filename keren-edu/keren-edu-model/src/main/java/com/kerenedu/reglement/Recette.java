/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_p_paie")
public class Recette extends BaseElement implements Serializable, Comparable<Recette> {
	
	
	@ManyToOne
	@JoinColumn(name = "ElEVE_ID")
	@Predicate(label = "Elève", type = Inscription.class, target = "many-to-one", optional = false, search = true, sequence = 1, observable = true, colsequence = 2, searchfields = "eleve.nom",updatable=false)
	private Inscription eleve;
	
	@ManyToOne
	@JoinColumn(name = "F_ID")
	 @Predicate(label = "SERVICE", updatable = false, type =FichePaiement.class, optional = true, target = "many-to-one", sequence =5, observable = true, colsequence = 2, editable=false)
	@Filter(value = "[{\"fieldName\":\"service.type\",\"value\":\"autres\"}]")
	protected FichePaiement service;

	@Column(name = "Code")
	@Predicate(label="Num Pièce",optional=false,updatable=true,search=false , sequence=2)
	protected String code ;	
	
	
	@Column(name = "DATE_ENC")
	@Predicate(label="Date",optional=false,updatable=true,search=true, type=Date.class,sequence=3, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datEnc;
	
	@Column(name = "TYP_PAI")
	@Predicate(label="Type Paiement",optional=false,updatable=false,search=true, target="combobox", values="especes;Espress Union" , sequence=4 )
	protected String typePaiment="0";

	@Column(name = "ZMNT_VERSER")
	@Predicate(label = "Versement ", optional = true, updatable = false, search = true, type = Long.class, sequence = 5, colsequence = 5)
	protected Long zMntverser;
	
	@Transient
	private String username;

	@Column(name = "ZMNT")
	@Predicate(label = " Montant Attendu", optional = false, updatable = false, search = false, type = Long.class, sequence = 6, editable = false)
	@Observer(observable = "eleve", source = "field:zMnt")
	protected Long zMnt;

	
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public Recette() {
		super();
	}


	

	public Recette(Inscription eleve, FichePaiement service, String code, Date datEnc, String typePaiment,
			Long zMntverser, String username, Long zMnt, String anneScolaire) {
		super();
		this.eleve = eleve;
		this.service = service;
		this.code = code;
		this.datEnc = datEnc;
		this.typePaiment = typePaiment;
		this.zMntverser = zMntverser;
		this.username = username;
		this.zMnt = zMnt;
		this.anneScolaire = anneScolaire;
	}


	public Recette(Recette entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.eleve = new Inscription(entity.eleve);
		this.service = new FichePaiement(entity.service);
		this.code = entity.code;
		this.datEnc = entity.datEnc;
		this.typePaiment = entity.typePaiment;
		this.zMntverser =entity.zMntverser;
		this.username = entity.username;
		this.zMnt = entity.zMnt;
		this.anneScolaire = entity.anneScolaire;
	}




	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Recette o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des  Recettes ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Recettes  ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return eleve.getDesignation();
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	/**
	 * @return the datEnc
	 */
	public Date getDatEnc() {
		return datEnc;
	}


	/**
	 * @param datEnc the datEnc to set
	 */
	public void setDatEnc(Date datEnc) {
		this.datEnc = datEnc;
	}





	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}



	public String getTypePaiment() {
		return typePaiment;
	}


	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}



	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}



	public String getCode() {
		return code;
	}


	public Inscription getEleve() {
		return eleve;
	}






	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}






	public FichePaiement getService() {
		return service;
	}






	public void setService(FichePaiement service) {
		this.service = service;
	}






	public Long getzMntverser() {
		return zMntverser;
	}






	public void setzMntverser(Long zMntverser) {
		this.zMntverser = zMntverser;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public Long getzMnt() {
		return zMnt;
	}






	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}






	public void setCode(String code) {
		this.code = code;
	}


	
	

}
