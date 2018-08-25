/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.website;

import com.core.base.BaseElement;
import com.core.menus.MenuAction;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_WEBSITE")
public class WebSiteModule extends BaseElement implements Serializable,Comparable<WebSiteModule>{

    @Column(unique = true)
    private String code ;
   
    /**
     * Categorie of Web Module there two categorie
     * website: for web site application
     * application:For application 
     */
    private String categorie ;
    
    @Column(name = "iden001")
    private String usercompte;
     
    @Column(name = "iden002")
    private String userpassword ;
    
    @OneToOne
    @JoinColumn(name="T_ITEM_ID")
    @Predicate(label = "Menu Item Parent" ,type = MenuAction.class,group = true,groupName = "group2",groupLabel = "MENUS ACTIONS",search = true)
    private MenuAction action ;
    
    @OneToMany(mappedBy = "website",fetch = FetchType.LAZY)
    private List<WebSiteComponent> webcomponents = new ArrayList<WebSiteComponent>();
    
    

    public WebSiteModule() {
    }

    /**
     * 
     * @param code
     * @param action 
     */
    public WebSiteModule(String code, MenuAction action) {
        this.code = code;
        this.action = action;
    }

    /**
     * 
     * @param code
     * @param action
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public WebSiteModule(String code, MenuAction action, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.action = action;
    }
    
     public WebSiteModule(WebSiteModule entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.usercompte = entity.usercompte;
        this.userpassword = entity.userpassword;
        this.categorie = entity.categorie;
//        if(entity.action!=null){
//            this.action = new MenuAction(entity.action);
//        }
    }

     
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MenuAction getAction() {
        return action;
    }

    public void setAction(MenuAction action) {
        this.action = action;
    }

    public List<WebSiteComponent> getWebcomponents() {
        return webcomponents;
    }

    public void setWebcomponents(List<WebSiteComponent> webcomponents) {
        this.webcomponents = webcomponents;
    }

    public String getUsercompte() {
        return usercompte;
    }

    public void setUsercompte(String usercompte) {
        this.usercompte = usercompte;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Sites Web"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Site Web"; //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
    @Override
    public int compareTo(WebSiteModule o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
