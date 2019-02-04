package com.kerenedu.configuration;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Table
@Entity(name="T_USER_CONNECT")
public class UtilisateurConnect
  extends BaseElement
  implements Serializable, Comparable<UtilisateurConnect>
{
  @ManyToOne
  @JoinColumn(name="USER_ID")
  @Predicate(label="Profil ", type=UserEducation.class, target="many-to-one", optional=false, sequence=1, search=true)
  private UserEducation compte;
  @Column(name="NOM")
  @Predicate(label="Nom ", optional=false, updatable=true, search=true, sequence=2)
  private String nom;
  @Column(name="PRENOM")
  @Predicate(label="Prénom ", optional=true, updatable=true, search=true, sequence=3)
  private String prenom;
  
  @Predicate(label="ALL ", updatable=true, search=true, type=Boolean.class, sequence=4, target="checkbox")
  protected Boolean allResponsabilite = Boolean.valueOf(false);
  
  @Predicate(label="Anti-Date ", updatable=true, search=true, type=Boolean.class, sequence=5, target="checkbox")
  protected Boolean antidate = Boolean.valueOf(false);
  
  @OneToMany(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true)
  @JoinColumn(name="RESP_ID")
  @Predicate(label="Responsabilité", updatable=true, type=Responsabilite.class, target="one-to-many", group=true, groupLabel="Responsablilités", groupName="tab1", edittable=true)
  protected List<Responsabilite> responsable;
  





  public UtilisateurConnect() {}
  





  public UtilisateurConnect(UtilisateurConnect entity)
  {
    super(entity.id, entity.designation, entity.moduleName, 0L);
    
    if (entity.compte != null) {
      compte = new UserEducation(entity.compte);
    }
    this.nom = entity.nom;
    this.prenom = entity.prenom;
    this.allResponsabilite =entity. allResponsabilite;
    this.responsable = new ArrayList<Responsabilite>();
    this.antidate=entity.antidate;
  }
  





  public UtilisateurConnect(UserEducation compte, String nom, String prenom, List<Responsabilite> responsable)
  {
    this.compte = compte;
    this.nom = nom;
    this.prenom = prenom;
    this.responsable = responsable;
  }
  





  public String getListTitle()
  {
    return "Année Scolaire";
  }
  

  public String getModuleName()
  {
    return "kereneducation";
  }
  

  public String getDesignation()
  {
    return "";
  }
  



  public int compareTo(UtilisateurConnect o)
  {
    return 0;
  }
  
  public UserEducation getCompte()
  {
    return compte;
  }
  
  public void setCompte(UserEducation compte)
  {
    this.compte = compte;
  }
  
  public String getNom()
  {
    return nom;
  }
  
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  
  public String getPrenom()
  {
    return prenom;
  }
  
  public void setPrenom(String prenom)
  {
    this.prenom = prenom;
  }
  
  public List<Responsabilite> getResponsable()
  {
    return responsable;
  }
  
  public void setResponsable(List<Responsabilite> responsable)
  {
    this.responsable = responsable;
  }
  
  public Boolean getAllResponsabilite() {
    return allResponsabilite;
  }
  



  public void setAllResponsabilite(Boolean allResponsabilite)
  {
    this.allResponsabilite = allResponsabilite;
  }
  



  public List<SectionE> getlistSection()
  {
    List<SectionE> datas = new ArrayList();
    
    for (Responsabilite r : responsable) {
      datas.add(r.getSection());
    }
    
    return datas;
  }
  
  public Boolean getAntidate() {
	return antidate;
}






public void setAntidate(Boolean antidate) {
	this.antidate = antidate;
}






public List<Cycle> getlistCycle()
  {
    List<Cycle> datas = new ArrayList();
    
    for (Responsabilite r : responsable) {
      datas.add(r.getCycle());
    }
    
    return datas;
  }
}
