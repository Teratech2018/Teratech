/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.Examen;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class EdtBulletinModal extends BaseElement implements Serializable, Comparable<EdtBulletinModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	

//	@Column(name = "LIBELLE")
//	@Predicate(label="Type Bulletin",optional=false,updatable=true,search=true, target="combobox", values="1ere Sequence;2eme Sequence;3eme Sequence;4eme Sequence;5eme Sequence;6eme Sequence;1ere Trimestre;2éme Trimestre;3éme Trimestre" , sequence=1,colsequence=1)
//	protected String typebulletin="0";
	
	@ManyToOne
    @JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Selectionner La Classe",updatable=true,type=Classe.class , target="many-to-one", sequence=1, observable=true, optional=false)
    protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Examen",type=Examen.class,target="many-to-one",optional=false, sequence=2)
	@Filter(value = "[{\"fieldName\":\"cycle\",\"value\":\"object.classe\",\"searchfield\":\"typecycle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Classe\"}]")
	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	private Examen periode ;
	

	
	@Predicate(label="Elève Concerne ?",target="combobox",values="Tous les élèves;Seulement les élèves selectionnés",optional=false,sequence=2)
//	@Observer(observable="classe",source="method:getidclasse",parameters="classe")
	//@Filter(value="[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une classe\"}]")
	private String porte ="0";
	
	
	@ManyToMany
	@Predicate(label="EM",type=InscriptionChoice.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Elèves",hidden="temporalData.porte=='0' || temporalData.porte==null")
	@Observer(observable="classe",source="method:getidclasse",parameters="classe")
	private List<InscriptionChoice> concernes = new ArrayList<InscriptionChoice>();
	
	@Transient
	private List<Examen> examen = new ArrayList<Examen>();
	
//	@Transient
//	private List<ExamenP> examenp = new ArrayList<ExamenP>();
	
		
	
	

	public EdtBulletinModal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EdtBulletinModal(EdtBulletinModal bull) {
		super(bull.id, bull.designation, bull.moduleName,0L);
		this.classe = new Classe(bull.classe);
//		this.typebulletin=bull.typebulletin;
		this.porte=bull.porte;
		this.concernes= new ArrayList<InscriptionChoice>();
		

	}
	
	public EdtBulletinModal(Bulletin bull) {
		this.classe = new Classe(bull.getClasse());
//		this.typebulletin=bull.getModel().getTypesequence();
		this.porte="1" ;
		this.examen.add(bull.getModel());
	//	this.concernes.add(bull.getInscription());

	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Impression des bulletins Séquentiels";
	}


//	public String getTypebulletin() {
//		return typebulletin;
//	}
//
//
//	public void setTypebulletin(String typebulletin) {
//		this.typebulletin = typebulletin;
//	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Impression des bulletins Séquentiels";
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



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	


	public String getPorte() {
		return porte;
	}


	public void setPorte(String porte) {
		this.porte = porte;
	}


	public List<InscriptionChoice> getConcernes() {
		return concernes;
	}


	public void setConcernes(List<InscriptionChoice> concernes) {
		this.concernes = concernes;
	}


	public int compareTo(EdtBulletinModal o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Examen> getExamen() {
		return examen;
	}


	public Examen getPeriode() {
		return periode;
	}




	public void setPeriode(Examen periode) {
		this.periode = periode;
	}


	public void setExamen(List<Examen> examens) {
		this.examen = examens;
	}
	

}
