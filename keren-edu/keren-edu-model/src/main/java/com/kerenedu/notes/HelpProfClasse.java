/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_zview_profclasse")
public class HelpProfClasse extends BaseElement implements Serializable, Comparable<HelpProfClasse> {

	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "PROF.", target = "many-to-one", type = Professeur.class, search = true, sequence = 2, colsequence = 2)
	private Professeur proffesseur;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	private Classe classe;

	public HelpProfClasse() {
		super();
	}

	public HelpProfClasse(HelpProfClasse cmatdetail) {
		super(cmatdetail.id, cmatdetail.designation, cmatdetail.moduleName, 0L);

		if (cmatdetail.proffesseur != null) {
			this.proffesseur = new Professeur(cmatdetail.proffesseur);
		}

		if (cmatdetail.classe != null) {
			this.classe = new Classe(cmatdetail.classe);
		}

	}
	
	public HelpProfClasse(CoefMatiereDetail coef) {

			this.proffesseur = new Professeur(coef.getProffesseur());
			this.classe = new Classe(coef.getClasse());

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Professeur";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Professeur";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	
	public Professeur getProffesseur() {
		return proffesseur;
	}

	public void setProffesseur(Professeur proffesseur) {
		this.proffesseur = proffesseur;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	

	public int compareTo(HelpProfClasse o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
