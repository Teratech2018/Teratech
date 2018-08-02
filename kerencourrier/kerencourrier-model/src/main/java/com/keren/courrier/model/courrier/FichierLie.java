/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.courrier;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "T_PJGC")
public class FichierLie extends BaseElement implements Serializable,Comparable<FichierLie>{

    @Predicate(label = "descriptif de la pièce",optional = false,search = true)
    private String code;
    
    @Predicate(label = "Fichier lié",target = "file",search = true)
    private String filename ;

    public FichierLie() {
    }
    
    public FichierLie(FichierLie fichierLie) {
        super(fichierLie.id, fichierLie.designation, fichierLie.moduleName,fichierLie.compareid);
        this.code = fichierLie.getCode();
        this.filename = fichierLie.getFilename();
    }
    
    /**
     * 
     * @param code
     * @param shortcut
     * @param id
     * @param designation
     * @param moduleName 
     */
    public FichierLie(String code, String shortcut, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.filename = shortcut;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

   
    
     @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Documents"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Document"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getCompareid() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(FichierLie o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
