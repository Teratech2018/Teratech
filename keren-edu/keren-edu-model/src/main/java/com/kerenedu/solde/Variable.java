/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Etablissement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */

@Entity
@Table(name="e_vari")
public class Variable extends BaseElement implements Serializable, Comparable<Variable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -144041932834708394L;
	
	@Predicate(label="Nom",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Propre au salarié",type=Boolean.class)
	private Boolean salarie = Boolean.FALSE;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Dossier de paie",type=Etablissement.class,target="many-to-one",search=true)
	private Etablissement societe ;
	
	@Predicate(label="Description",search=true)
	private String description;
	
	@Predicate(label="Report du cumul a la cloture",type=Boolean.class)
	private Boolean repannuel = Boolean.FALSE;
	
	@Predicate(label="Report mensuel",type=Boolean.class)
	private Boolean repmens = Boolean.TRUE;
	
	@Predicate(label="Type de variable",target="combobox",values="Variable système;Variable système calculée;Constante;Variable")
	private String typevar = "0";
	
	@Predicate(label="Methode de Calcul",target="combobox",values="Constante;Automatique;Formule de calcul")
	private String methodcal = "0";
	
	@Predicate(label="Type de Formule",target="combobox",values="Expression Arithmetique;SI Expression",hidden="currentObject.methodcal!='2'")
	private String typeformule = "0";
	
	@Predicate(label="Formule",target="aceeditor",group=true,groupName="group1",groupLabel="Formule",search=true,hidden="currentObject.methodcal=='1'")
	@Lob	
	private String formule;

	/**
	 * 
	 */
	public Variable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Variable(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param societe
	 * @param description
	 * @param repannuel
	 * @param repmens
	 * @param typevar
	 * @param methodcal
	 * @param formule
	 */
	public Variable(long id, String designation, String moduleName, String code, Etablissement societe, String description,
			Boolean repannuel, Boolean repmens, String typevar, String methodcal, String formule) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.societe = societe;
		this.description = description;
		this.repannuel = repannuel;
		this.repmens = repmens;
		this.typevar = typevar;
		this.methodcal = methodcal;
		this.formule = formule;
	}
	
	/**
	 * 
	 * @param var
	 */
	public Variable(Variable var) {
		super(var.id, var.designation, var.moduleName,var.compareid);
		this.code = var.code;
		if(var.societe!=null){
			this.societe = new Etablissement(var.societe);
		}
		this.description = var.description;
		this.repannuel = var.repannuel;
		this.repmens = var.repmens;
		this.typevar = var.typevar;
		this.methodcal = var.methodcal;
		this.formule = var.formule;
		this.salarie = var.salarie;
		this.typeformule = var.typeformule;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Etablissement getSociete() {
		return societe;
	}

	public void setSociete(Etablissement societe) {
		this.societe = societe;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getRepannuel() {
		return repannuel;
	}

	public void setRepannuel(Boolean repannuel) {
		this.repannuel = repannuel;
	}

	public Boolean getRepmens() {
		return repmens;
	}

	public void setRepmens(Boolean repmens) {
		this.repmens = repmens;
	}

	public String getTypevar() {
		return typevar;
	}

	public void setTypevar(String typevar) {
		this.typevar = typevar;
	}

	public String getMethodcal() {
		return methodcal;
	}

	public void setMethodcal(String methodcal) {
		this.methodcal = methodcal;
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}
	
	

	public String getTypeformule() {
		return typeformule;
	}

	public void setTypeformule(String typeformule) {
		this.typeformule = typeformule;
	}

	public Boolean getSalarie() {
		return salarie;
	}

	public void setSalarie(Boolean salarie) {
		this.salarie = salarie;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Variable de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Variables de paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+description;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(Variable arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
