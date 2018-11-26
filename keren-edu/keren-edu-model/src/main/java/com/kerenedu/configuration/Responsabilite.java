package com.kerenedu.configuration;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Table
@Entity(name="T_USER_CRESP")
public class Responsabilite
  extends BaseElement
  implements Serializable, Comparable<Responsabilite>
{
  @ManyToOne
  @JoinColumn(name="SECTION_ID")
  @Predicate(label="SECTION", type=SectionE.class, target="many-to-one", optional=false, search=true, sequence=1)
  private SectionE section;
  @ManyToOne
  @JoinColumn(name="CYCLE_ID")
  @Predicate(label="Cycle", type=Cycle.class, target="many-to-one", optional=false, search=true, sequence=2)
  private Cycle cycle;
  
  public Responsabilite() {}
  
  public Responsabilite(Responsabilite entity)
  {
    super(entity.id, entity.designation, entity.moduleName, entity.compareid);
    if (entity.section != null) {
      this.section = entity.section;
    }
    if (entity.cycle != null) {
        this.cycle = entity.cycle;
    }
  }
  


  public Responsabilite(SectionE section, Cycle cycle)
  {
    this.section = section;
    this.cycle = cycle;
  }
  





  public String getListTitle()
  {
    return "Responsabilité Utilisateur";
  }
  

  public String getModuleName()
  {
    return "kereneducation";
  }
  

  public String getDesignation()
  {
    return "";
  }
  



  public int compareTo(Responsabilite o)
  {
    return 0;
  }
  
  public SectionE getSection()
  {
    return section;
  }
  
  public void setSection(SectionE section)
  {
    this.section = section;
  }
  
  public Cycle getCycle()
  {
    return cycle;
  }
  
  public void setCycle(Cycle cycle)
  {
    this.cycle = cycle;
  }
}
