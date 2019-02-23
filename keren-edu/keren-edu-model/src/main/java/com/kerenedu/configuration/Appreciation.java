/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_app")
public class Appreciation extends BaseElement implements Serializable, Comparable<Appreciation> {
	
		
	@Column(name = "I_DEB" )	
	@Predicate(label="MIN.",optional=false,updatable=true,search=true , sequence=1, type=Double.class)
	protected Double deb=(double) 0;
	
	@Column(name = "I_FIN" )	
	@Predicate(label="MAX.",optional=false,updatable=true,search=true , sequence=2, type=Double.class)
	protected Double fin=(double) 0;
	
	@Column(name = "APP")	
	@Predicate(label="Appreciation Travial",optional=false,updatable=true,search=true , sequence=3)
	protected String libelle;
	
	
	@Column(name = "APP_EN")	
	@Predicate(label="Appreciation Anglais",optional=false,updatable=true,search=true , sequence=4)
	protected String libelleen;
	
	@Column(name = "SANCTION" )	
	@Predicate(label="Sanction Travail",optional=true,updatable=true,search=true , sequence=5)
	protected String sanction;
	
	@Column(name = "SANCTION_EN" )	
	@Predicate(label="Sanction Anglais",optional=true,updatable=true,search=true , sequence=6)
	protected String sanctionen;
	
	@Column(name = "MOYENNE" )	
	@Predicate(label="Sanction Moyenne",optional=true,updatable=true,search=true , sequence=7)
	protected String appreciationMoy;
	
	@Column(name = "MOYENNE_EN" )	
	@Predicate(label="Sanction Moyenne Anglais",optional=true,updatable=true,search=true , sequence=8)
	protected String appreciationMoyen;
	
	
	


	public Appreciation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Appreciation(String code, String libelle, Double min, Double max) {
		super();
		this.libelle = libelle;
		this.deb = min;
		this.fin = max;
	}
	
	public Appreciation(Appreciation app) {
		super(app.id, app.designation, app.moduleName,app.compareid);
		this.libelle = app.libelle;
		this.deb = app.deb;
		this.fin = app.fin;
		this.sanction=app.sanction;
		this.appreciationMoy=app.appreciationMoy;
		
		this.libelleen = app.libelleen;
		this.sanctionen=app.sanctionen;
		this.appreciationMoyen=app.appreciationMoyen;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public Double getDeb() {
		return deb;
	}



	public void setDeb(Double deb) {
		this.deb = deb;
	}



	public Double getFin() {
		return fin;
	}



	public void setFin(Double fin) {
		this.fin = fin;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Configuration des notations";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Configuration des notations";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
	}


	public String getSanction() {
		return sanction;
	}



	public void setSanction(String sanction) {
		this.sanction = sanction;
	}



	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getAppreciationMoy() {
		return appreciationMoy;
	}



	public String getLibelleen() {
		return libelleen;
	}



	public void setLibelleen(String libelleen) {
		this.libelleen = libelleen;
	}



	public String getSanctionen() {
		return sanctionen;
	}



	public void setSanctionen(String sanctionen) {
		this.sanctionen = sanctionen;
	}



	public String getAppreciationMoyen() {
		return appreciationMoyen;
	}



	public void setAppreciationMoyen(String appreciationMoyen) {
		this.appreciationMoyen = appreciationMoyen;
	}



	public void setAppreciationMoy(String appreciationMoy) {
		this.appreciationMoy = appreciationMoy;
	}



	public int compareTo(Appreciation o) {
		// TODO Auto-generated method stub
		return (int) o.getId();
	}

}
