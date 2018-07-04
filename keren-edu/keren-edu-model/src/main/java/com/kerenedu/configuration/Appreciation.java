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
	
	
	@Column(name = "APP",unique=true )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2)
	protected String libelle;
	
	@Column(name = "I_DEB" )	
	@Predicate(label="MIN.",optional=false,updatable=true,search=true , sequence=4, type=Long.class)
	protected Long deb;
	
	@Column(name = "I_FIN" )	
	@Predicate(label="MAX.",optional=false,updatable=true,search=true , sequence=3, type=Long.class)
	protected Long fin;


	public Appreciation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Appreciation(String code, String libelle, Long min, Long max) {
		super();
		this.libelle = libelle;
		this.deb = min;
		this.fin = max;
	}
	
	public Appreciation(Appreciation app) {
		super();
		this.libelle = app.libelle;
		this.deb = app.deb;
		this.fin = app.fin;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public Long getDeb() {
		return deb;
	}



	public void setDeb(Long deb) {
		this.deb = deb;
	}



	public Long getFin() {
		return fin;
	}



	public void setFin(Long fin) {
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


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	public int compareTo(Appreciation o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
