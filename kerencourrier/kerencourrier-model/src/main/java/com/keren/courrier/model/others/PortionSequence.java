/**
 * 
 */
package com.keren.courrier.model.others;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name ="T_PSEQ")
public class PortionSequence extends BaseElement implements Serializable, Comparable<PortionSequence> {

	
	@Predicate(label = "Nature", target = "combobox", values = "static;sequence;genérer", search = true, optional=true)
	private String nature = "0";
	
	@Predicate(label = "nombre", optional=false ,type=Long.class, search=true)
	private long nbreCaractere  ;
	
	@Predicate(label = "valeur", optional=true , search=true) //	hidden = "temporalData.nature !='0'",
	private String valeur = "0";
	
	@Predicate(label = "Valeur Intial", optional=true  , search=true)//,hidden = "currentObject.nature =='0'",
	private String intivalue = "0";
	
	@Predicate(label = "Sequence", target = "combobox", values = "seqca;seqcd;seqci", search = true, optional=true)//			,hidden = "temporalData.nature =='1'"
	private String sequence = "0";
		
	@ManyToOne
	@JoinColumn(name = "T_POR_ID")
	@Predicate(label = "Précedent", type = PortionSequence.class, target = "many-to-one", search=true)
	private PortionSequence precedent;
	

	
	
	public PortionSequence(String nature, long nbreCaractere, String valeur, String intivalue,
			PortionSequence precedent) {
		super();
		this.nature = nature;
		this.nbreCaractere = nbreCaractere;
		this.valeur = valeur;
		this.intivalue = intivalue;
		this.precedent = precedent;
	}

	@Override
	public int compareTo(PortionSequence o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PortionSequence() {
		super();
		
		
	}
	
	public PortionSequence(PortionSequence entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.nature = entity.nature;
		this.nbreCaractere = entity.nbreCaractere;
		this.valeur = entity.valeur;
		this.intivalue = entity.intivalue;
		this.sequence=entity.sequence;
		if(entity.precedent!=null){
			this.precedent = new PortionSequence(entity.precedent) ;
		}
		
		
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public long getNbreCaractere() {
		return nbreCaractere;
	}

	public void setNbreCaractere(long nbreCaractere) {
		this.nbreCaractere = nbreCaractere;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getIntivalue() {
		return intivalue;
	}

	public void setIntivalue(String intivalue) {
		this.intivalue = intivalue;
	}

	public PortionSequence getPrecedent() {
		return precedent;
	}

	public void setPrecedent(PortionSequence precedent) {
		this.precedent = precedent;
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Portion Numero Document";
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Portion Numero Document";
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		String libelle ="";
		if(nature.equals("0")){
			libelle="static";
		}else if(nature.equals("0")){
			libelle="static";
		}else{
			libelle="genérer";
		}
		return getId()+"-"+libelle;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}


}
