/**
 * 
 */
package com.keren.kerenpaie.model.comptabilite;

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
@Table(name="T_CBANCAIRE")
public class CompteBancaire extends BaseElement implements Serializable, Comparable<CompteBancaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5128243321703453664L;
	
	@Predicate(label = "Numéro de compte",optional = false,unique = true,search =true )
    private String numero ;
	
	 @Predicate(label = "Principal",type=Boolean.class,search =true )
	    private Boolean principal = Boolean.FALSE;
    
    @Predicate(label = "Banque",optional = false,unique = true,type = Banque.class,target = "many-to-one",search = true)
    @ManyToOne
    @JoinColumn(name = "CB_ID")
    private Banque banque;
    
   

	/**
	 * 
	 */
	public CompteBancaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CompteBancaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public CompteBancaire(CompteBancaire comp) {
		super(comp.id, comp.designation, comp.moduleName,comp.compareid);
		this.numero = comp.numero;
		this.banque = comp.banque;
		this.principal = comp.principal;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	
	

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	
	

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "COMPTE BANCAIRE";
	}

	

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return numero;
	}

	@Override
	public int compareTo(CompteBancaire o) {
		// TODO Auto-generated method stub
		return numero.compareTo(o.numero);
	}

}
