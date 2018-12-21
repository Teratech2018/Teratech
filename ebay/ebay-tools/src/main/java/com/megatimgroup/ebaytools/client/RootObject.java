/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DEV_4
 */
public class RootObject implements Serializable,Comparable<RootObject>{

    private Class<?> clazz ;
    
    private String name ;
    
    private List<NodeObject> nodes = new ArrayList<NodeObject>();

    
    /**
     * 
     * @param clazz
     * @param name 
     */
    public RootObject(Class<?> clazz, String name) {
        this.clazz = clazz;
        this.name = name;
    }

    /**
     * 
     */
    public RootObject() {
    }

    
    
    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NodeObject> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeObject> nodes) {
        this.nodes = nodes;
    }

    
    public void addNode(NodeObject node){
        
        if(!nodes.contains(node)){
            nodes.add(node);
        }
    }
    
    @Override
    public String toString() {
        return name ;
    }
    
    
    
    
    @Override
    public int compareTo(RootObject o) {
        //To change body of generated methods, choose Tools | Templates.
        return  name.compareTo(o.name);
    }
    
}
