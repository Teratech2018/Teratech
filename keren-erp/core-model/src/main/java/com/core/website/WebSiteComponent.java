/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.website;

import com.core.base.BaseElement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_WEBCOMP")
public class WebSiteComponent extends BaseElement implements Serializable,Comparable<WebSiteComponent>{

    private String code ;
    
    private String type ="page";
    
    private boolean indexPage = false;
    
    private String entity ;
    
    private String method ;
    
    private String var;
    
    private String modele ;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String script ;
    
    @ManyToOne
    @JoinColumn(name = "WEBSITE_ID")
    private WebSiteModule website ;
    
    
    /**
     * 
     */
    public WebSiteComponent() {
        
    }    
    
    /**
     * 
     * @param entity 
     */
    public WebSiteComponent(WebSiteComponent entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.entity = entity.entity;
        this.method = entity.method;
        this.var = entity.var;
        this.type = entity.type;
        this.indexPage = entity.indexPage;    
        this.script = entity.script;
        this.modele = entity.modele;
        if(entity.website!=null){
            this.website = new WebSiteModule(entity.website);
        }//end if(entity.website!=null){
    }

    public WebSiteComponent(long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
    }

    
    
    public WebSiteModule getWebsite() {
        return website;
    }

    public void setWebsite(WebSiteModule website) {
        this.website = website;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIndexPage() {
        return indexPage;
    }

    public void setIndexPage(boolean indexPage) {
        this.indexPage = indexPage;
    }
  

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
    
    

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getListTitle() {
        return "Composants Web"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Composant Web"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "WebSiteComponent{" + "type=" + type + ", index=" + indexPage + ", entity=" + entity + ", method=" + method + ", var=" + var + ", website=" + website.getId()+'}';
    }

    @Override
    public int compareTo(WebSiteComponent o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }

    

   
   
}
