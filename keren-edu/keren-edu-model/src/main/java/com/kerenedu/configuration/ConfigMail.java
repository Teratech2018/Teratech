/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Contacts;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.Nationalite;
import com.kerenedu.school.NiveauScolaire;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_cmail")
public class ConfigMail extends BaseElement implements Serializable, Comparable<ConfigMail> {
	
	
	@Column(name = "SERVEUR" ,unique=true)	
	@Predicate(label="SERVEUR",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String serveur;
	
	@Column(name = "EMAIL" ,unique=true)	
	@Predicate(label="EMAIL",optional=false,updatable=false,search=true , sequence=2, colsequence=2)
	protected String email;
	
	@Column(name = "PWORD" ,unique=true)	
	@Predicate(label="MOT DE PASSE",optional=false,updatable=false,search=true , sequence=3, colsequence=3)
	protected String pword;
	
	
	

	public String getServeur() {
		return serveur;
	}


	public void setServeur(String serveur) {
		this.serveur = serveur;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPword() {
		return pword;
	}


	public void setPword(String pword) {
		this.pword = pword;
	}


	public ConfigMail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConfigMail(ConfigMail filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.email = filiere.email;
		this.pword=filiere.pword;
		this.serveur=filiere.serveur;
		
	}


	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Configuration Mailer";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Configuration Mailer";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}




	public int compareTo(ConfigMail o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
