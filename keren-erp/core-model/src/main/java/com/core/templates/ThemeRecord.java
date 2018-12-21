/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.templates;

import com.core.base.BaseElement;
import com.core.menus.MenuModule;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_THEME")
public class ThemeRecord  extends BaseElement implements Serializable{
   
    /**
     *
     */    
   
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String script ;    
   
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String discussion ;    
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String form ;    
   
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String tree ;  
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String container ;  
   
//    @Predicate(label = " " ,group = true,groupName = "calendar",groupLabel = "Calendar template",target = "aceeditor",search = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String calendar ;    
   
//    @Predicate(label = " " ,group = true,groupName = "report",groupLabel = "Report",target = "aceeditor",search = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String report ;    
   
//    @Predicate(label = " " ,group = true,groupName = "dashboard",groupLabel = "Dashbord template",target = "aceeditor",search = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String dashbord ;    
   
//    @Predicate(label = " " ,group = true,groupName = "import",groupLabel = "Import Template",target = "aceeditor",search = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String importer ;    
   
//    @Predicate(label = " " ,group = true,groupName = "export",groupLabel = "Export Template",target = "aceeditor",search = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    protected String export ;
    
    /**
     *
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOD_ID")
     protected MenuModule module;

    /**
     * 
     */
    public ThemeRecord() {
    }

    /**
     * 
     * @param entity 
     */
    public ThemeRecord(ThemeRecord entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.script = entity.script;
        this.script = entity.script;
        this.form = entity.form;
        this.tree = entity.tree;
        this.calendar = entity.calendar;
        this.report = entity.report;
        this.dashbord = entity.dashbord;
        this.importer = entity.importer;
        this.export = entity.export;
        this.container = entity.container;
//        if(entity.module!=null){
//            this.module = new MenuModule(entity.module);
//        }
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }
    
    

   

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getDashbord() {
        return dashbord;
    }

    public void setDashbord(String dashbord) {
        this.dashbord = dashbord;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public MenuModule getModule() {
        return module;
    }

    public void setModule(MenuModule module) {
        this.module = module;
    }

  
    
}
