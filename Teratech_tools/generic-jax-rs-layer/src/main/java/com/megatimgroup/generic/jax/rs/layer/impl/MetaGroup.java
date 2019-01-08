/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Commercial_2
 */
@XmlRootElement
public class MetaGroup implements Serializable{
    private String groupName ;
    
    private String groupLabel ;
    
    private short sequence = 0;
    
    private String hidden ;
    
    
    private List<MetaArray> metaArray = new ArrayList<MetaArray>();
    
    private List<MetaColumn> columns = new ArrayList<MetaColumn>();

    /**
     * 
     */
    public MetaGroup() {
    }

    /**
     * 
     * @param groupName
     * @param groupLabel
     * @param metaArray 
     */
    public MetaGroup(String groupName, String groupLabel, MetaArray metaArray) {
        this.groupName = groupName;
        this.groupLabel = groupLabel;
//        this.metaArray = metaArray;
    }

    public MetaGroup(MetaGroup entity) {
        this.groupName = entity.groupName;
        this.groupLabel = entity.groupLabel;
        this.hidden = entity.hidden;
        this.sequence = entity.sequence;
        for(MetaColumn col:entity.columns){
            this.columns.add(new MetaColumn(col));
        }
        for(MetaArray meta:metaArray){
            this.metaArray.add(new MetaArray(meta));
        }
    }
    
    

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupLabel() {
        return groupLabel;
    }

    public void setGroupLabel(String groupLabel) {
        this.groupLabel = groupLabel;
    }

    public List<MetaArray> getMetaArray() {
        return metaArray;
    }

    public void setMetaArray(List<MetaArray> metaArray) {
        this.metaArray = metaArray;
    }

    public List<MetaColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<MetaColumn> columns) {
        this.columns = columns;
    }

    public short getSequence() {
        return sequence;
    }

    public void setSequence(short sequence) {
        this.sequence = sequence;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }
    
    

    @Override
    public String toString() {
        return "MetaGroup{" + "groupName=" + groupName + ", groupLabel=" + groupLabel + ", metaArray=" + metaArray + ", columns=" + columns + '}';
    }
    
    
    
}
