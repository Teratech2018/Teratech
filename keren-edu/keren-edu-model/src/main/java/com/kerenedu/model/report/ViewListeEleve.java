/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_inscription")
public class ViewListeEleve extends BaseElement implements Serializable, Comparable<ViewListeEleve> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8430641365166122149L;


	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1, observable=true)
	private SectionE section ;
	
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",updatable=false,type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true, searchfields="libelle", colsequence=1)
	protected Classe classe ;
	
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label="Elève",updatable=true,type=Eleve.class , target="many-to-one",search=true , sequence=3,searchfields="nom",colsequence=2	)
	protected Eleve eleve ;

	
	@Column(name = "STATUT")
	@Predicate(label="Statut Elève",optional=false,updatable=true,search=false, target="combobox", values="Redoublant(e);Non Redoublant(e)" , sequence=3)
	protected String satut="0";
	
	@Column(name = "DATE_INS")
	@Predicate(label="DATE INSCRIPTION",optional=false,updatable=true,search=true, type=Date.class,sequence=4, target="date" ,colsequence=3)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datIns ;
	
	@Column(name = "MNT" )	
	@Predicate(label="SCOLARITE",optional=true,updatable=false,search=true, type=BigDecimal.class ,sequence=5, editable=false,colsequence=4)
	protected Long zMnt ;
		
	@Column(name = "MNT_PAYE")	
	@Predicate(label="PAYER",optional=true,updatable=false,search=true, type=BigDecimal.class,sequence=7, editable=false,colsequence=5)
	protected Long zMntPaye;
	
	@Column(name = "SOLDE")	
	@Predicate(label="SOLDE ",optional=true,updatable=false,search=true, type=BigDecimal.class ,sequence=9,colsequence=6)
	protected Long zSolde ;
	
	@Column(name = "REMISE")	
	@Predicate(label="REMISE",optional=true,updatable=false,search=true, type=BigDecimal.class,sequence=11, editable=false,colsequence=7 	)
	protected Long zRemise;
	
	@Column(name = "RISTOURNE")	
	@Predicate(label="RISTOURNE",optional=true,updatable=false,search=false, type=BigDecimal.class,sequence=10)
	protected Long zRistourne;
	
	@Column(name = "TOTAL")	
	//@Predicate(label="TOTAL Frais",optional=true,updatable=false,search=false, type=BigDecimal.class, hide=true,sequence=9)
	protected Long zTotal;
	
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	@Column(name = "CYCLE_ID")
	protected long cycle ;
	
	
	
	


	public ViewListeEleve(SectionE section, Classe classe, Eleve eleve, String satut, Date datIns, Long zMnt,
			Long zMntPaye, Long zSolde, Long zRemise, Long zRistourne, Long zTotal, String anneScolaire, long cycle) {
		super();
		this.section = section;
		this.classe = classe;
		this.eleve = eleve;
		this.satut = satut;
		this.datIns = datIns;
		this.zMnt = zMnt;
		this.zMntPaye = zMntPaye;
		this.zSolde = zSolde;
		this.zRemise = zRemise;
		this.zRistourne = zRistourne;
		this.zTotal = zTotal;
		this.anneScolaire = anneScolaire;
		this.cycle = cycle;
	}


	public ViewListeEleve() {
		// TODO Auto-generated constructor stub
	}


	public ViewListeEleve(ViewListeEleve ins) {
		super(ins.id, ins.designation, ins.moduleName,ins.compareid);
		this.zMnt = ins.zMnt;
		if(ins.eleve!=null){
			this.eleve = new Eleve(ins.eleve);
		}
		
		this.zMnt = ins.zMnt;
		this.zMntPaye = ins.zMntPaye;
		this.zSolde = ins.zSolde;
		this.zRemise=ins.zRemise;
		this.zRistourne=ins.zRistourne;
		this.zTotal=ins.zTotal;
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);	
//			this.cycle=ins.getClasse().getCycle();
			this.section=ins.getClasse().getSection();
		}
		this.datIns=ins.getDatIns();
		this.anneScolaire=ins.anneScolaire;
		this.satut=ins.satut;	
		
	}


	public ViewListeEleve(ViewListeEleveModal ins) {
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);	
//			this.cycle=ins.getClasse().getCycle();
			this.section=ins.getClasse().getSection();
		}	
		if(ins.getSection()!=null){
			this.section= new SectionE(ins.getSection());
		}
		if(ins.getAnnee()!=null){
			this.anneScolaire= ins.getAnnee().getCode();
		}
		
	}



//	public void setServiceList(Service serviceList) {
//		this.serviceList = serviceList;
//	}


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


	

	public Date getDatIns() {
		return datIns;
	}


	public void setDatIns(Date datIns) {
		this.datIns = datIns;
	}





	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewListeEleve o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves inscrits";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Elèves inscrits";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getMatricule()+"-"+eleve.getNom();
	}
	
//


	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	public String getSatut() {
		return satut;
	}


	public void setSatut(String satut) {
		this.satut = satut;
	}


	public Long getzMnt() {
		return zMnt;
	}


	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}


	public Long getzMntPaye() {
		return zMntPaye;
	}


	public void setzMntPaye(Long zMntPaye) {
		this.zMntPaye = zMntPaye;
	}


	public Long getzSolde() {
		return zSolde;
	}


	public void setzSolde(Long zSolde) {
		this.zSolde = zSolde;
	}


	public Long getzRemise() {
		return zRemise;
	}


	public void setzRemise(Long zRemise) {
		this.zRemise = zRemise;
	}


	public Long getzRistourne() {
		return zRistourne;
	}


	public void setzRistourne(Long zRistourne) {
		this.zRistourne = zRistourne;
	}


	public Long getzTotal() {
		return zTotal;
	}


	public void setzTotal(Long zTotal) {
		this.zTotal = zTotal;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public long getCycle() {
		return cycle;
	}


	public void setCycle(long cycle) {
		this.cycle = cycle;
	}
	
	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}





	


	


}
