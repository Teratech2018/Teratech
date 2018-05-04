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
 * @author DEV_4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Predicate {
    
    Class<?> type() default String.class;
    
    String label() default "";
    
    String pattern() default "";
    
    int length() default -1;
    
    int min() default 0;
    
    int max() default -1;
    
    boolean unique() default false;
    
    boolean nullable() default true;
    
    boolean editable() default true ;
    
    boolean hide() default false;
    
    boolean updatable() default true;
    //Permet de savoir si on  doit verifer l'existance de l'entite en BD
    boolean entry() default false;
    
    boolean optional() default true;
    
    boolean group() default false ;
    
    String groupName() default "";
    
    String groupLabel() default "";
    
    String target() default "string";
    
    String values() default "";
    
    boolean search() default false;
    
    String searchfields() default "";
    
    short sequence() default 0 ;
    
    short colsequence() default 0;
    
    //Champs calculer
    boolean compute() default false;
    
    //Si true permet d'activer la construction de pied personalisé
    boolean customfooter() default false;
    
    /**
     * contient le regle pour masque un champs
     * @return 
     */
    String hidden() default "";
    
    /**
     * Marquer pour objet observe
     * @return 
     */
    boolean observable() default false;
    
    boolean edittable() default false;
    
    /**
     * Indique si un champs est gélé ou pas
     * @return 
     */
    String frozen() default "";
}
