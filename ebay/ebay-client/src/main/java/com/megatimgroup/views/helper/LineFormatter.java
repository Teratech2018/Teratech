/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Commercial_2
 */
public  class LineFormatter {    
   
    //Separateur des champs
    private char separator =';';
    
    private char quote = '"';
    
    private char endline='\n';

    //private char emptychar='';
    
    /**
     * 
     */
    public LineFormatter() {
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public char getQuote() {
        return quote;
    }

    public void setQuote(char quote) {
        this.quote = quote;
    }

    public char getEndline() {
        return endline;
    }

    public void setEndline(char endline) {
        this.endline = endline;
    }

    
    
    
    
    /**
     * Formate une liste de chaînes de caracteres
     * @param valeurs
     * @return 
     */
    public String format(String ... valeurs){
        
        //Declaration du builder
        StringBuilder builder = new StringBuilder();
        
         builder.append(quote).append(value(valeurs[0])).append(quote);
        
        for(int index = 1 ; index<valeurs.length;index++){
             String value = value(valeurs[index]);
            if(!value.trim().isEmpty()) {
                builder.append(separator).append(quote).append(value(valeurs[index])).append(quote);
            }else{
                builder.append(separator).append(value);
            }
                    
        }
        //builder.append(endline);
        
        return builder.toString();
    }
    
    /**
     * 
     * @param value
     * @return 
     */
    private String value(String value){
        
        StringBuilder builder = new StringBuilder();
        //System.out.println("LineFormatter.value(String value) =================================== "+value);
        if(value==null||value.trim().isEmpty()||value.trim().equalsIgnoreCase("null")){
            builder.append("");
        }else{
            builder.append(value.trim());
        }
        return builder.toString();
    }
    
    /**
     * 
     * @param line
     * @param separators
     * @return 
     */
    public String[] splitter(String line , char ... separators ){
        
        String[] blocs = null ;
        
        for(char sep : separators){            
           
            blocs = line.split(""+sep);
//            System.out.println();
//            for(String b : blocs){
//                System.out.println(b+"  "+"=== "+sep);
//            }
//             System.out.println();
            //List<String> values = Arrays.asList(blocs);
//            System.out.println(LineFormatter.class.getSimpleName()+".splitter(String line , char ... separators) ::::::: :::::::  "+line+" ::: "+blocs.length+" :::: "+sep);
            if(blocs!=null&&blocs.length>1){
                
                int index = 0 ;
                for(String b : blocs){
                    blocs[index] = b.replace('"', ' ').trim();
                    index = index + 1 ;
                }
                return blocs;
            }
        } 
        return blocs;
    }
    
}
