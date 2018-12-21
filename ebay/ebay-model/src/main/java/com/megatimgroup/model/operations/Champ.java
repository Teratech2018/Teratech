/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatimgroup.ebaytools.client.NodeObject;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="CHAMP")
public class Champ implements Serializable, Comparable<Champ> {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private String parentClassName ;
    
    private String className ;
    
    private String fieldName ;
    
    private String label ;
    
    private String pattern ;
    
    private int taille ;
    
    private  int index ;
    
    
    //Impose de verifier l'existance 
    private boolean entry = Boolean.FALSE;

    private boolean nullable = Boolean.TRUE;
    
    private boolean sansDoublons = Boolean.FALSE;
    
    private boolean optionelle = Boolean.TRUE;
    
    private String valeur ;
    

    public Champ() {
    }
    
    public Champ(NodeObject node) {
        
        this.parentClassName = node.getParentClazz()!=null ? node.getParentClazz().getName() : null;
        
        this.className = node.getClazz()!=null ? node.getClazz().getName() : null ;
        
        this.fieldName = node.getName();
        
        this.label = node.getLabel();
        
        this.pattern = node.getPattern() ;
        
        this.taille = node.getLength();
        this.entry = node.isEntry();
        this.nullable = node.isNullable();
        this.sansDoublons=node.isUnique();
        this.optionelle = node.isOptional();
        this.valeur = node.getValue()!=null ? node.getValue().toString():null;
    }

    public Champ(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getParentClassName() {
        return parentClassName;
    }

    public void setParentClassName(String parentClassName) {
        this.parentClassName = parentClassName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public boolean isEntry() {
        return entry;
    }

    public void setEntry(boolean entry) {
        this.entry = entry;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isSansDoublons() {
        return sansDoublons;
    }

    public void setSansDoublons(boolean sansDoublons) {
        this.sansDoublons = sansDoublons;
    }

    public boolean isOptionelle() {
        return optionelle;
    }

    public void setOptionelle(boolean optionelle) {
        this.optionelle = optionelle;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    

    /**
     * 
     * @return 
     */
    public NodeObject getNode() throws ClassNotFoundException{
       
        NodeObject node = new NodeObject();
        
        node.setClazz(Class.forName(getClassName()));
        
        node.setParentClazz(Class.forName(getParentClassName()));
        
        node.setEntry(isEntry());
        
        node.setLabel(getLabel());
        
        node.setLength(getTaille());
        
        node.setName(getFieldName());
        
        node.setNullable(isNullable());
        
        node.setOptional(isOptionelle());
        
        node.setPattern(getPattern());
        
        node.setUnique(isSansDoublons());
        
        node.setValue(getValeur());
        
        return node ;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.fieldName != null ? this.fieldName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Champ other = (Champ) obj;
        if ((this.fieldName == null) ? (other.fieldName != null) : !this.fieldName.equals(other.fieldName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(index);//index;
    }

    
    
    
    public int compareTo(Champ o) {
        return Integer.compare(index, o.index);
    }
    
    
    
}
