/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class ValiderSalaire extends BaseElement implements Serializable, Comparable<ValiderSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Structure",type=Etablissement.class,target="many-to-one",optional=false)
	private Etablissement societe ;
	
	@Predicate(label="Date de paiement",type=Date.class,target="date")
	private Date date ;
	
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	@Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	private PeriodePaie periode ;
	
	@Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
	@ManyToMany
	@Predicate(label="EM",type=BulletinPaie.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés",hidden="temporalData.porte=='0'||temporalData.periode==null||temporalData.periode.id=='load'")
    @Filter(value="[{\"fieldName\":\"periode\",\"value\":\"object.periode\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez sélectionner une periode\"}]")
	private List<BulletinPaie> concernes = new ArrayList<BulletinPaie>(); 
	
	/**
	 * 
	 */
	public ValiderSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ValiderSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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
	public ValiderSalaire(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<Professeur> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		
	}
	
	public ValiderSalaire(ValiderSalaire prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
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
	
	

	public Etablissement getSociete() {
		return societe;
	}

	public void setSociete(Etablissement societe) {
		this.societe = societe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public List<BulletinPaie> getConcernes() {
		return concernes;
	}

	public void setConcernes(List<BulletinPaie> concernes) {
		this.concernes = concernes;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Validation des salaires";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Validation des salaires";
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
	public int compareTo(ValiderSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
