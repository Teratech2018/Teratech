/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import com.core.base.BaseElement;

/**
 * @author ntchuente
 *
 */


public class RemiseEval extends BaseElement implements Serializable, Comparable<RemiseEval> {

	
		
	@Column(name = "Montant" )	
	protected Long Zvaleur ;
	
	@Column(name = "MontantExact" )	
	protected Long ZExact ;
	
		


	public RemiseEval() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	



	public RemiseEval(RemiseEval remiseval) {
		this.ZExact= remiseval.ZExact;
		this.Zvaleur= remiseval.Zvaleur;
	}








	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(RemiseEval o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Remies ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Remises  ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return id+" ";
	}








	public Long getZvaleur() {
		return Zvaleur;
	}








	public void setZvaleur(Long zvaleur) {
		Zvaleur = zvaleur;
	}








	public Long getZExact() {
		return ZExact;
	}








	public void setZExact(Long zExact) {
		ZExact = zExact;
	}








		

}
