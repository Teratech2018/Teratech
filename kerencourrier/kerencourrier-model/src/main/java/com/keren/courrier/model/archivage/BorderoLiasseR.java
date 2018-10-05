/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.courrier.model.others.UtilisateurClone;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_BORLIAS")
public class BorderoLiasseR extends BaseElement implements Serializable,Comparable<BorderoLiasseR>{

    @Predicate(label = "Bordero",optional = false,unique = true,search = true)
    private String code; 
  
  //  @Predicate(label = "Type de bordereau",target = "combobox",values = "Interne;Départ;Confidentiel",updatable = false)
    private String type ;
    
    @ManyToOne
    @JoinColumn(name = "SRC_ID")
//    @Predicate(label = "Service",type = StructureCompany.class,target = "many-to-one",optional = false,search = true)
    private StructureCompany source ;
    
    @ManyToOne
    @JoinColumn(name = "EXCIB_ID")
   // @Predicate(label = "Entité Cible",type = Correspondant.class,updatable = false,target = "many-to-one",search = true,hidden="currentObject.type==null||currentObject.type!='1'")
    private Correspondant excible;
   
    @ManyToOne
    @JoinColumn(name = "UTCL_ID")
    @Predicate(label = "Agent liaison",type = UtilisateurClone.class,target = "many-to-one",optional = true,search = true)
    private UtilisateurClone agentliaison ;
    
    @ManyToOne
    @JoinColumn(name = "CIB_ID")
    @Predicate(label = "Service",type = StructureCompany.class,updatable = false,target = "many-to-one",search = true)
    private StructureCompany cible ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date création",type = Date.class,editable =false,target = "date",search = true)
    private Date creation;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date Réception",type = Date.class,target = "date",editable =true,search = true)
    private Date emission;
    
    @Temporal(javax.persistence.TemporalType.DATE)
//    @Predicate(label = "Date émission",type = Date.class,target = "date",editable =false,search = true)
    private Date daccuse;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "BORD_ID")
    @Predicate(label ="",type = LigneBorderoLiasseR.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Listes des Liasses",edittable = true)
    private List<LigneBorderoLiasseR> liasses = new ArrayList<LigneBorderoLiasseR>();

    @Predicate(label = "Statut",search = false,hide = true)
    private String state = "etabli";
    
    
     public BorderoLiasseR(BorderoLiasseR entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.state = entity.state ;
        if(entity.source!=null){
            this.source = new StructureCompany(entity.source);
        }
        if(entity.cible!=null){
            this.cible = new StructureCompany(entity.cible);
        }
        if(entity.agentliaison!=null){
            this.agentliaison = new UtilisateurClone(entity.agentliaison);
        }
        this.creation = entity.creation;
        this.emission = entity.emission;
        this.type = entity.type;
        this.daccuse = entity.daccuse;
    }
     
    public BorderoLiasseR(String code, StructureCompany service, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        
    }

    public BorderoLiasseR() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StructureCompany getSource() {
        return source;
    }

    public void setSource(StructureCompany source) {
        this.source = source;
    }

    public StructureCompany getCible() {
        return cible;
    }

    public void setCible(StructureCompany cible) {
        this.cible = cible;
    }

    
   

    public Correspondant getExcible() {
		return excible;
	}

	public void setExcible(Correspondant excible) {
		this.excible = excible;
	}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDaccuse() {
        return daccuse;
    }

    public void setDaccuse(Date daccuse) {
        this.daccuse = daccuse;
    }
    
    

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Parafeurs"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Parafeur"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UtilisateurClone getAgentliaison() {
        return agentliaison;
    }

    public void setAgentliaison(UtilisateurClone agentliaison) {
        this.agentliaison = agentliaison;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getEmission() {
        return emission;
    }

    public void setEmission(Date emission) {
        this.emission = emission;
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    public List<LigneBorderoLiasseR> getLiasses() {
		return liasses;
	}

	public void setLiasses(List<LigneBorderoLiasseR> liasses) {
		this.liasses = liasses;
	}

	@Override
    public List<State> getStates() {
        State etat = new State("etabli", "Initié");
        List<State> states = new ArrayList<State>();
        if(this.state==null||this.state.equalsIgnoreCase("etabli")){
            states.add(etat);
        }else if(state.trim().equalsIgnoreCase("transmis")){
            states.add(new State("transmis", "Transmis"));
        }else if(state.trim().equalsIgnoreCase("receptionne")){
            states.add(new State("receptionne", "Receptionné"));
        }
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return super.getSerial(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(BorderoLiasseR o) {
        //To change body of generated methods, choose Tools | Templates.
        return Long.valueOf(id).compareTo(Long.valueOf(o.id));
    }
    
}
