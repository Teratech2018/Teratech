/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_INSOLP")
public class IndiceSolde extends BaseElement implements Serializable, Comparable<IndiceSolde> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4984717716206273959L;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;	

	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubrique",type=Rubrique.class,target="many-to-one",optional=false,search=true)
	private Rubrique rubrique ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date début",type=Date.class,target="date",optional=false,search=true)
	private Date debut ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date fin",type=Date.class,target="date",optional=false,search=true)
	private Date fin ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="INSOLP_ID")
	@Predicate(label="Indice Solde",type=LigneIndiceSolde.class,target="one-to-many",edittable=true,group=true,groupLabel="Indices de solde",groupName="group1")
	private List<LigneIndiceSolde> indicessolde = new ArrayList<LigneIndiceSolde>();
	
	private String state = "etabli";
	

	/**
	 * 
	 */
	public IndiceSolde() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public IndiceSolde(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
/**
 * 
 * @param id
 * @param designation
 * @param moduleName
 * @param code
 * @param mode
 * @param rubrique
 * @param debut
 * @param fin
 * @param indicessolde
 * @param convensions
 */
	public IndiceSolde(long id, String designation, String moduleName, String code, String mode, Rubrique rubrique,
			Date debut, Date fin, List<LigneIndiceSolde> indicessolde, List<LigneConvension> convensions) {
		super(id, designation, moduleName,0L);
		this.code = code;
//		this.mode = mode;
		this.rubrique = rubrique;
		this.debut = debut;
		this.fin = fin;
		this.indicessolde = indicessolde;
//		this.convensions = convensions;
	}

	/**
	 * 
	 * @param indice
	 */
	public IndiceSolde(IndiceSolde indice) {
		super(indice.id, indice.designation, indice.moduleName,indice.compareid);
		this.code = indice.code;
//		this.mode = indice.mode;
		if(indice.rubrique!=null){
			this.rubrique = new Rubrique(indice.rubrique);
		}
		this.debut = indice.debut;
		this.fin = indice.fin;
        this.state = indice.state;
	}
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public List<LigneIndiceSolde> getIndicessolde() {
		return indicessolde;
	}

	public void setIndicessolde(List<LigneIndiceSolde> indicessolde) {
		this.indicessolde = indicessolde;
	}

	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Indice de Solde";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Indices de Solde";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("active", "Actif");
		states.add(state);
		state = new State("inactive", "Inactif");
		states.add(state);
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IndiceSolde o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
