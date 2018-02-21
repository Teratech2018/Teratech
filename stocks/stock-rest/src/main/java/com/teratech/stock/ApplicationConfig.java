/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock;


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
        resources.add(com.teratech.stock.jaxrs.impl.banques.BanqueRSImpl.class); 
        resources.add(com.teratech.stock.jaxrs.impl.banques.CompteBancaireRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.ArticleRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.CategorieProduitRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.CiviliteRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.ContactRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.DeviseRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.EmplacementRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.EntrepotRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.FamilleArticleRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.PaysRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.RegionRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.SocieteRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.TierRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.UniteAchatRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.base.UniteGestionRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.CompteRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.JournalComptableRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.comptabilite.TaxeRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.invetaire.BaseInventaireRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.invetaire.FicheInventaireRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.invetaire.LigneInventaireRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.invetaire.RegulInventaireRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.DocumentStockRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.EntreeRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.LigneDocumentStockRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.LotRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.SortieRSImpl.class);
        resources.add(com.teratech.stock.jaxrs.impl.operations.TransfertRSImpl.class);
    }
    
}
