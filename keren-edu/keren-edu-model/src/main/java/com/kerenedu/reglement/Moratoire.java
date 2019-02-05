/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_moratoire")
public class Moratoire extends BaseElement implements Serializable, Comparable<Moratoire> {

	@ManyToOne
	@JoinColumn(name = "ElEVE_ID")
	@Predicate(label = "Sélectionner éléve", type = Inscription.class, target = "many-to-one", optional = false, sequence = 1, search=true)
	private Inscription eleve;
	
	@ManyToOne
	@JoinColumn(name = "FICHE_ID")
	@Predicate(label="SERVICE",updatable=true,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=2)
	protected FichePaiement service ;
	
	@Column(name = "DELAI")
	@Predicate(label="DELAI PAIEMENT",optional=false,updatable=false,search=true, type=Date.class,sequence=3, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date delai;

	@Column(name = "N_DATE")
	@Predicate(label = "Nouvelle Date Butoire", optional = false, updatable = true, search = true, type = Date.class, sequence = 4, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateDeb;
	
	@Column(name = "BLOC")
	@Predicate(label="Motif",optional=false,updatable=true,search=true, target="textarea", sequence=5)
	protected String motif;
	

	public Moratoire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moratoire(Moratoire ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		this.dateDeb = ins.dateDeb;
		if(ins.eleve!=null){
			this.eleve = new Inscription(ins.eleve);
		}
		if(ins.service!=null){
			this.service = new FichePaiement(ins.service);
		}
		this.motif=ins.motif;
		this.delai=ins.delai;

	}

	public Moratoire(Inscription eleve, FichePaiement service, Date dateDeb) {
		super();
		this.eleve = eleve;
		this.service = service;
		this.dateDeb = dateDeb;
		
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Moratoire o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Demande de Moratoire ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Demande de Moratoire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public FichePaiement getService() {
		return service;
	}

	public void setService(FichePaiement service) {
		this.service = service;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDelai() {
		return delai;
	}

	public void setDelai(Date delai) {
		this.delai = delai;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id + "";
	}

}
