/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.GroupeCours;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.MatiereNote;
import com.kerenedu.notes.NoteDetail;

/**
 * @author wapo
 *
 */
@Table
@Entity(name = "e_zview_note_helper")
public class ViewNoteHelper extends BaseElement implements Serializable, Comparable<ViewNoteHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name = "MAT_NOTE_ID")
	private MatiereNote matiereNote;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	private Classe classe;

	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	private Examen examen;

	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	private MatiereDlt matiere;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	private Inscription eleve;

	@ManyToOne
	@JoinColumn(name = "NOTE_ID")
	private NoteDetail notedlt;

	@Column(name = "NOTE")
	private Double note = new Double(0);

	@Column(name = "APPRECIATION")
	private String obs;

	@Column(name = "RANG")
	private Long rang = new Long(0);

	@Column(name = "RANG_MAT")
	private Long rangMat = new Long(0);

	// @ManyToOne
	// @JoinColumn(name="MOD_ID")
	// private GroupeCours model ;

	@Column(name = "MOY_CLA_MATIERE")
	private Double moyclasMat = new Double(0);

	@Column(name = "EXTR_MAX")
	private Double extrememax = new Double(0);

	@Column(name = "EXTR_MIN")
	private Double extremmemin = new Double(0);

	@Column(name = "TOTAL_POINT")
	private Double totalPoint = new Double(0);

	@Column(name = "TOTAL_COEF")
	private Long totalCoef = new Long(0);

	@Column(name = "MOY_ETUDIANT")
	private Double moyEtudiant = new Double(0);

	@Column(name = "MOY_PREMIER")
	private Double moyPremier = new Double(0);

	@Column(name = "MOY_DERNIER")
	private Double moyDernnier = new Double(0);
	
	@Column(name = "MOY_GEN_CLS")
	private Double moygencls = new Double(0);
	
	@Column(name = "NBRE_MOY")
	private Long nbreMoy = new Long(0);
	
	@Column(name = "TX_REU")
	private Double txReu = new Double(0);
	
	@Column(name = "ECART_TYPE")
	private Double ecartType = new Double(0);

	/**
	 * 
	 */
	public ViewNoteHelper() {
		// TODO Auto-generated constructor stub
	}

	
	

	public ViewNoteHelper(MatiereNote matiereNote, Classe classe, Examen examen, MatiereDlt matiere, Inscription eleve,
			NoteDetail notedlt, Double note, String obs, Long rang, Long rangMat, Double moyclasMat, Double extrememax,
			Double extremmemin, Double totalPoint, Long totalCoef, Double moyEtudiant, Double moyPremier,
			Double moyDernnier, Double moygencls, Long nbreMoy, Double txReu, Double ecartType) {
		super();
		this.matiereNote = matiereNote;
		this.classe = classe;
		this.examen = examen;
		this.matiere = matiere;
		this.eleve = eleve;
		this.notedlt = notedlt;
		this.note = note;
		this.obs = obs;
		this.rang = rang;
		this.rangMat = rangMat;
		this.moyclasMat = moyclasMat;
		this.extrememax = extrememax;
		this.extremmemin = extremmemin;
		this.totalPoint = totalPoint;
		this.totalCoef = totalCoef;
		this.moyEtudiant = moyEtudiant;
		this.moyPremier = moyPremier;
		this.moyDernnier = moyDernnier;
		this.moygencls = moygencls;
		this.nbreMoy = nbreMoy;
		this.txReu = txReu;
		this.ecartType = ecartType;
	}




	public ViewNoteHelper(ViewNoteHelper view) {
		super();
		this.matiereNote = view.matiereNote;
		this.classe = view.classe;
		this.examen = view.examen;
		this.matiere = view.matiere;
		this.eleve = view.eleve;
		this.notedlt = view.notedlt;
		this.note = view.note;
		this.obs = view.obs;
		// this.model = view.model;
		this.moyclasMat = view.moyclasMat;
		this.extrememax = view.extrememax;
		this.extremmemin = view.extremmemin;
		this.totalPoint = view.totalPoint;
		this.totalCoef = view.totalCoef;
		this.moyEtudiant = view.moyEtudiant;
		this.moyPremier = view.moyPremier;
		this.moyDernnier = view.moyDernnier;
		this.rangMat = view.rangMat;
		this.moygencls = view.moygencls;
		this.nbreMoy = view.nbreMoy;
		this.txReu = view.txReu;
		this.ecartType = view.ecartType;
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ViewNoteHelper(long id, String designation, String moduleName) {
		super(id, designation, moduleName, 0L);
		// TODO Auto-generated constructor stub
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public MatiereNote getMatiereNote() {
		return matiereNote;
	}

	public void setMatiereNote(MatiereNote matiereNote) {
		this.matiereNote = matiereNote;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public MatiereDlt getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereDlt matiere) {
		this.matiere = matiere;
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public NoteDetail getNotedlt() {
		return notedlt;
	}

	public void setNotedlt(NoteDetail notedlt) {
		this.notedlt = notedlt;
	}

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Double getExtrememax() {
		return extrememax;
	}

	public void setExtrememax(Double extrememax) {
		this.extrememax = extrememax;
	}

	public Double getExtremmemin() {
		return extremmemin;
	}

	public Long getRangMat() {
		return rangMat;
	}

	public void setRangMat(Long rangMat) {
		this.rangMat = rangMat;
	}

	public void setExtremmemin(Double extremmemin) {
		this.extremmemin = extremmemin;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getMoygencls() {
		return moygencls;
	}



	public void setMoygencls(Double moygencls) {
		this.moygencls = moygencls;
	}



	public Long getNbreMoy() {
		return nbreMoy;
	}



	public void setNbreMoy(Long nbreMoy) {
		this.nbreMoy = nbreMoy;
	}



	public Double getTxReu() {
		return txReu;
	}



	public void setTxReu(Double txReu) {
		this.txReu = txReu;
	}



	public Double getEcartType() {
		return ecartType;
	}



	public void setEcartType(Double ecartType) {
		this.ecartType = ecartType;
	}



	public Double getMoyclasMat() {
		return moyclasMat;
	}

	public Long getRang() {
		return rang;
	}

	public void setRang(Long rang) {
		this.rang = rang;
	}

	public void setMoyclasMat(Double moyclasMat) {
		this.moyclasMat = moyclasMat;
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

	public Double getMoyEtudiant() {
		return moyEtudiant;
	}

	public void setMoyEtudiant(Double moyEtudiant) {
		this.moyEtudiant = moyEtudiant;
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

	//
	// public GroupeCours getModel() {
	// return model;
	// }
	//
	// public void setModel(GroupeCours model) {
	// this.model = model;
	// }

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	public int compareTo(ViewNoteHelper o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

}
