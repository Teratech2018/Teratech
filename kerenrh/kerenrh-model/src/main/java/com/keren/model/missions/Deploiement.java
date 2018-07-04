/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Ville;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEPLOIRH")
public class Deploiement extends BaseElement implements Serializable, Comparable<Deploiement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8230053728158449101L;
	
	@ManyToOne
	@JoinColumn(name="SAL_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe salarie ;
	
	@ManyToOne
	@JoinColumn(name="VIL_ID")
	@Predicate(label="Ville",type=Ville.class,target="many-to-one",optional=false,search=true)
	private Ville ville ;
	
	@Predicate(label="Date de début",type=Date.class,target="date",optional=false,search=true)
	private Date ddebut ;
	
	@Predicate(label="Date de fin",type=Date.class,target="date",optional=false,search=true)
	private Date dfin ;

	/**
	 * 
	 */
	public Deploiement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Deploiement(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param salarie
	 * @param ville
	 * @param ddebut
	 * @param dfin
	 */

	public Deploiement(long id, String designation, String moduleName, Employe salarie, Ville ville, Date ddebut,
			Date dfin) {
		super(id, designation, moduleName,0L);
		this.salarie = salarie;
		this.ville = ville;
		this.ddebut = ddebut;
		this.dfin = dfin;
	}
	
	/**
	 * 
	 * @param deploie
	 */
	public Deploiement(Deploiement deploie) {
		super(deploie.id, deploie.designation, deploie.moduleName,deploie.compareid);
		if(deploie.salarie!=null){
			this.salarie = new Employe(deploie.salarie);
		}//end if(deploie.salarie!=null){
		this.ville = deploie.ville;
		this.ddebut = deploie.ddebut;
		this.dfin = deploie.dfin;
	}

	
	
	public Employe getSalarie() {
		return salarie;
	}

	public void setSalarie(Employe salarie) {
		this.salarie = salarie;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Date getDdebut() {
		return ddebut;
	}

	public void setDdebut(Date ddebut) {
		this.ddebut = ddebut;
	}

	public Date getDfin() {
		return dfin;
	}

	public void setDfin(Date dfin) {
		this.dfin = dfin;
	}

	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Plan deploiement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Plan deploiement";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
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
	public int compareTo(Deploiement o) {
		// TODO Auto-generated method stub
		return salarie.compareTo(o.salarie);
	}

}
