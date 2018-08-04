/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.tools.DateHelper;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.JoursCours;
import com.kerenedu.personnel.TrancheHoraireCours;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_zview_emarg")
public class ViewEmargement extends BaseElement implements Serializable, Comparable<ViewEmargement> {

		
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
		
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;

	@ManyToOne
	@JoinColumn(name="JOUR_ID")
	private JoursCours jours ;
	
	@ManyToOne
	@JoinColumn(name="TH_ID")
	private TrancheHoraireCours tranche ;
	

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	

	
	


	public ViewEmargement() {
		// TODO Auto-generated constructor stub
	}


	public ViewEmargement(ViewEmargement ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
			this.section=ins.classe.getSection();
		}
		this.anneScolaire=ins.anneScolaire;
		if(ins.tranche!=null){
			this.tranche= new TrancheHoraireCours(ins.tranche);
		}
		if(ins.jours!=null){
			this.jours= new JoursCours(ins.jours);
		}
		
	
		
	}
	

	public ViewEmargement(Inscription ins) {
		this.id=ins.getId();
		this.designation=ins.getDesignation();
		
		this.classe = new Classe(ins.getClasse());
	
		this.anneScolaire=ins.getAnneScolaire();
		
	}




	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewEmargement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Emargement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Emargement";
	}

	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public JoursCours getJours() {
		return jours;
	}


	public void setJours(JoursCours jours) {
		this.jours = jours;
	}


	public TrancheHoraireCours getTranche() {
		return tranche;
	}


	public void setTranche(TrancheHoraireCours tranche) {
		this.tranche = tranche;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}
	




	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}





	


}
