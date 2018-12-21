/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotations.Include;
import com.megatim.common.annotations.IncludeObject;
import com.megatim.common.annotationsprocessor.ValidateAndFillBeans;
import com.megatimgroup.ebaytools.client.NodeObject;
import com.megatimgroup.ebaytools.client.RootObject;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import java.lang.reflect.Field;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Commercial_2
 */
public class TreeHelper {
    
    /**
     * 
     * @param clazz
     * @return 
     */
    public static RootObject buildFromClass(Class<?> clazz){
        
                RootObject rootNode = null;
        
        if(clazz.equals(DeclarationPP.class)){
            rootNode = new RootObject(DeclarationPP.class, "Personnes Physiques");        
        }else if(clazz.equals(DeclarationPM.class)){
            rootNode = new RootObject(DeclarationPM.class, "Personnes Morales");              
        }else if(clazz.equals(DeclarationFinanciere.class)){
            rootNode = new RootObject(DeclarationFinanciere.class, "Opérations Financières");              
        }
        
        if(rootNode==null) return null;
          
          Field[] fields = ValidateAndFillBeans.getObjectDeclaredFields(clazz);
          
          for(Field field : fields){
             
              NodeObject node =null;
              
              if(field.isAnnotationPresent(Predicate.class)){
                  node = new NodeObject();
                  node.setClazz(field.getType());
                  node.setName(field.getName());              
                  Predicate predicate = field.getAnnotation(Predicate.class);
                  node.setNullable(predicate.nullable());
                  node.setUnique(predicate.unique());
                  node.setEntry(predicate.entry());
                  node.setLabel(predicate.label());
                  node.setLength(predicate.length());
                  node.setPattern(predicate.pattern());
                  node.setParentClazz(rootNode.getClazz());
                  node.setOptional(predicate.optional());     
                  
                  if(field.isAnnotationPresent(Include.class)){                  
                  
                       Include include = field.getAnnotation(Include.class);
                       
                       IncludeObject includeObject = new IncludeObject();
                       
                       includeObject.setClasses(include.classes());
                       
                       includeObject.setChamps(include.champs());
                       
                       includeObject.setConnector(include.connector());
                       
                       includeObject.setType(include.type());
                       
                       includeObject.setValeur(include.value());
                       
                       node.setInclude(includeObject);
                  }
              }
              
              
              if(node!=null){
                  rootNode.addNode(node);
              }
              
          }
        return rootNode;
    } 
    
    /**
     * 
     * @param root
     * @return 
     */
    public static DefaultMutableTreeNode buildNode(RootObject root){
        
        if(root==null)
                   return null;
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root);
        
        for(NodeObject object : root.getNodes()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(object);
            rootNode.add(node);
        }
        return rootNode;
    }
}
