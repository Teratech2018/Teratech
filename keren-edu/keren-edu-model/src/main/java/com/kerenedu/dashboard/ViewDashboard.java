/**
 * 
 */
package com.kerenedu.dashboard;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Table
@Entity(name = "e_zview_dashboard")
public class ViewDashboard extends BaseElement implements Serializable,Comparable<ViewDashboard>{

    @Column(name="N_ELEVE")
	@Predicate(label = "Total Elève" ,type = Double.class)
    private double nbreEtud ;
    
    @Column(name="N_ELEVE_INS")
    @Predicate(label = "Total Inscrit" ,type = Double.class)
    private double totalIns ;
    
    @Column(name="N_ELEVE_T1")
    @Predicate(label = "Sovable P. Tranche" ,type = Double.class)
    private double totalt1 ;
    
    @Column(name="N_ELEVE_T2")
    @Predicate(label = "Sovable D. Tranche" ,type = Double.class)
    private double totalt2 ;
    
    @Column(name="N_ELEVE_T3")
    @Predicate(label = "Sovable T. Tranche" ,type = Double.class)
    private double totalt3 ;
    
    @Column(name="N_ELEVE_S")
    @Predicate(label = "Nombre Sovable" ,type = Double.class)
    private double solvable ;
    
    @Column(name="PRE_G")
    @Predicate(label = "Prevision" ,type = double.class)
    private double previsionG ;
    
    @Column(name="ENC_G")
    @Predicate(label = "Encaissé" ,type = double.class)
    private double encaisseG ;
    
    @Column(name="REMISE_G")
    @Predicate(label = "Remise" ,type = double.class)
    private double remiseG ;
    
    @Column(name="RISTOURNE_G")
    @Predicate(label = "Ristourne" ,type = double.class)
    private double ristourneG ;
    
    @Column(name="SOLD_G")
    @Predicate(label = "Solde" ,type = double.class)
    private double soldeG ;
    
    @Column(name="PRE_I")
    @Predicate(label = "Prevision" ,type = double.class)
    private double previsionI ;
    
    @Column(name="ENC_I")
    @Predicate(label = "Encaissé" ,type = double.class)
    private double encaisseI ;
    
    @Column(name="SOLD_I")
    @Predicate(label = "Solde" ,type = double.class)
    private double soldeI ;
    
    @Column(name="PRE_T1")
    @Predicate(label = "Prevision" ,type = double.class)
    private double previsionT1 ;
    
    @Column(name="ENC_T1")
    @Predicate(label = "Encaissé" ,type = double.class)
    private double encaisseT1 ;
    
    @Column(name="SOLD_T1")
    @Predicate(label = "Solde" ,type = double.class)
    private double soldeT1 ;
    
    @Column(name="PRE_T2")
    @Predicate(label = "Prevision" ,type = double.class)
    private double previsionT2 ;
    
    @Column(name="ENC_T2")
    @Predicate(label = "Encaissé" ,type = double.class)
    private double encaisseT2 ;
    
    @Column(name="SOLD_T2")
    @Predicate(label = "Solde" ,type = double.class)
    private double soldeT2 ;
    
    @Column(name="PRE_T3")
    @Predicate(label = "Prevision" ,type = double.class)
    private double previsionT3 ;
    
    @Column(name="ENC_T3")
    @Predicate(label = "Encaissé" ,type = double.class)
    private double encaisseT3 ;
    
    @Column(name="SOLD_T3")
    @Predicate(label = "Solde" ,type = double.class)
    private double soldeT3 ;
    
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
    public ViewDashboard() {
    }
    
    

    public ViewDashboard(double nbreEtud, double totalIns, double totalt1, double totalt2, double totalt3,
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

    public ViewDashboard(ViewDashboard ins) {
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
		this.encaisseT3 = ins.encaisseT3;
		this.soldeT3 = ins.soldeT3;
		this.anneScolaire=ins.anneScolaire;
		this.txReu=ins.txReu;
		this.admis=ins.admis;
		this.remiseG=ins.remiseG;
		this.ristourneG=ins.ristourneG;
		
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

	public double getRemiseG() {
		return remiseG;
	}



	public void setRemiseG(double remiseG) {
		this.remiseG = remiseG;
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

	public double getRistourneG() {
		return ristourneG;
	}



	public void setRistourneG(double ristourneG) {
		this.ristourneG = ristourneG;
	}



	public void setSoldeG(double soldeG) {
		this.soldeG = soldeG;
	}

	public double getPrevisionI() {
		return previsionI;
	}

	public void setPrevisionI(double previsionI) {
		this.previsionI = previsionI;
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

	public void setSoldeI(double soldeI) {
		this.soldeI = soldeI;
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

	public String getAnneScolaire() {
		return anneScolaire;
	}



	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}



	public void setSoldeT3(double soldeT3) {
		this.soldeT3 = soldeT3;
	}

	/**
     * 
     * @param id
     * @param designation
     * @param moduleName 
     */
    public ViewDashboard(Long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
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
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Année Scolaire "+(new Long(this.anneScolaire)+1)+"-"+ this.anneScolaire;
	}



	@Override
    public String getEditTitle() {
        this.editTitle = "Tableau de bord";
        return "Tableau de bord"; //To change body of generated methods, choose Tools | Templates.
    }

	public int compareTo(ViewDashboard o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
 
}