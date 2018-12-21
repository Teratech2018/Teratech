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
 * Node of tree view 
 * @author BEKO
 */
public class TreeNode implements Serializable,Comparable<TreeNode>{

    
    protected String text ;
    
    protected List<String> tags;
    
    private long source;
    
    private String modulename;
    
    private String entityname ;    
    
    protected List<TreeNode> nodes = new ArrayList<TreeNode>();

    /**
     * 
     */
    public TreeNode() {
    }

    /**
     * 
     * @param label
     * @param entityname
     * @param moduleName
     * @param source 
     */
    public TreeNode(String label, String entityname, String moduleName, long source) {
        this.text = label;
        this.source = source;
        this.entityname = entityname;
        this.modulename = moduleName;
    }

    /**
     * Node description
     * @return 
     */
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * Nodes Tags (number of items 
     * @return 
     */
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Nodes children
     * @return 
     */
    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNode> nodes) {
        this.nodes = nodes;
    }

   /**
    * the ID of the entity
    * @return 
    */
    public long getSource() {
        return source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    /**
     * the name of entity that 
     * @return 
     */
    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String entityname) {
        this.entityname = entityname;
    }    

    /**
     * The name of module containig the entity
     * @return 
     */
    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }    
    

    @Override
    public int compareTo(TreeNode o) {
        //To change body of generated methods, choose Tools | Templates.
        return text.compareTo(o.text);
    }
    
}
