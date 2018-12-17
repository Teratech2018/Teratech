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

@Table
@Entity(name = "e_abs")
public class Abscence extends BaseElement implements Serializable, Comparable<Abscence> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426874191351556828L;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Séquence",type=Examen.class,target="many-to-one",optional=false, sequence=1, search=true)
	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	private Examen periode ;
	
	@Column(name = "DATE_ABS")
	//@Predicate(label="DATE ABSCENCE",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datAbs;
	
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	//@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=true, sequence=3)
	private SectionE section ;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	//@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ID_ABS")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Elèves Concernés",target ="one-to-many",type = LigneAbscence.class,search = false, edittable=true)
	@Observer(observable="classe",source="method:findeleveclasse",parameters="classe")
	private List<LigneAbscence> abscences = new ArrayList<LigneAbscence>();
	
	@Column(name = "OBS")
	@Predicate(group = true, groupName = "tab2", groupLabel = "Observation", target = "textarea", search = false, sequence=7)
	protected String observation;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	@Column(name = "ETAT")
	@Predicate(label = "Etat", hide = true, search = true)
	private String state = "etabli";

	

	

	public Abscence() {
		state = "etabli";

	}




	public Abscence(Date datAbs, Classe classe, List<LigneAbscence> abscences, String observation,
			String anneScolaire) {
		super();
		this.datAbs = datAbs;
		this.classe = classe;
		this.abscences = abscences;
		this.observation = observation;
		this.anneScolaire = anneScolaire;
		state = "etabli";
		
	}




	public Abscence(Abscence ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datAbs = ins.datAbs;
		this.observation = ins.observation;
		if(ins.getClasse()!=null){
			this.classe = new Classe(ins.classe);
			this.section= new SectionE(ins.getClasse().getSection());
		}
		
		this.abscences = new ArrayList<LigneAbscence>();
		this.anneScolaire=ins.anneScolaire;
		state = ins.state;
		if(ins.getPeriode()!=null){
			this.periode= new Examen(ins.getPeriode());
		}
		this.state=ins.state;
	
	}


	public Date getDatAbs() {
		return datAbs;
	}


	public void setDatAbs(Date datAbs) {
		this.datAbs = datAbs;
	}




	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public List<LigneAbscence> getAbscences() {
		return abscences;
	}




	public void setAbscences(List<LigneAbscence> abscences) {
		this.abscences = abscences;
	}




	public int compareTo(Abscence o) {
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
		return  " /de "+periode.getDesignation()+"Classe de /"+classe.getLibelle();
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
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

	public SectionE getSection() {
		return section;
	}




	public void setSection(SectionE section) {
		this.section = section;
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
