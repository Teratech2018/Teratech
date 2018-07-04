/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_mat")
public class Matiere extends BaseElement implements Serializable, Comparable<Matiere> {
	

	@ManyToOne 
    @JoinColumn(name = "FILIERE_ID",unique=true)
	@Predicate(label = "FILIERE",target = "many-to-one",type = Filiere.class,search = true  , sequence=1, colsequence=2)
	private Filiere filiere = new Filiere();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "MATIERE",target = "one-to-many",type = MatiereDlt.class,search = false,edittable=true)
	private List<MatiereDlt> matieres = new ArrayList<MatiereDlt>();

	
		


	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Matiere(Matiere filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.filiere=filiere.filiere;
		this.matieres= new ArrayList<MatiereDlt>();

	}

	


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres /Filière";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres /Filière";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return filiere.getLibelle();
	}


	


	public List<MatiereDlt> getMatieres() {
		return matieres;
	}


	public void setMatieres(List<MatiereDlt> matieres) {
		this.matieres = matieres;
	}


	public int compareTo(Matiere o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Filiere getFiliere() {
		return filiere;
	}




	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	

}
