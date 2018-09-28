/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.posweb;


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
        resources.add(com.keren.posweb.jaxrs.impl.ArticleRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.ClientRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.CommandeRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.CompteRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.FamilleArticleRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.LigneCommandeRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.PointVenteRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.PosSessionRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.PosWebDashboardRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.StructureRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.TaxeRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.UniteAchatRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.UniteGestionRSImpl.class);
        resources.add(com.keren.posweb.jaxrs.impl.UserRSImpl.class);
    }
    
}
