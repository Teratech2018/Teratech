/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.application;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;

/**
 *
 * @author BEKO
 */
public class ConfigItem extends BaseElement implements Serializable,Comparable<ConfigItem>{

    @Predicate(label = "KEY",unique = true,search = true,optional = false,nullable = false,updatable = false)
    private String code ;
    
    @Predicate(label = "VALUE",search = true,optional = false,nullable = false)
    private String value ;

    /**
     * 
     */
    public ConfigItem() {
    }

    /**
     * 
     * @param code
     * @param value
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ConfigItem(String code, String value, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.value = value;
    }

    /**
     * 
     * @param code
     * @param value 
     */
    public ConfigItem(String code, String value) {
        this.code = code;
        this.value = value;
    }
    
    
    
    public ConfigItem(ConfigItem entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.value = entity.value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getOwnermodule() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
         return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "CONFIGL"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "CONFIGD"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        StringBuilder builder = new StringBuilder();
        if(code!=null 
                && !code.trim().isEmpty()){
            builder.append(code);
        }
        if(value!=null
                && !value.trim().isEmpty()){
            builder.append(" ; ")
                    .append(value);
        }
        return builder.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ConfigItem o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return "{" + "code=" + code + ", value=" + value + '}';
    }

    @Override
    public boolean isDesableupdate() {
        return super.isDesableupdate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {       
        return code!=null && (code.trim().equalsIgnoreCase("script")
                || code.trim().equalsIgnoreCase("program")
                || code.trim().equalsIgnoreCase("system")
                || code.trim().equalsIgnoreCase("user")
                || code.trim().equalsIgnoreCase("password")
                ||code.trim().equalsIgnoreCase("database")
                || code.trim().equalsIgnoreCase("filename"));
    }

    @Override
    public boolean isDesablecreate() {
        return super.isDesablecreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
