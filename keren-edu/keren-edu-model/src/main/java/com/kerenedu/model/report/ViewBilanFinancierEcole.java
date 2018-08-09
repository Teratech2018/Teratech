/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

@Table
@Entity(name = "e_zview_bf_ecole")
public class ViewBilanFinancierEcole extends BaseElement implements Serializable, Comparable<ViewBilanFinancierEcole> {

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", updatable = true, type = Classe.class, target = "many-to-one", search = true , colsequence=1,searchfields="libelle")
	protected Classe classe;

	@Column(name = "INSCRIPTION")
	@Predicate(label = "INSCRIPTION", optional = true, updatable = false, search = true, type = BigDecimal.class , colsequence=2)
	protected Long zInscription;

	@Column(name = "INSCRIPTION_ENC")
	@Predicate(label = "Inscription Enc.", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=3)
	protected Long zInscriptionEnc;

	@Column(name = "I_TRAN")
	@Predicate(label = "P. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=4)
	protected Long tranche1;

	@Column(name = "I_TRAN_ENC")
	@Predicate(label = "P. Tranche Enc.", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=5)
	protected Long tranche1Enc;

	@Column(name = "II_TRAN")
	@Predicate(label = "Deux. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=6)
	protected Long tranche2;

	@Column(name = "II_TRAN_ENC")
	@Predicate(label = "Deux. Tranche Enc.", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=7)
	protected Long tranche2Enc;

	@Column(name = "III_TRAN")
	@Predicate(label = "Trois. Tranche", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=8)
	protected Long tranche3;

	@Column(name = "III_TRAN_ENC")
	@Predicate(label = "Trois. Tranche Enc.", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=9)
	protected Long tranche3Enc;

	@Column(name = "REMISE")
	@Predicate(label = "REMISE", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=10)
	protected Long remise;

	@Column(name = "RISTOURNE")
	@Predicate(label = "Ristourne", optional = true, updatable = false, search = true, type = BigDecimal.class , colsequence=11)
	protected Long ristourne;

	@Column(name = "TOTAL_A")
	@Predicate(label = "Total Attendu", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=12)
	protected Long zTotalA;

	@Column(name = "TOTAL_R")
	@Predicate(label = "Total Reçu", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=13)
	protected Long zTotalR;

	@Column(name = "SOLDE")
	@Predicate(label = "SOLDE", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=14)
	protected Long zSolde;

	@Column(name = "TX_RECO")
	@Predicate(label = "Tx. REC. %", optional = true, updatable = false, search = true, type = BigDecimal.class, colsequence=15)
	protected Long ztaux;
	
	@ManyToOne
    @JoinColumn(name = "CYCLE_ID")
	//@Predicate(label="Cycle Scolaire",updatable=true,type=Cycle.class , target="many-to-one",optional=false,sequence=2)
    protected Cycle cycle;
	
	@Column(name = "EFF")
	protected Long effectifs;
	@Column(name = "EFF_SOL")
	protected Long effectifssolvable;
	
	@Column(name = "ANNEE_ID")
	protected String anneeid;
	
	
	public ViewBilanFinancierEcole() {
		// TODO Auto-generated constructor stub
	}

	public ViewBilanFinancierEcole(Classe classe, Long zInscription, Long zInscriptionEnc, Long tranche1,
			Long tranche1Enc, Long tranche2, Long tranche2Enc, Long tranche3, Long tranche3Enc, Long remise,
			Long ristourne, Long zTotalA, Long zTotalR, Long zSolde) {
		super();
		this.classe = classe;
		this.zInscription = zInscription;
		this.zInscriptionEnc = zInscriptionEnc;
		this.tranche1 = tranche1;
		this.tranche1Enc = tranche1Enc;
		this.tranche2 = tranche2;
		this.tranche2Enc = tranche2Enc;
		this.tranche3 = tranche3;
		this.tranche3Enc = tranche3Enc;
		this.remise = remise;
		this.ristourne = ristourne;
		this.zTotalA = zTotalA;
		this.zTotalR = zTotalR;
		this.zSolde = zSolde;
		
	}

	public ViewBilanFinancierEcole(ViewBilanFinancierEcole ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		if (ins.classe != null) {
			this.classe = new Classe(ins.classe);
		}
		this.zInscription = ins.zInscription;
		this.cycle=ins.cycle;
		this.effectifs=ins.effectifs;
		this.effectifssolvable=ins.effectifssolvable;
		this.zInscriptionEnc = ins.zInscriptionEnc;
		this.tranche1 = ins.tranche1;
		this.tranche1Enc = ins.tranche1Enc;
		this.tranche2 = ins.tranche2;
		this.tranche2Enc = ins.tranche2Enc;
		this.tranche3 = ins.tranche3;
		this.tranche3Enc = ins.tranche3Enc;
		this.remise = ins.remise;
		this.ristourne = ins.ristourne;
		this.zTotalA = ins.zTotalA;
		this.zTotalR = ins.zTotalR;
		this.zSolde = ins.zSolde;
		this.ztaux = ins.ztaux;
		this.anneeid=ins.anneeid;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
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

	public Cycle getCycle() {
		return cycle;
	}

	


	public Long getEffectifs() {
		return effectifs;
	}

	public void setEffectifs(Long effectifs) {
		this.effectifs = effectifs;
	}

	public Long getEffectifssolvable() {
		return effectifssolvable;
	}

	public void setEffectifssolvable(Long effectifssolvable) {
		this.effectifssolvable = effectifssolvable;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewBilanFinancierEcole o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers Global";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers Global ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public Long getzSolde() {
		return zSolde;
	}

	public void setzSolde(Long zSolde) {
		this.zSolde = zSolde;
	}

	public Long getZtaux() {
	return ztaux;

	}

	public void setZtaux(Long ztaux) {
		this.ztaux = ztaux;
	}



	public Long getzInscription() {
		return zInscription;
	}

	public void setzInscription(Long zInscription) {
		this.zInscription = zInscription;
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

	public String getAnneeid() {
		return anneeid;
	}

	public void setAnneeid(String anneeid) {
		this.anneeid = anneeid;
	}

	public Long getTranche3Enc() {
		return tranche3Enc;
	}

	public void setTranche3Enc(Long tranche3Enc) {
		this.tranche3Enc = tranche3Enc;
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



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Bilan Financiers Global ";
	}

	
	
}
