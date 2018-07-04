/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Filiere;
import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotations.TableFooter;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_profmatens")
public class ProfMatiereEns extends BaseElement implements Serializable, Comparable<ProfMatiereEns> {

	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label="Professeur",updatable=true,type=Professeur.class , target="many-to-one",search=true , sequence=1	)
	protected Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name = "FIL_ID")
	@Predicate(label="FILIERE",updatable=true,type=Filiere.class , target="many-to-one",search=true , sequence=2	)
	protected Filiere filiere;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "MATIERE_ENS_ID")
	@Predicate(label = "MATIERE",group = true,groupName = "tab1",groupLabel = "Matiére enseignes",target = "one-to-many",type = MatiereCoutProf.class,
	search = false,customfooter = true)
	 @TableFooter(value = "<tr style='border:none;'> <td></td><td  align='right'>Total Heure</td><td align='right'><b>heuretotal</b></td><td></td> </tr> <tr style='border:none;'> <td></td><td align='right'>Total Montant</td> <td align='right'>coutheure</td> <td></td></tr> <tr style='border:none;'><td></td><td align='right'>Total</td><td align='right'>heuretotal,*,coutheure</td><td></td> </tr>")
	private List<MatiereCoutProf> matiereEns = new ArrayList<MatiereCoutProf>();

	@ManyToOne
	@JoinColumn(name = "ANNEE_ID")
	protected AnneScolaire anneScolaire;
	
	

	public ProfMatiereEns() {
		//super();
		// TODO Auto-generated constructor stub
	}


	public ProfMatiereEns(Professeur professeur, Filiere filiere, List<MatiereCoutProf> matiereEns,
			AnneScolaire anneScolaire) {
		super();
		this.professeur = professeur;
		this.filiere = filiere;
		this.matiereEns = matiereEns;
		this.anneScolaire = anneScolaire;
	}


	public ProfMatiereEns(ProfMatiereEns ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.professeur = new Professeur(ins.professeur);;
		this.filiere = new Filiere(ins.filiere);;
		this.matiereEns = new ArrayList<MatiereCoutProf>();

	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ProfMatiereEns o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public List<MatiereCoutProf> getMatiereEns() {
		return matiereEns;
	}


	public void setMatiereEns(List<MatiereCoutProf> matiereEns) {
		this.matiereEns = matiereEns;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Attribution de Matières au Professeur";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Attribution de Matières au Professeur";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return professeur.nom;
	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	
	

}
