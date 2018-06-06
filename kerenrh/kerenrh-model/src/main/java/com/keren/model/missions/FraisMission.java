/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_FRAMISRH")
public class FraisMission extends BaseElement implements Serializable, Comparable<FraisMission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8908604862572690474L;
	
	@ManyToOne
	@JoinColumn(name="CATMIS_ID")
	@Predicate(label="Catégorie de Frais",type=CategorieFrais.class,target="many-to-one",optional=false,search=true)
	private CategorieFrais categorie ;
	
	@Predicate(label="Type de depense",target="combobox",values="Forfait Mission;Forfait journalier",search=true)
	private String type="0";
	
	@Predicate(label="Groupe de Frais",target="combobox",values="Mission;Logistique",search=true)
	private String groupe ="0";
	
	@Predicate(label="Mode de Paiement",target="combobox",values="En espèce;En nature",search=true)
	private String mode ="0";
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true)
	private Double montant = 0.0 ;

	/**
	 * 
	 */
	public FraisMission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public FraisMission(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param categorie
	 * @param type
	 * @param groupe
	 * @param mode
	 * @param montant
	 */

	public FraisMission(long id, String designation, String moduleName, CategorieFrais categorie, String type,
			String groupe, String mode, Double montant) {
		super(id, designation, moduleName,0L);
		this.categorie = categorie;
		this.type = type;
		this.groupe = groupe;
		this.mode = mode;
		this.montant = montant;
	}
	
	public FraisMission(FraisMission frais) {
		super(frais.id, frais.designation, frais.moduleName,frais.compareid);
		if(frais.categorie!=null){
			this.categorie = new CategorieFrais(frais.categorie);
		}
		this.type = frais.type;
		this.groupe = frais.groupe;
		this.mode = frais.mode;
		this.montant = frais.montant;
	}
	
	

	public CategorieFrais getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieFrais categorie) {
		this.categorie = categorie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Frais de Mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Frais de Mission";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return categorie.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(FraisMission o) {
		// TODO Auto-generated method stub
		return categorie.compareTo(o.categorie);
	}

}
