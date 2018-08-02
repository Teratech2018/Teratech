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
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_zview_paiement")
public class ViewDltPaiementModal extends BaseElement implements Serializable, Comparable<ViewDltPaiementModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", updatable = true, type = Classe.class, target = "many-to-one", search = true ,sequence=1,searchfields="libelle")
	protected Classe classe;
	
	
	@Predicate(label = "Date Paiement allant du : ", optional = false, updatable = true, search = true, type = Date.class, target = "date" ,sequence=3)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datepaideb;
	
	
	@Predicate(label = "Au:", optional = false, updatable = true, search = true, type = Date.class, target = "date" ,sequence=2)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datepaifin;


	public ViewDltPaiementModal(Inscription inscription, FichePaiement fiche, Service service, Classe classe, Eleve eleve,
			String libelle, Long ztotal, Long mntpayer, Long solde, Date delai) {
		super();
		this.classe = classe;

	}

	public ViewDltPaiementModal() {
		// TODO Auto-generated constructor stub
	}

	public ViewDltPaiementModal(ViewDltPaiementModal ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		this.datepaideb = ins.datepaideb;
		this.datepaifin = ins.datepaifin;
		this.classe = new Classe(ins.getClasse());
;


	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	public Date getDatepaideb() {
		return datepaideb;
	}

	public void setDatepaideb(Date datepaideb) {
		this.datepaideb = datepaideb;
	}

	public Date getDatepaifin() {
		return datepaifin;
	}

	public void setDatepaifin(Date datepaifin) {
		this.datepaifin = datepaifin;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewDltPaiementModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Détails des Paiements: Selectionnez les critères";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Détails des Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}


	


}
