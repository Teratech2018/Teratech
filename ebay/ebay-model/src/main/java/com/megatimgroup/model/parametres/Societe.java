/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.parametres;

import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="SOCIETE")
public class Societe implements Serializable, Comparable<Societe> {
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected long id ;
	 
    @Column(name="C_CODE")
    @Predicate(max=10,nullable=false,optional=false)
    private String code ;
    
    @Column(name="C_DESIGN")
    private String designation ;    
    
    
    @Column(name="C_RSOCIAL")
    private String raisonSocial ;
    
    @Column(name = "ACTIVITE")
    private String activite;
    
    @Column(name = "IDENTIFIANT")
    private String identifiant;
    
    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "CODE_POSTAL")
    private String codePostal;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS")
    private String pays;
    
    @Column(name = "REGION")
    private String region;
    
    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "TELECOPIE")
    private String telecopie;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SITE_WEB")
    private String siteWeb;
    
    @Column(name = "P_PASSAGER_ID")
    private String pPassagerId;
    
    @Column(name = "LOGO")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] logo;
    
    @Column(name = "INREPOSITORY")//Repertoire en entrée
    private String inRepository ;
    
    @Column(name = "OUTREPOSITORY") //Repertoire en sortie
    private String outRepository ;
    
    @Column(name = "ERRREPOSITORY") //Repertoire en erreur
    private String errRepository ;
    
    //Prefixe de la reference niterne des clients de passages
    private String prefixCP ;


    /**
     * 
     */
    public Societe() {
    }

    /**
     * 
     * @param code
     * @param designation
     * @param raisonSocial 
     */
    public Societe(String code, String designation, String raisonSocial) {
        this.code = code;
        this.designation = designation;
        this.raisonSocial = raisonSocial;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getIdentifiant() {
//		return identifiant;
//	}
//
//	public void setIdentifiant(String identifiant) {
//		this.identifiant = identifiant;
//	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the pPassagerId
	 */
	public String getpPassagerId() {
		return pPassagerId;
	}

	/**
	 * @param pPassagerId the pPassagerId to set
	 */
	public void setpPassagerId(String pPassagerId) {
		this.pPassagerId = pPassagerId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelecopie() {
		return telecopie;
	}

	public void setTelecopie(String telecopie) {
		this.telecopie = telecopie;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

    public String getInRepository() {
        return inRepository;
    }

    public void setInRepository(String inRepository) {
        this.inRepository = inRepository;
    }

    public String getOutRepository() {
        return outRepository;
    }

    public void setOutRepository(String outRepository) {
        this.outRepository = outRepository;
    }

    public String getErrRepository() {
        return errRepository;
    }

    public void setErrRepository(String errRepository) {
        this.errRepository = errRepository;
    }

    public String getPrefixCP() {
        return prefixCP;
    }

    public void setPrefixCP(String prefixCP) {
        this.prefixCP = prefixCP;
    }
        
        

    public int compareTo(Societe o) {
    return code.compareTo(o.code);
    }
        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.code != null ? this.code.hashCode() : 0);
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
        final Societe other = (Societe) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }  
    
    
    
    
}
