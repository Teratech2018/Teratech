/**
 * 
 */
package com.kerenedu.inscription;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
//
// @Table
// @Entity(name = "e_inscription")
public class ChangeClasse extends BaseElement implements Serializable, Comparable<ChangeClasse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -611584757430488135L;

	@Transient
	@ManyToOne
	@JoinColumn(name = "SECTION_ID")
	@Predicate(label = "Section", type = SectionE.class, target = "many-to-one", optional = false, sequence = 1 ,editable=false)
	private SectionE section;

	@Transient
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Elève", updatable = true, type = Eleve.class, target = "many-to-one", search = true, sequence = 2,editable=false)
	protected Eleve eleve;

	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Ancienne Classe", type = Classe.class, target = "many-to-one", search = true, sequence = 3, observable = true,editable=false)
	@Filter(value = "[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe;

	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Nouvelle Classe", type = Classe.class, target = "many-to-one", search = true, sequence = 4, observable = true, optional=false)
	@Filter(value = "[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe newclasse;
	
	@Predicate(label = "Nouvelle Classe", type = Long.class, hide=true, sequence=5)
	public long idIns;

	public ChangeClasse() {
		// TODO Auto-generated constructor stub
	}

	public ChangeClasse(ChangeClasse ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);

		if (ins.getClasse() != null) {
			this.classe = ins.getClasse();
		}

		if (ins.getNewclasse() != null) {
			this.newclasse = ins.getNewclasse();
			this.section = ins.getClasse().getSection();
		}
		this.eleve = ins.getEleve();
		this.idIns = ins.getIdIns();

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ChangeClasse o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public SectionE getSection() {
		return section;
	}

	public void setSection(SectionE section) {
		this.section = section;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Classe getNewclasse() {
		return newclasse;
	}

	public void setNewclasse(Classe newclasse) {
		this.newclasse = newclasse;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public long getIdIns() {
		return idIns;
	}

	public void setIdIns(long idIns) {
		this.idIns = idIns;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Changer de Classe";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Changer de Classe";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

}
