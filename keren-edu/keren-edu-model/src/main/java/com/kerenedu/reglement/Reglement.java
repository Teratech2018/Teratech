/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_reglement")
public class Reglement extends BaseElement implements Serializable, Comparable<Reglement> {

	
	@Column(name = "DATE_REG")
	@Predicate(label="DATE PAIEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datReg;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label="ETUDIANT",updatable=true,type=Eleve.class , target="many-to-one",search=true , sequence=3	)
	protected Eleve eleve;


	@Column(name = "MNT_PAI" ,unique=true)	
	@Predicate(label="MONTANT PAIEMENT",optional=true,updatable=false,search=true, type=BigDecimal.class, hide=false ,sequence=4)
	protected BigDecimal zMnt =BigDecimal.ZERO;
	
	@Column(name = "MNT_PAI_TMP" ,unique=true)	
	@Predicate(label="MONTANT PAIEMENT",optional=true,updatable=false,search=false, type=BigDecimal.class, hide=true ,sequence=4)
	protected BigDecimal zMntTmp =BigDecimal.ZERO;
	
	@Column(name = "TYP_REG")
	@Predicate(label="TYPE PAIEMENT",optional=false,updatable=true,search=false, target="combobox", values="Espèce;Virement" , sequence=2 )
	protected String typePaiment="0";
	
	
	@ManyToOne
	@JoinColumn(name = "ANNEE_ID")
	protected AnneScolaire anneScolaire;
	


	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reglement(Reglement ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.zMnt = ins.zMnt;
		this.eleve = new Eleve(ins.eleve);
		this.zMnt = ins.zMnt;
		this.datReg=ins.datReg;
		this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.typePaiment=ins.typePaiment;
		this.zMntTmp=ins.zMntTmp;
		
	
	
	}

	

	/**
	 * @return the zMnt
	 */
	public BigDecimal getzMnt() {
		
	
		return zMnt;
	}

	/**
	 * @param zMnt the zMnt to set
	 */
	public void setzMnt(BigDecimal zMnt) {
	
		this.zMnt = zMnt;
	}

	
	public void setDatReg(Date datReg) {
		this.datReg = datReg;
	}



	public Date getDatReg() {
		return datReg;
	}


	public Eleve getEleve() {
		return eleve;
	}


	public String getTypePaiment() {
		return typePaiment;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Reglement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public BigDecimal getzMntTmp() {
		return zMntTmp;
	}


	public void setzMntTmp(BigDecimal zMntTmp) {
		this.zMntTmp = zMntTmp;
	}


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return "Etudiant  "+eleve.getMatricule()+"-"+eleve.getNom();
	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	
	

}
