/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
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
    @JoinColumn(name = "MOD_ID")
	@Predicate(label="Selectionner Le Model de Bulletin",updatable=true,type=ModelBulletin.class , target="many-to-one", sequence=1)
    protected ModelBulletin model;
	
	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
//	@Predicate(label="Selectionner La Filiere",updatable=true,type=Filiere.class , target="many-to-one", sequence=2)
    protected Filiere filiere;
	
	@ManyToOne
    @JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Selectionner La Classe",updatable=true,type=Classe.class , target="many-to-one", sequence=2)
    protected Classe classe;
	

	public EdtBulletin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EdtBulletin(EdtBulletin bull) {
		super(bull.id, bull.designation, bull.moduleName);
		this.filiere = new Filiere(bull.filiere);
		this.classe = new Classe(bull.classe);
		this.model = new ModelBulletin(bull.model);
		

	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Saisir les Paramtres des Bulletins à Editer ";
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Saisir les Paramtres des Bulletins à Editer";
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

	

	public ModelBulletin getModel() {
		return model;
	}


	public void setModel(ModelBulletin model) {
		this.model = model;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public int compareTo(EdtBulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
