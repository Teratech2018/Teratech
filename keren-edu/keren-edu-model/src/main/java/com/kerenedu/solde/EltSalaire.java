/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_eltSal")
public class EltSalaire extends BaseElement implements Serializable, Comparable<EltSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -12411984333486963L;

	@ManyToOne
	@JoinColumn(name = "PER_ID")
	@Predicate(label = "Periode", type = PeriodePaie.class, target = "many-to-one", updatable = false, optional = false, search = true, sequence = 1, observable=true)
	private PeriodePaie periode;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "LGN_SAL_ID")
	@Predicate(label = "Personnel", type = EltSalaireLigne.class, target = "one-to-many", updatable = false, editable = false, group = true, groupName = "group1", groupLabel = "Employés cornernés", edittable = true)
	@Observer(observable="periode",source="method:findpersonnel")
	private List<EltSalaireLigne> listemploye;

	
    @Predicate(label = "Statut",search = true,hide = true, sequence=7)
	private String state="etabli";

	    
	/**
	 * 
	 */
	public EltSalaire() {
		
	}
	

	
	
	public EltSalaire(PeriodePaie periode, List<EltSalaireLigne> listemploye, String state) {
		super();
		this.periode = periode;
		this.listemploye = listemploye;
		this.state = state;
	}




	public EltSalaire(EltSalaire entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		if(entity.periode!=null){
		this.periode = new PeriodePaie(entity.periode) ;
		}
		this.listemploye = new ArrayList<EltSalaireLigne>();
		this.state = entity.state;
	}


	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EltSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	






	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Saisir des Heures Travaillées";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Saisir des Heures Travaillées";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return periode.getDesignation();
	}



	public PeriodePaie getPeriode() {
		return periode;
	}


	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}


	public List<EltSalaireLigne> getListemploye() {
		return listemploye;
	}


	public void setListemploye(List<EltSalaireLigne> listemploye) {
		this.listemploye = listemploye;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int compareTo(EltSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "saisie");
		states.add(state);
		state = new State("validé", "Validé");
		states.add(state);

		return states;
	}
	

}
