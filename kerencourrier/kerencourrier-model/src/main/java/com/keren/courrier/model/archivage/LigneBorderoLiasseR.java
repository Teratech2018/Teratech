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
public class LigneBorderoLiasseR extends BaseElement implements Serializable,Comparable<LigneBorderoLiasseR>{

	@Predicate(label = "Vue(?)",target = "checkbox",search = true)
    private Boolean statut = Boolean.FALSE;
	
	@ManyToOne
    @JoinColumn(name = "LIASS_ID")
    @Predicate(label = "Liasse Concerné",type = LiasseDocument.class,target = "many-to-one",search = true,observable = true)
    private LiasseDocument liasse ;
   
    
    @Predicate(label = "Objet",target = "textarea",editable = false,search = true)
    @Observer(observable = "courrier",source = "field:objet")
    private String objet ;
    
    @Predicate(label = "Instruction",target = "textarea",editable = true,search = true)
    private String instruction ;
    
    


    public LigneBorderoLiasseR(Boolean statut, LiasseDocument liasse, NatureCourrier naturecourrier, String objet,
			String instruction) {
		super();
		this.statut = statut;
		this.liasse = liasse;
		this.objet = objet;
		this.instruction = instruction;
	}

    
    public LigneBorderoLiasseR(LigneBorderoLiasseR entity) {
		super();
		this.statut = entity.statut;
		this.liasse = new LiasseDocument(entity.liasse);
		this.objet = entity.objet;
		this.instruction = entity.instruction;
	}


	public LigneBorderoLiasseR() {
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

    public Boolean getStatut() {
		return statut;
	}



	public void setStatut(Boolean statut) {
		this.statut = statut;
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
    public int compareTo(LigneBorderoLiasseR o) {
         //To change body of generated methods, choose Tools | Templates.
        return liasse.compareTo(o.liasse);
    }
    
}
