/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_eltsallgn")
public class EltSalaireLigne extends BaseElement implements Serializable, Comparable<EltSalaireLigne> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -12411984333486963L;

	@ManyToOne
	@JoinColumn(name = "PER_ID")
	@Predicate(label = "Personnel", type = Professeur.class, target = "many-to-one", updatable = true, optional = false, search = true, sequence = 1)
	private Professeur personnel;

	@Column(name = "NH_T")
	@Predicate(label = "Nombre Heure  ", type = Double.class, editable = true, updatable = true)
	private Double nbt = 0.0;

	@Column(name = "TAUX_H")
	@Predicate(label = "Taux Horaire", type = Double.class, editable = false, updatable = false)
	private Long th = (long) 0;

	/**
	 * 
	 */
	public EltSalaireLigne() {
		// TODO Auto-generated constructor stub
	}

	public EltSalaireLigne(Professeur personnel, Double nbt, Long th) {
		super();
		this.personnel = personnel;
		this.nbt = nbt;
		this.th = th;
	}

	public EltSalaireLigne(EltSalaireLigne entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);

		if (entity.personnel != null) {
			this.personnel = new Professeur(entity.personnel);
		}
		this.nbt = entity.nbt;
		this.th = entity.th;
	}
	
	public EltSalaireLigne(Professeur entity) {
		super(-1, null, null, 0L);

		this.personnel = new Professeur(entity);
		this.nbt = (double) 0;
		this.th = entity.getThoraire();
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EltSalaireLigne(long id, String designation, String moduleName) {
		super(id, designation, moduleName, 0L);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Ligne";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ligne";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return personnel.getDesignation();
	}

	public int compareTo(EltSalaireLigne o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Professeur getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Professeur personnel) {
		this.personnel = personnel;
	}

	public Double getNbt() {
		return nbt;
	}

	public void setNbt(Double nbt) {
		this.nbt = nbt;
	}

	public Long getTh() {
		return th;
	}

	public void setTh(Long th) {
		this.th = th;
	}

}
