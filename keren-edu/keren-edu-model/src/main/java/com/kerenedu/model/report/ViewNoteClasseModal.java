package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseSecondaire;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;



public class ViewNoteClasseModal extends BaseElement  implements Serializable, Comparable<ViewNoteClasseModal>
{
  @ManyToOne
  @JoinColumn(name="EXAMEN_ID")
  @Predicate(label="Examen", type=Examen.class, target="many-to-one", optional=false, sequence=1)
  private Examen examen;
  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  @Predicate(label="Classe", type=ClasseSecondaire.class, target="many-to-one", search=true, sequence=2, observable=true, optional=false)
  @Filter(value = "[{\"fieldName\":\"cycle\",\"value\":\"3\"}]")
  protected ClasseSecondaire classe;
  
  
  @ManyToMany
  @Predicate(label="EM", type=InscriptionChoice.class, target="many-to-many-list", group=true, groupName="group1", groupLabel="Liste des Elèves", hidden="temporalData.classe==null")
  @Observer(observable="classe", source="method:getidclasse", parameters="classe")
  private List<InscriptionChoice> eleve = new ArrayList<InscriptionChoice>();
  
  public ViewNoteClasseModal() {}
  
  public ViewNoteClasseModal(Examen examen, ClasseSecondaire classe)
  {
    this.examen = examen;
    this.classe = classe;
  }
  

  public ViewNoteClasseModal(ViewNoteClasseModal ins)
  {
    super(ins.id, ins.designation, ins.moduleName, 0L);
    
    if (ins.getClasse() != null) {
    	this.classe = new ClasseSecondaire(ins.getClasse());
    }
    
    if (ins.getExamen() != null) {
      this.examen = new Examen(ins.getExamen());
    }
  
  }
  





  public ClasseSecondaire getClasse()
  {
    return classe;
  }
  
  public void setClasse(ClasseSecondaire classe)
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
  

  public List<InscriptionChoice> getEleve() {
	return eleve;
}

public void setEleve(List<InscriptionChoice> eleve) {
	this.eleve = eleve;
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
  

}
