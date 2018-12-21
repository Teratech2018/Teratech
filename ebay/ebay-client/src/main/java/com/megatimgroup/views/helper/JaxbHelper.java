/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;


import com.megatimgroup.views.jaxb.ObjectFactory;
import com.megatimgroup.views.jaxb.Services;
import com.megatimgroup.views.jaxb.ServicesConfig;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Cette classe permet une manipulation facile de 
 * nos fichier XML
 * @author Commercial_2
 */
public class JaxbHelper {
    //"META-INF/mgt-esb.xml"
     public static Services getServices(String url) throws JAXBException{
         
         //Creation d'une instance du context
         JAXBContext context =  JAXBContext.newInstance(ObjectFactory.class);
         
         //Utilisation de context pour cree
         Unmarshaller unmarshaller = context.createUnmarshaller();
         
//         System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::   "+ClassLoader.getSystemResource("META-INF/mgt-esb.xml").getFile());
         //Utilisation de JaxB pour recuperer une instance de Services-config
         ServicesConfig servicesConfig = (ServicesConfig) unmarshaller.unmarshal(
                                                ClassLoader.getSystemResourceAsStream(url));
         //Recuperation instance de ServicesConfig
//         ServicesConfig servicesConfig = unmarshallObject.getValue();
         //Renvoyer le services
         return servicesConfig.getServices();
     }
     
     //"META-INF/mgt-esb.xml"
     public static Services getServices(InputStream stream) throws JAXBException{
         
         //Creation d'une instance du context
         JAXBContext context =  JAXBContext.newInstance(ObjectFactory.class);
         
         //Utilisation de context pour cree
         Unmarshaller unmarshaller = context.createUnmarshaller();
         
         System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::   "+stream);
         //Utilisation de JaxB pour recuperer une instance de Services-config
         ServicesConfig servicesConfig = (ServicesConfig) unmarshaller.unmarshal(stream);
         //Recuperation instance de ServicesConfig
//         ServicesConfig servicesConfig = unmarshallObject.getValue();
         //Renvoyer le services
         return servicesConfig.getServices();
     }
}
