package com.kerenedu.notes;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class ImportNoteModal
  extends BaseElement
  implements Serializable, Comparable<ImportNoteModal>
{
  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  @Predicate(label="CLASSE", type=Classe.class, target="many-to-one", search=true, sequence=2, optional=false)
  protected Classe classe;
  @ManyToOne
  @JoinColumn(name="MATIERE_ID")
  @Predicate(label="MATIERE", optional=false, search=true, sequence=1, type=CoefMatiereDetail.class)
  @Filter("[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Classe\"}]")
  protected CoefMatiereDetail matiere;
  @ManyToOne
  @JoinColumn(name="EXAMEN_ID")
  @Predicate(label="EXAMEN", type=Examen.class, target="many-to-one", search=true, sequence=3, optional=false)
  protected Examen examen;
  @Predicate(label="Fichier lié", target="file", search=true, sequence=5)
  private String filename;
  @Predicate(label="", type=Long.class, search=true, sequence=6)
  private String className;
  
  public ImportNoteModal(Professeur prof, CoefMatiereDetail matiere, Classe classe, Examen examen, String filename)
  {
    this.matiere = matiere;
    this.classe = classe;
    this.examen = examen;
    this.filename = filename;
  }
  
  public ImportNoteModal(ImportNoteModal entity) {
    super(entity.id, entity.designation, entity.moduleName, 0L);
    this.matiere =new CoefMatiereDetail( entity.matiere);
    this. classe = new Classe(entity.getClasse());
    this.examen = new Examen( entity.examen);
    this.filename = entity.filename;
  }
  


  public ImportNoteModal() {}
  


  public int compareTo(ImportNoteModal o)
  {
    return 0;
  }
  


  public CoefMatiereDetail getMatiere()
  {
    return matiere;
  }
  

  public void setMatiere(CoefMatiereDetail matiere)
  {
    this.matiere = matiere;
  }
  

  public Classe getClasse()
  {
    return classe;
  }
  

  public void setClasse(Classe classe)
  {
    this.classe = classe;
  }
  

  public Examen getExamen()
  {
    return examen;
  }
  

  public void setExamen(Examen examen)
  {
    this.examen = examen;
  }
  

  public String getFilename()
  {
    return filename;
  }
  

  public void setFilename(String filename)
  {
    this.filename = filename;
  }
  
  public String getEditTitle()
  {
    return "Imorter les notes  ";
  }
  

  public String getListTitle()
  {
    return "Importer les notes";
  }
  

  public String getDesignation()
  {
    return matiere.getMatiere().getLibelle();
  }
  
  public String getClassName() {
    return className;
  }
  
  public void setClassName(String className) {
    this.className = className;
  }
  


  public String getModuleName()
  {
    return "kereneducation";
  }
  
  public String toString()
  {
    return "ImportNote [matiere=" + matiere + ", classe=" + classe + ", examen=" + examen + ", filename=" + filename + "]";
  }
}
