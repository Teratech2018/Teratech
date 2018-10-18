/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.Inscriptionclone;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_zview_retard")
public class FichePaiementRetard extends BaseElement implements Serializable, Comparable<FichePaiementRetard> {

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Elève", updatable = true, type = Inscription.class, target = "many-to-one", search = true, sequence = 1, searchfields = "eleve.nom")
	protected Inscription eleve;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", updatable = false, type = Classe.class, target = "many-to-one", search = true, sequence = 2, observable = true, searchfields = "libelle")
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "FICHE_ID")
	@Predicate(label = "Service ", updatable = false, type = FichePaiement.class, target = "many-to-one", search = true, sequence = 3, observable = true)
	protected FichePaiement fiche;

	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	@Predicate(label = "Service", updatable = false, type = Service.class, target = "many-to-one", search = false, sequence = 5, observable = true, searchfields = "libelle", hide = true)
	protected Service service;

	@Column(name = "DELAI")
	@Predicate(label = "DELAI PAIEMENT", optional = false, updatable = false, search = true, type = Date.class, sequence = 4, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date delai;

	@Transient
	@Column(name = "TOTAL_TTC")
	@Predicate(label = "MONTANT", optional = true, type = Long.class, sequence = 5, search = true, editable = false)
	protected Long ztotal;

	@Transient
	@Column(name = "MNT_PAYER")
	@Predicate(label = "PAYER ", optional = false, updatable = false, search = true, type = Long.class, sequence = 6, editable = false)
	protected Long mntpayer;

	@Transient
	@Column(name = "SOLDE")
	@Predicate(label = "Solde ", optional = false, updatable = false, search = true, type = Long.class, sequence = 7, editable = false)
	protected Long solde;

	protected Boolean payer = false;

	@Transient
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MORATOIRE_ID")
	@Predicate(label = "Moratoire ", updatable = true, type = Moratoire.class, target = "one-to-many", search = true, sequence = 2, group = true, groupLabel = "Moratoire", groupName = "tab1")
	protected List<Moratoire> moratoires;

	public FichePaiementRetard() {
		// TODO Auto-generated constructor stub
	}

	public FichePaiementRetard(Inscription eleve, Classe classe, Service service, Date delai, FichePaiement fiche,
			Long ztotal, Long mntpayer, Long solde) {
		super();
		this.eleve = eleve;
		this.classe = classe;
		this.service = service;
		this.delai = delai;
		this.fiche = fiche;
		this.ztotal = ztotal;
		this.mntpayer = mntpayer;
		this.solde = solde;
	}

	public FichePaiementRetard(FichePaiementRetard entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);

		if (entity.eleve != null) {
			this.eleve = new Inscription(entity.eleve);
		}
		if (entity.classe != null) {
			this.classe = new Classe(entity.classe);
		}
		// if(entity.service!=null){
		// this.service = new Service(entity.getService());
		// }
		this.delai = entity.delai;
		this.payer = entity.payer;
		this.fiche = new FichePaiement(entity.fiche);
		this.ztotal = entity.getFiche().getZtotal();
		this.mntpayer = entity.getFiche().getMntpayer();
		this.solde = entity.getFiche().getSolde();
		this.service = new Service(entity.fiche.getService());

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Inscriptionclone o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return " Retard de Paiement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Retard de Paiement";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getEleve().getNom() + " " + eleve.getEleve().getPrenon();
	}

	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getDelai() {
		return delai;
	}

	public void setDelai(Date delai) {
		this.delai = delai;
	}

	public FichePaiement getFiche() {
		return fiche;
	}

	public void setFiche(FichePaiement fiche) {
		this.fiche = fiche;
	}

	public Long getZtotal() {
		return ztotal;
	}

	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}

	public Long getMntpayer() {
		return mntpayer;
	}

	public List<Moratoire> getMoratoires() {
		return moratoires;
	}

	public void setMoratoires(List<Moratoire> moratoires) {
		this.moratoires = moratoires;
	}

	public void setMntpayer(Long mntpayer) {
		this.mntpayer = mntpayer;
	}

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	public Boolean getPayer() {
		return payer;
	}

	public void setPayer(Boolean payer) {
		this.payer = payer;
	}

	public int compareTo(FichePaiementRetard o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
