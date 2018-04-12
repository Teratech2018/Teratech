/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_PARTSEARH")
public class ParticipantSeance extends BaseElement implements Serializable, Comparable<ParticipantSeance> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869645255912285834L;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe salarie ;
	
	@Predicate(label="Est présent?",type=Boolean.class,search=true)
	private Boolean present = Boolean.FALSE;

	/**
	 * 
	 */
	public ParticipantSeance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ParticipantSeance(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param salarie
	 * @param present
	 */

	public ParticipantSeance(long id, String designation, String moduleName, Employe salarie, Boolean present) {
		super(id, designation, moduleName);
		this.salarie = salarie;
		this.present = present;
	}
	
	public ParticipantSeance(ParticipantSeance part) {
		super(part.id, part.designation, part.moduleName);
		if(part.salarie!=null){
			this.salarie = new Employe(part.salarie);
		}
		this.present = part.present;
	}
	
	

	public Employe getSalarie() {
		return salarie;
	}

	public void setSalarie(Employe salarie) {
		this.salarie = salarie;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Participant";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Participants";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return salarie.getDesignation();
	}
	
	

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ParticipantSeance o) {
		// TODO Auto-generated method stub
		return salarie.compareTo(o.salarie);
	}

}
