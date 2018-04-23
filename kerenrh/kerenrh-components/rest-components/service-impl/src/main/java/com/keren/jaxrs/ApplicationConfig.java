/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.jaxrs;

import com.keren.jaxrs.impl.comptabilite.BanqueRSImpl;
import com.keren.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl;
import com.keren.jaxrs.impl.comptabilite.CompteBancaireRSImpl;
import com.keren.jaxrs.impl.comptabilite.CompteRSImpl;
import com.keren.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl;
import com.keren.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl;
import com.keren.jaxrs.impl.comptabilite.TaxeRSImpl;
import com.keren.jaxrs.impl.conges.DemandeCongeCRSImpl;
import com.keren.jaxrs.impl.conges.DemandeCongeRSImpl;
import com.keren.jaxrs.impl.employes.CategorieRSImpl;
import com.keren.jaxrs.impl.employes.DepartementSocRSImpl;
import com.keren.jaxrs.impl.employes.EchelonRSImpl;
import com.keren.jaxrs.impl.employes.EmployeRSImpl;
import com.keren.jaxrs.impl.employes.FamilleRSImpl;
import com.keren.jaxrs.impl.employes.FonctionRSImpl;
import com.keren.jaxrs.impl.employes.PosteRSImpl;
import com.keren.jaxrs.impl.employes.TypeContratRSImpl;
import com.keren.jaxrs.impl.structures.DepartementRSImpl;
import com.keren.jaxrs.impl.structures.DiplomeRSImpl;
import com.keren.jaxrs.impl.structures.NiveauEtudeRSImpl;
import com.keren.jaxrs.impl.structures.PaysRSImpl;
import com.keren.jaxrs.impl.structures.RegionRSImpl;
import com.keren.jaxrs.impl.structures.SpecialiteRSImpl;
import com.keren.jaxrs.impl.structures.TypeDemandeRSImpl;

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
        resources.add(com.keren.jaxrs.impl.carrieres.AffectationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.AvancementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.BonificationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.CessationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.NominationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.ReclassementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.carrieres.RetrogradationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.BanqueRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.CompteAnalytiqueRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.CompteBancaireRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.CompteRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.NiveauAnalyseRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.SectionAnalytiqueRSImpl.class);
        resources.add(com.keren.jaxrs.impl.comptabilite.TaxeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.DemandeCongeCRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.DemandeCongeRRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.DemandeCongeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.DemandeCongeVRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.InterruptionCongeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.RepriseServiceRSImpl.class);
        resources.add(com.keren.jaxrs.impl.conges.TypeCongeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.ConvocationConseilRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.DemandeExplicationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.LigneResolutionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.MembreConseilRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.ReponseDERSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.ResolutionConseilRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.SanctionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.discipline.TraitementDERSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.CategorieRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.DepartementSocRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.EchelonRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.EmployeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.FamilleRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.FonctionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.PosteRSImpl.class);
        resources.add(com.keren.jaxrs.impl.employes.TypeContratRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.BesionFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.CategorieModuleRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.DemandeFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.FormateurRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.FormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.GenererBesionFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.LigneBesionFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.LignePlanningFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.LigneThemeFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.ModuleFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.ParticipantSeanceRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.PlanningFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.SeanceFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.formations.ThemeFormationRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.ActionMissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.CategorieFraisRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.CategorieMissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.DeploiementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.EscaleRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.FraisMissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.GrilleFraisRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.IndicateurPerformanceRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.MissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.OrdreMissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.missions.ResultatMissionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.AbsenceRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.FichePointageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.LigneFichePointageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.LignePointageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.PointageJouranlierRSImpl.class);
        resources.add(com.keren.jaxrs.impl.presences.RetardRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.AffectationCandidatRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.BesionRecrutementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.CandidatureSpontaneRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.ContratTravailRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.DetailRecrutementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.EmploiRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.EtapeRecrutementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.ExperienceCandidatRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.FormationCandidatRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.LangueCandidatRSImpl.class);
        resources.add(com.keren.jaxrs.impl.recrutement.RecrutementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.BesionStageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.EvaluationStageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.LivrableStageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.StageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.SuiviStageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.stages.TacheStageRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.DepartementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.DeviseRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.DiplomeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.EtablissementRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.NiveauEtudeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.PaysRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.RegionRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.SocieteRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.SpecialiteRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.TypeDemandeRSImpl.class);
        resources.add(com.keren.jaxrs.impl.structures.VilleRSImpl.class);
    }
    
}
