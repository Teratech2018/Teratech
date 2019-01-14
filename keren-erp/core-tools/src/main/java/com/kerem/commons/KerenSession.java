/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.commons;

import com.core.securites.Utilisateur;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.HashMap;
import java.util.Map;

/**
 *Keren Memory data
 * @author BEKO
 */
public class KerenSession {
    
    private static Utilisateur currentUser ;
    
    private static Map<String,String> traductMap = new HashMap<String,String>();

    /**
     * 
     */
    private KerenSession() {
    }

    
    
    /**
     * 
     * @return 
     */
    public static Utilisateur getCurrentUser() {
        return currentUser;
    }

    /**
     * 
     * @param currentUser 
     */
    public static void setCurrentUser(Utilisateur currentUser) {
        KerenSession.currentUser = currentUser;
    }

    /**
     * 
     * @param traductMap 
     */
    public static void setTraductMap(Map<String, String> traductMap) {
        KerenSession.traductMap = traductMap;
//        System.out.println(KerenSession.class.toString()+" ==================================== "+traductMap);
    }
    
    /**
     * Ajoute une entre dans la correspondance
     * @param key
     * @param value 
     */
    public static void addEntry(String key , String value){
        KerenSession.traductMap.put(key, value);
    }
   
    /**
     * Retourne la traduction correspondante
     * @param key
     * @return 
     */
    public static String getEntry(String key){
        return key ; //KerenSession.traductMap.get(key);
    }
    
    /**
     * 
     * @param key
     * @return 
     */
    public static Boolean containKey(String key){
        return KerenSession.traductMap.containsKey(key);
    }

    public static Map<String, String> getTraductMap() {
//        newInstance();
        return traductMap;
    }
    
    /**
     * 
     */
    private static  void newInstance(){
        if(traductMap==null || traductMap.isEmpty()){
            Client client = Client.create();
            WebResource webResource = client.resource("http://localhost/kerencore/terme/traduction");
            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);
            String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
        }//end if(traductMap==null){
    }
}
