/**
 * 
 */
package com.keren.courrier.model.others;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name ="T_PCSEQ")
public class ConfigSequence extends BaseElement implements Serializable, Comparable<ConfigSequence> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Predicate(label = "Type Document", target = "combobox", values = "Courrier Arrivée;Courrier Départ;Courrier Interne;Bordereau", search = true)
	private String typedoc = "0";
	
	@Predicate(label = "Séparateur", target = "combobox", values = "/;//;*", search = true, sequence=3, optional=true)
	private String separateur = "0";
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "POR_ID")
	@Predicate(label = "Numero ", type = PortionSequence.class, target = "one-to-many", group = true, groupName = "group1", groupLabel = "Numero Document")
	private List<PortionSequence> portions ;
	

	@Override
	public int compareTo(ConfigSequence o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public ConfigSequence() {
		super();
		
		
	}
	

	public ConfigSequence(String typedoc, String separateur, List<PortionSequence> portions) {
		super();
		this.typedoc = typedoc;
		this.separateur = separateur;
		this.portions = portions;
	}



	public ConfigSequence(ConfigSequence entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.typedoc = entity.typedoc;
		this.separateur = entity.separateur;
		this.portions = new ArrayList<PortionSequence>() ;
		
	}

	public String getTypedoc() {
		return typedoc;
	}

	public void setTypedoc(String typedoc) {
		this.typedoc = typedoc;
	}

	

	public String getSeparateur() {
		return separateur;
	}


	public void setSeparateur(String separateur) {
		this.separateur = separateur;
	}


	public List<PortionSequence> getPortions() {
		return portions;
	}

	public void setPortions(List<PortionSequence> portions) {
		this.portions = portions;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return " Numero Document";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return " Numero Document";
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}
	
	




}
