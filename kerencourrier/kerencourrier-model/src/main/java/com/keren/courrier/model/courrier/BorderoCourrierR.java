/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.courrier;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.courrier.model.others.UtilisateurClone;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "T_BORCOUGC")
public class BorderoCourrierR extends BaseElement implements Serializable,Comparable<BorderoCourrierR>{

    @Predicate(label = "Bordero",optional = false,unique = true,search = true,editable = false)
    private String code; 
    
    
    @Predicate(label = "Type de bordereau",target = "combobox",values = "Interne;Départ;Confidentiel",updatable = false,editable = false)
    private String type ;
    
    @ManyToOne
    @JoinColumn(name = "SRC_ID")
//    @Predicate(label = "Service",type = StructureCompany.class,target = "many-to-one",optional = false,search = true)
    private StructureCompany source ;
    
    @ManyToOne
    @JoinColumn(name = "CIB_ID")
    @Predicate(label = "Service",type = StructureCompany.class,updatable = false,target = "many-to-one",optional = false,search = true,editable = false)
    private StructureCompany cible ;
    
    @ManyToOne
    @JoinColumn(name = "UTCL_ID")
    @Predicate(label = "Agent liaison",type = UtilisateurClone.class,target = "many-to-one",optional = true,search = true,editable = false)
    private UtilisateurClone agentliaison ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date création",type = Date.class,editable =false,target = "date",search = true)
    private Date creation;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date émission",type = Date.class,target = "date",editable =false,search = true)
    private Date emission;
    
     @Temporal(javax.persistence.TemporalType.DATE)
//    @Predicate(label = "Date émission",type = Date.class,target = "date",editable =false,search = true)
     private Date daccuse;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "BORD_ID")
    @Predicate(label ="",type = LigneBorderoCourrierR.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Listes des Courriers",edittable = true)
    private List<LigneBorderoCourrierR> courriers = new ArrayList<LigneBorderoCourrierR>();

    @Predicate(label = "Statut",search = false,hide = true)
    private String state = "etabli";
    
   
    @Predicate(label = " ",search =true,type=Long.class,hide=true)
    @Column(name = "N_CRECU")
    private long ncrecu ; 
    
    
     public BorderoCourrierR(BorderoCourrierR entity) {
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
        this.ncrecu=entity.ncrecu;
    }
     
    public BorderoCourrierR(String code, StructureCompany service, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        
    }

    public BorderoCourrierR() {
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

    public Date getDaccuse() {
        return daccuse;
    }

    public void setDaccuse(Date daccuse) {
        this.daccuse = daccuse;
    }

   

    public List<LigneBorderoCourrierR> getCourriers() {
        return courriers;
    }

    public void setCourriers(List<LigneBorderoCourrierR> courriers) {
        this.courriers = courriers;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
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

    public long getNcrecu() {
		return ncrecu;
	}

	public void setNcrecu(long ncrecu) {
		this.ncrecu = ncrecu;
	}

	@Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
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
    public int compareTo(BorderoCourrierR o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
