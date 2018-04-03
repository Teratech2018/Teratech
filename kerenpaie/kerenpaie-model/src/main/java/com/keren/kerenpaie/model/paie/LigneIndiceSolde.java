/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Echelon;
import com.keren.kerenpaie.model.employes.TypeContrat;
import com.keren.kerenpaie.model.structures.Grade;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity  
@Table(name="T_LIINSOLP")
public class LigneIndiceSolde extends BaseElement implements Serializable, Comparable<LigneIndiceSolde> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2803389900487479120L;	
	
	@ManyToOne
	@JoinColumn(name="ECHE_ID")
	@Predicate(label="Catégorie",type=Echelon.class,target="many-to-one",optional=false,search=true)
	private Echelon echelon ;
	
	@ManyToOne
	@JoinColumn(name="CATE_ID")
	@Predicate(label="Echélon",type=Categorie.class,target="many-to-one",optional=false,search=true)
	private Categorie categorie ;
	
	@Predicate(label="Indice",optional=false,type=Short.class,search=true)
	private Short indice  ;
	
	@ManyToOne
	@JoinColumn(name="TYCO_ID")
	@Predicate(label="Type de Contrat",type=TypeContrat.class,target="many-to-one",optional=false,search=true)
	private TypeContrat contrat ;
	
	@ManyToOne
	@JoinColumn(name="GRAD_ID")
	@Predicate(label="Grade",type=Grade.class,target="many-to-one",search=true)
	private Grade grade ;
	
	@Predicate(label="Salaire de base",optional=false,type=Double.class,search=true)
	private Double salbase =0.0;

	/**
	 * 
	 */
	public LigneIndiceSolde() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneIndiceSolde(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param indice
	 * @param contrat
	 * @param grade
	 * @param salbase
	 */

	public LigneIndiceSolde(long id, String designation, String moduleName, Short indice, TypeContrat contrat,
			Grade grade, Double salbase) {
		super(id, designation, moduleName);
		this.indice = indice;
		this.contrat = contrat;
		this.grade = grade;
		this.salbase = salbase;
	}
	
	/**
	 * 
	 * @param indice
	 * @param contrat
	 * @param grade
	 * @param salbase
	 */
	public LigneIndiceSolde(Short indice, TypeContrat contrat,	Grade grade, Double salbase) {
		super(-1, null, null);
		this.indice = indice;
		this.contrat = contrat;
		this.grade = grade;
		this.salbase = salbase;
	}
	
	/**
	 * 
	 * @param ligne
	 */
	public LigneIndiceSolde(LigneIndiceSolde ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName);
		this.indice = ligne.indice;
		this.contrat = ligne.contrat;
		this.grade = ligne.grade;
		this.salbase = ligne.salbase;
		if(ligne.categorie!=null){
			this.categorie = new Categorie(ligne.categorie);
		}
		if(ligne.getEchelon()!=null){
			this.echelon = new Echelon(ligne.echelon);
		}
	}
	
	

	public Short getIndice() {
		return indice;
	}

	public void setIndice(Short indice) {
		this.indice = indice;
	}

	public TypeContrat getContrat() {
		return contrat;
	}

	public void setContrat(TypeContrat contrat) {
		this.contrat = contrat;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Double getSalbase() {
		return salbase;
	}

	public void setSalbase(Double salbase) {
		this.salbase = salbase;
	}
	
	

	public Echelon getEchelon() {
		return echelon;
	}

	public void setEchelon(Echelon echelon) {
		this.echelon = echelon;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Indice Solde";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Indices Solde";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LigneIndiceSolde o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "LigneIndiceSolde [echelon=" + echelon + ", categorie=" + categorie + ", indice=" + indice + ", contrat="
				+ contrat + ", grade=" + grade + ", salbase=" + salbase + "] ID = "+id;
	}
	
	

}
