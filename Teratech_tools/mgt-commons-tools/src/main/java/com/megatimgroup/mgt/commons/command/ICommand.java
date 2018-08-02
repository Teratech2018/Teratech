/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.command;

/**
 *interface of 
 * @author BEKO
 */
public interface ICommand {
    
    /**
     * Fonction execution de la commande
     * @return 
     * @throws java.lang.Exception 
     */
    public boolean execute() throws Exception;
}
