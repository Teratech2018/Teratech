/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import com.megatim.common.jaxb.entities.Linecolumn;
import com.megatimgroup.ebaytools.client.NodeObject;
import java.io.Serializable;

/**
 *
 * @author DEV_4
 */
public class ValidateError implements  Serializable,Comparable<ValidateError>{

    private NodeObject node ;
    
    private Linecolumn column ;
    
    private String errorMessage;

    public ValidateError() {
    }

    /**
     * 
     * @param node
     * @param column
     * @param errorMessage 
     */
    public ValidateError(NodeObject node, Linecolumn column, String errorMessage) {
        this.node = node;
        this.column = column;
        this.errorMessage = errorMessage;
    }
    
    
    
    public NodeObject getNode() {
        return node;
    }

    public void setNode(NodeObject node) {
        this.node = node;
    }

    public Linecolumn getColumn() {
        return column;
    }

    public void setColumn(Linecolumn column) {
        this.column = column;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.node != null ? this.node.hashCode() : 0);
        hash = 97 * hash + (this.column != null ? this.column.hashCode() : 0);
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
        final ValidateError other = (ValidateError) obj;
        if (this.node != other.node && (this.node == null || !this.node.equals(other.node))) {
            return false;
        }
        if (this.column != other.column && (this.column == null || !this.column.equals(other.column))) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public int compareTo(ValidateError o) {
        return node.compareTo(o.node); //To change body of generated methods, choose Tools | Templates.
    }
    
}
