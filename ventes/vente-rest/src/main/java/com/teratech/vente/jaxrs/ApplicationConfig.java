/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.jaxrs;


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
        resources.add(com.teratech.vente.jaxrs.impl.banques.BanqueRSImpl.class); 
        resources.add(com.teratech.vente.jaxrs.impl.base.ArticleRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.CategorieProduitRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.CiviliteRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.ConditionPaiementRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.DeviseRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.EmplacementRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.EntrepotRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.FamilleArticleRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.LienEmplacementRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.PaysRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.RegionRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.SocieteRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.TierRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.UniteAchatRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.UniteGestionRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.base.UtilisateurRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.AcompteRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.CompteRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.EcheanceReglementRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.ExerciceComptableRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.JournalComptableRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.ModeReglementRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.comptabilite.TaxeRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.BonLivraisonRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.CommandeRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.DevisRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.FactureRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.LIgneRetourClientRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.LigneCommandeRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.LotRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.operations.RetourClientRSImpl.class);
        resources.add(com.teratech.vente.jaxrs.impl.others.SendDevisFormRSImpl.class);
    }
    
}
