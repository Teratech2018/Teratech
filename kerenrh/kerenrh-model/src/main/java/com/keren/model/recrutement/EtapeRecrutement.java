/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.structures.Departement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ETAPRH")
public class EtapeRecrutement extends BaseElement implements Serializable, Comparable<EtapeRecrutement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8635243368208200240L;
	
	@Predicate(label="Nom ",unique=true,optional=false)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Dernier Etape?",type=Boolean.class)
	private Boolean dernier;
	
	@Predicate(label="Séquence",type=Short.class)
	private Short sequ ;
	
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	@Predicate(label="Département Lié",type=Departement.class,target="many-to-one")
	private Departement departement ;
	
	@Lob
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Exigences")
	private String note;

	/**
	 * 
	 */
	public EtapeRecrutement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EtapeRecrutement(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	
    /**
     * 
     * @param id
     * @param designation
     * @param moduleName
     * @param code
     * @param dernier
     * @param sequ
     * @param departement
     * @param note
     */
	public EtapeRecrutement(long id, String designation, String moduleName, String code, Boolean dernier, Short sequ,
			Departement departement, String note) {
		super(id, designation, moduleName);
		this.code = code;
		this.dernier = dernier;
		this.sequ = sequ;
		this.departement = departement;
		this.note = note;
	}
	
	/**
	 * 
	 * @param etape
	 */
	public EtapeRecrutement(EtapeRecrutement etape) {
		super(etape.id, etape.designation, etape.moduleName);
		this.code = etape.code;
		this.dernier = etape.dernier;
		this.sequ = etape.sequ;
		if(etape.departement!=null){
			this.departement = new Departement(etape.departement);
		}
		this.note = etape.note;
	}

	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getDernier() {
		return dernier;
	}

	public void setDernier(Boolean dernier) {
		this.dernier = dernier;
	}

	public Short getSequ() {
		return sequ;
	}

	public void setSequ(Short sequ) {
		this.sequ = sequ;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Etape du Recrutement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Etapes du Recrutement";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(EtapeRecrutement o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
