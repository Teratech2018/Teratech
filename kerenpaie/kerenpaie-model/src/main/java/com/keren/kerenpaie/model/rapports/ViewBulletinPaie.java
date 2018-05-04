package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;


@Table
@Entity(name = "v_bulletin_paie")
public class ViewBulletinPaie  extends BaseElement implements Serializable, Comparable<ViewBulletinPaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "RUBRIQUE_ID")
	protected Rubrique rubrique;

	@ManyToOne
	@JoinColumn(name = "LIGNE_BULL_ID")
	protected LigneBulletinPaie ligneBulletin;
	
	@ManyToOne
	@JoinColumn(name = "BUL_ID")
	protected BulletinPaie bulletin;
	
//
//	@Column(name = "MATRICULE")
//	@Predicate(label = "Matricule:",type = String.class, search=true)
//    private String matricule ;
	
    
    @ManyToOne
    @JoinColumn(name = "PERIODE_ID")
    @Predicate(label = "Periode:",type = PeriodePaie.class,target = "many-to-one",optional=false)
    @Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
    private PeriodePaie periode ;
    
    @Transient
    @Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
    @ManyToMany
    @Transient
	@Predicate(label="EM",type=BulletinPaie.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés",hidden="temporalData.porte=='0'||temporalData.periode==null||temporalData.periode.id=='load'")
    @Filter(value="[{\"fieldName\":\"periode\",\"value\":\"object.periode\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez sélectionner une periode\"}]")
	private List<BulletinPaie> concernes = new ArrayList<BulletinPaie>(); 
	

	public ViewBulletinPaie(Rubrique rubrique, LigneBulletinPaie ligneBulletin, 
			BulletinPaie bulletin, PeriodePaie periode, String matricule , String porte,
			List<BulletinPaie> concernes) {
		super();
		this.rubrique = rubrique;
		this.ligneBulletin =ligneBulletin;
		this.bulletin = bulletin;
		this.periode= periode;
		this.porte = porte;
		this.concernes = concernes;
	}
	
	public ViewBulletinPaie(BulletinPaie bulletin) {
		super();
		this.bulletin = new BulletinPaie(bulletin);
		if(this.periode!=null){
		this.periode= new PeriodePaie(bulletin.getPeriode());
		this.porte = "0";
		}
	}
	
	public ViewBulletinPaie(LivrePaie livre) {
		super();
		this.bulletin = new BulletinPaie();
		if(this.periode!=null){
		this.periode= new PeriodePaie(livre.getPeriode());
		this.porte = "0";
		}
	}
	
	public ViewBulletinPaie(BPaie entity) {
		super();
		this.bulletin = new BulletinPaie();
		if(this.periode!=null){
		this.periode= new PeriodePaie(entity.getPeriode());
		this.porte = "0";
		}
	}
	
	public ViewBulletinPaie(ViewBulletinPaie view) {
		this.id = view.id;
		this.rubrique = new Rubrique(view.rubrique);
		this.ligneBulletin = new LigneBulletinPaie(view.ligneBulletin);
		this.bulletin = new BulletinPaie(view.bulletin);
		this.periode= new PeriodePaie(view.getPeriode());
	}

	public ViewBulletinPaie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int compareTo(ViewBulletinPaie o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public LigneBulletinPaie getLigneBulletin() {
		return ligneBulletin;
	}

	public void setLigneBulletin(LigneBulletinPaie ligneBulletin) {
		this.ligneBulletin = ligneBulletin;
	}

	public BulletinPaie getBulletin() {
		return bulletin;
	}

	public void setBulletin(BulletinPaie bulletin) {
		this.bulletin = bulletin;
	}


	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
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
		return "Bulletin de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Bulletin de Paie";
	}

}
