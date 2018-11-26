/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_bulvar")
public class LigneElementVariable extends BaseElement implements Serializable, Comparable<LigneElementVariable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6230563192447407792L;
	
	@ManyToOne
	@JoinColumn(name="VAR_ID")
	@Predicate(label="Variable de paie",type=Variable.class,target="many-to-one",optional=false,search=true)
	private Variable variable ;
	
	@Predicate(label="Valeur",type=Double.class,search=true)
	private Double valeur = 0.0;
	

	/**
	 * 
	 */
	public LigneElementVariable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneElementVariable(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * 
	 * @param variable
	 */
	public LigneElementVariable(LigneElementVariable variable) {
		super(variable.id, variable.designation, variable.moduleName,variable.compareid);
		if(variable.variable!=null){
			this.variable = new Variable(variable.variable);//.code;
		}
		this.valeur = variable.valeur;
	}
	
	

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	
	

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Variable ";
	}
	
	

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return variable.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(LigneElementVariable arg0) {
		// TODO Auto-generated method stub
		return variable.compareTo(arg0.variable);
	}

}
