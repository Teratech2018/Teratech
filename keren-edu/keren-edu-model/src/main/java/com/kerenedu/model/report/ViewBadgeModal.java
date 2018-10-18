/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseCycle;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.notes.CoefMatiereDetail;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_v_anniv")
public class ViewBadgeModal extends BaseElement implements Serializable, Comparable<ViewBadgeModal> {

			
	
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Cycle",type=Cycle.class,target="many-to-one",optional=true, observable=true)
	private Cycle cycle ;
	
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true )
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "CLASS_ID")
	//@Predicate(group = true,groupName = "tab1",groupLabel = "Matière",target = "one-to-many",type = CoefMatiereDetail.class,search = false,edittable=true)
//	@Observer(observable="section",source="method:setid")
	private List<CoefMatiereDetail> matdetailList = new ArrayList<CoefMatiereDetail>();
	
	
		
	


	public ViewBadgeModal() {
		// TODO Auto-generated constructor stub
	}


	public ViewBadgeModal(ViewBadgeModal entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		this.cycle = entity.cycle;
		if (entity.classe != null) {
			this.classe = new Classe(entity.classe);
		}
		if (entity.section != null) {
			this.section = new SectionE(entity.section);
		}

	}
	



	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewBadgeModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Badge";
	}

	public Cycle getCycle() {
		return cycle;
	}


	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}


	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Critères de Recherches";
	}




	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}


	public List<CoefMatiereDetail> getMatdetailList() {
		return matdetailList;
	}


	public void setMatdetailList(List<CoefMatiereDetail> matdetailList) {
		this.matdetailList = matdetailList;
	}
	
//
//	@Override
//	public boolean isCreateonfield() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	@Override
//	public boolean isDesablecreate() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isDesabledelete() {
//		// TODO Auto-generated method stub
//		return false;
//	}
	


}
