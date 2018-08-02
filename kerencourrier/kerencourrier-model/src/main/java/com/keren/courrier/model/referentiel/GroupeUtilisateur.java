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
@Table(name="T_GRUTKC")
public class GroupeUtilisateur extends BaseElement implements Serializable, Comparable<GroupeUtilisateur> {


	private static final long serialVersionUID = -4149066010295989757L;

	@Predicate(label="Groupe",optional=false,unique = true,search=true )
	private String code ;
	
	@Column(name = "Désignation")
	@Predicate(label="Description",optional=false,search=true)
	private String intitule ;
	
	
	/**
	 * 
	 */
	public GroupeUtilisateur() {
		// TODO Auto-generated constructor stub
	}



	public GroupeUtilisateur(GroupeUtilisateur dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.intitule = dep.intitule;
	
	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Groupe utilisateur";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Groupes utilisateurs";
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
	public int compareTo(GroupeUtilisateur o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
