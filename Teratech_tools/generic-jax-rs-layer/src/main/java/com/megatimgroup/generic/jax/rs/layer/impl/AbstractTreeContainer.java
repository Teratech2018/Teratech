/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.util.List;

/**
 *
 * @author BEKO
 */
public abstract class AbstractTreeContainer {
    
    /**
     * This function convert you list data 
     * to TreeNode list
     * @param datas
     * @return 
     */
    public abstract List<TreeNode> buildTree(List datas);
}
