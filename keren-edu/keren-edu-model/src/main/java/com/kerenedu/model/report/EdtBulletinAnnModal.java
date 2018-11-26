package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;





















public class EdtBulletinAnnModal
  extends BaseElement
  implements Serializable, Comparable<EdtBulletinAnnModal>
{
  private static final long serialVersionUID = -4609375799032659501L;
  @ManyToOne
  @JoinColumn(name="PERI_ID")
  private Examen periode;
  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  @Predicate(label="Selectionner La Classe", updatable=true, type=Classe.class, target="many-to-one", sequence=3, observable=true, optional=false)
  protected Classe classe;
  @Predicate(label="Elève Concerne ?", target="combobox", values="Tous les élèves;Seulement les élèves selectionnés", optional=false, sequence=2)
  @Observer(observable="classe", source="method:getidclasse", parameters="classe")
  private String porte = "0";
  


  @ManyToMany
  @Predicate(label="EM", type=Inscription.class, target="many-to-many-list", group=true, groupName="group1", groupLabel="Liste des Elèves", hidden="temporalData.porte=='0' || temporalData.porte==null")
  private List<Inscription> concernes = new ArrayList();
  

  @Transient
  private List<Examen> examen = new ArrayList();
  






  public EdtBulletinAnnModal() {}
  





  public EdtBulletinAnnModal(EdtBulletinAnnModal bull)
  {
    super(bull.id, bull.designation, bull.moduleName, 0L);
    this.classe = new Classe(bull.classe);
    
    this.porte = bull.porte;
    this.concernes = new ArrayList<Inscription>();
  }
  

  public EdtBulletinAnnModal(Bulletin bull)
  {
	  this.classe = new Classe(bull.getClasse());
    
	  this.porte = "1";
	  this.examen.add(bull.getModel());
	  this.concernes.add(bull.getInscription());
  }
  




  public String getEditTitle()
  {
    return "Impression des Bulletins Annuels";
  }
  












  public String getListTitle()
  {
    return "Impression des Bulletins Annuels";
  }
  

  public String getModuleName()
  {
    return "kereneducation";
  }
  

  public String getDesignation()
  {
    return "";
  }
  

  public Classe getClasse()
  {
    return classe;
  }
  

  public void setClasse(Classe classe)
  {
    this.classe = classe;
  }
  



  public String getPorte()
  {
    return porte;
  }
  
  public void setPorte(String porte)
  {
    this.porte = porte;
  }
  
  public List<Inscription> getConcernes()
  {
    return concernes;
  }
  
  public void setConcernes(List<Inscription> concernes)
  {
    this.concernes = concernes;
  }
  

  public int compareTo(EdtBulletinAnnModal o)
  {
    return 0;
  }
  
  public List<Examen> getExamen()
  {
    return examen;
  }
  
  public Examen getPeriode()
  {
    return periode;
  }
  


  public void setPeriode(Examen periode)
  {
    this.periode = periode;
  }
  
  public void setExamen(List<Examen> examens)
  {
    examen = examens;
  }
}
