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
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.MatiereDlt;
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

	@Column(name = "NOTE1")
	private Double note1 = new Double(0);

	@Column(name = "NOTE2")
	private Double note2 = new Double(0);

	@Column(name = "NOTE3")
	private Double note3 = new Double(0);

	@Column(name = "NOTE4")
	private Double note4 = new Double(0);

	@Column(name = "NOTE5")
	private Double note5 = new Double(0);

	@Column(name = "NOTE6")
	private Double note6 = new Double(0);

	@Column(name = "MOY_CLA_MATIERE")
	private Double moyclasMat = new Double(0);

	@Column(name = "EXTR_MAX_MAT")
	private Double extrememaxmat = new Double(0);

	@Column(name = "EXTR_MIN_MAT")
	private Double extremmeminmat = new Double(0);

	@Column(name = "MOY1")
	private Double moy1 = new Double(0);

	@Column(name = "MOY2")
	private Double moy2 = new Double(0);

	@Column(name = "MOY3")
	private Double moy3 = new Double(0);

	@Column(name = "MOY4")
	private Double moy4 = new Double(0);

	@Column(name = "MOY5")
	private Double moy5 = new Double(0);

	@Column(name = "MOY6")
	private Double moy6 = new Double(0);

	@Column(name = "RANG_MAT")
	private Long rangmat = new Long(0);

	@Column(name = "RANG_MOY")
	private Long rangmoy = new Long(0);

	@Column(name = "MOY_GEN_CLS")
	private Double moyGenCls ;

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

	@Column(name = "TOTAL_POINT")
	private Double totalPoint = new Double(0);

	@Column(name = "TOTAL_COEF")
	private Long totalCoef = new Long(0);
	
	@Column(name = "ECART_TYPE")
	private Double eType = new Double(0);
	
	@Column(name = "RANG1")
	private Long rang1 = new Long(0);

	@Column(name = "RANG2")
	private Long rang2 = new Long(0);

	@Column(name = "RANG3")
	private Long rang3 = new Long(0);

	@Column(name = "RANG4")
	private Long rang4 = new Long(0);

	@Column(name = "RANG5")
	private Long rang5 = new Long(0);
	
	@Column(name = "RANG6")
	private Long rang6 = new Long(0);

	
	@Column(name = "APP_MAT")
	private String appreciationMatiere ;
	
	@Column(name = "APP")
	private String appreciation ;
	
	@Column(name = "SANCTION")
	private String santcion ;


	public BulletinHelperGenerate() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public BulletinHelperGenerate(Inscription inscription, Eleve eleve, Classe classe, Cycle cycle, String anneeid,
			CoefMatiereDetail coef, MatiereDlt matiere, Examen examen, Double note1, Double note2, Double note3,
			Double note4, Double note5, Double note6, Double moyclasMat, Double extrememaxmat, Double extremmeminmat,
			Double moy1, Double moy2, Double moy3, Double moy4, Double moy5, Double moy6, Long rangmat, Long rangmoy,
			Double moyGenCls, Double moyPremier, Double moyDernnier, Long nbreMoy, Long nbreElve, Double tauxReussite,
			Double totalPoint, Long totalCoef, Double eType, Long rang1, Long rang2, Long rang3, Long rang4,
			Long rang5) {
		super();
		this.inscription = inscription;
		this.eleve = eleve;
		this.classe = classe;
		this.cycle = cycle;
		this.anneeid = anneeid;
		this.coef = coef;
		this.matiere = matiere;
		this.examen = examen;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.note4 = note4;
		this.note5 = note5;
		this.note6 = note6;
		this.moyclasMat = moyclasMat;
		this.extrememaxmat = extrememaxmat;
		this.extremmeminmat = extremmeminmat;
		this.moy1 = moy1;
		this.moy2 = moy2;
		this.moy3 = moy3;
		this.moy4 = moy4;
		this.moy5 = moy5;
		this.moy6 = moy6;
		this.rangmat = rangmat;
		this.rangmoy = rangmoy;
		this.moyGenCls = moyGenCls;
		this.moyPremier = moyPremier;
		this.moyDernnier = moyDernnier;
		this.nbreMoy = nbreMoy;
		this.nbreElve = nbreElve;
		this.tauxReussite = tauxReussite;
		this.totalPoint = totalPoint;
		this.totalCoef = totalCoef;
		this.eType = eType;
		this.rang1 = rang1;
		this.rang2 = rang2;
		this.rang3 = rang3;
		this.rang4 = rang4;
		this.rang5 = rang5;
	}



	public BulletinHelperGenerate(BulletinHelperGenerate bull) {
		super(bull.id, bull.designation, bull.moduleName, 0L);
		this.inscription = bull.inscription;
		this.eleve = bull.eleve;
		this.classe = bull.classe;
		this.cycle = bull.cycle;
		this.anneeid = bull.anneeid;
		this.coef = bull.coef;
		this.matiere = bull.matiere;
		this.examen = bull.examen;
		this.note1 = bull.note1;
		this.note2 = bull.note2;
		this.note3 = bull.note3;
		this.note4 = bull.note4;
		this.note5 = bull.note5;
		this.note6 = bull.note6;
		this.moyclasMat = bull.moyclasMat;
		this.extrememaxmat = bull.extrememaxmat;
		this.extremmeminmat = bull.extremmeminmat;
		this.moy1 = bull.moy1;
		this.moy2 = bull.moy2;
		this.moy3 = bull.moy3;
		this.moy4 = bull.moy4;
		this.moy5 = bull.moy5;
		this.moy6 = bull.moy6;
		this.rangmat = bull.rangmat;
		this.rangmoy = bull.rangmoy;
		this.moyGenCls = bull.moyGenCls;
		this.moyPremier = bull.moyPremier;
		this.moyDernnier = bull.moyDernnier;
		this.nbreMoy = bull.nbreMoy;
		this.nbreElve = bull.nbreElve;
		this.tauxReussite = bull.tauxReussite;
		this.totalPoint = bull.totalPoint;
		this.totalCoef = bull.totalCoef;
		this.eType=bull.eType;
		this.rang1 =bull.rang1;
		this.rang2 = bull.rang2;
		this.rang3 = bull.rang3;
		this.rang4 = bull.rang4;
		this.rang5 = bull.rang5;
		this.appreciation=bull.appreciation;
		this.santcion=bull.santcion;
		this.appreciationMatiere=bull.appreciationMatiere;
		this.rang6=bull.rang6;
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

	public Long getRang4() {
		return rang4;
	}

	public void setRang4(Long rang4) {
		this.rang4 = rang4;
	}

	public Long getRang5() {
		return rang5;
	}

	public void setRang5(Long rang5) {
		this.rang5 = rang5;
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

	public void setCoef(CoefMatiereDetail coef) {
		this.coef = coef;
	}

	public MatiereDlt getMatiere() {
		return matiere;
	}

	public Long getRang6() {
		return rang6;
	}







	public void setRang6(Long rang6) {
		this.rang6 = rang6;
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







	public String getAppreciation() {
		return appreciation;
	}







	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
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


	public Long getRangmat() {
		return rangmat;
	}

	public void setRangmat(Long rangmat) {
		this.rangmat = rangmat;
	}

	public Long getRangmoy() {
		return rangmoy;
	}

	public void setRangmoy(Long rangmoy) {
		this.rangmoy = rangmoy;
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







	public Double getNote1() {
		return note1;
	}







	public void setNote1(Double note1) {
		this.note1 = note1;
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







	public Double getNote4() {
		return note4;
	}







	public void setNote4(Double note4) {
		this.note4 = note4;
	}







	public Double getNote5() {
		return note5;
	}







	public void setNote5(Double note5) {
		this.note5 = note5;
	}







	public Double getNote6() {
		return note6;
	}







	public void setNote6(Double note6) {
		this.note6 = note6;
	}







	public Double getMoyclasMat() {
		return moyclasMat;
	}







	public void setMoyclasMat(Double moyclasMat) {
		this.moyclasMat = moyclasMat;
	}







	public Double getExtrememaxmat() {
		return extrememaxmat;
	}







	public void setExtrememaxmat(Double extrememaxmat) {
		this.extrememaxmat = extrememaxmat;
	}







	public Double getExtremmeminmat() {
		return extremmeminmat;
	}







	public void setExtremmeminmat(Double extremmeminmat) {
		this.extremmeminmat = extremmeminmat;
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







	public Double getMoy4() {
		return moy4;
	}







	public void setMoy4(Double moy4) {
		this.moy4 = moy4;
	}







	public Double getMoy5() {
		return moy5;
	}







	public void setMoy5(Double moy5) {
		this.moy5 = moy5;
	}







	public Double getMoy6() {
		return moy6;
	}







	public void setMoy6(Double moy6) {
		this.moy6 = moy6;
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







	public int compareTo(BulletinHelperGenerate o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
