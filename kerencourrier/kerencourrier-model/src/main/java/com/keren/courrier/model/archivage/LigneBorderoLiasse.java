/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LIBORLIAS")
public class LigneBorderoLiasse extends BaseElement implements Serializable,Comparable<LigneBorderoLiasse>{

    @ManyToOne
    @JoinColumn(name = "LIASS_ID")
    @Predicate(label = "Liasse Concerné",type = LiasseDocument.class,target = "many-to-one",search = true,observable = true)
    private LiasseDocument liasse ;
    
    
    @Predicate(label = "Objet",target = "textarea",editable = false,search = true)
    @Observer(observable = "liasse",source = "field:objet")
    private String objet ;
    
    @Predicate(label = "Instruction",target = "textarea",editable = false,search = true)
    private String instruction ;


    
    public LigneBorderoLiasse(LiasseDocument liasse, NatureCourrier naturecourrier, String objet, String instruction) {
		super();
		this.liasse = liasse;
		this.objet = objet;
		this.instruction = instruction;
	}
    
    public LigneBorderoLiasse(LigneBorderoLiasse entity) {
    	 super(entity.id, entity.designation, entity.moduleName, entity.compareid);
    	 if(entity.liasse!=null){
    		 this.liasse = new LiasseDocument(entity.liasse); 
    	 }
		this.objet = entity.objet;
		this.instruction = entity.instruction;
	}
    
    public LigneBorderoLiasse(LiasseDocument entity) {
   	 super(-1, null,null,0L);
		this.liasse = entity;
		this.objet ="Enliasser Courrier "+entity.getDossier().getIntitule();
		this.instruction = "";
	}



	public LigneBorderoLiasse() {
    }

   

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

  

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Liasse"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public LiasseDocument getLiasse() {
		return liasse;
	}



	public void setLiasse(LiasseDocument liasse) {
		this.liasse = liasse;
	}



	@Override
    public int compareTo(LigneBorderoLiasse o) {
         //To change body of generated methods, choose Tools | Templates.
        return liasse.compareTo(o.liasse);
    }
    
}
