/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.kerenpaie.jaxrs;


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
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.BanqueRSImpl.class); 
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.CompteBancaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.CompteRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.ExerciceComptableRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.JournalComptableRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.PeriodePaieCloseRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.PeriodePaieOpenRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.PeriodePaieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.comptabilite.TaxeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.CategorieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.ContratTravailRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.DepartementSocRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.EchelonRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.EmployeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.FamilleRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.FonctionRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.PosteRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.employes.TypeContratRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.BrouillardSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.BulletinPaieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ConvensionRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ElementSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ElementVariableRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.IndiceSoldeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.LigneBulletinPaieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.LigneConvensionRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.LigneIndiceSoldeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.LignePonderationSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.LignePonderationTypeContratRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ParametreAvanceRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.PayerSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.PrepaSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ProfilPaieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.RubriqueRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.SoumettreSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.TraitSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.ValiderSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.paie.VariableRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.AcompteRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.AvanceSalaireRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.CategoriePretRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.DemandePretRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.LigneRappelRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.RappelRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.RemboursementAvanceRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.prets.RemboursementPretRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.rapports.ViewBulletinPaieRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.DepartementRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.DeviseRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.DiplomeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.GradeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.NiveauEtudeRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.PaysRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.RegionRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.SocieteRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.SpecialiteRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.SyndicatRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.TypeCaisseRSImpl.class);
        resources.add(com.keren.kerenpaie.jaxrs.impl.structures.TypeDemandeRSImpl.class);
        
    }
    
}
