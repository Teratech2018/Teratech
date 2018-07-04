/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BEKO
 */
public class ImportData implements Serializable,Comparable<ImportData>{

    private String fichier ;
    
    private String format ;
    
    private String separator ;
    
    private List<ImportLigne> fields = new ArrayList<ImportLigne>();
    
    private List<Long> datas = new ArrayList<>();
    
    private String className ;
    
    private String typeexport = "0";
    

    public ImportData() {
    }

    /**
     * 
     * @param fichier
     * @param format 
     */
    public ImportData(String fichier, String format) {
        this.fichier = fichier;
        this.format = format;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<ImportLigne> getFields() {
        return fields;
    }

    public void setFields(List<ImportLigne> fields) {
        this.fields = fields;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getTypeexport() {
        return typeexport;
    }

    public void setTypeexport(String typeexport) {
        this.typeexport = typeexport;
    }

    public List<Long> getDatas() {
        return datas;
    }

    public void setDatas(List<Long> datas) {
        this.datas = datas;
    } 

    @Override
    public String toString() {
        return "ImportData{" + "fichier=" + fichier + ", format=" + format + ", separator=" + separator + ", fields=" + fields + ", datas=" + datas + ", className=" + className + ", typeexport=" + typeexport + '}';
    }    
    
    @Override
    public int compareTo(ImportData o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
