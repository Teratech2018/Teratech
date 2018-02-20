/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_contacts")
public class Contacts extends BaseElement implements Serializable, Comparable<Contacts> {

	@Column(name = "ADRESSE")
	@Predicate(label="ADRESSE",optional=false,updatable=false,search=true, sequence=1)
	protected String adresse;

	@Column(name = "VILLE")
	@Predicate(label="VILLE",optional=false,updatable=false,search=true, sequence=2)
	protected String ville;

	@Column(name = "TELEPHONE")
	@Predicate(label="TELEPHONE",optional=false,updatable=false,search=true, sequence=3)
	protected String telephone;
	
	@Column(name = "EMAIL")
	@Predicate(label="EMAIL",optional=false,updatable=false,search=true, sequence=4)
	protected String email;
	
	public Contacts() {
		
	}

	public Contacts(Contacts contacts) {
		super(contacts.id, contacts.designation, contacts.moduleName);
		this.adresse = contacts.adresse;
		this.email = contacts.email;
		this.ville = contacts.ville;
		this.telephone = contacts.telephone;
	}

	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Contacts other = (Contacts) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return adresse;
	}

	public int compareTo(Contacts o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Contacts";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Contacts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return adresse;
	}

}
