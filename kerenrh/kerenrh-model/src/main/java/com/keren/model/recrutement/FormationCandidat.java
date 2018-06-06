/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.structures.Etablissement;
import com.keren.model.structures.NiveauEtude;
import com.keren.model.structures.Specialite;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */

@Entity
@Table(name="T_FORCANRH")
public class FormationCandidat extends BaseElement implements Serializable, Comparable<FormationCandidat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382783685573021236L;
	
	@Predicate(label="Type de Formation",target="combobox",values="Académique;Professionnel;Autres",search=true)
	private String type ="0";
	
	@ManyToOne
	@JoinColumn(name="NIV_ID")
	@Predicate(label="Niveau d'étude",type=NiveauEtude.class,target="many-to-one",search=true)
	private NiveauEtude niveau ;
	
	@ManyToOne
	@JoinColumn(name="SPEC_ID")
	@Predicate(label="Spécialité",type=Specialite.class,target="many-to-one",search=true)
	private Specialite specialite ;	
	
	@ManyToOne
	@JoinColumn(name="ECOL_ID")
	@Predicate(label="Etablissement",type=Etablissement.class,target="many-to-one",search=true)
	private Etablissement ecole;

	/**
	 * 
	 */
	public FormationCandidat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public FormationCandidat(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param type
	 * @param niveau
	 * @param specialite
	 * @param ecole
	 */

	public FormationCandidat(long id, String designation, String moduleName, String type, NiveauEtude niveau,
			Specialite specialite, Etablissement ecole) {
		super(id, designation, moduleName,0L);
		this.type = type;
		this.niveau = niveau;
		this.specialite = specialite;
		this.ecole = ecole;
	}
	
	public FormationCandidat(FormationCandidat formation) {
		super(formation.id, formation.designation, formation.moduleName,formation.compareid);
		this.type = formation.type;
		this.niveau = formation.niveau;
		this.specialite = formation.specialite;
		this.ecole = formation.ecole;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public NiveauEtude getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauEtude niveau) {
		this.niveau = niveau;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Etablissement getEcole() {
		return ecole;
	}

	public void setEcole(Etablissement ecole) {
		this.ecole = ecole;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Formations";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FormationCandidat o) {
		// TODO Auto-generated method stub
		return niveau.compareTo(o.niveau);
	}

}
