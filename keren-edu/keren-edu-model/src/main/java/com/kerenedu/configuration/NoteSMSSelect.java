/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Contacts;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.Nationalite;
import com.kerenedu.school.NiveauScolaire;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
//@Table
//@Entity(name = "e_sms")
public class NoteSMSSelect extends BaseElement implements Serializable, Comparable<NoteSMSSelect> {
	

	@Column(name = "CONCERNES")
	@Predicate(label="Personne Concerné : ",optional=false,updatable=true,search=false, target="combobox", values="les classes suivantes ?;les étudiants suivants ?;Tous les elèves ?" , sequence=1)
	protected String concerne="0";
	
	@Column(name = "NUMERO_ETD" )	
	protected String numero ;
	
	@Column(name = "NUMERO_PERE" )	
	protected String numeroPere ;
	
	@Column(name = "NUMERO_MERE" )
	protected String numeroMere ;
	
	@Transient
	@ManyToOne 
    @JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "CLASSE",target = "many-to-one",type = Classe.class,search =false  , sequence=5, colsequence=5 , observable=true,
			hidden="temporalData.concerne=='0'",hide=true)
	private Classe classe ;
	
	@Transient
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELEVE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "ETUDIANT CONCERNES",target = "many-to-many-list",type = Inscription.class,search = false,
			hidden="temporalData.concerne=='0'")
	private List<Inscription> eleveList = new ArrayList<Inscription>();
	
	@Transient
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLS_ID")
	@Predicate(group = true,groupName = "tab2",groupLabel = "CLASSE CONCERNES",target = "many-to-many-list",type = Classe.class,search = false)
	private List<Classe> classeList = new ArrayList<Classe>();
	
	



	public NoteSMSSelect() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NoteSMSSelect(NoteSMSSelect filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.eleveList= new ArrayList<Inscription>();
		this.classeList= new ArrayList<Classe>();
		this.concerne= filiere.concerne;
		if(filiere.classe!=null){
		this.classe= new Classe(filiere.classe);
		}
		this.numero= filiere.numero;
		this.numeroPere= filiere.numeroPere;
		this.numeroMere= filiere.numeroMere;
	
	}
	
	public NoteSMSSelect(NoteSMSSelect filiere, Eleve eleve) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.concerne= filiere.concerne;
		this.numero= eleve.getTelephone();
		this.numeroPere=eleve.getTelPere();
		this.numeroMere= eleve.getTelMere();
		this.eleveList= filiere.getEleveList();
		this.classeList= filiere.getClasseList();
	}


	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Notification Par SMS";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Notification Par SMS";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Notification Par SMS"+id;
	}




	public List<Inscription> getEleveList() {
		return eleveList;
	}


	public void setEleveList(List<Inscription> eleveList) {
		this.eleveList = eleveList;
	}


	public String getConcerne() {
		return concerne;
	}


	public void setConcerne(String concerne) {
		this.concerne = concerne;
	}




	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public List<Classe> getClasseList() {
		return classeList;
	}


	public void setClasseList(List<Classe> classeList) {
		this.classeList = classeList;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNumeroPere() {
		return numeroPere;
	}


	public void setNumeroPere(String numeroPere) {
		this.numeroPere = numeroPere;
	}


	public String getNumeroMere() {
		return numeroMere;
	}


	public void setNumeroMere(String numeroMere) {
		this.numeroMere = numeroMere;
	}


	public int compareTo(NoteSMSSelect o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
