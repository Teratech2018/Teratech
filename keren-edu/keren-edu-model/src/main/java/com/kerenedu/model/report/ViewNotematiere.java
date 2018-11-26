package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.MatiereNote;
import com.kerenedu.notes.NoteDetail;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table
@Entity(name="e_zview_note_matiere")
public class ViewNotematiere extends BaseElement   implements Serializable, Comparable<ViewNotematiere>
{
  private static final long serialVersionUID = 4083876520606273661L;
  
  
  @ManyToOne
  @JoinColumn(name="MAT_NOTE_ID")
  private MatiereNote matiereNote;
  
  
  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  private Classe classe;
  @ManyToOne
  @JoinColumn(name="EXAMEN_ID")
  private Examen examen;
  @ManyToOne
  @JoinColumn(name="MATIERE_ID")
  private CoefMatiereDetail matiere;
  
  public ViewNotematiere() {}
  
  public ViewNotematiere(MatiereNote matiereNote, Classe classe, Examen examen, CoefMatiereDetail matiere, Inscription eleve, NoteDetail notedlt, Double note, String obs, Long rang, Long rangMat, Double moyclasMat, Double extrememax, Double extremmemin, Double totalPoint, Long totalCoef, Double moyEtudiant, Double moyPremier, Double moyDernnier, Double moygencls, Long nbreMoy, Double txReu, Double ecartType)
  {
    this.matiereNote = matiereNote;
    this.classe = classe;
    this.examen = examen;
    this.matiere = matiere;
  }
  


  public ViewNotematiere(ViewNotematiere view)
  {
    this.matiereNote = new MatiereNote(view.getMatiereNote());
    this.classe = new Classe(view.classe);
    this.examen = new Examen(view.examen);
    this.matiere = new CoefMatiereDetail(view.matiere);
  }
  

  
  public Classe getClasse()
  {
    return classe;
  }
  
  public void setClasse(Classe classe) {
    this.classe = classe;
  }
  

  public String getEditTitle()
  {
    return "Traitement des notes";
  }
  

  public String getListTitle()
  {
    return "Traitement des notes";
  }
  

  public String getModuleName()
  {
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
  
  public CoefMatiereDetail getMatiere() {
    return matiere;
  }
  
  public void setMatiere(CoefMatiereDetail matiere) {
    this.matiere = matiere;
  }


  public String getDesignation()
  {
    return super.getDesignation();
  }
  
  public int compareTo(ViewNotematiere o)
  {
    return 0;
  }
}