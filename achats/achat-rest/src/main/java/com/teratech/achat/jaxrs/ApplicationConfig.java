/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.jaxrs;


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
        resources.add(com.teratech.achat.jaxrs.impl.banques.BanqueRSImpl.class); 
        resources.add(com.teratech.achat.jaxrs.impl.base.ArticleRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.CategorieProduitRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.CiviliteRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.ConditionPaiementRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.DeviseRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.EmplacementRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.EntrepotRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.FamilleArticleRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.PaysRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.RegionRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.SocieteRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.TierRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.UniteAchatRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.UniteGestionRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.base.UtilisateurRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.CompteRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.ExerciceComptableRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.JournalComptableRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.comptabilite.TaxeRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.AppelOffreRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.BonCommandeRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.BonReceptionRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.CMDEFactureTMPRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.DemandePrixRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.DocumentAchatRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.EntreeRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.ExprBesionRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.FactureRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.LigneDocumentAchatRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.LigneDocumentStockRSImpl.class);
        resources.add(com.teratech.achat.jaxrs.impl.operations.LotRSImpl.class);
    }
    
}
