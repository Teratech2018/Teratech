/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
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
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.solde.ParaCoutMatiere;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_emarge_dlt_periode")
public class EmargementDtlPeriode extends BaseElement implements Serializable, Comparable<EmargementDtlPeriode> {
	

	@Column(name = "MATIERE")
	//@Predicate(label = "Matiere", optional = false, updatable = true, search = true, sequence = 1)
	protected String matiere;
	
	@Column(name = "MAT")
	@Predicate(label = "Matricule", optional = true, updatable = true, search = true, sequence = 2,editable=false)
	protected String matricule;

	@Column(name = "NOM")
	@Predicate(label = "NOM", optional = false, updatable = true, search = true, sequence = 3)
	protected String nom;
	
	
	@ManyToOne
	@JoinColumn(name = "P_ID")
	//@Predicate(label="Professeur",updatable=false,type=ProfesseurChoice.class , target="many-to-one",search=true , sequence=1	,colsequence=1,hide=true)
	protected Professeur prof;
	

	@ManyToOne
	@JoinColumn(name = "MAT_COUT_ID")
	//@Predicate(label="Professeur",updatable=false,type=ProfesseurChoice.class , target="many-to-one",search=true , sequence=1	,colsequence=1,hide=true)
	protected ParaCoutMatiere cout;

	
	@Column(name = "HTEMARG")
	@Predicate(label="Presence",updatable=false,search=true,  sequence=5, type=Double.class,colsequence=5)
	protected Double presence;
	
	@Column(name = "HTERETARD")
	@Predicate(label="Retard",updatable=false,search=true,  sequence=5, type=Double.class,colsequence=6)
	protected Double retard;
	
	@Column(name = "STATUT")
	@Predicate(label="Statut",type=Boolean.class,search=true,colsequence=7)
	private Boolean statut = Boolean.FALSE;
	
	@ManyToOne
	@JoinColumn(name="PERIODE_ID")
	@Predicate(label="Periode",type=PeriodePaie.class,target="many-to-one",optional=true, sequence=3, observable=true, search=true,colsequence=3)
	private PeriodePaie periode ;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	//@Predicate(label="Date de debut",type=Date.class,target="date",search=true, sequence=3)
	private Date dsaisie;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;


	public EmargementDtlPeriode() {
		super();
		// TODO Auto-generated constructor stub
	}





	

	public EmargementDtlPeriode(Professeur prof, Double heuretotal, Boolean statut) {
		super();
		this.prof = prof;
	//	this.heuretotal = heuretotal;
		this.statut = statut;
		
	}




	public EmargementDtlPeriode(EmargementDtlPeriode entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		if(entity.prof!=null){
		//this.prof = new EnseignantSecondaire(entity.prof) ;
		
		}
		this.matricule=entity.matricule;
		this.nom=entity.nom;
		if(entity.periode!=null){
			this.periode= new PeriodePaie(entity.periode);
			}
		if(entity.cout!=null){
			this.cout= new ParaCoutMatiere(entity.cout);
			}
		this.presence = entity.presence;
		this.retard = entity.retard;
		this.statut = entity.statut;
		this.matiere=entity.matiere;
		this.anneScolaire=entity.anneScolaire;
		
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EmargementDtlPeriode o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des Heures";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des Heures";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return id+"";
	}



	public Boolean getStatut() {
		return statut;
	}


	public void setStatut(Boolean statut) {
		this.statut = statut;
	}



	public Professeur getProf() {
		return prof;
	}







	public void setProf(Professeur prof) {
		this.prof = prof;
	}







	public String getMatricule() {
		return matricule;
	}







	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}







	public String getNom() {
		return nom;
	}







	public void setNom(String nom) {
		this.nom = nom;
	}







	public PeriodePaie getPeriode() {
		return periode;
	}







	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}







	public Double getPresence() {
		return presence;
	}







	public String getMatiere() {
		return matiere;
	}







	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}







	public ParaCoutMatiere getCout() {
		return cout;
	}







	public void setCout(ParaCoutMatiere cout) {
		this.cout = cout;
	}







	public void setPresence(Double presence) {
		this.presence = presence;
	}







	public Double getRetard() {
		return retard;
	}







	public String getAnneScolaire() {
		return anneScolaire;
	}







	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}







	public void setRetard(Double retard) {
		this.retard = retard;
	}

	public Date getDsaisie() {
		return dsaisie;
	}







	public void setDsaisie(Date dsaisie) {
		this.dsaisie = dsaisie;
	}







	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		this.searchkeys = matricule+ "  " +nom+" , " +anneScolaire;
		return matricule+ "  " +nom+" , " +anneScolaire;
	}

}
