/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_bul_lgn")
public class LigneBulletinClasse extends BaseElement implements Serializable, Comparable<LigneBulletinClasse> {

	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	@Predicate(label = "Matiere", updatable = false, search = true, type = MatiereDlt.class, target = "many-to-one", sequence = 1, editable = false)
	protected MatiereDlt matiere;

	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "PROF.", updatable = false, search = true, type = Professeur.class, target = "many-to-one", sequence = 2, editable = false)
	protected Professeur prof;
	
	@Column(name = "NOTE_1")
	@Predicate(label = "Q1/Mois1",type = Double.class,search = true  , sequence=3 ,editable=false)
	private Double note1 = new Double(0) ;
	
	@Column(name = "NOTE_2")
	@Predicate(label = "Q2/Mois2",type = Double.class,search = true  , sequence=4 ,editable=false)
	private Double note2 = new Double(0) ;
	
	@Column(name = "NOTE_3")
	@Predicate(label = "SEQ/Mois3",type = Double.class,search = true  , sequence=5,editable=false )
	private Double note3 = new Double(0) ;
	
	@Column(name = "S_NOTE_1")
	//@Predicate(label = "Q1/Mois1",type = Double.class,search = true  , sequence=3 ,editable=false)
	private Double snote1 = new Double(0) ;
	
	@Column(name = "S_NOTE_2")
	//@Predicate(label = "Q2/Mois2",type = Double.class,search = true  , sequence=4 ,editable=false)
	private Double snote2 = new Double(0) ;
	
	@Column(name = "S_NOTE_3")
	//@Predicate(label = "SEQ/Mois3",type = Double.class,search = true  , sequence=5,editable=false )
	private Double snote3 = new Double(0) ;

	@Column(name = "NOTE")
	@Predicate(label = "Note",type = Double.class,search = true  , sequence=6, editable=false )
	private Double note = new Double(0) ;
	
//	@Column(name = "S_NOTE")
//	//@Predicate(label = "Note",type = Double.class,search = true  , sequence=6, editable=false )
//	private Double snote = new Double(0) ;


	@Column(name = "COEF")
	@Predicate(label = "Coef", type = Long.class, search = true, sequence = 7, updatable = false)
	private Long coef = new Long(0);

	@Column(name = "TOTAL")
//	@Predicate(label = "Totaux", type = Double.class, search = true, sequence = 8, updatable = false)
	private Double totaux = new Double(0);

	@ManyToOne
	@JoinColumn(name = "MODULE_ID")
	protected GroupeCours module;

	@Column(name = "RANG")
	@Predicate(label = "Rang", type = Long.class, search = true, sequence =9, updatable = false)
	private Long rang = new Long(0);

	@Column(name = "APPRECIATION")
	@Predicate(label = "Appreciation", search = true, sequence = 10, editable = false)
	private String obs;

	@Column(name = "MOY_20")
	private Double moyenne = new Double(0);

	@Column(name = "POUR_REU")
	private Long pourcentage = new Long(0);

	@Column(name = "MOY_CLA")
	private Double moyeClasse = new Double(0);

	@Column(name = "EXTR_MIN")
	private Double extremeMin = new Double(0);

	@Column(name = "EXTR_MAX")
	private Double extremeMax = new Double(0);

	public LigneBulletinClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneBulletinClasse(MatiereDlt matiere, Professeur prof, Double note, Double moyenne, Long coef,
			Long pourcentage, Long rang, Double moyeClasse, Double extremeMin, Double extremeMax, String obs, Double totaux) {
		super();
		this.matiere = matiere;
		this.prof = prof;
		this.note = note;
		this.moyenne = moyenne;
		this.coef = coef;
		this.pourcentage = pourcentage;
		this.rang = rang;
		this.moyeClasse = moyeClasse;
		this.extremeMin = extremeMin;
		this.extremeMax = extremeMax;
		this.obs = obs;
		this.totaux = totaux;
	}

	public LigneBulletinClasse(LigneBulletinClasse filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName, 0L);
		this.obs = filiere.obs;
		this.note = filiere.note;
		this.matiere = new MatiereDlt(filiere.matiere);
		this.prof = new Professeur(filiere.prof);
		this.moyenne = filiere.moyenne;
		this.coef = filiere.coef;
		this.pourcentage = filiere.pourcentage;
		this.rang = filiere.rang;
		this.moyeClasse = filiere.moyeClasse;
		this.extremeMin = filiere.extremeMin;
		this.extremeMax = filiere.extremeMax;
		this.totaux = filiere.totaux;
		this.module = new GroupeCours(filiere.module);
		this.note = filiere.note;
		this.note1 = filiere.note1;
		this.note2 = filiere.note2;
		this.note3 = filiere.note3;
		
