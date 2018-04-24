/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Contacts;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_annee")
public class AnneScolaire extends BaseElement implements Serializable, Comparable<AnneScolaire> {
	
	@Column(name = "CODE")	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "D_DEBUT" )	
	@Predicate(label="DEBUT",optional=false,updatable=true,search=true, target="date", sequence=3, type=Date.class, colsequence=2)
	protected String ddeb;
	
	@Column(name = "D_FIN" )	
	@Predicate(label="FIN",optional=false,updatable=true,search=true , target="date", sequence=4, type=Date.class, colsequence=3)
	protected String dfin;
	
	@Column(name = "CONNECTED" )	
	@Predicate(label="EXERCICE COURANT",optional=false,updatable=true,search=true , target="checkbox", sequence=2, type=Boolean.class, colsequence=4)
	protected Boolean connected = false;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ANNEE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Période Scolaire",target = "one-to-many",type = PeriodeScolaire.class,search = false)
	private List<PeriodeScolaire> periodeScoalire = new ArrayList<PeriodeScolaire>() ;
	
	


	public AnneScolaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AnneScolaire(String code, String ddeb, String dfin, Boolean connected,
			List<PeriodeScolaire> periodeScoalire) {
		super();
		this.code = code;
		this.ddeb = ddeb;
		this.dfin = dfin;
		this.connected = connected;
		this.periodeScoalire = periodeScoalire;
	}


	public AnneScolaire(AnneScolaire annee) {
		super(annee.id, annee.designation, annee.moduleName);
		this.code = annee.code;
		this.ddeb = annee.ddeb;
		this.dfin = annee.dfin;
		this.connected=annee.connected;
		this.periodeScoalire= new ArrayList<PeriodeScolaire>();
//		for(PeriodeScolaire periode:annee.periodeScoalire){
//			periodeScoalire.add(new PeriodeScolaire(periode));
//	    }
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDdeb() {
		return ddeb;
	}

	public void setDdeb(String ddeb) {
		this.ddeb = ddeb;
	}

	public String getDfin() {
		return dfin;
	}

	public void setDfin(String dfin) {
		this.dfin = dfin;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Année Scolaire";
	}

	/**
	 * @return the periodeScoalire
	 */
	public List<PeriodeScolaire> getPeriodeScoalire() {
		return periodeScoalire;
	}


	/**
	 * @param periodeScoalire the periodeScoalire to set
	 */
	public void setPeriodeScoalire(List<PeriodeScolaire> periodeScoalire) {
		this.periodeScoalire = periodeScoalire;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Année Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return ddeb+"-"+dfin;
	}


	/**
	 * @return the connected
	 */
	public Boolean getConnected() {
		return connected;
	}


	/**
	 * @param connected the connected to set
	 */
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}


	public int compareTo(AnneScolaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
