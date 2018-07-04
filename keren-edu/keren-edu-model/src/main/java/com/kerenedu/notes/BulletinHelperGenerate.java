/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_zview_bulletin")
public class BulletinHelperGenerate extends BaseElement implements Serializable, Comparable<BulletinHelperGenerate> {
	

	@ManyToOne
    @JoinColumn(name = "MAT_NOT_ID")
    protected MatiereNote matiere;
	

	@ManyToOne
    @JoinColumn(name = "NOTE_ID")
    protected NoteDetail note;
	
	@ManyToOne
    @JoinColumn(name = "INS_ID")
    protected Inscription inscription;
	
	@Column(name = "MOY_CLA_MATIERE")
	private Long moyclasMat = new Long(0) ;

	@Column(name = "EXTR_MAX")
	private Long extrememax = new Long(0) ;
	
	@Column(name = "EXTR_MIN")
	private Long extremmemin = new Long(0) ;
	
	@Column(name = "TOTAL_POINT")
	private Long totalPoint = new Long(0) ;
	
	@Column(name = "TOTAL_COEF")
	private Long totalCoef = new Long(0) ;
	
	@Column(name = "MOY_ETUDIANT")
	private Long moyEtudiant = new Long(0) ;
	
	@Column(name = "MOY_PREMIER")
	private Long moyPremier = new Long(0) ;
	
	@Column(name = "MOY_DERNIER")
	private Long moyDernnier = new Long(0) ;
	
	@ManyToOne
    @JoinColumn(name = "CLASSE_ID")
    protected Classe classe;
	
	@ManyToOne
    @JoinColumn(name = "MODULE_ID")
    protected GroupeCours module;
	
	@ManyToOne
    @JoinColumn(name = "ELEVE_ID")
    protected Eleve eleve;
	
	public BulletinHelperGenerate() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
	public BulletinHelperGenerate(MatiereNote matiere, NoteDetail note, Long moyclasMat, Long extrememax,
			Long extremmemin, Long totalPoint, Long totalCoef, Long moyEtudiant, Long moyPremier, Long moyDernnier,
			Classe classe, Eleve eleve) {
		super();
		this.matiere = matiere;
		this.note = note;
		this.moyclasMat = moyclasMat;
		this.extrememax = extrememax;
		this.extremmemin = extremmemin;
		this.totalPoint = totalPoint;
		this.totalCoef = totalCoef;
		this.moyEtudiant = moyEtudiant;
		this.moyPremier = moyPremier;
		this.moyDernnier = moyDernnier;
		this.classe = classe;
		this.eleve = eleve;
	}






	public BulletinHelperGenerate(BulletinHelperGenerate bulletin) {
		super(bulletin.id, bulletin.designation,bulletin. moduleName,0L);
		this.note = new NoteDetail(bulletin.note);
		this.matiere = new MatiereNote(bulletin.matiere);
		this.classe = new Classe(bulletin.classe);
		this.eleve = new Eleve(bulletin.eleve);
		this.moyclasMat = bulletin.moyclasMat;
		this.extrememax = bulletin.extrememax;
		this.extremmemin = bulletin.extremmemin;
		this.totalPoint = bulletin.totalPoint;
		this.totalCoef = bulletin.totalCoef;
		this.moyEtudiant =bulletin. moyEtudiant;
		this.moyPremier = bulletin.moyPremier;
		this.moyDernnier = bulletin.moyDernnier;
		this.inscription = new Inscription(bulletin.inscription);
		this.module= new GroupeCours(bulletin.module);
	}




	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de classe";
	}

	

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return " Bulletin de classe";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id+"";
	}

	

	public MatiereNote getMatiere() {
		return matiere;
	}






	public void setMatiere(MatiereNote matiere) {
		this.matiere = matiere;
	}






	public NoteDetail getNote() {
		return note;
	}






	public void setNote(NoteDetail note) {
		this.note = note;
	}






	public Long getMoyclasMat() {
		return moyclasMat;
	}






	public void setMoyclasMat(Long moyclasMat) {
		this.moyclasMat = moyclasMat;
	}






	public Long getExtrememax() {
		return extrememax;
	}






	public void setExtrememax(Long extrememax) {
		this.extrememax = extrememax;
	}






	public Long getExtremmemin() {
		return extremmemin;
	}






	public void setExtremmemin(Long extremmemin) {
		this.extremmemin = extremmemin;
	}






	public Inscription getInscription() {
		return inscription;
	}






	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}






	public Long getTotalPoint() {
		return totalPoint;
	}






	public void setTotalPoint(Long totalPoint) {
		this.totalPoint = totalPoint;
	}






	public Long getTotalCoef() {
		return totalCoef;
	}






	public void setTotalCoef(Long totalCoef) {
		this.totalCoef = totalCoef;
	}






	public Long getMoyEtudiant() {
		return moyEtudiant;
	}






	public void setMoyEtudiant(Long moyEtudiant) {
		this.moyEtudiant = moyEtudiant;
	}






	public Long getMoyPremier() {
		return moyPremier;
	}






	public void setMoyPremier(Long moyPremier) {
		this.moyPremier = moyPremier;
	}






	public Long getMoyDernnier() {
		return moyDernnier;
	}






	public void setMoyDernnier(Long moyDernnier) {
		this.moyDernnier = moyDernnier;
	}






	public Classe getClasse() {
		return classe;
	}






	public void setClasse(Classe classe) {
		this.classe = classe;
	}






	public Eleve getEleve() {
		return eleve;
	}






	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}






	public GroupeCours getModule() {
		return module;
	}






	public void setModule(GroupeCours module) {
		this.module = module;
	}






	public int compareTo(BulletinHelperGenerate o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
