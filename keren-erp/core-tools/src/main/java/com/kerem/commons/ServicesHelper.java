/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerem.commons;

import com.kerem.core.FileHelper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BEKO
 */
public class ServicesHelper {
    
    private static final String _CONNECTIONFACTORY = "java:/ConnectionFactory";
    
    private static final String _DESTINATION = "java:/kerencore/coremdb";
    
    /**
     * 
     * @param servicename
     * @return true if service exist false else
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    public static Boolean exists(String servicename) throws NamingException, SQLException{
        String builder = "SELECT COUNT(c) FROM ServiceRegistry c WHERE c.code = '"+servicename+"'";
        Context ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:/KEREN");
        Connection connect = ds.getConnection();
        PreparedStatement stat = connect.prepareCall(builder);
        ResultSet result = stat.executeQuery();
        int nbre = 0 ;
        result.next();
        nbre = result.getInt(1);
        return nbre>0;
    }
    
    /**
     * Publication d'un nouveau service
     * @param service 
     * @throws javax.jms.JMSException 
     * @throws javax.naming.NamingException 
     */
   public static void publish(ServiceRegistry service) throws  Exception{
      if(exists(service.getCode())){
          throw  new Exception("service.registrty.code.allready.user");
      }//end if(exists(service.getCode())){
       KerenCoreMDBHelper.serviceMessageProducer(service);
   }
   /**
    * Deinscription d'un service
    * @param service
    * @throws NamingException
    * @throws SQLException
    * @throws JMSException 
    */
   public static void unpublish(ServiceRegistry service) throws NamingException, SQLException, JMSException{
       if(exists(service.getCode())){
           KerenCoreMDBHelper.serviceMessageProducer(service);
      }//end if(exists(service.getCode())){
   }
   
   public static ServiceRegistry getService(String servicename) throws NamingException, SQLException{
        String builder = "SELECT c FROM ServiceRegistry c WHERE c.code = '"+servicename+"'";
        Context ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:/KEREN");
        Connection connect = ds.getConnection();
        PreparedStatement stat = connect.prepareCall(builder);
        ResultSet result = stat.executeQuery();
        result.next();
        com.core.application.ServiceRegistry service = result.getObject(1, com.core.application.ServiceRegistry.class);
        return new ServiceRegistry(service.getCode(), service.getName(), service.getModele(), service.getEntity());
   }
   /**
    * Process the message to the correct service
     * Process the message 
     * @param message 
     */
    public static void process(Message message) throws Exception{
        Properties config = FileHelper.getConfiguration();
        String host="localhost";
        String port = "8080";
        String protocol ="http";
        if(config.containsKey("host-name")){
            host = config.getProperty("host-name");
        }//end if(config.containsKey("hostname")){
        if(config.contains("port-value")){
            port = config.getProperty("port-value");
        }//end if(config.contains("portvalue")){
        if(config.containsKey("http-protocol")){
            protocol = config.getProperty("http-protocol");
        }//end if(config.containsKey("http-protocol")){
        String url = protocol+"://"+host+":"+port+"/"+message.getService().getModele()+"/"+message.getService().getEntity()+"/"+message.getService().getName();
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, message);
        if(response.getStatus()!=200){//Error
            throw new Exception(response.toString());
        }
    }
            
/**
 * 
 */
public static class ServiceRegistry  implements Serializable{

    private String code ;
    
    private String name;
    
    private String modele ;
    
    private String entity;

    public ServiceRegistry() {
    }

    /**
     * 
     * @param code
     * @param name
     * @param modele
     * @param entity 
     */
    public ServiceRegistry(String code, String name, String modele, String entity) {
        this.code = code;
        this.name = name;
        this.modele = modele;
        this.entity = entity;
    }
    
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    
}

    
    /**
     * Message process by the service
     */
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Message implements Serializable{
        private ServiceRegistry service ;

        private Map<String,String> data ;

        /**
         * 
         */
        public Message() {
            data = new HashMap<String, String>();
        }

        /**
         * 
         * @param service
         * @param data 
         */
        public Message(ServiceRegistry service, Map<String, String> data) {
            this.service = service;
            this.data = data;
        }
        
        

        public Map<String, String> getData() {
            return data;
        }

        public void setData(Map<String, String> data) {
            this.data = data;
        }
        
        
        
        public ServiceRegistry getService() {
            return service;
        }

        public void setService(ServiceRegistry service) {
            this.service = service;
        }
        
        
    }
    
   
}
