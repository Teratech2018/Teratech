/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.smsgwsv.rest.impl;

import com.megatimgroup.smsgw.jaxrs.impl.referentiel.ClientRSImpl;
import com.megatimgroup.smsgw.jaxrs.impl.referentiel.OrderRSImpl;
import com.megatimgroup.smsgw.jaxrs.impl.referentiel.ProductRSImpl;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Commercial_2
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ClientRSImpl.class);
        resources.add(ProductRSImpl.class);
        resources.add(OrderRSImpl.class);
    }
    
}
