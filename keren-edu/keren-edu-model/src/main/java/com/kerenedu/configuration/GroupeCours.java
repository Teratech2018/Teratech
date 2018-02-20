/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE")	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String libelle;
	
	@Column(name = "COEF")	
	@Predicate(label="Coeficient",optional=true,updatable=true,search=true , sequence=3, colsequence=3, editable=false)
	protected String coef;
	
	@ManyToOne 
    @JoinColumn(name = "UNITE_ID")
	@Predicate(label = "Unité d'enseignement",target = "many-to-one",type = UniteEns.class,search = true  , sequence=4, colsequence=4)
	private UniteEns unite = new UniteEns();
	
	@ManyToOne 
    @JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "CLASSE",target = "many-to-one",type = Classe.class,search =false  , sequence=5, colsequence=5)
	private Classe classe = new Classe();
	
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "MATIERE",target = "many-to-many-list",type = Matiere.class,search = false)
	private List<Matiere> matiereList = new ArrayList<Matiere>();
	
	


	public GroupeCours() {
		super();
	}


	public GroupeCours(GroupeCours annee) {
		super(annee.id, annee.designation, annee.moduleName);
		this.code = annee.code;
		this.libelle = annee.libelle;
		this.coef = annee.coef;
		this.unite=new UniteEns(annee.unite);
		this.classe=new Classe(annee.classe);
		this.matiereList= new ArrayList<Matiere>();

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


	public String getCoef() {
		return coef;
	}


	public void setCoef(String coef) {
		this.coef = coef;
	}


	public UniteEns getUnite() {
		return unite;
	}


	public void setUnite(UniteEns unite) {
		this.unite = unite;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public List<Matiere> getMatiereList() {
		return matiereList;
	}


	public void setMatiereList(List<Matiere> matiereList) {
		this.matiereList = matiereList;
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
		return "Module";
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
