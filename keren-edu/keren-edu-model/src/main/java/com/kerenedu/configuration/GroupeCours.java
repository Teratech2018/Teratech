/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_module")
public class GroupeCours extends BaseElement implements Serializable, Comparable<GroupeCours> {
	
	@Column(name = "CODE", unique=true)	
	@Predicate(label="CODE",optional=false,updatable=true,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE")	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String libelle;
	
//	@Column(name = "COEF")	
//	@Predicate(label="Coeficient",optional=true,updatable=true,search=true , sequence=3, colsequence=3, editable=false)
//	protected String coef;
//	
//	@ManyToOne 
//    @JoinColumn(name = "UNITE_ID")
//	@Predicate(label = "Unité d'enseignement",target = "many-to-one",type = UniteEns.class,search = true  , sequence=4, colsequence=4)
//	private UniteEns unite = new UniteEns();
//	
//	@ManyToOne 
//    @JoinColumn(name = "CLASSE_ID")
//	@Predicate(label = "CLASSE",target = "many-to-one",type = Classe.class,search =false  , sequence=5, colsequence=5 , observable=true)
//	private Classe classe = new Classe();
//	
//	@Transient
//	@ManyToOne 
//    @JoinColumn(name ="FILIERE_ID")
//	@Predicate(label = "Filiere",target = "many-to-one",type = Filiere.class,search =false  , sequence=6,hide=true)
//	@Observer(observable="classe",source="field:filiere")
//	private Filiere filiere = new Filiere();
	
	
//	@ManyToMany(fetch = FetchType.LAZY)
//  @JoinColumn(name = "MATIERE_ID")
//	@Predicate(group = true,groupName = "tab1",groupLabel = "MATIERE",target = "many-to-many-list",type = MatiereDlt.class,search = false)
//	@Filter(value="[{\"fieldName\":\"filiere\",\"value\":\"object.filiere\",\"searchfield\":\"code\"}]")
//	private List<MatiereDlt> matiereList = new ArrayList<MatiereDlt>();
	
	


	public GroupeCours() {
		super();
	}


	public GroupeCours(GroupeCours annee) {
		super(annee.id, annee.designation, annee.moduleName,0L);
		this.code = annee.code;
		this.libelle = annee.libelle;
//		this.matiereList= new ArrayList<MatiereDlt>();

	}

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Module";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Modules";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+"-"+libelle;
	}



	public int compareTo(GroupeCours o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
