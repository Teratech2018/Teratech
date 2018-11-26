/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.core.tools.DateHelper;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_abs")
public class AbscenceModal extends BaseElement implements Serializable, Comparable<AbscenceModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426874191351556828L;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Séquence",type=Examen.class,target="many-to-one",optional=false, sequence=1)
	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	private Examen periode ;
	
	

	

	

	public AbscenceModal() {
	

	}





	public AbscenceModal(AbscenceModal ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.getPeriode()!=null){
			this.periode= new Examen(ins.getPeriode());
		}
	
	
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}




	public int compareTo(AbscenceModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gérer les Abscences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gérer les Abscences";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return  " ";
	}


	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State etat = new State("etabli", "Brouillon");
		states.add(etat);
		etat = new State("valider", "Validée");
		states.add(etat);
		return states;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	



	public Examen getPeriode() {
		return periode;
	}




	public void setPeriode(Examen periode) {
		this.periode = periode;
	}




	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
