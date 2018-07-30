/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.jaxrs.base;


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
        resources.add(com.keren.courrier.jaxrs.impl.courrier.BorderoCourrierRRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.BorderoCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierAAnnoteRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierAClasserRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierAQuoteRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierARelancerRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierCloneRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierDepartRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierInterneRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.CourrierRecuRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.LigneBorderoCourrierRRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.LigneBorderoCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.courrier.TraitementCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.dashbord.CorbeilleRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.dashbord.CourrierDashboardRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.others.UtilisateurCloneRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.CiviliteRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.ClasseurCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.CompanyRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.CompartimentClasseurRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.ContactRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.CorrespondantRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.DossierCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.GroupeUtilisateurRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.NatureCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.PrioriteRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.StatutRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.StructureCompanyRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.TypeCorrespondantRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.TypeCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.TypeDossierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.UserRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.referentiel.UtilisateurCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.traitement.AnnotationActionRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.traitement.ClassementActionRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.traitement.QuotationActionRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.workflow.ActionCourrierRSImpl.class);
        resources.add(com.keren.courrier.jaxrs.impl.workflow.WorkflowActionRSImpl.class);
    }
    
}
