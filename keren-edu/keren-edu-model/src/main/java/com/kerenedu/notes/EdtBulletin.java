/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
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

	@Column(name = "LIBELLE")
	@Predicate(label="Type Bulletin",optional=false,updatable=true,search=true, target="combobox", values="1ere Trimestre;2eme Trimestre;3éme Trimestre" , sequence=2,colsequence=1)
	protected String typebulletin="0";
	
	
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
		super(bull.id, bull.designation, bull.moduleName,0L);
		this.filiere = new Filiere(bull.filiere);
		this.classe = new Classe(bull.classe);
		this.typebulletin=bull.typebulletin;
		

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

	


	public String getTypebulletin() {
		return typebulletin;
	}


	public void setTypebulletin(String typebulletin) {
		this.typebulletin = typebulletin;
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
