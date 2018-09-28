/**
 * 
 */
package com.kerenedu.solde;

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
@Entity
@Table(name = "e_rub")
public class RubriquePaie extends BaseElement implements Serializable, Comparable<RubriquePaie> {

	@Column(name = "CODE")
	@Predicate(label="Code",optional=false,updatable=false,search=true, sequence=1)
	protected String code;
	
	@Column(name = "DES")
	@Predicate(label="Description",optional=false,updatable=false,search=true, sequence=2)
	protected String desc;
	
	@Predicate(label="Type de rubrique",target="combobox",values="Gain;Retenue",search=true, sequence=3,optional=false)
	private String type ="0";
	
	@Predicate(label="Impression sur le bulletin",target="combobox",values="Jamais;Toujours;si non nul", sequence=4)
	private String porte="0";
	
	@Predicate(label="Base",group=true,groupName="group1",groupLabel="Elements de calcul",search=true, sequence=5,optional=false)
	private String formule;	
	@Predicate(label="Taux salarial(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=6,optional=false)
	private Double tauxsal =0.0;
	
	@Predicate(label="Taux patronal(%)",type=Double.class,group=true,groupName="group1",groupLabel="Elements de calcul", sequence=7,optional=false)
	private Double tauxpat=0.0;
	
	
	

	public RubriquePaie(String code, String desc, String type, String porte, String formule, Double tauxsal,
			Double tauxpat) {
		super();
		this.code = code;
		this.desc = desc;
		this.type = type;
		this.porte = porte;
		this.formule = formule;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
	}
	
	public RubriquePaie(RubriquePaie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.desc = entity.desc;
		this.type = entity.type;
		this.porte = entity.porte;
		this.formule = entity.formule;
		this.tauxsal = entity.tauxsal;
		this.tauxpat = entity.tauxpat;
	}

	public RubriquePaie() {
		// TODO Auto-generated constructor stub
	}

	public int compareTo(RubriquePaie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public Double getTauxsal() {
		return tauxsal;
	}

	public void setTauxsal(Double tauxsal) {
		this.tauxsal = tauxsal;
	}

	public Double getTauxpat() {
		return tauxpat;
	}

	public void setTauxpat(Double tauxpat) {
		this.tauxpat = tauxpat;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Rubrique de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Rubrique de  Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"-"+desc;
	}

}
