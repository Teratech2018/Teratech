/**
 * 
 */
package com.keren.model.conges;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Departement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DECORH")
public class DemandeCongeC extends BaseElement  implements Serializable,Comparable<DemandeCongeC>{

	/**
	 * 
	 */
	protected static final long serialVersionUID = 7741105795796486143L;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,search=true)
	protected Employe employe ;
	
	@ManyToOne
	@JoinColumn(name="TYP_ID")
	@Predicate(label="Type de congé",type=TypeConge.class,target="many-to-one",optional=false,search=true)
	private TypeConge type ;
	
	@ManyToOne
	@JoinColumn(name="DEPE_ID")
	@Predicate(label="Département",type=Departement.class,target="many-to-one",optional=false,search=true)
	protected Departement departement ;
	
	@Predicate(label="Nombre de jours possible",type=Short.class,optional=true,search=true, editable=true, hide=true)
	protected Short joursp = 0;
	 
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de debut",type=Date.class,target="date",optional=false,search=true)
	protected Date debut ;

	@Predicate(label="Durée du congé",type=Short.class,optional=true,search=true ,editable=false)
	protected Short duree ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date Fin",type=Date.class,target="date",optional=false,search=false ,editable=true)
	protected Date fin ;
	
	
	@Temporal(TemporalType.DATE)
	protected Date finEffetif ;
	
	@Predicate(label="Mode de compensation",target="combobox",values="Acune;Sur salaire;Sur congé annuel",group=true,groupName="group1",groupLabel="COMPENSATION")
	protected String compensation = "0";
	
	@Predicate(label="Motif",target="textarea",group=true,groupName="group2",groupLabel="Motif")
	protected String motif;
	
	protected String state ;

	/**
	 * 
	 */
	public DemandeCongeC() {
		// TODO Auto-generated constructor stub
		this.state = "confirmer";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeCongeC(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		this.state = "confirmer";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public DemandeCongeC(DemandeCongeC dc) {
		super(dc.id, dc.designation, dc.moduleName);
		this.employe = new Employe(dc.employe);
		this.type = new TypeConge(dc.type);
		if(dc.getDepartement()!=null){
			this.departement = new Departement(dc.departement);
		}
		this.joursp = dc.joursp;
		this.debut = dc.debut;
		this.fin=dc.fin;
		this.duree = dc.duree;
		this.compensation = dc.compensation;
		this.motif = dc.motif;
		this.state = dc.state;
		// TODO Auto-generated constructor stub
	}
	

	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public TypeConge getType() {
		return type;
	}

	public void setType(TypeConge type) {
		this.type = type;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Short getJoursp() {
		return joursp;
	}

	public void setJoursp(Short joursp) {
		this.joursp = joursp;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Date getFinEffetif() {
		return finEffetif;
	}

	public void setFinEffetif(Date finEffetif) {
		this.finEffetif = finEffetif;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
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
		return "DEMANDE DE CONGE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "DEMANDES DE CONGE";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
	}


	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}



		@Override
	public String getSerial() {
		// TODO Auto-generated method stub
	    serial = Long.toString(serialVersionUID);
		return serial;
	}

	


	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "A soumettre");
			states.add(etat);
			etat = new State("confirmer", "A approuvée");
			states.add(etat);
			etat = new State("valider", "Approuvée");
			states.add(etat);
			etat = new State("rejete", "Rejetée");
			states.add(etat);
		return states;
	}
	
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(DemandeCongeC arg0) {
		// TODO Auto-generated method stub
		return employe.compareTo(arg0.employe);
	}


}
