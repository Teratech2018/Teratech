package com.kerenedu.model.report;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseSecondaire;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;













public class EdtBulletinTrimModal
  extends BaseElement
  implements Serializable, Comparable<EdtBulletinTrimModal>
{
  private static final long serialVersionUID = -4609375799032659501L;
  @Column(name="LIBELLE")
  @Predicate(label="Type Bulletin", optional=false, updatable=true, search=true, target="combobox", values="1ere Trimestre;2éme Trimestre;3éme Trimestre", sequence=1, colsequence=1)
  protected String typebulletin = "0";
  

  @ManyToOne
  @JoinColumn(name="PERI_ID")
  private Examen periode;
  

  @ManyToOne
  @JoinColumn(name="CLASSE_ID")
  @Predicate(label="Selectionner La Classe", updatable=true, type=ClasseSecondaire.class, target="many-to-one", sequence=2, observable=true, optional=false)
  protected ClasseSecondaire classe;
  

  @Predicate(label="Elève Concerne ?", target="combobox", values="Tous les élèves;Seulement les élèves selectionnés", optional=false, sequence=3)
  private String porte = "0";
  @ManyToMany
  @Predicate(label="EM", type=InscriptionChoice.class, target="many-to-many-list", group=true, groupName="group1", groupLabel="Liste des Elèves", hidden="temporalData.porte=='0' || temporalData.porte==null")
  @Observer(observable="classe", source="method:getidclasse", parameters="classe")
  private List<InscriptionChoice> concernes = new ArrayList();
  


  @Transient
  private List<Examen> examen = new ArrayList();
  






  public EdtBulletinTrimModal() {}
  





  public EdtBulletinTrimModal(EdtBulletinTrimModal bull)
  {
    super(bull.id, bull.designation, bull.moduleName, 0L);
    this.classe = new ClasseSecondaire(bull.classe);
    this.typebulletin = bull.typebulletin;
    this.porte =  bull.porte;
    this.concernes = new ArrayList<InscriptionChoice>();
  }
  

  public EdtBulletinTrimModal(Bulletin bull)
  {
	  this.classe = new ClasseSecondaire(bull.getClasse());
	  this.typebulletin = bull.getModel().getTypesequence();
	  this.porte = "1";
	  this.examen.add(bull.getModel());
    
	  this. concernes = new ArrayList<InscriptionChoice>();
  }
  




  public String getEditTitle()
  {
    return "Impression des bulletins Trimestriels ";
  }
  












  public String getListTitle()
  {
    return "Impression des bulletins Trimestriels";
  }
  

  public String getModuleName()
  {
    return "kereneducation";
  }
  

  public String getDesignation()
  {
    return "";
  }
  

  public ClasseSecondaire getClasse()
  {
    return classe;
  }
  

  public void setClasse(ClasseSecondaire classe)
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
  
  public List<InscriptionChoice> getConcernes()
  {
    return concernes;
  }
  
  public void setConcernes(List<InscriptionChoice> concernes)
  {
    this.concernes = concernes;
  }
  

  public int compareTo(EdtBulletinTrimModal o)
  {
    return 0;
  }
  
  public List<Examen> getExamen()
  {
    return examen;
  }
  
  public String getTypebulletin()
  {
    return typebulletin;
  }
  
  public void setTypebulletin(String typebulletin)
  {
    this.typebulletin = typebulletin;
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
