/**
 * 
 */
package com.kerenedu.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class EducationDashboard extends BaseElement implements Serializable,Comparable<EducationDashboard>{
	
	 private List<Raccourci> raccourcis = new ArrayList<Raccourci>();

	 @Predicate(label = "Total Elève" ,type = Double.class)
	    private double nbreEtud ;
	    
	    @Predicate(label = "Total Inscrit" ,type = Double.class)
	    private double totalIns ;
	    
	    @Predicate(label = "Sovable P. Tranche" ,type = Double.class)
	    private double totalt1 ;
	    
	    @Predicate(label = "Sovable D. Tranche" ,type = Double.class)
	    private double totalt2 ;
	    
	    @Predicate(label = "Sovable T. Tranche" ,type = Double.class)
	    private double totalt3 ;
	    
	    @Predicate(label = "Nombre Sovable" ,type = Double.class)
	    private double solvable ;
	    
	    @Predicate(label = "Prevision" ,type = double.class)
	    private double previsionG ;
	    
	    @Predicate(label = "Encaissé" ,type = double.class)
	    private double encaisseG ;
	    
	    @Predicate(label = "Remise" ,type = double.class)
	    private double remiseG ;
	    
	    @Predicate(label = "Ristourne" ,type = double.class)
	    private double ristourneG ;
	    
	    @Predicate(label = "Solde" ,type = double.class)
	    private double soldeG ;
	    
	    @Predicate(label = "Prevision" ,type = double.class)
	    private double previsionI ;
	    
	    @Predicate(label = "Encaissé" ,type = double.class)
	    private double encaisseI ;
	    
	    @Predicate(label = "Solde" ,type = double.class)
	    private double soldeI ;
	    
	    @Predicate(label = "Prevision" ,type = double.class)
	    private double previsionT1 ;
	    
	    @Predicate(label = "Encaissé" ,type = double.class)
	    private double encaisseT1 ;
	    
	    @Predicate(label = "Solde" ,type = double.class)
	    private double soldeT1 ;
	    
	    @Predicate(label = "Prevision" ,type = double.class)
	    private double previsionT2 ;
	    
	    @Predicate(label = "Encaissé" ,type = double.class)
	    private double encaisseT2 ;
	    
	    @Predicate(label = "Solde" ,type = double.class)
	    private double soldeT2 ;
	    
	    @Predicate(label = "Prevision" ,type = double.class)
	    private double previsionT3 ;
	    
	    @Predicate(label = "Encaissé" ,type = double.class)
	    private double encaisseT3 ;
	    
	    @Predicate(label = "Solde" ,type = double.class)
	    private double soldeT3 ;
	    
	    @Transient
	    private double remise ;
	    
	   
	    @Column(name = "ANNEE_ID")
		protected String anneScolaire;
    /**
     * 
     */
    public EducationDashboard() {
    }
    
    public EducationDashboard(double nbreEtud, double totalIns, double totalt1, double totalt2, double totalt3,
			double solvable, double previsionG, double encaisseG, double soldeG, double previsionI, double encaisseI, double soldeI,
			double previsionT1, double encaisseT1, double soldeT1, double previsionT2, double encaisseT2, double soldeT2,
			double previsionT3, double encaisseT3, double soldeT3) {
		super();
		this.nbreEtud = nbreEtud;
		this.totalIns = totalIns;
		this.totalt1 = totalt1;
		this.totalt2 = totalt2;
		this.totalt3 = totalt3;
		this.solvable = solvable;
		this.previsionG = previsionG;
		this.encaisseG = encaisseG;
		this.soldeG = soldeG;
		this.previsionI = previsionI;
		this.encaisseI = encaisseI;
		this.soldeI = soldeI;
		this.previsionT1 = previsionT1;
		this.encaisseT1 = encaisseT1;
		this.soldeT1 = soldeT1;
		this.previsionT2 = previsionT2;
		this.encaisseT2 = encaisseT2;
		this.soldeT2 = soldeT2;
		this.previsionT3 = previsionT3;
		this.encaisseT3 = encaisseT3;
		this.soldeT3 = soldeT3;
	}

    public EducationDashboard(EducationDashboard ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.nbreEtud = ins.nbreEtud;
		this.totalIns = ins.totalIns;
		this.totalt1 = ins.totalt1;
		this.totalt2 = ins.totalt2;
		this.totalt3 = ins.totalt3;
		this.solvable = ins.solvable;
		this.previsionG = ins.previsionG;
		this.encaisseG = ins.encaisseG;
		this.soldeG = ins.soldeG;
		this.previsionI = ins.previsionI;
		this.encaisseI = ins.encaisseI;
		this.soldeI = ins.soldeI;
		this.previsionT1 = ins.previsionT1;
		this.encaisseT1 = ins.encaisseT1;
		this.soldeT1 = ins.soldeT1;
		this.previsionT2 = ins.previsionT2;
		this.encaisseT2 = ins.encaisseT2;
		this.soldeT2 = ins.soldeT2;
		this.previsionT3 = ins.previsionT3;
		this.encaisseT3 = ins.encaisseT3-ins.remiseG;
		this.soldeT3 = ins.soldeT3;
		this.remiseG=ins.remiseG;
		this.raccourcis=ins.raccourcis;
		this.ristourneG=ins.ristourneG;
	
		
    }
    
    public EducationDashboard(ViewDashboard ins) {
		this.nbreEtud = ins.getNbreEtud();
		this.totalIns = ins.getTotalIns();
		this.totalt1 = ins.getTotalt1();
		this.totalt2 = ins.getTotalt2();
		this.totalt3 = ins.getTotalt3();
		this.solvable = ins.getSolvable();
		this.previsionG = ins.getPrevisionG();
		this.encaisseG = ins.getEncaisseG();
		this.soldeG = ins.getSoldeG();
		this.previsionI = ins.getPrevisionI();
		this.encaisseI = ins.getEncaisseI();
		this.soldeI = ins.getSoldeI();
		this.previsionT1 = ins.getPrevisionT1();
		this.encaisseT1 = ins.getEncaisseT1();
		this.soldeT1 = ins.getSoldeT1();
		this.previsionT2 = ins.getPrevisionT2();
		this.encaisseT2 = ins.getEncaisseT2();
		this.soldeT2 = ins.getSoldeT2();
		this.previsionT3 = ins.getPrevisionT3()+ins.getPrevisionT2()+ins.getPrevisionT1();
		this.encaisseT3 = ins.getEncaisseT3()+ins.getEncaisseT2()+ins.getEncaisseT1();
		this.soldeT3 = ins.getSoldeT3()+ins.getSoldeT2()+ins.getSoldeT1();
		this.anneScolaire=ins.getAnneScolaire();
		this.remiseG=ins.getRemiseG();
		this.ristourneG=ins.getRistourneG();
		
		
    }
    
    

    /**
     * 
     * @param id
     * @param designation
     * @param moduleName 
     */
    public EducationDashboard(long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
    }

   
    /**
	 * @return the nbreEtud
	 */
	public double getNbreEtud() {
		return nbreEtud;
	}

	public List<Raccourci> getRaccourcis() {
		return raccourcis;
	}

	public void setRaccourcis(List<Raccourci> raccourcis) {
		this.raccourcis = raccourcis;
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

	public double getTotalt1() {
		return totalt1;
	}

	public void setTotalt1(double totalt1) {
		this.totalt1 = totalt1;
	}

	public double getTotalt2() {
		return totalt2;
	}

	public void setTotalt2(double totalt2) {
		this.totalt2 = totalt2;
	}

	public double getTotalt3() {
		return totalt3;
	}

	public void setTotalt3(double totalt3) {
		this.totalt3 = totalt3;
	}

	public double getSolvable() {
		return solvable;
	}

	public void setSolvable(double solvable) {
		this.solvable = solvable;
	}

	public double getPrevisionG() {
		return previsionG;
	}

	public void setPrevisionG(double previsionG) {
		this.previsionG = previsionG;
	}

	public double getEncaisseG() {
		return encaisseG;
	}

	public void setEncaisseG(double encaisseG) {
		this.encaisseG = encaisseG;
	}

	public double getSoldeG() {
		return soldeG;
	}

	public void setSoldeG(double soldeG) {
		this.soldeG = soldeG;
	}

	public double getRemiseG() {
		return remiseG;
	}

	public void setRemiseG(double remiseG) {
		this.remiseG = remiseG;
	}

	public double getPrevisionI() {
		return previsionI;
	}

	public void setPrevisionI(double previsionI) {
		this.previsionI = previsionI;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getEncaisseI() {
		return encaisseI;
	}

	public void setEncaisseI(double encaisseI) {
		this.encaisseI = encaisseI;
	}

	public double getSoldeI() {
		return soldeI;
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public void setSoldeI(double soldeI) {
		this.soldeI = soldeI;
	}

	public double getRistourneG() {
		return ristourneG;
	}

	public void setRistourneG(double ristourneG) {
		this.ristourneG = ristourneG;
	}

	public double getPrevisionT1() {
		return previsionT1;
	}

	public void setPrevisionT1(double previsionT1) {
		this.previsionT1 = previsionT1;
	}

	public double getEncaisseT1() {
		return encaisseT1;
	}

	public void setEncaisseT1(double encaisseT1) {
		this.encaisseT1 = encaisseT1;
	}

	public double getSoldeT1() {
		return soldeT1;
	}

	public void setSoldeT1(double soldeT1) {
		this.soldeT1 = soldeT1;
	}

	public double getPrevisionT2() {
		return previsionT2;
	}

	public void setPrevisionT2(double previsionT2) {
		this.previsionT2 = previsionT2;
	}

	public double getEncaisseT2() {
		return encaisseT2;
	}

	public void setEncaisseT2(double encaisseT2) {
		this.encaisseT2 = encaisseT2;
	}

	public double getSoldeT2() {
		return soldeT2;
	}

	public void setSoldeT2(double soldeT2) {
		this.soldeT2 = soldeT2;
	}

	public double getPrevisionT3() {
		return previsionT3;
	}

	public void setPrevisionT3(double previsionT3) {
		this.previsionT3 = previsionT3;
	}

	public double getEncaisseT3() {
		return encaisseT3;
	}

	public void setEncaisseT3(double encaisseT3) {
		this.encaisseT3 = encaisseT3;
	}

	public double getSoldeT3() {
		return soldeT3;
	}

	public void setSoldeT3(double soldeT3) {
		this.soldeT3 = soldeT3;
	}

	@Override
    public String getDesignation() {
        this.designation = "Education";
        return "Education"; //To change body of generated methods, choose Tools | Templates.
    }
	
	 @Override
		public String getListTitle() {
			// TODO Auto-generated method stub
			return "Année Scolaire "+ this.anneScolaire +"-"+ (new Long(this.anneScolaire)+1);
		}


    @Override
    public String getEditTitle() {

        return "Année Scolaire "+ this.anneScolaire +"-"+ (new Long(this.anneScolaire)+1);//To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(EducationDashboard o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}