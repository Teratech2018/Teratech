/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_mail")
public class NoteMail extends BaseElement implements Serializable, Comparable<NoteMail> {
	
	
	@Column(name = "CHOIX_DEST_MSG")
	@Predicate(label="ENVOYE A :",optional=false,updatable=true,search=false, target="combobox", 
			values="notifier l'étudiant; notifier les parents; tous"  , sequence=2)
	protected String destMessage="0";
	
	@Column(name = "OBJET" )	
	@Predicate(label="OBJET",optional=false,updatable=true,search=true , sequence=2,group = true,groupName = "tab2",groupLabel = "Message")
	protected String Objet;
	@Column(name = "MSG" )	
	@Predicate(label="MESSAGE SMS",optional=false,updatable=true,search=false , sequence=1, target="textarea"
			,group = true,groupName = "tab2",groupLabel = "Message")
	protected String libelle;
	
	@ManyToMany(fetch = FetchType.LAZY  )
    @JoinColumn(name ="ELEVE_ID")
	@Predicate(label = "ETUDIANT CONCERNES" ,target = "many-to-many-list",type = Eleve.class,search = false
			,group = true,groupName = "tab1",groupLabel = "Liste étudiants")
	private List<Eleve> eleveList = new ArrayList<Eleve>();
	



	public NoteMail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NoteMail(NoteMail filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		this.Objet = filiere.Objet;
		this.destMessage=filiere.destMessage;
		this.libelle=filiere.libelle;
		this.eleveList= new ArrayList<Eleve>();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Notification Par SMS";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Notification Par Mail";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Notification Par SMS"+id;
	}


	


	public String getDestMessage() {
		return destMessage;
	}


	public void setDestMessage(String destMessage) {
		this.destMessage = destMessage;
	}


	public String getObjet() {
		return Objet;
	}


	public void setObjet(String objet) {
		Objet = objet;
	}


	public List<Eleve> getEleveList() {
		return eleveList;
	}


	public void setEleveList(List<Eleve> eleveList) {
		this.eleveList = eleveList;
	}


	public int compareTo(NoteSMS o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int compareTo(NoteMail o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
