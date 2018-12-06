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
public class ViewListingPModal extends BaseElement implements Serializable, Comparable<ViewListingPModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", updatable = true, type = Classe.class, target = "many-to-one", search = true ,sequence=1)
	protected Classe classe;
	
	@Column(name = "TYP_PAI")
	@Predicate(label = "Type Paiement", optional = false, updatable = true, search = true, target = "combobox", values = "especes;Espress Union", colsequence = 6, sequence = 6)
	protected String typePaiment = "0";

	


	public ViewListingPModal(Inscription inscription, FichePaiement fiche, Service service, Classe classe, Eleve eleve,
			String libelle, Long ztotal, Long mntpayer, Long solde, Date delai) {
		super();
		this.classe = classe;

	}

	public ViewListingPModal() {
		// TODO Auto-generated constructor stub
	}

	public ViewListingPModal(ViewListingPModal ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		if(ins.getClasse()!=null){
		this.classe = new Classe(ins.getClasse());
		}
		this.typePaiment=ins.typePaiment;
;


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

	public int compareTo(ViewListingPModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Listing des Paiements: Selectionnez les critères";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Listing des Paiements";
	}

	public String getTypePaiment() {
		return typePaiment;
	}

	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
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
