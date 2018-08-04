/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_CLACOGC")
public class ClasseurCourrier extends BaseElement implements Serializable, Comparable<ClasseurCourrier> {

	@Predicate(label = "Dossier", optional = false, unique = true, search = true)
	private String code;

	@Predicate(label = "Confidentiel", type = Boolean.class, target = "checkbox", search = true)
	private Boolean confidentialite = Boolean.FALSE;

	@Predicate(label = "Désignation", optional = true, search = true)
	private String intitule;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COMP_ID")
	@Predicate(label = "", type = CompartimentClasseur.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "Compartiments")
	private List<CompartimentClasseur> compartiments = new ArrayList<CompartimentClasseur>();

	public ClasseurCourrier() {
	}

	public ClasseurCourrier(String code, String intitule, String style, ClasseurCourrier parent) {
		this.code = code;
		this.intitule = intitule;

	}

	public ClasseurCourrier(String code, String intitule, String style, ClasseurCourrier parent, long id,
			String designation, String moduleName, long comparedid) {
		super(id, designation, moduleName, comparedid);
		this.code = code;
		this.intitule = intitule;

	}

	public ClasseurCourrier(ClasseurCourrier entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.intitule = entity.intitule;
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

	public List<CompartimentClasseur> getCompartiments() {
		return compartiments;
	}

	public void setCompartiments(List<CompartimentClasseur> compartiments) {
		this.compartiments = compartiments;
	}

	public Boolean getConfidentialite() {
		return confidentialite;
	}

	public void setConfidentialite(Boolean confidentialite) {
		this.confidentialite = confidentialite;
	}

	@Override
	public String getDesignation() {
		return code + " - " + intitule; // To change body of generated methods,
										// choose Tools | Templates.
	}

	@Override
	public String getModuleName() {
		return "kerencourrier"; // To change body of generated methods, choose
								// Tools | Templates.
	}

	@Override
	public String getListTitle() {
		return "Classeurs"; // To change body of generated methods, choose Tools
							// | Templates.
	}

	@Override
	public String getEditTitle() {
		return "Classeur"; // To change body of generated methods, choose Tools
							// | Templates.
	}

	@Override
	public int compareTo(ClasseurCourrier o) {
		return code.compareTo(o.code); // To change body of generated methods,
										// choose Tools | Templates.
	}

}
