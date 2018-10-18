/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

@Table
@Entity(name = "e_zview_bf")
public class ViewBilanFinancierModal extends BaseElement implements Serializable, Comparable<ViewBilanFinancierModal> {

	
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=true, sequence=1)
	private SectionE section ;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	
	
	public ViewBilanFinancierModal() {
		// TODO Auto-generated constructor stub
	}



	public ViewBilanFinancierModal(SectionE section, Classe classe) {
		super();
		this.section = section;
		this.classe = classe;
	}



	public ViewBilanFinancierModal(ViewBilanFinancierModal ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
		}
		
		if(ins.getSection()!=null){
			this.section=ins.section;
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

	public int compareTo(ViewBilanFinancierModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financier Détaillé ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financier Détaillé ";
	}

	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
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


	


}
