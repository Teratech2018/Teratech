/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIRE")
public class LigneResolution extends BaseElement implements Serializable,Comparable<LigneResolution>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1478087362649689592L;
	
	@ManyToOne
	@JoinColumn(name="DE_ID")
	@Predicate(label="Demande",type=DemandeExplication.class,target="many-to-one",search=true,optional=false,nullable=false)
	private DemandeExplication demande ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Concerné",type=Employe.class,target="many-to-one",search=true,editable=false,updatable=false)
	private Employe concerne;
	
	@ManyToOne
	@JoinColumn(name="SAN_ID")
	@Predicate(label="Sanction",type=Sanction.class,target="many-to-one",search=true,editable=false,updatable=false)
	private Sanction sanction ;
	
	@Predicate(label="Recommendation",target="textarea",group=true,groupName="group1",groupLabel="RECOMMENDATION")
	private String recommendation ;	
	

	/**
	 * 
	 */
	public LigneResolution() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param demande
	 * @param recommendation
	 */
	public LigneResolution(long id, String designation, String moduleName, DemandeExplication demande,
			String recommendation) {
		super(id, designation, moduleName);
		this.demande = demande;
		this.recommendation = recommendation;
	}


	public LigneResolution(LigneResolution lign) {
		super(lign.id, lign.designation, lign.moduleName);
		if(lign.demande!=null){
			this.demande = new DemandeExplication(lign.demande);
	    }
		if(lign.concerne!=null){
			this.concerne = new Employe(lign.concerne);
		}
		if(lign.sanction!=null){
			this.sanction = new Sanction(lign.sanction);
		}
		this.recommendation = lign.recommendation;
	}
	
	

	public DemandeExplication getDemande() {
		return demande;
	}



	public void setDemande(DemandeExplication demande) {
		this.demande = demande;
	}



	public String getRecommendation() {
		return recommendation;
	}



	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	
	



	public Employe getConcerne() {
		return concerne;
	}



	public void setConcerne(Employe concerne) {
		this.concerne = concerne;
	}



	public Sanction getSanction() {
		return sanction;
	}



	public void setSanction(Sanction sanction) {
		this.sanction = sanction;
	}

    

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "RESOLITION";
	}



	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}



	@Override
	public int compareTo(LigneResolution arg0) {
		// TODO Auto-generated method stub
		return demande.compareTo(arg0.demande);
	}

}
