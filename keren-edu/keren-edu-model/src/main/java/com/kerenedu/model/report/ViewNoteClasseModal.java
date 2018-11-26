package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class ViewNoteClasseModal extends BaseElement  implements Serializable, Comparable<ViewNoteClasseModal>
{
  @ManyToOne
  @JoinColumn(name="EXAMEN_ID")
  @Predicate(label="Examen", type=Examen.class, target="many-to-one", optional=true, sequence=1)
  private Examen examen;
  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  @Predicate(label="Classe", type=Classe.class, target="many-to-one", search=true, sequence=2, observable=true)
  protected Classe classe;
  @ManyToOne
  @JoinColumn(name="Eleve_ID")
  @Predicate(label="Eleve", type=Inscription.class, target="many-to-one", search=true, sequence=3)
  protected Inscription eleve;
  
  public ViewNoteClasseModal() {}
  
  public ViewNoteClasseModal(Examen examen, Classe classe)
  {
    this.examen = examen;
    this.classe = classe;
  }
  

  public ViewNoteClasseModal(ViewNoteClasseModal ins)
  {
    super(ins.id, ins.designation, ins.moduleName, 0L);
    
    if (ins.getClasse() != null) {
    	this.classe = new Classe(ins.getClasse());
    }
    
    if (ins.getExamen() != null) {
      this.examen = new Examen(ins.getExamen());
    }
    if (ins.getEleve() != null) {
      this.eleve = new Inscription(ins.getEleve());
    }
  }
  





  public Classe getClasse()
  {
    return classe;
  }
  
  public void setClasse(Classe classe)
  {
    this.classe = classe;
  }
  


  public int hashCode()
  {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(Long.valueOf(id));
    return hash;
  }
  
  public int compareTo(ViewNoteClasseModal o)
  {
    return 0;
  }
  
  public String getEditTitle()
  {
    return "Sélectionnez la Classe ";
  }
  

  public String getListTitle()
  {
    return "Sélectionnez la Classe ";
  }
  


  public String getModuleName()
  {
    return "kereneducation";
  }
  

  public String getDesignation()
  {
    return "";
  }
  

  public Examen getExamen()
  {
    return examen;
  }
  

  public void setExamen(Examen examen)
  {
    this.examen = examen;
  }
  

  public Inscription getEleve()
  {
    return eleve;
  }
  

  public void setEleve(Inscription eleve)
  {
    this.eleve = eleve;
  }
}
