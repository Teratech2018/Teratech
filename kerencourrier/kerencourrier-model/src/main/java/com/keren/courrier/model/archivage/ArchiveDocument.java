/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ARCDOCGC")
public class ArchiveDocument extends BaseElement implements Serializable,Comparable<ArchiveDocument>{

    @Predicate(label = "Reference",optional = false,search = true)
    private String code ;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule;
    
    @ManyToOne
    @JoinColumn(name = "CAD_ID")
    @Predicate(label = "Numéro de série",type = CadreClassement.class,target = "many-to-one",search = true)
    private CadreClassement cadre ;
    
     @ManyToOne
    @JoinColumn(name = "BOI_ID")
    @Predicate(label = "Boîte d'archivage",type = BoiteArchivage.class,target = "many-to-one",search = true)
    private BoiteArchivage boite ;
    
    @Predicate(label = "Mots clés",optional = false,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String motscles;
    
    @Predicate(label = "Auteur",optional = false,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String auteur ;
    
    @Predicate(label = "Resumé",optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String description;
    
    @Predicate(label = "Nombre de page",type = Short.class,optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private Short nbrepages = 0 ;
    
    @Predicate(label = "Editeur",optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String editeur ;
    
    @Predicate(label = "Publié par",optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String publisher ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date publication",type = Date.class,target = "date",optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private Date dpublisher;
    
    @Predicate(label = "Observation",optional = true,group = true,groupName = "group1",groupLabel = "Général",search = true)
    private String observation;
    
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
     
     
    @Override
    public int compareTo(ArchiveDocument o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
