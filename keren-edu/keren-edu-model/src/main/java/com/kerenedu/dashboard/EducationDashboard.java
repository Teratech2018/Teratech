/**
 * 
 */
package com.kerenedu.dashboard;

import java.io.Serializable;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class EducationDashboard extends BaseElement implements Serializable,Comparable<EducationDashboard>{

    @Predicate(label = "Nombre etudiant" ,type = Double.class)
    private double nbreEtud =100;
    
    @Predicate(label = "TOTAL INSCRIT" ,type = Double.class)
    private double totalIns = 25;

    /**
     * 
     */
    public EducationDashboard() {
    }

    /**
     * 
     * @param id
     * @param designation
     * @param moduleName 
     */
    public EducationDashboard(long id, String designation, String moduleName) {
        super(id, designation, moduleName);
    }

   
    /**
	 * @return the nbreEtud
	 */
	public double getNbreEtud() {
		return nbreEtud;
	}

	/**
	 * @param nbreEtud the nbreEtud to set
	 */
	public void setNbreEtud(double nbreEtud) {
		this.nbreEtud = nbreEtud;
	}

	/**
	 * @return the totalIns
	 */
	public double getTotalIns() {
		return totalIns;
	}

	/**
	 * @param totalIns the totalIns to set
	 */
	public void setTotalIns(double totalIns) {
		this.totalIns = totalIns;
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

	public int compareTo(EducationDashboard o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}