/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_SANC")
public class Sanction extends BaseElement implements Serializable, Comparable<Sanction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2062764020303145550L;
	
	@Predicate(label="Sanction",target="combobox",values="Avertissement;Lettre d'observation;Blâme;Mise à pied;Licenciement",search=true)
	private String sanction ="0";
	
	@Predicate(label="Référence",optional=false,unique=true,search=true)
	private String reference;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CC_ID")
	@Predicate(label="Demande",type=DemandeExplication.class,target="many-to-one",optional=false,search=true)
	private DemandeExplication demande ;
	
	@Predicate(label="Date d'effet",type=Date.class,target="date",optional=false,search=true)
	private Date dateeffet ;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Concerné",type=Employe.class,target="many-to-one",editable=false,search=true)
	private Employe concerne ;
	
	@Predicate(label="compte",target="textarea",group=true,groupName="group1",groupLabel="Compte rendu")
	private String compterendu;

	/**
	 * 
	 */
	public Sanction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Sanction(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param sanction
	 * @param reference
	 * @param conseil
	 * @param dateeffet
	 * @param concerne
	 * @param compterendu
	 */

	public Sanction(long id, String designation, String moduleName, String sanction, String reference,
			DemandeExplication demande, Date dateeffet, Employe concerne, String compterendu) {
		super(id, designation, moduleName);
		this.sanction = sanction;
		this.reference = reference;
		this.demande = demande;
		this.dateeffet = dateeffet;
		this.concerne = concerne;
		this.compterendu = compterendu;
	}
	
	/**
	 * 
	 * @param san
	 */
	public Sanction(Sanction san) {
		super(san.id, san.designation, san.moduleName);
		this.sanction = san.sanction;
		this.reference = san.reference;
		if(san.demande!=null){
			this.demande = new DemandeExplication(san.demande);
		}
		this.dateeffet = san.dateeffet;
		if(san.concerne!=null){
			this.concerne = new Employe(san.concerne);
		}
		this.compterendu = san.compterendu;
	}
	
	

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	

	public DemandeExplication getDemande() {
		return demande;
	}

	public void setDemande(DemandeExplication demande) {
		this.demande = demande;
	}

	public Date getDateeffet() {
		return dateeffet;
	}

	public void setDateeffet(Date dateeffet) {
		this.dateeffet = dateeffet;
	}

	public Employe getConcerne() {
		return concerne;
	}

	public void setConcerne(Employe concerne) {
		this.concerne = concerne;
	}

	public String getCompterendu() {
		return compterendu;
	}

	public void setCompterendu(String compterendu) {
		this.compterendu = compterendu;
	}
	
	
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "SANCTION";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "SANCTIONS";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return reference;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Sanction arg0) {
		// TODO Auto-generated method stub
		return reference.compareTo(arg0.reference);
	}

}