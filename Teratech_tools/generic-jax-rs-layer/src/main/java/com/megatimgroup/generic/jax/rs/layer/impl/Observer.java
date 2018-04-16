/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BEKO
 */
@XmlRootElement
public class Observer implements Serializable,Comparable<Observer>{
    
    private String observable;
    
    private Source source ;

    /**
     * 
     * @param observable
     * @param source 
     */
    public Observer(String observable, String source) {
        this.observable = observable;
        this.source = new Source(source);
    }

    /**
     * 
     * @param obser 
     */
     public Observer(Observer obser) {
        this.observable = obser.observable;
        this.source = obser.source;
    }
     
    public Observer() {
    }

    public String getObservable() {
        return observable;
    }

    public void setObservable(String observable) {
        this.observable = observable;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
    
    
    @Override
    public int compareTo(Observer o) {
        //To change body of generated methods, choose Tools | Templates.
        return observable.compareTo(o.observable);
    }
    
    /**
     * 
     */
    public class  Source implements Serializable{
       
        private String fieldname ;
        
        private String methodname ;
        
       

        /**
         * 
         * @param texte 
         */
        public Source(String texte) {
            String[] split = texte.split(":");
//            System.out.println(Observer.class.toString()+" ======== "+texte+" ::::: "+split[0]+" ====== "+split[1]);
            if("field".equals(split[0].trim())){
                fieldname = split[1];
            }else if("method".equals(split[0].trim())){
                methodname = split[1];
            }//end if(split[0].trim()=="field"){
//            value = split[1];
        }

        public String getFieldname() {
            return fieldname;
        }

        public void setFieldname(String fieldname) {
            this.fieldname = fieldname;
        }

        public String getMethodname() {
            return methodname;
        }

        public void setMethodname(String methodname) {
            this.methodname = methodname;
        }      
        
        
    }
    
}
