/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao;


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
        resources.add(com.teratech.gmao.jaxrs.impl.base.ArticleRSImpl.class); 
        resources.add(com.teratech.gmao.jaxrs.impl.base.CalendrierEquipementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CalendrierIntervenantRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CauseExceptionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CentreAnalytiqueRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CentreFraisRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CiviliteRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.ClasseRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CompteurRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.ContactRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.ContratRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.CriticiteRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.DeviseRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.DivisionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.EmplacementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.EntrepotRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.EntrepriseRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.EquipementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.FamilleArticleRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.IntervenantRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.LienEmplacementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.LotRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.MarqueRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.OrganeRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.PaysRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.QualificationRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.RegionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.RubriqueRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.SecteurRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.UniteAchatRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.base.UniteGestionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.budget.BudgetCentreRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.budget.BudgetDivisionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.budget.BudgetEquipementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.budget.LigneBudgetSaisieRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.ActiviteBTRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.ActiviteHBTRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.AffectationBonTravailRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.BonTravailRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.DemandeInterventionRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.DiagnosticRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.EtatEquipementRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.PrioriteRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.RemedeRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.SymptomeRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.curative.TraitementDIRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.preventif.GammeRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.preventif.MaintenancePreventiveRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.preventif.MiseAJourCompteurRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.preventif.TypePlanningRSImpl.class);
        resources.add(com.teratech.gmao.jaxrs.impl.projet.ProjetRSImpl.class);
    }
    
}
