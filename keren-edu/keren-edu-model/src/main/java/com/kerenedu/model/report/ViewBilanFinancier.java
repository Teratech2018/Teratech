/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

@Table
@Entity(name = "e_zview_bf")
public class ViewBilanFinancier extends BaseElement implements Serializable, Comparable<ViewBilanFinancier> {

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",updatable=true,type=Classe.class , target="many-to-one",search=true ,searchfields="libelle"  ,colsequence=1)
	protected Classe classe ;
	
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label="Elève",updatable=true,type=Eleve.class , target="many-to-one",search=true, colsequence=2, searchfields="matricule"	)
	protected Eleve eleve ;
	
	
	@Column(name = "INSCRIPTION_ENC")
	@Predicate(label = "Inscription Enc.", optional = true, updatable = false, search = true, type = Long.class , colsequence=3)
	protected Long zInscriptionEnc;
	
	@Column(name = "I_TRAN_ENC")
	@Predicate(label = "P. Tranche Enc.", optional = true, updatable = false, search = true, type = Long.class , colsequence=4)
	protected Long tranche1Enc;
	
	@Column(name = "II_TRAN_ENC")
	@Predicate(label = "Deux. Tranche Enc.", optional = true, updatable = false, search = true, type = Long.class , colsequence=5)
	protected Long tranche2Enc;
	
	@Column(name = "III_TRAN_ENC")
	@Predicate(label = "Trois. Tranche Enc.", optional = true, updatable = false, search = true, type = Long.class , colsequence=6)
	protected Long tranche3Enc;
	
	@Column(name = "INSCRIPTION")
	@Predicate(label = "INSCRIPTION", optional = true, updatable = false, search = true, type = BigDecimal.class , colsequence=2)
	protected Long zInscription;
	
	@Column(name = "I_TRAN")
	@Predicate(label = "P. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class)
	protected Long tranche1;
	
	@Column(name = "II_TRAN")
	@Predicate(label = "Deux. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class)
	protected Long tranche2;
	
	@Column(name = "III_TRAN")
	@Predicate(label = "Trois. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class)
	protected Long tranche3;

	@Column(name = "REMISE")
	@Predicate(label = "REMISE", optional = true, updatable = false, search = true, type = Long.class, colsequence=7)
	protected Long remise;

	@Column(name = "RISTOURNE")
	@Predicate(label = "Ristourne", optional = true, updatable = false, search = true, type = Long.class , colsequence=8)
	protected Long ristourne;

	@Column(name = "TOTAL_A")
	@Predicate(label = "Total Attendu", optional = true, updatable = false, search = true, type = Long.class , colsequence=9)
	protected Long zTotalA;

	@Column(name = "TOTAL_R")
	@Predicate(label = "Total Reçu", optional = true, updatable = false, search = true, type = Long.class , colsequence=10)
	protected Long zTotalR;

	@Column(name = "SOLDE")
	@Predicate(label = "SOLDE", optional = true, updatable = false, search = true, type = Long.class , colsequence=11)
	protected Long zSolde;
	
	@Transient
	@Column(name = "TX_RECO")
	@Predicate(label = "Tx. REC. %", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=15)
	protected Long ztaux;
	
	@Transient
	@ManyToOne
    @JoinColumn(name = "CYCLE_ID")
	//@Predicate(label="Cycle Scolaire",updatable=true,type=Cycle.class , target="many-to-one",optional=false,sequence=2)
    protected Cycle cycle;
	
	@Column(name = "EFF_SOL_CYCLE")
	protected Long effectifssolcycle;
	
	@Column(name = "EFF_SOL")
	protected Long effectifssolvable;
	
	@Column(name = "EFF_SOL_SECTION")
	protected Long effectifssolsection;
	
	@Column(name = "EFF_SOL_TOTAL")
	protected Long effectifssoltotal;
	
	@Column(name = "EFF_TOTAL")
	protected Long efftotal;

	
	@Column(name = "ANNEE_ID")
	protected String anneeid;

	
	public ViewBilanFinancier() {
		// TODO Auto-generated constructor stub
	}


	public ViewBilanFinancier(Classe classe, Eleve eleve, Long zInscriptionEnc, Long tranche1Enc, Long tranche2Enc,
			Long tranche3Enc, Long remise, Long ristourne, Long zTotalA, Long zTotalR, Long zSolde, Cycle cycle,
			Long effectifs, Long effectifssolvable, String anneeid) {
		super();
		this.classe = classe;
		this.eleve = eleve;
		this.zInscriptionEnc = zInscriptionEnc;
		this.tranche1Enc = tranche1Enc;
		this.tranche2Enc = tranche2Enc;
		this.tranche3Enc = tranche3Enc;
		this.remise = remise;
		this.ristourne = ristourne;
		this.zTotalA = zTotalA;
		this.zTotalR = zTotalR;
		this.zSolde = zSolde;
		this.cycle = cycle;
	//	this.effectifs = effectifs;
		this.effectifssolvable = effectifssolvable;
		this.anneeid = anneeid;
		
	}


	public ViewBilanFinancier(ViewBilanFinancier ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(ins.eleve!=null){
			this.eleve = new Eleve(ins.eleve);
		}
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
			this.cycle = ins.getClasse().getFiliere().getCycle();
		}
	
		this.zInscriptionEnc = ins.zInscriptionEnc;
		this.tranche1Enc = ins.tranche1Enc;
		this.tranche2Enc = ins.tranche2Enc;
		this.tranche3Enc = ins.tranche3Enc;
		this.remise = ins.remise;
		this.ristourne = ins.ristourne;
		this.zTotalA = ins.zTotalA;
		this.zTotalR = ins.zTotalR;
		this.zSolde = ins.zSolde;
	
		this.effectifssolcycle = ins.effectifssolcycle;
		this.effectifssolvable = ins.effectifssolvable;
		this.effectifssolsection = ins.effectifssolsection;
		this.effectifssoltotal = ins.effectifssoltotal;
		this.anneeid = ins.anneeid;
		this.ztaux=ins.ztaux;
		this.zInscription = ins.zInscription;
		this.tranche1 = ins.tranche1;
		this.tranche2 = ins.tranche2;
		this.tranche3 = ins.tranche3;
		this.efftotal = ins.efftotal;

			
	}
	

	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewBilanFinancier o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getMatricule()+"-"+eleve.getNom();
	}



	public Long getzSolde() {
		return zSolde;
	}


	public Long getzInscriptionEnc() {
		return zInscriptionEnc;
	}


	public void setzInscriptionEnc(Long zInscriptionEnc) {
		this.zInscriptionEnc = zInscriptionEnc;
	}


	public Long getTranche1Enc() {
		return tranche1Enc;
	}


	public void setTranche1Enc(Long tranche1Enc) {
		this.tranche1Enc = tranche1Enc;
	}


	public Long getTranche2Enc() {
		return tranche2Enc;
	}


	public void setTranche2Enc(Long tranche2Enc) {
		this.tranche2Enc = tranche2Enc;
	}


	public Long getTranche3Enc() {
		return tranche3Enc;
	}


	public void setTranche3Enc(Long tranche3Enc) {
		this.tranche3Enc = tranche3Enc;
	}


	public Long getzTotalA() {
		return zTotalA;
	}


	public void setzTotalA(Long zTotalA) {
		this.zTotalA = zTotalA;
	}


	public Long getzTotalR() {
		return zTotalR;
	}


	public void setzTotalR(Long zTotalR) {
		this.zTotalR = zTotalR;
	}


	public Cycle getCycle() {
		return cycle;
	}


	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}


	public Long getEfftotal() {
		return efftotal;
	}


	public void setEfftotal(Long efftotal) {
		this.efftotal = efftotal;
	}


	public Long getEffectifssolvable() {
		return effectifssolvable;
	}


	public void setEffectifssolvable(Long effectifssolvable) {
		this.effectifssolvable = effectifssolvable;
	}


	public Long getEffectifssoltotal() {
		return effectifssoltotal;
	}


	public void setEffectifssoltotal(Long effectifssoltotal) {
		this.effectifssoltotal = effectifssoltotal;
	}


	public String getAnneeid() {
		return anneeid;
	}


	public void setAnneeid(String anneeid) {
		this.anneeid = anneeid;
	}


	public Long getzInscription() {
		return zInscription;
	}


	public void setzInscription(Long zInscription) {
		this.zInscription = zInscription;
	}


	public Long getEffectifssolcycle() {
		return effectifssolcycle;
	}


	public void setEffectifssolcycle(Long effectifssolcycle) {
		this.effectifssolcycle = effectifssolcycle;
	}


	public Long getEffectifssolsection() {
		return effectifssolsection;
	}


	public void setEffectifssolsection(Long effectifssolsection) {
		this.effectifssolsection = effectifssolsection;
	}


	public Long getTranche1() {
		return tranche1;
	}





	public void setTranche1(Long tranche1) {
		this.tranche1 = tranche1;
	}


	public Long getTranche2() {
		return tranche2;
	}


	public void setTranche2(Long tranche2) {
		this.tranche2 = tranche2;
	}


	public Long getTranche3() {
		return tranche3;
	}


	public void setTranche3(Long tranche3) {
		this.tranche3 = tranche3;
	}


	public Long getZtaux() {
		if (this.getzTotalA()!=null&&this.getzTotalR()!=null &&this.getzTotalA()!=0&&this.getzTotalR()!=0){
		ztaux= new Long((this.getzTotalA()/this.getzTotalR())*100);
		}else{
			ztaux=(long) 0;
		}
		return ztaux;
	}


	public void setZtaux(Long ztaux) {
		this.ztaux = ztaux;
	}


	public void setzSolde(Long zSolde) {
		this.zSolde = zSolde;
	}


	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}


	public Long getRemise() {
		return remise;
	}


	public void setRemise(Long remise) {
		this.remise = remise;
	}


	public Long getRistourne() {
		return ristourne;
	}


	public void setRistourne(Long ristourne) {
		this.ristourne = ristourne;
	}





}
