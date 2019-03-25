/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseSecondaire;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.inscription.InscriptionChoice;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class EdtBulletin extends BaseElement implements Serializable, Comparable<EdtBulletin> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=ClasseSecondaire.class , target="many-to-one",search=true , sequence=1, observable=true, optional=false)
	@Filter(value="[{\"fieldName\":\"typecycle\",\"value\":\"2\"}]")
	protected ClasseSecondaire classe ;

	@ManyToOne
    @JoinColumn(name = "SEQ_ID")
	@Predicate(label="Sequence",updatable=true,type=Examen.class , target="many-to-one", sequence=2, optional=false)
	@Filter(value="[{\"fieldName\":\"state\",\"operator\":\"!=\",\"value\":\"ferme\"}]")
    protected Examen seq;

//	@Column(name = "LIBELLE")
//	@Predicate(label="Type Bulletin",optional=false,updatable=true,search=true, target="combobox", values="1ere Trimestre;2eme Trimestre;3éme Trimestre" , sequence=2,colsequence=1)
//	protected String typebulletin="0";
//	
	
	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
//	@Predicate(label="Selectionner La Filiere",updatable=true,type=Filiere.class , target="many-to-one", sequence=2)
    protected Filiere filiere;
//	
//	@Transient
//	@ManyToOne
//	@JoinColumn(name="SECTION_ID")
//	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=2)
//	private SectionE section ;
//	

	@Predicate(label="Elève Concerne ?",target="combobox",values="Tous les élèves;Seulement les élèves selectionnés",optional=false,sequence=3)
	//@Filter(value="[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une classe\"}]")
	private String porte ="0";
	
	@ManyToMany
	@Predicate(label="EM",type=InscriptionChoice.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Elèves",hidden="temporalData.porte!='1'")
	@Observer(observable="classe",source="method:getidclasse",parameters="classe")
	private List<InscriptionChoice> concernes = new ArrayList<InscriptionChoice>();
	

	public EdtBulletin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EdtBulletin(EdtBulletin bull) {
		super(bull.id, bull.designation, bull.moduleName,0L);
		this.filiere = new Filiere(bull.filiere);
		this.classe = new ClasseSecondaire(bull.classe);
	//	this.section= new SectionE(bull.getSection());
		this.seq=bull.seq;
		

	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes ";
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Traitement des notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return seq.getDesignation();
	}




	public Examen getSeq() {
		return seq;
	}


	public void setSeq(Examen seq) {
		this.seq = seq;
	}


	public Filiere getFiliere() {
		return filiere;
	}




	public ClasseSecondaire getClasse() {
		return classe;
	}

//
//
//	public SectionE getSection() {
//		return section;
//	}
//
//
//	public void setSection(SectionE section) {
//		this.section = section;
//	}


	public void setClasse(ClasseSecondaire classe) {
		this.classe = classe;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
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


	public int compareTo(EdtBulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
