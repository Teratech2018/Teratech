/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIRERH")
public class LigneResolution extends BaseElement implements Serializable,Comparable<LigneResolution>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1478087362649689592L;
	
	@OneToOne
	@JoinColumn(name="DE_ID")
	@Predicate(label="Demande",type=DemandeExplication.class,target="many-to-one",search=true,optional=false,nullable=false)
	private DemandeExplication demande ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Concerné",type=Employe.class,target="many-to-one",search=true,editable=false,updatable=false)
	private Employe concerne;
	
	@OneToOne(mappedBy="resolution")
	@Predicate(label="Sanction",type=Sanction.class,target="many-to-one",search=true,editable=false,updatable=false)
	private Sanction sanction ;
	
	@Predicate(label="Recommendation",target="textarea",group=true,groupName="group1",groupLabel="RECOMMENDATION",search=true)
	@Lob
	private String recommendation ;	
	
//	@ManyToOne
//	
//	@JsonManagedReference
//	private ResolutionConseil resolution;

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
		super(id, designation, moduleName,0L);
		this.demande = demande;
		this.recommendation = recommendation;
	}

	public LigneResolution(DemandeExplication dmde) {
		super(-1, null, null,0L);
		
	   this.demande = new DemandeExplication(dmde);
	    
		if(dmde.getDestinataire()!=null){
			this.concerne = new Employe(dmde.getDestinataire());
		}//end if(dmde.getDestinataire()!=null){		
		
	}

	/**
	 * 
	 * @param lign
	 */
	public LigneResolution(LigneResolution lign) {
		super(lign.id, lign.designation, lign.moduleName,lign.compareid);
		if(lign.demande!=null){
			this.demande = new DemandeExplication(lign.demande);
	    }
		if(lign.concerne!=null){
			this.concerne = new Employe(lign.concerne);
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
	public boolean isDesablecreate() {
                if(sanction!=null){
                    return true;
                }
		return super.isDesablecreate(); //To change body of generated methods, choose Tools | Templates.
	}

//	public ResolutionConseil getResolution() {
//		return resolution;
//	}
//
//
//
//	public void setResolution(ResolutionConseil resolution) {
//		this.resolution = resolution;
//	}
    @Override
    public boolean isCreateonfield() {
        if(sanction!=null){
            return false;
        }
        return super.isCreateonfield(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        // TODO Auto-generated method stub
        return "DETAIS DE LA RESOLITION";
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
