/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Contacts;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.Nationalite;
import com.kerenedu.school.NiveauScolaire;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_smsserver_out")
public class NoteSMS extends BaseElement implements Serializable, Comparable<NoteSMS> {
	

	
	@Column(name = "CHOIX_DEST_MSG")
	@Predicate(label="Envoyé à: ",optional=false,updatable=true,search=false, target="combobox", values="notifier l'étudiant; notifier les parents; tous" , sequence=1)
	protected String destMessage="0";

	@Column(name = "type" )	
	protected String type="O" ;
	
	
	@Lob
	@Column(name = "text" )	
	@Predicate(label="MESSAGE SMS",optional=false,updatable=false,search=true , sequence=2, target="textarea")
	protected String libelle;
	
	@Column(name = "recipient" )	
	protected String numero ;
	
	@Column(name = "wap_url" )	
	protected String wapurl ;
	
	@Column(name = "wap_expiry_date" )	
	protected String wapexpirydate ;
	
	@Column(name = "wap_signal" )	
	protected String wapsignal ;
	
	@Column(name = "create_date" )	
	protected Date createdate ;
		
	@Column(name = "originator" )	
	protected String originator ;
	
	@Column(name = "encoding" )	
	protected String encoding ="7";
	
	@Column(name = "status_report" )	
	protected String status_report ="0";
	
	@Column(name = "flash_sms" )	
	protected int flash_sms=0;
	
	@Column(name = "src_port" )	
	protected int src_port =-1;
	
	@Column(name = "dst_port" )	
	protected int dst_port=-1 ;
	
	@Column(name = "sent_date" )	
	protected Date sent_date ;
	
	@Column(name = "ref_no" )	
	protected String ref_no ;
	
	@Column(name = "priority" )	
	protected int priority=0 ;
	
	@Column(name = "errors" )	
	protected int errors=0 ;
	
	@Column(name = "gateway_id" )	
	protected String gateway_id= "*" ;

	
	
	@Column(name = "status" )	
	protected String statut="U" ;
	
	@Transient
	List<Inscription> listDestinataire = new ArrayList<Inscription>();


	public NoteSMS() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public NoteSMS(String destMessage, String type, String libelle, String numero, String wapurl, String wapexpirydate,
			String wapsignal, Date createdate, String originator, String wap_signal, String encoding,
			String status_report, int flash_sms, int src_port, int dst_port, Date sent_date, String ref_no,
			int priority, int errors, String gateway_id, String statut) {
		super();
		this.destMessage = destMessage;
		this.type = type;
		this.libelle = libelle;
		this.numero = numero;
		this.wapurl = wapurl;
		this.wapexpirydate = wapexpirydate;
		this.wapsignal = wapsignal;
		this.createdate = createdate;
		this.originator = originator;
		this.encoding = encoding;
		this.status_report = status_report;
		this.flash_sms = flash_sms;
		this.src_port = src_port;
		this.dst_port = dst_port;
		this.sent_date = sent_date;
		this.ref_no = ref_no;
		this.priority = priority;
		this.errors = errors;
		this.gateway_id = gateway_id;
		this.statut = statut;
	}



	public NoteSMS(NoteSMS filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		this.destMessage=filiere.destMessage;
		this.libelle=filiere.libelle;
		this.numero= filiere.numero;
		this.wapurl = filiere.wapurl;
		this.wapexpirydate = filiere.wapexpirydate;
		this.wapsignal = filiere.wapsignal;
		this.createdate = filiere.createdate;
		this.originator = filiere.originator;
		this.encoding = filiere.encoding;
		this.status_report = filiere.status_report;
		this.flash_sms = filiere.flash_sms;
		this.src_port = filiere.src_port;
		this.dst_port = filiere.dst_port;
		this.sent_date = filiere.sent_date;
		this.ref_no = filiere.ref_no;
		this.priority = filiere.priority;
		this.errors = filiere.errors;
		this.gateway_id = filiere.gateway_id;
		this.statut = filiere.statut;
	
	}
	
	public NoteSMS(NoteSMS filiere, Eleve eleve) {
		this.libelle = filiere.libelle;
		this.destMessage=filiere.destMessage;
		this.numero= eleve.getTelephone();
		this.createdate = new Date();
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
		return "Notification Par SMS";
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



	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}



	public int compareTo(NoteSMS o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getWapurl() {
		return wapurl;
	}


	public void setWapurl(String wapurl) {
		this.wapurl = wapurl;
	}


	public String getWapexpirydate() {
		return wapexpirydate;
	}


	public void setWapexpirydate(String wapexpirydate) {
		this.wapexpirydate = wapexpirydate;
	}


	public String getWapsignal() {
		return wapsignal;
	}


	public void setWapsignal(String wapsignal) {
		this.wapsignal = wapsignal;
	}


	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public String getOriginator() {
		return originator;
	}


	public void setOriginator(String originator) {
		this.originator = originator;
	}




	public String getEncoding() {
		return encoding;
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


	public String getStatus_report() {
		return status_report;
	}


	public void setStatus_report(String status_report) {
		this.status_report = status_report;
	}


	public int getFlash_sms() {
		return flash_sms;
	}


	public void setFlash_sms(int flash_sms) {
		this.flash_sms = flash_sms;
	}


	public int getSrc_port() {
		return src_port;
	}


	public void setSrc_port(int src_port) {
		this.src_port = src_port;
	}


	public int getDst_port() {
		return dst_port;
	}


	public void setDst_port(int dst_port) {
		this.dst_port = dst_port;
	}


	public Date getSent_date() {
		return sent_date;
	}


	public void setSent_date(Date sent_date) {
		this.sent_date = sent_date;
	}


	public String getRef_no() {
		return ref_no;
	}


	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getErrors() {
		return errors;
	}


	public void setErrors(int errors) {
		this.errors = errors;
	}


	public String getGateway_id() {
		return gateway_id;
	}


	public void setGateway_id(String gateway_id) {
		this.gateway_id = gateway_id;
	}



	public List<Inscription> getListDestinataire() {
		return listDestinataire;
	}



	public void setListDestinataire(List<Inscription> listDestinataire) {
		this.listDestinataire = listDestinataire;
	}
	

}
