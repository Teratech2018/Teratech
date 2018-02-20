/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.DossierMedical;
import com.kerenedu.school.Nationalite;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_service")
public class Service extends BaseElement implements Serializable, Comparable<Service> {
	

	@ManyToOne
    @JoinColumn(name = "FILIERE_ID")
	@Predicate(label="FILIERE",updatable=true,type=Filiere.class , target="many-to-one",search=true , sequence=1)
    protected Filiere filiere;
	
	@Column(name = "LIBELLE")	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true, sequence=2)
	protected String libelle;
	
	@Column(name = "MONTANT")	
	@Predicate(label="MONTANT",optional=true,updatable=false,search=true, sequence=3,type=BigDecimal.class , editable=false )
	protected BigDecimal zMnt;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "FRAIS_ID")
	@Predicate(label = "Liste Frais",target = "one-to-many",type = FraisScolaire.class,search = false, group=true,groupLabel="Frais",groupName="Frais Scolaire")
	private List<FraisScolaire> fraisScolaire = new ArrayList<FraisScolaire>();
	

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Service(Service service) {
		super(service.id, service.designation, service.moduleName);
		this.filiere = service.filiere;
		this.libelle=service.libelle;
		this.zMnt=service.zMnt;
		fraisScolaire= new ArrayList<FraisScolaire>();
		
//		for(FraisScolaire frais:service.fraisScolaire){
//			fraisScolaire.add(new FraisScolaire(frais));
//	    }
	}

	
	/**
	 * @return the filiere
	 */
	public Filiere getFiliere() {
		return filiere;
	}

	/**
	 * @param filiere the filiere to set
	 */
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	


		

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Frais de scolarité /  Filiere";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Frais de scolarité / Filiere";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return filiere.libelle;
	}


	public String getLibelle() {
		return libelle;
	}


	public BigDecimal getzMnt() {

		return zMnt;
	}


	public void setzMnt(BigDecimal zMnt) {
		this.zMnt = zMnt;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<FraisScolaire> getFraisScolaire() {
		return fraisScolaire;
	}


	public void setFraisScolaire(List<FraisScolaire> fraisScolaire) {
		this.fraisScolaire = fraisScolaire;
	}
	
	

}
