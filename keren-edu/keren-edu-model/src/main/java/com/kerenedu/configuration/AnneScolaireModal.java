/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
public class AnneScolaireModal extends BaseElement implements Serializable, Comparable<AnneScolaireModal> {
	
	@Transient
	@ManyToOne
    @JoinColumn(name = "ANNEEID")
	@Predicate(label="Année Scolaire ",updatable=true,type=AnneScolaire.class , target="many-to-one",search=false, sequence=1)
    protected AnneScolaire anneScolaire;
	
	@Transient
	@ManyToOne
    @JoinColumn(name = "CYCEID")
	@Predicate(label="Cycle ",updatable=true,type=Cycle.class , target="many-to-one",search=false, sequence=1)
    protected Cycle cycle;
	
	


	public AnneScolaireModal() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AnneScolaireModal(AnneScolaireModal annee) {
		super(annee.id, annee.designation, annee.moduleName,0L);
		if(annee.anneScolaire!=null){
			this.anneScolaire = annee.anneScolaire;	
		}
		if(annee.cycle!=null){
			this.cycle=annee.cycle;
		}
		
	}

	


	public int compareTo(AnneScolaireModal o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}

	public Cycle getCycle() {
		return cycle;
	}
	
	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}




	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Selectionnez Année Scolaire et le cycle ";
	}
	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Selectionnez Année Scolaire et le cycle";
	}



	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

}
