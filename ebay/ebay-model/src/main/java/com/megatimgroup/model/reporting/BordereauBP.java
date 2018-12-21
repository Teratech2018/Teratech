/**
 * 
 */
package com.megatimgroup.model.reporting;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.megatimgroup.model.parametres.Mois;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.parametres.StatutDeclaration;

/**
 * @author mgt
 *
 */
@Entity
@Table(name="BORDEREAU_BP")
public class BordereauBP implements Serializable, Comparable<BordereauBP> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected long id ;
    
    @JoinColumn(name="C_SOCIETE")
    private Societe societe ;
    
    @Column(name="NAT_SUPPORT")
	private String natureSupport;
    
    @Column(name="NBRE_SUPPORT")
	private int nombreSupport;
    
    @Column(name="NBRE_PP")
	private int nombrePP ;
    
    @Column(name="NBRE_PM")
	private int nombrePM;
    
    @Column(name="NBRE_OF")
	private int nombreOF;
    
    @Column(name="D_REMISE")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateRemise;
    
    @Column(name="D_DEBUT")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateDebut;
    
    @Column(name="D_FIN")
    @Temporal(javax.persistence.TemporalType.DATE)
	private Date dateFin;
    
    @Column(name="L_MOIS_GEN")
    private Mois lMoisGeneration;
    
    @Column(name="C_REP_FILE")
	private String reportFiledeport ;
    
    
    @Transient
    private String fileName;
    
    public BordereauBP(){
    	
    }
	
	public BordereauBP(Societe societe,String natureSupport,int nombreSupport,int nombrePP
			,int nombrePM,int nombreOF,Date dateRemise,String reportFiledeport, Mois mois){
		this.societe=societe;
		this.natureSupport=natureSupport;
		this.nombreSupport=nombreSupport;
		this.nombrePP=nombrePP;
		this.nombrePM=nombrePM;
		this.nombreOF=nombreOF;
		this.dateRemise=dateRemise;
		this.reportFiledeport=reportFiledeport;
		this.lMoisGeneration=mois;
		
	}



	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getNatureSupport() {
		return natureSupport;
	}

	public void setNatureSupport(String natureSupport) {
		this.natureSupport = natureSupport;
	}

	public int getNombreSupport() {
		return nombreSupport;
	}

	public void setNombreSupport(int nombreSupport) {
		this.nombreSupport = nombreSupport;
	}

	public int getNombrePP() {
		return nombrePP;
	}

	public void setNombrePP(int nombrePP) {
		this.nombrePP = nombrePP;
	}

	public int getNombrePM() {
		return nombrePM;
	}

	public void setNombrePM(int nombrePM) {
		this.nombrePM = nombrePM;
	}

	public int getNombreOF() {
		return nombreOF;
	}

	public void setNombreOF(int nombreOF) {
		this.nombreOF = nombreOF;
	}

	public Date getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	public String getReportFiledeport() {
		return reportFiledeport;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setReportFiledeport(String reportFiledeport) {
		this.reportFiledeport = reportFiledeport;
	}

        public String getFileName() {
            return fileName;
        }


		public void setFileName(String fileName) {
            this.fileName = fileName;
            
        }
        
        
	
	public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

	public Mois getlMoisGeneration() {
			return lMoisGeneration;
		}

		public void setlMoisGeneration(Mois lMoisGeneration) {
			this.lMoisGeneration = lMoisGeneration;
		}

	public static BordereauBP DataTestBP(){
		Societe societe = new Societe();
		BordereauBP Bbp = new BordereauBP(societe, "", 100, 25, 25, 50, new Date(), "H:\\WORKSPACE\\PROJET\\BPAY\\BDR\\",Mois.AOUT) ;
		
		return Bbp ;
		
	}



	public int compareTo(BordereauBP o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
