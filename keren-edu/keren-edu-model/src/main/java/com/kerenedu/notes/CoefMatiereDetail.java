/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_coefmatdtl")
public class CoefMatiereDetail extends BaseElement implements Serializable, Comparable<CoefMatiereDetail> {

	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	@Predicate(label = "Matiere", target = "many-to-one", type = Matiere.class, search = true, optional=false, editable = false, sequence = 1, colsequence = 1)
	private Matiere matiere= new Matiere() ;

	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "PROF.", target = "many-to-one", type = Professeur.class, search = true, sequence = 2, colsequence = 2)
	private Professeur proffesseur;

	@Column(name = "COEF")
	@Predicate(label = "Coef", type = Long.class, search = true, sequence = 3, colsequence = 3)
	private Long coef = new Long(0);
	
	@Column(name = "HEURE_TOTAL")
	@Predicate(label="HEURE TOTAL",optional=true,updatable=true,search=true, type=Long.class , sequence=4)
	protected Long heuretotal=new Long(0);
	
	@Column(name = "COUT_HEURE")
	@Predicate(label="COUT/HEURE",optional=true,updatable=true,search=true, type=Long.class, sequence=5)
	protected Long coutheure=new Long(0);

	@ManyToOne 
    @JoinColumn(name = "CLASSE_ID")
	private Classe classe ;
	
	public CoefMatiereDetail() {
		super();
	}

	public CoefMatiereDetail(CoefMatiereDetail cmatdetail) {
		super(cmatdetail.id, cmatdetail.designation, cmatdetail.moduleName);
		this.matiere = new Matiere(cmatdetail.matiere);
		this.proffesseur= new Professeur(cmatdetail.proffesseur);
		this.coutheure=cmatdetail.coutheure;
		this.heuretotal=cmatdetail.heuretotal;
		this.coef = cmatdetail.coef;
		if(cmatdetail.classe!=null){
		this.classe=new Classe( cmatdetail.classe);
		}

	}

	public CoefMatiereDetail(Matiere matiere) {
		this.matiere = new Matiere(matiere);
		this.coef = new Long(0);
		this.coutheure=new Long(0);
		this.heuretotal=new Long(0);

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return " Affectation des Coeficient et professeurs";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Coeficient Matiere";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return matiere.getDesignation();
	}

	public Long getCoef() {
		return coef;
	}

	public void setCoef(Long coef) {
		this.coef = coef;
	}

	public Professeur getProffesseur() {
		return proffesseur;
	}

	public void setProffesseur(Professeur proffesseur) {
		this.proffesseur = proffesseur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Long getHeuretotal() {
		return heuretotal;
	}

	public void setHeuretotal(Long heuretotal) {
		this.heuretotal = heuretotal;
	}

	public Long getCoutheure() {
		return coutheure;
	}

	public void setCoutheure(Long coutheure) {
		this.coutheure = coutheure;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public int compareTo(CoefMatiereDetail o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
