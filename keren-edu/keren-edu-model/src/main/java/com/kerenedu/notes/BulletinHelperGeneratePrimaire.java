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
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_zview_bulletin_prim")
public class BulletinHelperGeneratePrimaire extends BaseElement implements Serializable, Comparable<BulletinHelperGeneratePrimaire> {

	@ManyToOne
	@JoinColumn(name = "INS_ID")
	protected Inscription inscription;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	protected Eleve eleve;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "CYCLE_ID")
	protected Cycle cycle;

	@Column(name = "ANNEE_ID")
	private String anneeid;

	@ManyToOne
	@JoinColumn(name = "COEF_ID")
	protected CoefMatiereDetail coef;

	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	protected MatiereDlt matiere;

	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	protected Examen examen;

	@ManyToOne
	@JoinColumn(name = "NOTE_ID")
	protected NoteDetail notedetail;

	@Column(name = "MOY1")
	private Double moy1 = new Double(0);

	@Column(name = "MOY2")
	private Double moy2 = new Double(0);

	@Column(name = "MOY3")
	private Double moy3 = new Double(0);
	
	@Column(name = "RANG1")
	private Long rang1 = new Long(0);

	@Column(name = "RANG2")
	private Long rang2 = new Long(0);

	@Column(name = "RANG3")
	private Long rang3 = new Long(0);

	@Column(name = "MOIS1")
	private Double mois1 = new Double(0);

	@Column(name = "MOIS2")
	private Double mois2 = new Double(0);

	@Column(name = "MOIS3")
	private Double mois3 = new Double(0);
	
	@Column(name = "MOIS4")
	private Double mois4 = new Double(0);

	@Column(name = "MOIS5")
	private Double mois5 = new Double(0);

	@Column(name = "MOIS6")
	private Double mois6 = new Double(0);
	
	@Column(name = "MOIS7")
	private Double mois7 = new Double(0);

	@Column(name = "MOIS8")
	private Double mois8 = new Double(0);
	
	@Column(name = "RGM1")
	private Long rgm1 = new Long(0);

	@Column(name = "RGM2")
	private Long rgm2 = new Long(0);

	@Column(name = "RGM3")
	private Long rgm3 = new Long(0);
	
	@Column(name = "RGM4")
	private Long rgm4 = new Long(0);

	@Column(name = "RGM5")
	private Long rgm5 = new Long(0);

	@Column(name = "RGM6")
	private Long rgm6 = new Long(0);
	
	@Column(name = "RGM7")
	private Long rgm7 = new Long(0);

	@Column(name = "RGM8")
	private Long rgm8 = new Long(0);


	@Column(name = "MOY_GEN_CLS")
	private Double moyGenCls;

	@Column(name = "MOY_PREMIER")
	private Double moyPremier = new Double(0);

	@Column(name = "MOY_DERNIER")
	private Double moyDernnier = new Double(0);

	@Column(name = "NBRE_MOY")
	private Long nbreMoy = new Long(0);

	@Column(name = "NBRE_ELVE")
	private Long nbreElve = new Long(0);

	@Column(name = "TX_REU")
	private Double tauxReussite = new Double(0);

	@Transient
	@Column(name = "TOTAL_POINT")
	private Double totalPoint = new Double(0);
    
	@Transient
	@Column(name = "TOTAL_COEF")
	private Long totalCoef = new Long(0);

	@Column(name = "ECART_TYPE")
	private Double eType = new Double(0);


	@Column(name = "APP_MAT")
	private String appreciationMatiere;


	@Column(name = "APP")
	protected String app;

	@Column(name = "APP_EN")
	protected String appen;

	@Column(name = "SANCTION")
	private String santcion;

	@Transient
	private byte[] photo;

	public BulletinHelperGeneratePrimaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteDetail getNotedetail() {
		return notedetail;
	}

	public void setNotedetail(NoteDetail notedetail) {
		this.notedetail = notedetail;
	}



	public BulletinHelperGeneratePrimaire(Inscription inscription, Eleve eleve, Classe classe, Cycle cycle,
			String anneeid, CoefMatiereDetail coef, MatiereDlt matiere, Examen examen, NoteDetail notedetail,
			Double moy1, Double moy2, Double moy3, Long rang1, Long rang2, Long rang3, Double mois1, Double mois2,
			Double mois3, Double mois4, Double mois5, Double mois6, Double mois7, Double mois8, Double rgm1,
			Double rgm2, Double rgm3, Double rgm4, Double rgm5, Double rgm6, Double rgm7, Double rgm8, Double moyGenCls,
			Double moyPremier, Double moyDernnier, Long nbreMoy, Long nbreElve, Double tauxReussite, Double totalPoint,
			Long totalCoef, Double eType, String appreciationMatiere, String app, String appen, String santcion,
			byte[] photo) {
		super();
		this.inscription = inscription;
		this.eleve = eleve;
		this.classe = classe;
		this.cycle = cycle;
		this.anneeid = anneeid;
		this.coef = coef;
		this.matiere = matiere;
		this.examen = examen;
		this.notedetail = notedetail;
		this.moy1 = moy1;
		this.moy2 = moy2;
		this.moy3 = moy3;
		this.rang1 = rang1;
		this.rang2 = rang2;
		this.rang3 = rang3;
		this.mois1 = mois1;
		this.mois2 = mois2;
		this.mois3 = mois3;
		this.mois4 = mois4;
		this.mois5 = mois5;
		this.mois6 = mois6;
		this.mois7 = mois7;
		this.mois8 = mois8;
//		this.rgm1 = rgm1;
//		this.rgm2 = rgm2;
//		this.rgm3 = rgm3;
//		this.rgm4 = rgm4;
//		this.rgm5 = rgm5;
//		this.rgm6 = rgm6;
//		this.rgm7 = rgm7;
//		this.rgm8 = rgm8;
		this.moyGenCls = moyGenCls;
		this.moyPremier = moyPremier;
		this.moyDernnier = moyDernnier;
		this.nbreMoy = nbreMoy;
		this.nbreElve = nbreElve;
		this.tauxReussite = tauxReussite;
		this.totalPoint = totalPoint;
		this.totalCoef = totalCoef;
		this.eType = eType;
		this.appreciationMatiere = appreciationMatiere;
		this.app = app;
		this.appen = appen;
		this.santcion = santcion;
		this.photo = photo;
	}

	public BulletinHelperGeneratePrimaire(BulletinHelperGeneratePrimaire bull) {
		super(bull.id, bull.designation, bull.moduleName, 0L);
		this.inscription = new Inscription(bull.inscription);
		this.eleve = new Eleve(bull.eleve);
		this.classe = new Classe(bull.classe);
		this.cycle = new Cycle(bull.cycle);
		this.anneeid = bull.anneeid;
		this.coef = bull.coef;
		this.matiere = new MatiereDlt(bull.matiere);
		this.examen = new Examen(bull.examen);
		
	
		this.moy1 = bull.moy1;
		this.moy2 = bull.moy2;
		this.moy3 = bull.moy3;
		this.rang1 = bull.rang1;
		this.rang2 = bull.rang2;
		this.rang3 = bull.rang3;
		this.mois1 = bull.mois1;
		this.mois2 = bull.mois2;
		this.mois3 = bull.mois3;
		this.mois4 = bull.mois4;
		this.mois5 = bull.mois5;
		this.mois6 = bull.mois6;
		this.mois7 = bull.mois7;
		this.mois8 = bull.mois8;
		this.rgm1 = bull.rgm1;
		this.rgm2 = bull.rgm2;
		this.rgm3 = bull.rgm3;
		this.rgm4 = bull.rgm4;
		this.rgm5 = bull.rgm5;
		this.rgm6 = bull.rgm6;
		this.rgm7 = bull.rgm7;
		this.rgm8 = bull.rgm8;
	
		this.moyGenCls = bull.moyGenCls;
		this.moyPremier = bull.moyPremier;
		this.moyDernnier = bull.moyDernnier;
		this.nbreMoy = bull.nbreMoy;
		this.nbreElve = bull.nbreElve;
		this.tauxReussite = bull.tauxReussite;
		this.totalPoint = bull.totalPoint;
		this.totalCoef = bull.totalCoef;
		this.eType = bull.eType;
		this.santcion = bull.santcion;
		this.appreciationMatiere = bull.appreciationMatiere;
		this.notedetail = new NoteDetail(bull.notedetail);
		this.app = bull.app;
		this.appen = bull.appen;
		//this.appreciationMatiereen = bull.appreciationMatiereen;
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
		return id + "";
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

	public Cycle getCycle() {
		return cycle;
	}

	public Long getRang1() {
		return rang1;
	}

	public void setRang1(Long rang1) {
		this.rang1 = rang1;
	}



	public Long getRang2() {
		return rang2;
	}

	public void setRang2(Long rang2) {
		this.rang2 = rang2;
	}

	public Long getRang3() {
		return rang3;
	}

	public void setRang3(Long rang3) {
		this.rang3 = rang3;
	}



	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public String getAnneeid() {
		return anneeid;
	}

	public void setAnneeid(String anneeid) {
		this.anneeid = anneeid;
	}

	public CoefMatiereDetail getCoef() {
		return coef;
	}

	public String getApp() {
		return app;
	}

	public void setCoef(CoefMatiereDetail coef) {
		this.coef = coef;
	}

	

	public String getAppen() {
		return appen;
	}

	public void setAppen(String appen) {
		this.appen = appen;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public MatiereDlt getMatiere() {
		return matiere;
	}


	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setMatiere(MatiereDlt matiere) {
		this.matiere = matiere;
	}

	public String getAppreciationMatiere() {
		return appreciationMatiere;
	}

	public void setAppreciationMatiere(String appreciationMatiere) {
		this.appreciationMatiere = appreciationMatiere;
	}

	public String getSantcion() {
		return santcion;
	}

	public void setSantcion(String santcion) {
		this.santcion = santcion;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}



	public Long getRgm1() {
		return rgm1;
	}

	public void setRgm1(Long rgm1) {
		this.rgm1 = rgm1;
	}

	public Long getRgm2() {
		return rgm2;
	}

	public void setRgm2(Long rgm2) {
		this.rgm2 = rgm2;
	}

	public Long getRgm3() {
		return rgm3;
	}

	public void setRgm3(Long rgm3) {
		this.rgm3 = rgm3;
	}

	public Long getRgm4() {
		return rgm4;
	}

	public void setRgm4(Long rgm4) {
		this.rgm4 = rgm4;
	}

	public Long getRgm5() {
		return rgm5;
	}

	public void setRgm5(Long rgm5) {
		this.rgm5 = rgm5;
	}

	public Long getRgm6() {
		return rgm6;
	}

	public void setRgm6(Long rgm6) {
		this.rgm6 = rgm6;
	}

	public Long getRgm7() {
		return rgm7;
	}

	public void setRgm7(Long rgm7) {
		this.rgm7 = rgm7;
	}

	public Long getRgm8() {
		return rgm8;
	}

	public void setRgm8(Long rgm8) {
		this.rgm8 = rgm8;
	}

	public Long getNbreMoy() {
		return nbreMoy;
	}

	public void setNbreMoy(Long nbreMoy) {
		this.nbreMoy = nbreMoy;
	}

	public Long getNbreElve() {
		return nbreElve;
	}

	public void setNbreElve(Long nbreElve) {
		this.nbreElve = nbreElve;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}


	public Double getMoy1() {
		return moy1;
	}

	public void setMoy1(Double moy1) {
		this.moy1 = moy1;
	}

	public Double getMoy2() {
		return moy2;
	}

	public void setMoy2(Double moy2) {
		this.moy2 = moy2;
	}

	public Double getMoy3() {
		return moy3;
	}

	public void setMoy3(Double moy3) {
		this.moy3 = moy3;
	}

	

	public Double getMoyGenCls() {
		return moyGenCls;
	}

	public void setMoyGenCls(Double moyGenCls) {
		this.moyGenCls = moyGenCls;
	}

	public Double getMoyPremier() {
		return moyPremier;
	}

	public void setMoyPremier(Double moyPremier) {
		this.moyPremier = moyPremier;
	}

	public Double getMoyDernnier() {
		return moyDernnier;
	}

	public void setMoyDernnier(Double moyDernnier) {
		this.moyDernnier = moyDernnier;
	}

	public Double getTauxReussite() {
		return tauxReussite;
	}

	public void setTauxReussite(Double tauxReussite) {
		this.tauxReussite = tauxReussite;
	}

	public Double getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Double totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Long getTotalCoef() {
		return totalCoef;
	}

	public void setTotalCoef(Long totalCoef) {
		this.totalCoef = totalCoef;
	}

	public Double geteType() {
		return eType;
	}

	public void seteType(Double eType) {
		this.eType = eType;
	}

	public Double getMois1() {
		return mois1;
	}

	public void setMois1(Double mois1) {
		this.mois1 = mois1;
	}

	public Double getMois2() {
		return mois2;
	}

	public void setMois2(Double mois2) {
		this.mois2 = mois2;
	}

	public Double getMois3() {
		return mois3;
	}

	public void setMois3(Double mois3) {
		this.mois3 = mois3;
	}

	public Double getMois4() {
		return mois4;
	}

	public void setMois4(Double mois4) {
		this.mois4 = mois4;
	}

	public Double getMois5() {
		return mois5;
	}

	public void setMois5(Double mois5) {
		this.mois5 = mois5;
	}

	public Double getMois6() {
		return mois6;
	}

	public void setMois6(Double mois6) {
		this.mois6 = mois6;
	}

	public Double getMois7() {
		return mois7;
	}

	public void setMois7(Double mois7) {
		this.mois7 = mois7;
	}

	public Double getMois8() {
		return mois8;
	}

	public void setMois8(Double mois8) {
		this.mois8 = mois8;
	}


	public int compareTo(BulletinHelperGeneratePrimaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
