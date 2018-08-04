/**
 * 
 */
package com.kerenedu.dashboard;

import java.io.Serializable;

import javax.persistence.Column;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class PedagogieDashboard extends BaseElement implements Serializable,Comparable<PedagogieDashboard>{

	 
	 @Column(name="TX_REU")
	    @Predicate(label = "% Réusite" ,type = double.class)
	    private double txReu ;
	    
	    @Column(name="NBRE_ADMIS")
	    @Predicate(label = "Admis" ,type = Long.class)
	    private long admis ;

	    @Column(name = "ANNEE_ID")
		protected String anneScolaire;
    /**
     * 
     */
    public PedagogieDashboard() {
    }
    
   

    public PedagogieDashboard(double txReu, long admis, String anneScolaire) {
		super();
		this.txReu = txReu;
		this.admis = admis;
		this.anneScolaire = anneScolaire;
	}



	public PedagogieDashboard(PedagogieDashboard ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.txReu = ins.txReu;
		this.admis = ins.admis;
		this.anneScolaire = ins.anneScolaire;
		
		
    }
    
    public PedagogieDashboard(ViewDashboard ins) {
    	this.txReu = ins.getTxReu();
		this.admis = ins.getAdmis();
		this.anneScolaire=ins.getAnneScolaire();
		
    }
    
    

    /**
     * 
     * @param id
     * @param designation
     * @param moduleName 
     */
    public PedagogieDashboard(long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
    }

   
   

	public double getTxReu() {
		return txReu;
	}



	public void setTxReu(double txReu) {
		this.txReu = txReu;
	}



	public long getAdmis() {
		return admis;
	}



	public void setAdmis(long admis) {
		this.admis = admis;
	}



	public String getAnneScolaire() {
		return anneScolaire;
	}



	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}



	@Override
    public String getDesignation() {
        this.designation = "Education";
        return "Education"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        this.editTitle = "Tableau de bord";
        return "Tableau de bord"; //To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(PedagogieDashboard o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}