/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Entity
//@Table(name = "e_inscription")
public class ViewListeEleveModal extends BaseElement implements Serializable, Comparable<ViewListeEleveModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8430641365166122149L;


	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1, observable=true)
	private SectionE section ;
	
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",updatable=false,type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true, searchfields="libelle", colsequence=1)
	protected Classe classe ;
	

	
	
	
	


	public ViewListeEleveModal(SectionE section, Classe classe, Eleve eleve, String satut, Date datIns, Long zMnt,
			Long zMntPaye, Long zSolde, Long zRemise, Long zRistourne, Long zTotal, String anneScolaire, long cycle) {
		super();
		this.section = section;
		this.classe = classe;
		}


	public ViewListeEleveModal() {
		// TODO Auto-generated constructor stub
	}


	public ViewListeEleveModal(ViewListeEleveModal ins) {
		super(ins.id, ins.designation, ins.moduleName,ins.compareid);
	
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);	
//			this.cycle=ins.getClasse().getCycle();
			this.section=ins.getClasse().getSection();
		}
		
	}




//	public void setServiceList(Service serviceList) {
//		this.serviceList = serviceList;
//	}


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

	public int compareTo(ViewListeEleveModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves inscrits";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves inscrits";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Critère de Recherche ";
	}
	
//


	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	
	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}





	


	


}
