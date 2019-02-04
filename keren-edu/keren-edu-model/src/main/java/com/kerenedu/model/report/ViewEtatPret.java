/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

@Table
@Entity(name = "e_zview_pret")
public class ViewEtatPret extends BaseElement implements Serializable, Comparable<ViewEtatPret> {

	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Professeur.class,target="many-to-one",optional=false,updatable=false,search=true)
	private Professeur employe ;
	
	@Predicate(label="Date Effet",type=Date.class,target="date",optional=false,search=true)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date datepret ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true,updatable=false)
	private Double montant = 0.0;
	
	@Predicate(label="Montant proposé par la hiérarchie",type=Double.class,search=true)
	private Double montantpro=0.0;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	//@Predicate(label="Montant",type=Double.class,optional=false,search=true,updatable=false)
	private Double janvier = 0.0;
	private Double fev = 0.0;
	private Double mars = 0.0;
	private Double avril = 0.0;
	private Double mai = 0.0;
	private Double juin = 0.0;
	private Double juill = 0.0;
	private Double aout = 0.0;
	private Double sept = 0.0;
	@Column(name = "octobre")
	private Double oct = 0.0;
	
	private Double nov = 0.0;
	@Column(name = "decembre")
	private Double dec = 0.0;
	private Double totalpret = 0.0;
	private Double totalliquide = 0.0;
	
	private String statejanvier ;
	private String statefev ;
	private String statemars ;
	private String stateavril ;
	private String statemai ;
	private String statejuin ;
	private String statejuill ;
	private String stateaout ;
	private String statesept ;
	private String stateoct ;
	private String statenov ;
	@Column(name = "statedecembre")
	private String statedec ;
	
	
	private int moisrem;
	
	
	
//	@Column(name = "ANNEE_ID")
//	protected String anneeid;

	
	public int getMoisrem() {
		return moisrem;
	}


	public void setMoisrem(int moisrem) {
		this.moisrem = moisrem;
	}


	public ViewEtatPret() {
		// TODO Auto-generated constructor stub
	}


	public ViewEtatPret(Classe classe, Eleve eleve, Long zInscriptionEnc, Long tranche1Enc, Long tranche2Enc,
			Long tranche3Enc, Long remise, Long ristourne, Long zTotalA, Long zTotalR, Long zSolde, Cycle cycle,
			Long effectifs, Long effectifssolvable, String anneeid) {
		super();
		
		//this.anneeid = anneeid;
		
	}


	


	public ViewEtatPret(Professeur employe, Date datepret, Double montant, Double montantpro, Double janvier,
			Double fev, Double mars, Double avril, Double mai, Double juin, Double juill, Double aout, Double sept,
			Double oct, Double nov, Double dec, int moisrem) {
		super();
		this.employe = employe;
		this.datepret = datepret;
		this.montant = montant;
		this.montantpro = montantpro;
		this.janvier = janvier;
		this.fev = fev;
		this.mars = mars;
		this.avril = avril;
		this.mai = mai;
		this.juin = juin;
		this.juill = juill;
		this.aout = aout;
		this.sept = sept;
		this.oct = oct;
		this.nov = nov;
		this.dec = dec;
		this.moisrem = moisrem;
	}


	public ViewEtatPret(ViewEtatPret ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.employe = ins.employe;
		this.datepret = ins.datepret;
		this.montant = ins.montant;
		this.montantpro = ins.montantpro;
		this.moisrem = ins.moisrem;
		this.janvier = ins.janvier;
		this.fev = ins.fev;
		this.mars =ins.mars;
		this.avril = ins.avril;
		this.mai = ins.mai;
		this.juin = ins.juin;
		this.juill = ins.juill;
		this.aout = ins.aout;
		this.sept = ins.sept;
		this.oct = ins.oct;
		this.nov = ins.nov;
		this.dec = ins.dec;
		this.anneScolaire=ins.anneScolaire;
		this.totalpret=ins.totalpret;
		this.totalliquide=ins.totalliquide;
		
		this.statejanvier = ins.statejanvier;
		this.statefev = ins.statefev;
		this.statemars =ins.statemars;
		this.stateavril = ins.stateavril;
		this.statemai = ins.statemai;
		this.statejuin = ins.statejuin;
		this.statejuill = ins.statejuill;
		this.stateaout = ins.stateaout;
		this.statesept = ins.statesept;
		this.stateoct = ins.stateoct;
		this.statenov = ins.statenov;
		this.statedec = ins.statedec;
		
	}
	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewEtatPret o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Etat des Prêts";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Etat des Prêts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	
