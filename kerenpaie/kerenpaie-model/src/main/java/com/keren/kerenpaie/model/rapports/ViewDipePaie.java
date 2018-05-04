package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;


@Table
@Entity(name = "v_dipe_paie")
public class ViewDipePaie  extends BaseElement implements Serializable, Comparable<ViewDipePaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn(name = "BULL_ID")
	protected BulletinPaie bulletin;
	
    
    @Column(name="SB")
    private BigDecimal salBrut ;
    
    @Column(name="SEXCEP")
    private BigDecimal salExceptionel ;
    
    @Column(name="STAXABLE")
    private BigDecimal salTaxable ;
    
    @Column(name="SCOTCNPS")
    private BigDecimal salCotCnps ;
    
    @Column(name="SCOTPLAF")
    private BigDecimal salCotPlaf ;
    
    @Column(name="RET")
    private BigDecimal retenue ;
    
    @Column(name="RETTAXCOM")
    private BigDecimal retenuetaxeCom ;
    
    @Column(name="RETIRPP")
    private BigDecimal retenueIrpp ;
    
    
    @Transient
    @Predicate(label="DIPE ?",target="combobox",values="Mensuel;Debut Exercice;Fin Exercice",optional=false , sequence=1)
	private String dipe ="0";
    
    @Transient
	private String repertoire ="";
    
    @ManyToOne
    @JoinColumn(name = "PERIODE_ID")
    @Predicate(label = "Periode:",type = PeriodePaie.class,target = "many-to-one",optional=false ,hidden="temporalData.dipe!='0'" , sequence=2)
    @Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
    private PeriodePaie periode ;

	
	public ViewDipePaie(BulletinPaie bulletin, PeriodePaie periode, BigDecimal salBrut, BigDecimal salExceptionel,
			BigDecimal salTaxable, BigDecimal salCotCnps, BigDecimal salCotPlaf, BigDecimal retenue,
			BigDecimal retenuetaxeCom, BigDecimal retenueIrpp, String dipe,String repertoire) {
		super();
		this.bulletin = bulletin;
		this.periode = periode;
		this.salBrut = salBrut;
		this.salExceptionel = salExceptionel;
		this.salTaxable = salTaxable;
		this.salCotCnps = salCotCnps;
		this.salCotPlaf = salCotPlaf;
		this.retenue = retenue;
		this.retenuetaxeCom = retenuetaxeCom;
		this.retenueIrpp = retenueIrpp;
		this.dipe = dipe;
		this.repertoire=repertoire;
	}

	
	public ViewDipePaie(ViewDipePaie view) {
		this.id = view.id;
		this.bulletin = new BulletinPaie(view.bulletin);
		this.periode= new PeriodePaie(view.getPeriode());
		this.salBrut = view.salBrut;
		this.salExceptionel = view.salExceptionel;
		this.salTaxable = view.salTaxable;
		this.salCotCnps = view.salCotCnps;
		this.salCotPlaf = view.salCotPlaf;
		this.retenue = view.retenue;
		this.retenuetaxeCom = view.retenuetaxeCom;
		this.retenueIrpp = view.retenueIrpp;
		this.dipe=view.dipe;
		this.repertoire= view.repertoire;
	}

	public ViewDipePaie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int compareTo(ViewDipePaie o) {
		// TODO Auto-generated method stub
		return 0;
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

	

	public String getDipe() {
		return dipe;
	}


	public void setDipe(String dipe) {
		this.dipe = dipe;
	}


	public BigDecimal getSalBrut() {
		return salBrut;
	}

	public void setSalBrut(BigDecimal salBrut) {
		this.salBrut = salBrut;
	}

	public BigDecimal getSalExceptionel() {
		return salExceptionel;
	}

	public void setSalExceptionel(BigDecimal salExceptionel) {
		this.salExceptionel = salExceptionel;
	}

	public BigDecimal getSalTaxable() {
		return salTaxable;
	}

	public void setSalTaxable(BigDecimal salTaxable) {
		this.salTaxable = salTaxable;
	}

	public BigDecimal getSalCotCnps() {
		return salCotCnps;
	}

	public void setSalCotCnps(BigDecimal salCotCnps) {
		this.salCotCnps = salCotCnps;
	}

	public BigDecimal getSalCotPlaf() {
		return salCotPlaf;
	}

	public void setSalCotPlaf(BigDecimal salCotPlaf) {
		this.salCotPlaf = salCotPlaf;
	}

	public BigDecimal getRetenue() {
		return retenue;
	}

	public void setRetenue(BigDecimal retenue) {
		this.retenue = retenue;
	}

	public BigDecimal getRetenuetaxeCom() {
		return retenuetaxeCom;
	}

	public void setRetenuetaxeCom(BigDecimal retenuetaxeCom) {
		this.retenuetaxeCom = retenuetaxeCom;
	}

	public BigDecimal getRetenueIrpp() {
		return retenueIrpp;
	}

	public String getRepertoire() {
		return repertoire;
	}


	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}


	public void setRetenueIrpp(BigDecimal retenueIrpp) {
		this.retenueIrpp = retenueIrpp;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Generer le Dipe Magnetique ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Generer le Dipe Magnetique";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Generer le Dipe Magnetique";
	}

}
