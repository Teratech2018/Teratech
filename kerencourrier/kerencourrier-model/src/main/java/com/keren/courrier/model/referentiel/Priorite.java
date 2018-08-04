/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW
 * table type correspondants
 */
@Entity
@Table(name="T_PRIOKC")
public class Priorite extends BaseElement implements Serializable, Comparable<Priorite> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5954077291868061600L;


	@Predicate(label="Nom de la Priorite",optional=false,unique = true,search=true )
	private String code ;
	
	@Predicate(label="Délai Traitement(jours)",optional=true,search=true , type=Short.class)
	private Short delai=0 ;
		
	@Predicate(label="Méthode de Calcul",optional=false,search=true, target="combobox", values="Jours ouvrés;Jours calendaires" )
	private String methode ;
	

	/**
	 * 
	 */
	public Priorite() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Priorite(String priorite, Short delai, String methode) {
		super();
		this.code = priorite;
		this.delai = delai;
		this.methode = methode;
	}


	public Priorite(Priorite dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.delai = dep.delai;
		this.methode = dep.methode;
	
	}

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Short getDelai() {
            return delai;
        }

        public void setDelai(Short delai) {
            this.delai = delai;
        }

	
	public String getMethode() {
		return methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Paramétrage des priorités";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Paramétrage des priorités";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int compareTo(Priorite o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