//		this.snote = filiere.snote;
		this.snote1 = filiere.snote1;
		this.snote2 = filiere.snote2;
		this.snote3 = filiere.snote3;

	}


	public LigneBulletinClasse(ViewNoteHelper helper) {
		this.obs = helper.getObs();
		this.note = helper.getNote();
		this.matiere = new MatiereDlt(helper.getMatiere().getMatiere());
		this.prof = new Professeur(helper.getMatiereNote().getProf());
		this.coef = (long) helper.getMatiere().getMatiere().getCoeficient();
		this.totaux = helper.getNote() * this.coef;
		this.moyeClasse = helper.getMoyclasMat();
		this.extremeMin = helper.getExtrememax();
		this.extremeMax = helper.getExtrememax();
		this.module = helper.getMatiereNote().getMatiere().getGroupe();
		this.moyenne=helper.getMoyEtudiant();
		this.rang=helper.getRangMat();
//		System.out.println("LigneBulletinClasse.LigneBulletinClasse() note1"+helper.getNote1()+" note2"+helper.getNote2()+"note 3"+helper.getNote3());
	//	double note1=0 ;double note2=0;double notmoy=0;double note3=0;
		if(helper.getClasse().getFiliere().getCycle().getTypecycle().equals("1")){
			
			this.note1=helper.getNote1()*helper.getExamen().getE1()/helper.getMatiere().getCoef();
			this.note2=helper.getNote2()*helper.getExamen().getE2()/helper.getMatiere().getCoef();
			this.note3=helper.getNote3()*helper.getExamen().getE2()/helper.getMatiere().getCoef();
			
			this.snote1=helper.getNote1()*helper.getExamen().getE1()/helper.getMatiere().getCoef();
			this.snote2=helper.getNote2()*helper.getExamen().getE2()/helper.getMatiere().getCoef();
			this.snote3=helper.getNote3()*helper.getExamen().getE2()/helper.getMatiere().getCoef();
			
			this.note=(this.note1+this.note2+this.note3)/3;
			
		}else if(helper.getClasse().getFiliere().getCycle().getTypecycle().equals("2")){
		if(helper.getNote1()==0&&helper.getNote2()!=0&&helper.getNote3()!=0){
			this.note1=(double) 0;
			this.note2=helper.getNote2()*helper.getExamen().getE3();
			 note3=helper.getNote3()*helper.getExamen().getE3();
		}else if(helper.getNote2()==0&&helper.getNote1()!=0&&helper.getNote3()!=0){
			this.note2=(double) 0;
			this.note1=helper.getNote1()*helper.getExamen().getE3();
			this.note3=helper.getNote3()*helper.getExamen().getE3();
		}else if(helper.getNote1()==0&&helper.getNote2()==0&&helper.getNote3()!=0){
			this.note2=(double) 0;
			this.note1=(double) 0;
			this.note3=helper.getNote3();
		}else if(helper.getNote1()!=0&&helper.getNote2()==0&&helper.getNote3()==0){
			this.note2=(double) 0;
			this.note3=(double) 0;
			this.note1=helper.getNote1();
		}else if(helper.getNote1()==0&&helper.getNote2()!=0&&helper.getNote3()==0){
			this.note1=(double) 0;
			this.note3=(double) 0;
			this.note2=helper.getNote2();
		}
		else if(helper.getNote1()!=0&&helper.getNote2()!=0&&helper.getNote3()!=0){
			this.note1=helper.getNote3()*helper.getExamen().getE3();
			this.note2=helper.getNote2()*helper.getExamen().getE2();
			this.note3=helper.getNote1()*helper.getExamen().getE1();
		}else if(helper.getNote1()!=0&&helper.getNote2()!=0&&helper.getNote3()==0){
			this.note1=(double) 0;
			this.note2=helper.getNote2()*helper.getExamen().getE3();
			this.note3=helper.getNote1()*helper.getExamen().getE3();
		}
		}
//
//		
//		this.note1 = helper.getNote1()*helper.getExamen().getE1();
//		this.note2 = helper.getNote2()*helper.getExamen().getE2();
//		this.note3 = helper.getNote3()*helper.getExamen().getE3();

	}

	public GroupeCours getModule() {
		return module;
	}

	public void setModule(GroupeCours module) {
		this.module = module;
	}

	public MatiereDlt getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereDlt matiere) {
		this.matiere = matiere;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	public Long getCoef() {
		return coef;
	}

	public void setCoef(Long coef) {
		this.coef = coef;
	}

	public Long getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(Long pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Long getRang() {
		return rang;
	}

	public void setRang(Long rang) {
		this.rang = rang;
	}

	public Double getMoyeClasse() {
		return moyeClasse;
	}

	public void setMoyeClasse(Double moyeClasse) {
		this.moyeClasse = moyeClasse;
	}

	public Double getExtremeMin() {
		return extremeMin;
	}

	public void setExtremeMin(Double extremeMin) {
		this.extremeMin = extremeMin;
	}

	public Double getTotaux() {
		return totaux;
	}

	public void setTotaux(Double totaux) {
		this.totaux = totaux;
	}

	public Double getExtremeMax() {
		return extremeMax;
	}
//
//	public Double getSnote1() {
//		return snote1;
//	}
//
//	public void setSnote1(Double snote1) {
//		this.snote1 = snote1;
//	}
//
//	public Double getSnote2() {
//		return snote2;
//	}
//
//	public void setSnote2(Double snote2) {
//		this.snote2 = snote2;
//	}
//
//	public Double getSnote3() {
//		return snote3;
//	}
//
//	public void setSnote3(Double snote3) {
//		this.snote3 = snote3;
//	}
//
//	public Double getSnote() {
//		return snote;
//	}
//
//	public void setSnote(Double snote) {
//		this.snote = snote;
//	}

	public void setExtremeMax(Double extremeMax) {
		this.extremeMax = extremeMax;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Details  Bulletin";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Details Bulletin";
	}

	public Double getNote1() {
		return note1;
	}

	public void setNote1(Double note1) {
		this.note1 = note1;
	}

	public Double getSnote1() {
		return snote1;
	}

	public void setSnote1(Double snote1) {
		this.snote1 = snote1;
	}

	public Double getSnote2() {
		return snote2;
	}

	public void setSnote2(Double snote2) {
		this.snote2 = snote2;
	}

	public Double getSnote3() {
		return snote3;
	}

	public void setSnote3(Double snote3) {
		this.snote3 = snote3;
	}

	public Double getNote2() {
		return note2;
	}

	public void setNote2(Double note2) {
		this.note2 = note2;
	}

	public Double getNote3() {
		return note3;
	}

	public void setNote3(Double note3) {
		this.note3 = note3;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}
	
	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	public int compareTo(LigneBulletinClasse o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
