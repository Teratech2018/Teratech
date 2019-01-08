/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.jaxrs.impl.tools;

import com.megatimgroup.generic.jax.rs.layer.impl.AbstractTreeContainer;
import com.megatimgroup.generic.jax.rs.layer.impl.TreeNode;
import com.teratech.vente.model.base.FamilleArticle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BEKO
 */
public class FamilleArticleTNContainer extends AbstractTreeContainer{

    @Override
    public List<TreeNode> buildTree(List datas) {
       //To change body of generated methods, choose Tools | Templates.
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        Map<Long,TreeNode> nodesMap = new HashMap<Long, TreeNode>();
        //Root node 
        TreeNode rootnode = new TreeNode("Root", " ", " ", -1);
        rootnode.setTags(new ArrayList<String>());
        rootnode.setNodes(new ArrayList<TreeNode>());
        nodesMap.put(-1L, rootnode);
        nodes.add(rootnode);
        for(Object data : datas){
            TreeNode node = insertFamilleArticle((FamilleArticle) data, nodes, nodesMap);
            node.getTags().add(node.getNodes().size()>0 ? Integer.toString(node.getNodes().size()):"0");
        }//end for(Object data : datas){
        return nodes ;
    }
    
    /**
     * 
     * @param famille
     * @param nodes
     * @param nodesMap
     * @return 
     */
    private TreeNode insertFamilleArticle(FamilleArticle famille , List<TreeNode> nodes , Map<Long,TreeNode> nodesMap){
        TreeNode node = convert(famille) ;
        if(nodesMap.containsKey(famille.getId())){
            node = nodesMap.get(famille.getId());
        }//end if(nodesMap.containsKey(famille.getId())){
        if(famille.getCentralisateur()!=null){
          if(!nodesMap.containsKey(famille.getCentralisateur().getId())){
            TreeNode pnode = insertFamilleArticle(famille.getCentralisateur(), nodes, nodesMap);
            pnode.getNodes().add(node);
          }else{
            TreeNode pnode = nodesMap.get(famille.getCentralisateur().getId());
            pnode.getNodes().add(node);
          }//end if(!nodesMap.containsKey(famille.getCentralisateur().getId())){
        }else{
          if(!nodesMap.containsKey(famille.getId())){
              Long key = -1L;
              TreeNode pnode = nodesMap.get(key);
              pnode.getNodes().add(node);
          }//end if(!nodesMap.containsKey(famille.getId())){
        }//end if(famille.getCentralisateur()!=null){
        nodesMap.put(famille.getId(), node);       
        return node ;
    }
    /**
     * 
     * @param famille
     * @return 
     */
    private TreeNode convert(FamilleArticle famille){
        TreeNode node = new TreeNode(famille.getDesignation(), "FamilleArticle", "teratechachat", famille.getId());
        node.setTags(new ArrayList<String>());
        node.setNodes(new ArrayList<TreeNode>());
        return node ;
    }
}
