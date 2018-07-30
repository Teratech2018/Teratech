/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW
 * table type correspondants
 */
@Entity
@Table(name="T_STATUKC")
public class Statut extends BaseElement implements Serializable, Comparable<Statut> {


	private static final long serialVersionUID = -4149066010295989757L;

	@Predicate(label="Statut",optional=false,unique = true,search=true )
	private String code ;
	
	@Column(name = "Désignation")
	@Predicate(label="Description",optional=false,search=true)
	private String intitule ;
	
	
	/**
	 * 
	 */
	public Statut() {
		// TODO Auto-generated constructor stub
	}



	public Statut(Statut dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.intitule = dep.intitule;
	
	}

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getIntitule() {
            return intitule;
        }

        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Statut";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Statut";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}
	
	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule ;
	}



	@Override
	public int compareTo(Statut o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
