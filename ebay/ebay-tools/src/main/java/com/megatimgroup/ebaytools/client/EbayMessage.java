/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.swing.tree.TreeNode;


/**
 *
 * @author Commercial_2
 */
public class EbayMessage extends Observable{
    
    private String message ;
    
    private Date debut ;
    
    private Date fin ;
    
    private TreeNode treeNode ;
    
    //-1 = erreur
    private MessageType statut = MessageType.INITIAL ;

    private List<EbayMessageItem> elements ;
    
    private List<ValidateError> errors = new ArrayList<ValidateError>();
    
    /**
     * 
     */
    public EbayMessage() {
        //treeNode.get
        elements = new ArrayList<EbayMessageItem>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public MessageType getStatut() {
        return statut;
    }

    public void setStatut(MessageType statut) {
        this.statut = statut;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
    
    

    /**
     * 
     * @return 
     */
    public List<EbayMessageItem> getElements() {
        return Collections.unmodifiableList(elements);
    }
    
    public void addMessage(EbayMessageItem message){
        elements.add(message);
        setChanged();
        notifyObservers(this);
    }

    @Override
    public String toString() {
        return message ;
    }

    /**
     * 
     * @return 
     */
    public List<ValidateError> getErrors() {
        return errors;
    }

    
    /**
     * 
     * @param errors 
     */
    public void setErrors(List<ValidateError> errors) {
        this.errors = errors;
    }
    
    
    
}
