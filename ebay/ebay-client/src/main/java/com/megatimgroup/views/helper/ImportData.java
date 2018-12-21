/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatimgroup.model.operations.Modele;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Commercial_2
 */
public class ImportData implements Serializable, Comparable<ImportData> {
    
    private Modele modele ;
    
    private String fileName ;
    
    private File file ;

    
    /**
     * 
     */
    public ImportData() {
    }

    /**
     * 
     * @param modele
     * @param fileName
     * @param file 
     */
    public ImportData(Modele modele, String fileName, File file) {
        this.modele = modele;
        this.fileName = fileName;
        this.file = file;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }    

    @Override
    public String toString() {
        return "ImportData{" + "modele=" + modele + ", fileName=" + fileName + ", file=" + file + '}';
    }

        
    
    
    public int compareTo(ImportData o) {
        return 0;
    }
    
}