//
//
//	public String getAnneeid() {
//		return anneeid;
//	}
//
//
//	public void setAnneeid(String anneeid) {
//		this.anneeid = anneeid;
//	}


	



	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	public Professeur getEmploye() {
		return employe;
	}


	public void setEmploye(Professeur employe) {
		this.employe = employe;
	}


	public Date getDatepret() {
		return datepret;
	}


	public void setDatepret(Date datepret) {
		this.datepret = datepret;
	}


	public Double getMontant() {
		return montant;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}


	public Double getMontantpro() {
		return montantpro;
	}


	public void setMontantpro(Double montantpro) {
		this.montantpro = montantpro;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	public Double getJanvier() {
		return janvier;
	}


	public void setJanvier(Double janvier) {
		this.janvier = janvier;
	}


	public Double getFev() {
		return fev;
	}


	public Double getTotalliquide() {
		return totalliquide;
	}


	public void setTotalliquide(Double totalliquide) {
		this.totalliquide = totalliquide;
	}


	public void setFev(Double fev) {
		this.fev = fev;
	}


	public Double getMars() {
		return mars;
	}


	public void setMars(Double mars) {
		this.mars = mars;
	}


	public Double getAvril() {
		return avril;
	}


	public void setAvril(Double avril) {
		this.avril = avril;
	}


	public Double getMai() {
		return mai;
	}


	public void setMai(Double mai) {
		this.mai = mai;
	}


	public Double getJuin() {
		return juin;
	}


	public void setJuin(Double juin) {
		this.juin = juin;
	}


	public Double getJuill() {
		return juill;
	}


	public void setJuill(Double juill) {
		this.juill = juill;
	}


	public Double getAout() {
		return aout;
	}


	public void setAout(Double aout) {
		this.aout = aout;
	}


	public Double getSept() {
		return sept;
	}


	public String getStatejanvier() {
		return statejanvier;
	}


	public void setStatejanvier(String statejanvier) {
		this.statejanvier = statejanvier;
	}


	public String getStatefev() {
		return statefev;
	}


	public void setStatefev(String statefev) {
		this.statefev = statefev;
	}


	public String getStatemars() {
		return statemars;
	}


	public void setStatemars(String statemars) {
		this.statemars = statemars;
	}


	public String getStateavril() {
		return stateavril;
	}


	public void setStateavril(String stateavril) {
		this.stateavril = stateavril;
	}


	public String getStatemai() {
		return statemai;
	}


	public void setStatemai(String statemai) {
		this.statemai = statemai;
	}


	public String getStatejuin() {
		return statejuin;
	}


	public void setStatejuin(String statejuin) {
		this.statejuin = statejuin;
	}


	public String getStatejuill() {
		return statejuill;
	}


	public void setStatejuill(String statejuill) {
		this.statejuill = statejuill;
	}


	public String getStateaout() {
		return stateaout;
	}


	public void setStateaout(String stateaout) {
		this.stateaout = stateaout;
	}


	public String getStatesept() {
		return statesept;
	}


	public void setStatesept(String statesept) {
		this.statesept = statesept;
	}


	public String getStateoct() {
		return stateoct;
	}


	public void setStateoct(String stateoct) {
		this.stateoct = stateoct;
	}


	public String getStatenov() {
		return statenov;
	}


	public void setStatenov(String statenov) {
		this.statenov = statenov;
	}


	public String getStatedec() {
		return statedec;
	}


	public void setStatedec(String statedec) {
		this.statedec = statedec;
	}


	public void setSept(Double sept) {
		this.sept = sept;
	}


	public Double getOct() {
		return oct;
	}


	public void setOct(Double oct) {
		this.oct = oct;
	}


	public Double getTotalpret() {
		return totalpret;
	}


	public void setTotalpret(Double totalpret) {
		this.totalpret = totalpret;
	}


	public Double getNov() {
		return nov;
	}


	public void setNov(Double nov) {
		this.nov = nov;
	}


	public Double getDec() {
		return dec;
	}


	public void setDec(Double dec) {
		this.dec = dec;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}




}
