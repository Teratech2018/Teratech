/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import com.core.tools.DateHelper;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_v_anniv")
public class ViewAnniversaireModal extends BaseElement implements Serializable, Comparable<ViewAnniversaireModal> {

		
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	//@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	@Transient
	@Column(name = "DATE_INS")
	//@Predicate(label="Date Début",optional=false,updatable=true,search=true, type=Date.class,target="date" ,sequence=3)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datInsdeb ;
	
	@Transient
	@Column(name = "DATE_INS")
	//@Predicate(label="Date Fin",optional=false,updatable=true,search=true, type=Date.class,target="date" ,sequence=4 )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datInsfin ;
	
	@Column(name = "Mois")
	@Predicate(label="Mois",optional=true,updatable=true,search=false, target="combobox", values="Janvier;Février;Mars;Avril;Mai;Juin;Juillet;Août;Septembre;octobre;Novembre;Decembre" , sequence=11)
	protected String mois="0";
	
		
	


	public ViewAnniversaireModal() {
		// TODO Auto-generated constructor stub
	}


	public ViewAnniversaireModal(ViewAnniversaireModal ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
			this.datInsdeb=ins.datInsdeb;
			this.datInsfin=ins.datInsfin;
			this.mois=ins.mois;

		
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

	public int compareTo(ViewAnniversaireModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Anniversaires: Selection des critères";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Anniversaires: Selection des critères";
	}

	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public Date getDatInsdeb() {
		return datInsdeb;
	}


	public void setDatInsdeb(Date datInsdeb) {
		this.datInsdeb = datInsdeb;
	}


	public Date getDatInsfin() {
		return datInsfin;
	}


	public void setDatInsfin(Date datInsfin) {
		this.datInsfin = datInsfin;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public String getMois() {
		return mois;
	}


	public void setMois(String mois) {
		this.mois = mois;
	}


	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
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
