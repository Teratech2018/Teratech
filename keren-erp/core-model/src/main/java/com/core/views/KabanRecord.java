/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.views;

import com.core.menus.MenuAction;
import com.megatim.common.annotations.Predicate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue(value = "KABAN")
public class KabanRecord extends Record{ 
    
    @OneToOne
    @JoinColumn(name="T_ITEM_ID")
    @Predicate(label = "Menu Item Parent" ,type = MenuAction.class,group = true,groupName = "group2",groupLabel = "MENUS ACTIONS",search = true)
    private MenuAction action ;

     


    public KabanRecord() {
    }

    /**
     * 
     * @param action 
     */
    public KabanRecord(MenuAction action) {
        this.action = action;
    }

    /**
     * 
     * @param action
     * @param code
     * @param titre
     * @param modele
     * @param sequence
     * @param script
     * @param id
     * @param designation
     * @param moduleName 
     */
    public KabanRecord(MenuAction action, String code, String titre, String modele, short sequence, String script, long id, String designation, String moduleName) {
        super(code, titre, modele, sequence, script, id, designation, moduleName);
        this.action = action;
    }

    /**
     * 
     * @param entity 
     */
   public KabanRecord(KabanRecord entity) {
        super(entity.code, entity.titre, entity.modele, entity.sequence, entity.script, entity.id, entity.designation, entity.moduleName);
//        this.action = entity.action;
        
    }
    public MenuAction getAction() {
        return action;
    }

    public void setAction(MenuAction action) {
        this.action = action;
    }

    @Override
    public String getDesignation() {
        return titre; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "CALANDRIER"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "CALANDRIER"; //To change body of generated methods, choose Tools | Templates.
    }
     
     
     
}
