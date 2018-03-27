/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.structures.Departement;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class PayerSalaire extends BaseElement implements Serializable, Comparable<PayerSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Structure",type=Societe.class,target="many-to-one",optional=false)
	private Societe societe ;
	
	@Predicate(label="Date de paiement",type=Date.class,target="date")
	private Date date ;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	private PeriodePaie periode ;
	
	@Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
	
	@ManyToMany
	@Predicate(label="EM",type=Employe.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés")
	private List<Employe> concernes = new ArrayList<Employe>(); 
	
	/**
	 * 
	 */
	public PayerSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PayerSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param periode
	 * @param porte
	 * @param concernes
	 */
	public PayerSalaire(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<Employe> concernes) {
		super(id, designation, moduleName);
		this.periode = periode;
		
	}
	
	public PayerSalaire(PayerSalaire prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
		
	}
	
	

	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Ordre de paiement des salaires";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ordre de paiement des salaires";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
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
	public int compareTo(PayerSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
