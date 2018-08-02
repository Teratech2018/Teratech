/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_v_list_elev")
public class ViewListeEleve extends BaseElement implements Serializable, Comparable<ViewListeEleve> {

		
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	//@Predicate(label="Elève",updatable=true,type=Eleve.class , target="many-to-one",search=true ,observable=true	)
	protected Eleve eleve ;
	
	@Transient
	@Column(name = "TUTEUR")
	//@Predicate(label="Tuteur",optional=false,updatable=true,search=true )
	protected String tuteur ;
	
	@Transient
	@Column(name = "CONTACT")
	//@Predicate(label="Contact Tuteur",optional=false,updatable=true,search=true )
	protected String contacttuteur ;
	
	@Transient
	@Column(name = "GENRE")
	//@Predicate(label="Genre",optional=false,updatable=true,search=true )
	protected String genre ;
	
	@Transient
	@Column(name = "QUARTIER")
//	@Predicate(label="Quartier d'Habitation",optional=false,updatable=true,search=true )
	protected String quartier ;
	
	
	@Transient
	@Column(name = "DATE_INS")
	//@Predicate(label="Date Anniversaire",optional=false,updatable=true,search=true, type=Date.class,target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datIns ;
	
	
	
	


	public ViewListeEleve() {
		// TODO Auto-generated constructor stub
	}


	public ViewListeEleve(ViewListeEleve ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(ins.eleve!=null){
			this.eleve = new Eleve(ins.eleve);
			this.genre=ins.getEleve().getSexe();
			this.quartier=ins.getEleve().getQuartier();
			if(ins.getEleve().getResp()!=null){
				this.contacttuteur=ins.getEleve().getResp().getTel();
				this.tuteur=ins.getEleve().getResp().getNom();
			}
		}
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
		}
	
		
	}
	

	public ViewListeEleve(Inscription ins) {
		this.id=ins.getId();
		this.designation=ins.getDesignation();
		this.eleve = new Eleve(ins.getEleve());
		this.classe = new Classe(ins.getClasse());
		this.genre=ins.getEleve().getSexe();
		this.quartier=ins.getEleve().getQuartier();
		if(ins.getEleve().getResp()!=null){
			this.contacttuteur=ins.getEleve().getResp().getTel();
			this.tuteur=ins.getEleve().getResp().getNom();
		}
		
		
		
	}




//	public void setServiceList(Service serviceList) {
//		this.serviceList = serviceList;
//	}


	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	

	public Date getDatIns() {
		return datIns;
	}


	public void setDatIns(Date datIns) {
		this.datIns = datIns;
	}





	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewListeEleve o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getMatricule()+"-"+eleve.getNom();
	}
	
//

	public String getTuteur() {
		return tuteur;
	}


	public void setTuteur(String tuteur) {
		this.tuteur = tuteur;
	}


	public String getContacttuteur() {
		return contacttuteur;
	}


	public void setContacttuteur(String contacttuteur) {
		this.contacttuteur = contacttuteur;
	}


	public String getGenre() {
		return genre;
	}


	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getQuartier() {
		return quartier;
	}


	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}


	


	


}
