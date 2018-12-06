/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.LigneBulletinPaie;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_zview_bullpaie")
public class ViewBulletinPaieHelper extends BaseElement implements Serializable, Comparable<ViewBulletinPaieHelper> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274847472533474787L;
	
	@ManyToOne
	@JoinColumn(name = "BULL_ID")
	private BulletinPaie bulletin;


	@ManyToOne
	@JoinColumn(name = "LGN_BULL_ID")
	private LigneBulletinPaie lignes;


	/**
	 * 
	 */
	public ViewBulletinPaieHelper() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ViewBulletinPaieHelper(long id, String designation, String moduleName) {
		super(id, designation, moduleName, 0L);
		// TODO Auto-generated constructor stub
	}

	

	public ViewBulletinPaieHelper(BulletinPaie bulletin, LigneBulletinPaie lignes) {
		super();
		this.bulletin = bulletin;
		this.lignes = lignes;
	}
	
	public ViewBulletinPaieHelper(ViewBulletinPaieHelper entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		this.bulletin = entity.bulletin;
		this.lignes = entity.lignes;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "etat";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "etat";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}

	public BulletinPaie getBulletin() {
		return bulletin;
	}


	public void setBulletin(BulletinPaie bulletin) {
		this.bulletin = bulletin;
	}


	public LigneBulletinPaie getLignes() {
		return lignes;
	}


	public void setLignes(LigneBulletinPaie lignes) {
		this.lignes = lignes;
	}


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
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


	public int compareTo(ViewBulletinPaieHelper o) {
		// TODO Auto-generated method stub
		return bulletin.compareTo(o.bulletin);
	}


}
