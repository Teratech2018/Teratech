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
import com.kerenedu.configuration.Appreciation;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.discipline.ViewAbscence;
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
	@JoinColumn(name = "LGN_ID")
	protected LigneBulletinClasse lignes;
	
	@ManyToOne
	@JoinColumn(name = "BULL_ID")
	protected Bulletin bulletin;
	
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
	@JoinColumn(name = "EXAMEN_ID")
	protected Examen examen ;
	
	@Column(name = "MOY")
	private Double moy = new Double(0);
	
	@Column(name = "RANG")
	private Long rang = new Long(0);
	
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
	
	@ManyToOne
	@JoinColumn(name = "APPS")
	private Appreciation appreciation;

//	@Column(name = "SANCTION")
//	private String santcion;
//
//	@Column(name = "APP_EN")
//	protected String appen;
	
	@ManyToOne
	@JoinColumn(name = "ABS_ID")
	protected ViewAbscence abscence;

	@Column(name = "RANGT1")
	private Long rangt1 = new Long(0);
	
	@Column(name = "RANGT2")
	private Long rangt2 = new Long(0);
	
	
	@Column(name = "RANGT3")
	private Long rangt3 = new Long(0);
	
	@Column(name = "NBMOYT1")
	private Double nbmoyt1 = new Double(0);
	
	@Column(name = "ECARTT1")
	private Double ecartt1 = new Double(0);
	
	@Column(name = "MINMOYT1")
	private Double minmoyt1 = new Double(0);
	
	@Column(name = "MYGENT1")
	private Double moygent1 = new Double(0);
	
	@Column(name = "MAXMOYT1")
	private Double maxmoyt1 = new Double(0);
	
	@Column(name = "NBMOYT2")
	private Double nbmoyt2 = new Double(0);
	
	@Column(name = "ECARTT2")
	private Double ecartt2 = new Double(0);
	
	@Column(name = "MINMOYT2")
	private Double minmoyt2 = new Double(0);
	
	@Column(name = "MYGENT2")
	private Double moygent2 = new Double(0);
	
	@Column(name = "MAXMOYT2")
	private Double maxmoyt2 = new Double(0);
	
	@Column(name = "NBMOYT3")
	private Double nbmoyt3 = new Double(0);
	
	@Column(name = "ECARTT3")
	private Double ecartt3 = new Double(0);
	
	@Column(name = "MINMOYT3")
	private Double minmoyt3 = new Double(0);
	
	@Column(name = "MYGENT3")
	private Double moygent3 = new Double(0);
	
	@Column(name = "MAXMOYT3")
	private Double maxmoyt3 = new Double(0);
	
	@Column(name = "ANNEE_ID")
	private String anneeid;

	@Transient
	@Column(name = "MOY_CLA_MATIERE")
	private Double moyclasMat = new Double(0);

	@Transient
	@Column(name = "EXTR_MAX_MAT")
	private Double extrememaxmat = new Double(0);

	@Transient
	@Column(name = "EXTR_MIN_MAT")
	private Double extremmeminmat = new Double(0);
	
	@Column(name = "RANKMATT1")
	private Long rankmatt1 = new Long(0);
	
	@Column(name = "RANKMATT2")
	private Long rankmatt2 = new Long(0);
	
	@Column(name = "RANKMATT3")
	private Long rankmatt3 = new Long(0);
	
	@Column(name = "MOYMATT1")
	private Double moymatt1 = new Double(0);
	
	@Column(name = "MOYMATT2")
	private Double moymatt2 = new Double(0);
	
	@Column(name = "MOYMATT3")
	private Double moymatt3 = new Double(0);
	
	@ManyToOne
	@JoinColumn(name = "ABST0")
	protected ViewAbscence abscencet0;
	
	@ManyToOne
	@JoinColumn(name = "ABST1")
	protected ViewAbscence abscencet1;
	
	@ManyToOne
	@JoinColumn(name = "ABST2")
	protected ViewAbscence abscencet2;
	
	@ManyToOne
	@JoinColumn(name = "ABST3")
	protected ViewAbscence abscencet3;
	
	@ManyToOne
	@JoinColumn(name = "ABST4")
	protected ViewAbscence abscencet4;
	
	@ManyToOne
	@JoinColumn(name = "ABST5")
	protected ViewAbscence abscencet5;
	
	@ManyToOne
	@JoinColumn(name = "APPT1")
	protected Appreciation appt1;
	
	@ManyToOne
	@JoinColumn(name = "APPT2")
	protected Appreciation appt2;
	
	@ManyToOne
	@JoinColumn(name = "APPT3")
	protected Appreciation appt3;
	
	@ManyToOne
	@JoinColumn(name = "APPMOY1")
	protected Appreciation apptmoy1;
	
	@Column(name = "TCOEFS1")
	private Long tcoefs1 = new Long(0);
	
	@Column(name = "TCOEFS2")
	private Long tcoefs2 = new Long(0);
	

	@Column(name = "TCOEFS3")
	private Long tcoefs3 = new Long(0);
	
	@Column(name = "TCOEFS4")
	private Long tcoefs4 = new Long(0);
	

	@Column(name = "TCOEFS5")
	private Long tcoefs5 = new Long(0);
	
	@Column(name = "TCOEFS6")
	private Long tcoefs6 = new Long(0);

	
	@Transient
	private Cycle cycle;
	
	@Transient
	private MatiereDlt matiere;
	
	@Transient
	private Long rangmat ;
	@Transient
	private Long rangmoy ;
	
	@Transient
	private Double moyGenCls ;
	
	@Transient
	private Double moyPremier ;
	
	@Transient
	private Double moyDernnier;
	
	@Transient
	private Long nbreMoy;
	
	@Transient
	private Long nbreElve;
	
	@Transient
	private Double tauxReussite;
	@Transient
	private Double totalPoint;
	@Transient
	private Long totalCoef;
	@Transient
	private Double eType;
	
	@Transient
	private byte[] photo;

	public BulletinHelperGenerate() {
		super();
		// TODO Auto-generated constructor stub
	}




	public BulletinHelperGenerate(LigneBulletinClasse lignes, Bulletin bulletin, Inscription inscription, Eleve eleve,
			Classe classe, Examen examen, Double moy, Long rang, Double note1, Double note2, Double note3, Double note4,
			Double note5, Double note6, Double moy1, Double moy2, Double moy3, Double moy4, Double moy5, Double moy6,
			Long rang1, Long rang2, Long rang3, Long rang4, Long rang5, Long rang6, String appreciation,
			String santcion, String appen, ViewAbscence abscence, Long rangt1, Long rangt2, Long rangt3, Double nbmoyt1,
			Double ecartt1, Double minmoyt1, Double moygent1, Double maxmoyt1, Double nbmoyt2, Double ecartt2,
			Double minmoyt2, Double moygent2, Double maxmoyt2, Double nbmoyt3, Double ecartt3, Double minmoyt3,
			Double moygent3, Double maxmoyt3, String anneeid, Double moyclasMat, Double extrememaxmat,
			Double extremmeminmat, Long rankmatt1, Long rankmatt2, Long rankmatt3, Double moymatt1, Double moymatt2,
			Double moymatt3, ViewAbscence abscencet0, ViewAbscence abscencet1, Appreciation appt1, Appreciation appt2,
			Appreciation appt3, Cycle cycle, MatiereDlt matiere, Long rangmat, Long rangmoy, Double moyGenCls,
			Double moyPremier, Double moyDernnier, Long nbreMoy, Long nbreElve, Double tauxReussite, Double totalPoint,
			Long totalCoef, Double eType, byte[] photo) {
		super();
		this.lignes = lignes;
		this.bulletin = bulletin;
		this.inscription = inscription;
		this.eleve = eleve;
		this.classe = classe;
		this.examen = examen;
		this.moy = moy;
		this.rang = rang;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.note4 = note4;
		this.note5 = note5;
		this.note6 = note6;
		this.moy1 = moy1;
		this.moy2 = moy2;
		this.moy3 = moy3;
		this.moy4 = moy4;
		this.moy5 = moy5;
		this.moy6 = moy6;
		this.rang1 = rang1;
		this.rang2 = rang2;
		this.rang3 = rang3;
		this.rang4 = rang4;
		this.rang5 = rang5;
		this.rang6 = rang6;
	//	this.appreciation = appreciation;
//		this.santcion = santcion;
//		this.appen = appen;
		this.abscence = abscence;
		this.rangt1 = rangt1;
		this.rangt2 = rangt2;
		this.rangt3 = rangt3;
		this.nbmoyt1 = nbmoyt1;
		this.ecartt1 = ecartt1;
		this.minmoyt1 = minmoyt1;
		this.moygent1 = moygent1;
		this.maxmoyt1 = maxmoyt1;
		this.nbmoyt2 = nbmoyt2;
		this.ecartt2 = ecartt2;
		this.minmoyt2 = minmoyt2;
		this.moygent2 = moygent2;
		this.maxmoyt2 = maxmoyt2;
		this.nbmoyt3 = nbmoyt3;
		this.ecartt3 = ecartt3;
		this.minmoyt3 = minmoyt3;
		this.moygent3 = moygent3;
		this.maxmoyt3 = maxmoyt3;
		this.anneeid = anneeid;
		this.moyclasMat = moyclasMat;
		this.extrememaxmat = extrememaxmat;
		this.extremmeminmat = extremmeminmat;
		this.rankmatt1 = rankmatt1;
		this.rankmatt2 = rankmatt2;
		this.rankmatt3 = rankmatt3;
		this.moymatt1 = moymatt1;
		this.moymatt2 = moymatt2;
		this.moymatt3 = moymatt3;
		this.abscencet0 = abscencet0;
		this.abscencet1 = abscencet1;
		this.appt1 = appt1;
		this.appt2 = appt2;
		this.appt3 = appt3;
		this.cycle = cycle;
		this.matiere = matiere;
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
		this.photo = photo;
	}




	public BulletinHelperGenerate(BulletinHelperGenerate bull) {
		super(bull.id, bull.designation, bull.moduleName, 0L);
		this.inscription = new Inscription(bull.inscription);
		this.eleve = new Eleve(bull.eleve);
		this.classe = new Classe(bull.classe);
		this.cycle = new Cycle(bull.cycle);
		this.anneeid = bull.anneeid;
		this.matiere = new MatiereDlt(bull.matiere);
		this.examen = new Examen(bull.examen);
		if (bull.abscence != null) {
			this.abscence = new ViewAbscence(bull.abscence);
		}
		this.note1 = bull.note1;
		this.note2 = bull.note2;
		this.note3 = bull.note3;
		this.note4 = bull.note4;
		this.note5 = bull.note5;
		this.note6 = bull.note6;
		this.moyclasMat = bull.getLignes().getMoyeClasse();
		this.extrememaxmat = bull.getLignes().getExtremeMax();
		this.extremmeminmat = bull.getLignes().getExtremeMin();
		this.moy1 = bull.moy1;
		this.moy2 = bull.moy2;
		this.moy3 = bull.moy3;
		this.moy4 = bull.moy4;
		this.moy5 = bull.moy5;
		this.moy6 = bull.moy6;
		this.rangmat = bull.getLignes().getRang();
		this.rangmoy = bull.getRang();
		this.moyGenCls = bull.getBulletin().getMoyenneClas();
		this.moyPremier = bull.getBulletin().getMoypremier();
		this.moyDernnier = bull.getBulletin().getMoydernier();
		this.nbreMoy = bull.getBulletin().getNbreMoy();
		this.nbreElve = bull.getBulletin().getNbreElve();
		this.tauxReussite = bull.getBulletin().getTxreusitte();
		this.totalPoint = bull.getBulletin().getTpoint();
		this.totalCoef = bull.getBulletin().getTcoef();
		this.eType = bull.getBulletin().geteType();
		this.rang1 = bull.rang1;
		this.rang2 = bull.rang2;
		this.rang3 = bull.rang3;
		this.rang4 = bull.rang4;
		this.rang5 = bull.rang5;
		this.rang6 = bull.rang6;

//		this.santcion = bull.santcion;
//		this.appen = bull.appen;
		
		this.rankmatt1 = bull.rankmatt1;
		this.rankmatt2 = bull.rankmatt2;
		this.rankmatt3 = bull.rankmatt3;
		this.moymatt1 = bull.moymatt1;
		this.moymatt2 = bull.moymatt2;
		this.moymatt3 = bull.moymatt3;
		this.abscencet0 = new ViewAbscence(bull.abscencet0);
		this.abscencet1 = new ViewAbscence(bull.abscencet1);
		this.abscencet2 = new ViewAbscence(bull.abscencet2);
		this.abscencet3 = new ViewAbscence(bull.abscencet3);
		this.abscencet4 = new ViewAbscence(bull.abscencet4);
		this.abscencet5 = new ViewAbscence(bull.abscencet5);
		this.appt1 = new Appreciation(bull.appt1);
		this.appt2 = new Appreciation(bull.appt2);
		this.appt3 = new Appreciation(bull.appt3);
		this.apptmoy1 = new Appreciation(bull.apptmoy1);
		this.appreciation = new Appreciation(bull.appreciation);
		this.tcoefs1=bull.tcoefs1;
		this.tcoefs2=bull.tcoefs2;
		this.tcoefs3=bull.tcoefs3;
		this.tcoefs4=bull.tcoefs4;
		this.tcoefs5=bull.tcoefs5;
		this.tcoefs6=bull.tcoefs6;
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

	public ViewAbscence getAbscencet2() {
		return abscencet2;
	}




	public void setAbscencet2(ViewAbscence abscencet2) {
		this.abscencet2 = abscencet2;
	}




	public ViewAbscence getAbscencet3() {
		return abscencet3;
	}




	public void setAbscencet3(ViewAbscence abscencet3) {
		this.abscencet3 = abscencet3;
	}




	public ViewAbscence getAbscencet4() {
		return abscencet4;
	}




	public void setAbscencet4(ViewAbscence abscencet4) {
		this.abscencet4 = abscencet4;
	}




	public ViewAbscence getAbscencet5() {
		return abscencet5;
	}




	public void setAbscencet5(ViewAbscence abscencet5) {
		this.abscencet5 = abscencet5;
	}




	public void setRang1(Long rang1) {
		this.rang1 = rang1;
	}

	public ViewAbscence getAbscence() {
		return abscence;
	}

	public void setAbscence(ViewAbscence abscence) {
		this.abscence = abscence;
	}

	public Long getRang2() {
		return rang2;
	}

	public void setRang2(Long rang2) {
		this.rang2 = rang2;
	}

	public Appreciation getApptmoy1() {
		return apptmoy1;
	}




	public void setApptmoy1(Appreciation apptmoy1) {
		this.apptmoy1 = apptmoy1;
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

	public Long getTcoefs1() {
		return tcoefs1;
	}




	public void setTcoefs1(Long tcoefs1) {
		this.tcoefs1 = tcoefs1;
	}




	public Long getTcoefs2() {
		return tcoefs2;
	}




	public void setTcoefs2(Long tcoefs2) {
		this.tcoefs2 = tcoefs2;
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



	


	
	public MatiereDlt getMatiere() {
		return matiere;
	}

	public Long getRang6() {
		return rang6;
	}

	public Long getRankmatt1() {
		return rankmatt1;
	}


	public void setRankmatt1(Long rankmatt1) {
		this.rankmatt1 = rankmatt1;
	}


	public Long getRankmatt2() {
		return rankmatt2;
	}


	public void setRankmatt2(Long rankmatt2) {
		this.rankmatt2 = rankmatt2;
	}


	public Long getRankmatt3() {
		return rankmatt3;
	}


	public void setRankmatt3(Long rankmatt3) {
		this.rankmatt3 = rankmatt3;
	}


	public Double getMoymatt1() {
		return moymatt1;
	}


	public void setMoymatt1(Double moymatt1) {
		this.moymatt1 = moymatt1;
	}


	public Double getMoymatt2() {
		return moymatt2;
	}


	public void setMoymatt2(Double moymatt2) {
		this.moymatt2 = moymatt2;
	}


	public Double getMoymatt3() {
		return moymatt3;
	}


	public void setMoymatt3(Double moymatt3) {
		this.moymatt3 = moymatt3;
	}


	public ViewAbscence getAbscencet0() {
		return abscencet0;
	}


	public void setAbscencet0(ViewAbscence abscencet0) {
		this.abscencet0 = abscencet0;
	}


	public ViewAbscence getAbscencet1() {
		return abscencet1;
	}


	public void setAbscencet1(ViewAbscence abscencet1) {
		this.abscencet1 = abscencet1;
	}


	public Appreciation getAppt1() {
		return appt1;
	}


	public void setAppt1(Appreciation appt1) {
		this.appt1 = appt1;
	}


	public Appreciation getAppt2() {
		return appt2;
	}


	public void setAppt2(Appreciation appt2) {
		this.appt2 = appt2;
	}


	public Appreciation getAppt3() {
		return appt3;
	}


	public void setAppt3(Appreciation appt3) {
		this.appt3 = appt3;
	}


	public void setRang6(Long rang6) {
		this.rang6 = rang6;
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

	public LigneBulletinClasse getLignes() {
		return lignes;
	}


	public void setLignes(LigneBulletinClasse lignes) {
		this.lignes = lignes;
	}


	public Bulletin getBulletin() {
		return bulletin;
	}


	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}


	public Double getMoy() {
		return moy;
	}


	public void setMoy(Double moy) {
		this.moy = moy;
	}


	public Long getRang() {
		return rang;
	}


	public void setRang(Long rang) {
		this.rang = rang;
	}



	public Long getRangt1() {
		return rangt1;
	}


	public void setRangt1(Long rangt1) {
		this.rangt1 = rangt1;
	}


	public Long getRangt2() {
		return rangt2;
	}


	public void setRangt2(Long rangt2) {
		this.rangt2 = rangt2;
	}


	public Long getRangt3() {
		return rangt3;
	}


	public void setRangt3(Long rangt3) {
		this.rangt3 = rangt3;
	}


	public Double getNbmoyt1() {
		return nbmoyt1;
	}


	public void setNbmoyt1(Double nbmoyt1) {
		this.nbmoyt1 = nbmoyt1;
	}


	public Double getEcartt1() {
		return ecartt1;
	}


	public void setEcartt1(Double ecartt1) {
		this.ecartt1 = ecartt1;
	}


	public Double getMinmoyt1() {
		return minmoyt1;
	}


	public void setMinmoyt1(Double minmoyt1) {
		this.minmoyt1 = minmoyt1;
	}


	public Double getMoygent1() {
		return moygent1;
	}


	public void setMoygent1(Double moygent1) {
		this.moygent1 = moygent1;
	}


	public Double getMaxmoyt1() {
		return maxmoyt1;
	}


	public void setMaxmoyt1(Double maxmoyt1) {
		this.maxmoyt1 = maxmoyt1;
	}


	public Double getNbmoyt2() {
		return nbmoyt2;
	}


	public void setNbmoyt2(Double nbmoyt2) {
		this.nbmoyt2 = nbmoyt2;
	}


	public Double getEcartt2() {
		return ecartt2;
	}


	public void setEcartt2(Double ecartt2) {
		this.ecartt2 = ecartt2;
	}


	public Double getMinmoyt2() {
		return minmoyt2;
	}


	public void setMinmoyt2(Double minmoyt2) {
		this.minmoyt2 = minmoyt2;
	}


	public Double getMoygent2() {
		return moygent2;
	}


	public void setMoygent2(Double moygent2) {
		this.moygent2 = moygent2;
	}


	public Double getMaxmoyt2() {
		return maxmoyt2;
	}


	public void setMaxmoyt2(Double maxmoyt2) {
		this.maxmoyt2 = maxmoyt2;
	}


	public Double getNbmoyt3() {
		return nbmoyt3;
	}


	public void setNbmoyt3(Double nbmoyt3) {
		this.nbmoyt3 = nbmoyt3;
	}


	public Double getEcartt3() {
		return ecartt3;
	}


	public void setEcartt3(Double ecartt3) {
		this.ecartt3 = ecartt3;
	}


	public Double getMinmoyt3() {
		return minmoyt3;
	}


	public void setMinmoyt3(Double minmoyt3) {
		this.minmoyt3 = minmoyt3;
	}


	public Appreciation getAppreciation() {
		return appreciation;
	}




	public void setAppreciation(Appreciation appreciation) {
		this.appreciation = appreciation;
	}




	public Double getMoygent3() {
		return moygent3;
	}


	public void setMoygent3(Double moygent3) {
		this.moygent3 = moygent3;
	}


	public Double getMaxmoyt3() {
		return maxmoyt3;
	}


	public void setMaxmoyt3(Double maxmoyt3) {
		this.maxmoyt3 = maxmoyt3;
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

	public Long getTcoefs3() {
		return tcoefs3;
	}




	public void setTcoefs3(Long tcoefs3) {
		this.tcoefs3 = tcoefs3;
	}




	public Long getTcoefs4() {
		return tcoefs4;
	}




	public void setTcoefs4(Long tcoefs4) {
		this.tcoefs4 = tcoefs4;
	}




	public Long getTcoefs5() {
		return tcoefs5;
	}




	public void setTcoefs5(Long tcoefs5) {
		this.tcoefs5 = tcoefs5;
	}




	public Long getTcoefs6() {
		return tcoefs6;
	}




	public void setTcoefs6(Long tcoefs6) {
		this.tcoefs6 = tcoefs6;
	}




	public int compareTo(BulletinHelperGenerate o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
