

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.megatim.common.context.ToolsContext;
import com.megatim.security.model.Utilisateur;
import com.megatimgroup.model.parametres.Societe;

/**
 *
 * @author DEV_4
 */
public class CurrentSessionInformations {
    
    private static Utilisateur currentUser = null;
    private static Societe currentSociete= null;
    
    
 

    public static synchronized Utilisateur getCurrentUser() {
        return currentUser;
    }

  
    public static synchronized void setCurrentUser(Utilisateur currentUser) {
        CurrentSessionInformations.currentUser = currentUser;

        //On recupere le user courant
        ToolsContext.CURRENT_USER = CurrentSessionInformations.currentUser;
        
    }

    /**
     * @return the currentSociete
     */
    public synchronized static Societe getCurrentSociete() {
            return currentSociete;
    }

    /**
     * @param object the currentSociete to set
     */
    public static synchronized void setCurrentSociete(Societe object) {
            CurrentSessionInformations.currentSociete = object;
    }

   
}
