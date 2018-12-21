/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatimgroup.ebaytools.client.EbayItem;
import com.megatimgroup.ebaytools.client.NodeObject;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="MODELE")
public class Modele implements Serializable, Comparable<Modele> {
    
    @Id
    private String code ;
    
    @Column(name="DESIGNATION")
    private String designation ;
    
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="MODELE_ID")
    private List<Champ> elements ;
    
    @Transient
    private List<NodeObject> nodes ;

    /**
     * 
     */
    public Modele() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public Modele(String code, String designation) {
        this.code = code;
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Champ> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public void setElements(List<Champ> elements) {
        this.elements = elements;
    }

    
    /**
     * Ajout d'un champs dans la liste
     * @param champ 
     */
    public  void add(Champ champ){
        
        //Pas de champ a inserer
        if(champ==null) return ;
        
        //Si la liste est vide bien vouloir la creer
        if(elements==null)
            elements = new ArrayList<Champ>();
        //Verifier que l'element n'est pas encore dans la liste
        if(elements.contains(champ)) return ;
        
        //insertion de l'element dans la liste
        elements.add(champ);
    }
    
    public   void remove(Champ champ){
        
         //Pas de champ a inserer ou liste vide 
        if(champ==null || elements==null||elements.isEmpty()||!elements.contains(champ)) return ;
        //Enlever le champ dans la liste 
        elements.remove(champ);
        
    }

    public List<NodeObject> getNodes() {
        return nodes;
    }

    /**
     * 
     * @param nodes 
     */
    public void setNodes(List<NodeObject> nodes) {
        this.nodes = nodes;
//        elements = new ArrayList<Champ>();
//        
//        if(nodes!=null&&!nodes.isEmpty()){
//                
//            for(NodeObject node : nodes){
//                elements.add(new Champ(node));
//            }
//            
//        }
    }
    
    /**
     * 
     * @return 
     */
    public List<NodeObject> buildNode(List<NodeObject> nodes) throws ClassNotFoundException{
        
        List<NodeObject> noeuds = new ArrayList<NodeObject>();
        //Tri des elements par orde
        Map<String,Champ> map = new HashMap<String, Champ>();
        
        for(Champ node : elements){
            map.put(node.getFieldName(), node);
        }
        
        //Construction de la liste des noeuds
        for(NodeObject node : nodes){
            if(map.containsKey(node.getName())){
                Champ champ = map.get(node.getName());
                node.setClazz(Class.forName(champ.getClassName()));
                node.setParentClazz(Class.forName(champ.getParentClassName()));
                noeuds.add(node);
            }
        }
        return noeuds;
    }
    
//     /**
//     * 
//     * @return 
//     */
//    public List<NodeObject> buildNode() throws ClassNotFoundException{
//        
//        List<NodeObject> noeuds = new ArrayList<NodeObject>();
//        //Tri des elements par orde
//        Collections.sort(elements);
//        for(Champ node : elements){
//            noeuds.add(node.getNode());
//        }
//        return noeuds;
//    }
    
    
    public int compareTo(Modele o) {
        return code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return code+" - "+designation ;
    }
    
    /**
     * Renvoie les elements sous la forme d'une liste de 
     * champs
     * @return 
     */
    public String getFields(){
        
        StringBuilder builder = new StringBuilder();
        
        //Verifier que les elements sont non null
        if(elements!=null&&!elements.isEmpty()){
            
//            HashMap<String , Champ> database = new HashMap<String , Champ>();
            Collections.sort(elements);
            int discover = 0 ;
            
            for(Champ champ : elements){
                  
                 if(discover==0){
                       //Est le premier decouvert
                       //initialisation de la liste des elements
                       builder.append(champ.getFieldName());
                    }else{
                         //Ajour du separateur
                       builder.append(" , ");
                        builder.append(champ.getFieldName());
                    }
                   
                    //Mise a jour du nombre de decouvert
                    discover = discover + 1 ;
                          
//                database.put(champ.getFieldName(), champ);
            }
            
//            //Collections.sort(elements);
//            Field[] itemsFeilds = EbayItem.class.getDeclaredFields();
//            
//            int discover = 0 ;
//            //Construction de la liste
//            for(Field field : itemsFeilds){
//                
//                if(database.containsKey(field.getName())){
//                    
//                    if(discover==0){
//                        //Est le premier decouvert
//                        //initialisation de la liste des elements
//                        builder.append(field.getName());
//                    }else{
//                         //Ajour du separateur
//                        builder.append(" , ");
//                        builder.append(field.getName());
//                    }
//                    
//                    //Mise a jour du nombre de decouvert
//                    discover = discover + 1 ;
//                }
//            }           
//
       }
        return builder.toString();
    }
    
}
