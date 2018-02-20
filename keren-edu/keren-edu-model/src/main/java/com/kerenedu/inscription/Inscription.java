/**
 * 
 */
package com.kerenedu.inscription;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_inscription")
public class Inscription extends BaseElement implements Serializable, Comparable<Inscription> {

	
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1)
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label="ETUDIANT",updatable=true,type=Eleve.class , target="many-to-one",search=true , sequence=2	)
	protected Eleve eleve;

	
	@Column(name = "STATUT")
	@Predicate(label="STATUT ELEVE",optional=false,updatable=true,search=false, target="combobox", values="Redoublant(e);Non Redoublant(e)" , sequence=3)
	protected String satut="0";
	
	@Column(name = "DATE_INS")
	@Predicate(label="DATE INSCRIPTION",optional=false,updatable=true,search=true, type=Date.class,sequence=4, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datIns;
	
	@Column(name = "MNT" )	
	@Predicate(label="SCOLARITE",optional=true,updatable=false,search=true, type=BigDecimal.class, hide=true ,sequence=5)
	protected BigDecimal zMnt =BigDecimal.ZERO;
	
	
	
	@Column(name = "MNT_PAYE")	
	@Predicate(label="PAYER",optional=true,updatable=false,search=true, type=BigDecimal.class, hide=true,sequence=7)
	protected BigDecimal zMntPaye =BigDecimal.ZERO;
	
	@Column(name = "SOLDE")	
	@Predicate(label="SOLDE",optional=true,updatable=false,search=true, type=BigDecimal.class, hide=true,sequence=8)
	protected BigDecimal zSolde =BigDecimal.ZERO;
	
	@ManyToOne
    @JoinColumn(name ="SERVICE_ID")
	@Predicate(label = "Services",group = true,groupName = "tab1",groupLabel = "Fras de Scolarité",target = "many-to-one",type = Service.class,search = false)
	private Service serviceList ;
	
	
	@ManyToOne
	@JoinColumn(name = "ANNEE_ID")
	protected AnneScolaire anneScolaire;
	

	public Service getServiceList() {
		return serviceList;
	}


	public void setService(Service serviceList) {
		this.serviceList = serviceList;
	}


	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Inscription(Inscription ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.zMnt = ins.zMnt;
		this.eleve = new Eleve(ins.eleve);
		this.zMnt = ins.zMnt;
		this.zMntPaye = ins.zMntPaye;
		this.zSolde = ins.zSolde;
		this.classe = new Classe(ins.classe);
		this.datIns=ins.datIns;
		this.anneScolaire=new AnneScolaire(ins.anneScolaire);
		this.serviceList= new Service(ins.serviceList);
		this.satut=ins.satut;
		
		/*for(Service service:ins.serviceList){
			serviceList.add(new Service(service));
	    }*/
	
	}

	/**
	 * @return the zMnt
	 */
	public BigDecimal getzMnt() {
		
	
		return zMnt;
	}

	/**
	 * @param zMnt the zMnt to set
	 */
	public void setzMnt(BigDecimal zMnt) {
	
		this.zMnt = zMnt;
	}

	
	public void setDatIns(Date datIns) {
		this.datIns = datIns;
	}


	public void setServiceList(Service serviceList) {
		this.serviceList = serviceList;
	}


	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public BigDecimal getzMntPaye() {
		return zMntPaye;
	}


	public void setzMntPaye(BigDecimal zMntPaye) {
		this.zMntPaye = zMntPaye;
	}


	public BigDecimal getzSolde() {
		return zSolde;
	}


	public void setzSolde(BigDecimal zSolde) {
		this.zSolde = zSolde;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Inscription o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Inscriptions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Inscrists";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Etudiant  "+eleve.getMatricule()+"-"+eleve.getNom();
	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Date getDatIns() {
		return datIns;
	}
	


	public String getSatut() {
		return satut;
	}


	public void setSatut(String satut) {
		this.satut = satut;
	}
	

}
