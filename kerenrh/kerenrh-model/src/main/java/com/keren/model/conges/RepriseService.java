/**
 * 
 */
package com.keren.model.conges;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_REPSERRH")
public class RepriseService extends BaseElement implements Serializable, Comparable<RepriseService> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 3332914649204491901L;
	
	@Predicate(label="N. Reprise",optional=false,unique=true,search=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de reprise",type=Date.class,target="date",optional=false,nullable=false,search=true)
	private Date date ;

	@ManyToOne
	@JoinColumn(name="CON_ID")
	@Predicate(label="Congé concerné",type=DemandeConge.class,target="many-to-one",search=true, observable = true)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"valider\"}]")
	private DemandeConge conge;
		
	@Predicate(label="Employe",type=Employe.class,target="many-to-one",optional=true,nullable=false,search=true,editable=false)
        @Observer(observable = "conge",source = "field:employe")
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employe employe ;
	
	@Predicate(label="Statut",hide=true, search=true)
	private String state = "etabli";
	

	/**
	 * 
	 */
	public RepriseService() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public RepriseService(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
		state = "etabli";
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param date
	 * @param employe
	 * @param conge
	 */
	public RepriseService(long id, String designation, String moduleName, String code, Date date, Employe employe,
			DemandeConge conge) {
		super(id, designation, moduleName);
		this.code = code;
		this.date = date;
		this.employe = employe;
		this.conge = conge;
		state = "etabli";
	}
	
	public RepriseService(RepriseService reprise) {
		super(reprise.id, reprise.designation, reprise.moduleName);
		this.code = reprise.code;
		this.date = reprise.date;
		state = reprise.state;
		if(reprise.employe!=null){
		this.employe = new Employe(reprise.employe);
		}
		if(reprise.conge!=null){
			this.conge = new DemandeConge(reprise.conge);
		}
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public DemandeConge getConge() {
		return conge;
	}

	public void setConge(DemandeConge conge) {
		this.conge = conge;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "REPRISE DU SERVICE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "REPRISES DU SERVICE";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" / "+conge.getEmploye().getDesignation();
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
		State etat = new State("etabli", "Brouillon");
		states.add(etat);
		etat = new State("confirmer", "Validé");
		states.add(etat);		
	return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(RepriseService o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
