package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.Rubrique;

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
	

	@Column(name = "MATRICULE")
	//@Predicate(label = "Matricule:",type = String.class, search=true)
    private String matricule ;
	
    
    @ManyToOne
    @JoinColumn(name = "PERIODE_ID")
   // @Predicate(label = "Periode:",type = PeriodePaie.class,target = "many-to-one")
    private PeriodePaie periode ;

	

	public ViewBulletinPaie(Rubrique rubrique, LigneBulletinPaie ligneBulletin, BulletinPaie bulletin, PeriodePaie periode, String matricule) {
		super();
		this.rubrique = rubrique;
		this.ligneBulletin =ligneBulletin;
		this.bulletin = bulletin;
		this.periode= periode;
		this.matricule=matricule;
	}
	
	public ViewBulletinPaie(BulletinPaie bulletin) {
		super();
		this.bulletin = new BulletinPaie(bulletin);
		this.periode= new PeriodePaie(bulletin.getPeriode());
		this.matricule=bulletin.getEmploye().getMatricule();
	}
	public ViewBulletinPaie(ViewBulletinPaie view) {
		this.id = view.id;
		this.rubrique = new Rubrique(view.rubrique);
		this.ligneBulletin = new LigneBulletinPaie(view.ligneBulletin);
		this.bulletin = new BulletinPaie(view.bulletin);
		this.periode= new PeriodePaie(view.getPeriode());
		this.matricule=view.getMatricule();
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
