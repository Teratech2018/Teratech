/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatim.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author BEKO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Observer {
    
    /**
     * Champs observe
     * @return 
     */
    String observable() ;
    
    /**
     * Source de données
     * @return 
     */
    String source();
    /**
     * Liste des parametres pour la methode
     * Liste des champs donc le ID doit être injecte separe par des ,
     * @return 
     */
    String parameters() default "";
}
