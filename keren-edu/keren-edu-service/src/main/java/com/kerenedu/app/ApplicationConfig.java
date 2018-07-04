/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.app;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.kerenedu.configuration.AnneScolaireModalRSImpl;
import com.kerenedu.configuration.AnneScolaireRSImpl;
import com.kerenedu.configuration.AppreciationRSImpl;
import com.kerenedu.configuration.ClasseRSImpl;
import com.kerenedu.configuration.ConfigMailRSImpl;
import com.kerenedu.configuration.CycleRSImpl;
import com.kerenedu.configuration.EtablissementRSImpl;
import com.kerenedu.configuration.EventEduRSImpl;
import com.kerenedu.configuration.FiliereRSImpl;
import com.kerenedu.configuration.FraisScolaireRSImpl;
import com.kerenedu.configuration.GroupeCoursRSImpl;
import com.kerenedu.configuration.MatiereDltRSImpl;
import com.kerenedu.configuration.MatiereRSImpl;
import com.kerenedu.configuration.NiveauRSImpl;
import com.kerenedu.configuration.NoteMailRSImpl;
import com.kerenedu.configuration.NoteSMSRSImpl;
import com.kerenedu.configuration.PeriodeScolaireRSImpl;
import com.kerenedu.configuration.RappelERSImpl;
import com.kerenedu.configuration.ReductionRSImpl;
import com.kerenedu.configuration.ServiceRSImpl;
import com.kerenedu.configuration.TypeDepenseRSImpl;
import com.kerenedu.configuration.UniteEnsRSImpl;
import com.kerenedu.configuration.UserEducationRSImpl;
import com.kerenedu.dashboard.ViewDashboardRSImpl;
import com.kerenedu.discipline.AbscenceRSImpl;
import com.kerenedu.discipline.PresenceRSImpl;
import com.kerenedu.discipline.TypeAbscenceRSImpl;
import com.kerenedu.inscription.InscriptionRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewAnniversaireModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewAnniversaireRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierEcoleModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierEcoleRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewDltPaiementModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewDltPaiementRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewListeEleveRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewNoteHelperRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewRetardPaiementRSImpl;
import com.kerenedu.notes.BulletinRSImpl;
import com.kerenedu.notes.CoefMatiereDetailRSImpl;
import com.kerenedu.notes.CoefMatiereModalRSImpl;
import com.kerenedu.notes.CoefMatiereRSImpl;
import com.kerenedu.notes.ExamenRSImpl;
import com.kerenedu.notes.NoteDetailRSImpl;
import com.kerenedu.notes.NoteRSImpl;
import com.kerenedu.personnel.DiplomeRSImpl;
import com.kerenedu.personnel.EmargementProfDetailsRSImpl;
import com.kerenedu.personnel.EmargementProfRSImpl;
import com.kerenedu.personnel.JoursCoursRSImpl;
import com.kerenedu.personnel.MatiereCoutProfRSImpl;
import com.kerenedu.personnel.PlanifCoursRSImpl;
import com.kerenedu.personnel.ProfMatiereEnsRSImpl;
import com.kerenedu.personnel.ProfesseurRSImpl;
import com.kerenedu.personnel.StatusProfRSImpl;
import com.kerenedu.personnel.TrancheHoraireCoursRSImpl;
import com.kerenedu.reglement.AvanceProfRSImpl;
import com.kerenedu.reglement.CaisseRSImpl;
import com.kerenedu.reglement.ConsultationEchRSImpl;
import com.kerenedu.reglement.ConsultationPaieRSImpl;
import com.kerenedu.reglement.EcheancierDltRSImpl;
import com.kerenedu.reglement.EcheancierRSImpl;
import com.kerenedu.reglement.FichePaiementProfRSImpl;
import com.kerenedu.reglement.FichePaiementRSImpl;
import com.kerenedu.reglement.PaiementProfRSImpl;
import com.kerenedu.reglement.PaiementRSImpl;
import com.kerenedu.reglement.PrimeProfRSImpl;
import com.kerenedu.reglement.ReglementProfRSImpl;
import com.kerenedu.reglement.ReglementRSImpl;
import com.kerenedu.reglement.RetardRSImpl;
import com.kerenedu.reglement.RetenueProfRSImpl;
import com.kerenedu.reglement.SelectClasseRSImpl;
import com.kerenedu.school.ContactsRSImpl;
import com.kerenedu.school.EleveRSImpl;
import com.kerenedu.school.NationaliteRSImpl;
import com.kerenedu.school.NiveauScolaireRSImpl;
import com.kerenedu.school.ProfessionRSImpl;
import com.kerenedu.school.ResponsableRSImpl;
import com.kerenedu.stages.BesionStageRSImpl;
import com.kerenedu.stages.BesionStageVRSImpl;
import com.kerenedu.stages.DivisionStageRSImpl;
import com.kerenedu.stages.EvaluationStageRSImpl;
import com.kerenedu.stages.LieuStageRSImpl;
import com.kerenedu.stages.StageCLRSImpl;
import com.kerenedu.stages.StageERSImpl;
import com.kerenedu.stages.StageRSImpl;
import com.kerenedu.stages.SuiviStageEleveRSImpl;
import com.kerenedu.stages.SuiviStageRSImpl;
import com.kerenedu.stages.TacheStageRSImpl;

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
        resources.add(NationaliteRSImpl.class);
        resources.add(ProfessionRSImpl.class);
        resources.add(NiveauScolaireRSImpl.class);
        resources.add(ContactsRSImpl.class); 
        resources.add(EleveRSImpl.class);
        resources.add(AnneScolaireRSImpl.class);
        resources.add(PeriodeScolaireRSImpl.class); 
        resources.add(ServiceRSImpl.class); 
        resources.add(ReductionRSImpl.class);
        resources.add(FiliereRSImpl.class);
        resources.add(EtablissementRSImpl.class);
        resources.add(InscriptionRSImpl.class); 
        resources.add(ClasseRSImpl.class);
        resources.add(NiveauRSImpl.class); 
        resources.add(FraisScolaireRSImpl.class); 
        resources.add(ReglementRSImpl.class);
        resources.add(com.kerenedu.jaxrs.search.EleveSearchRSImpl.class); 
        resources.add(CaisseRSImpl.class); 
        resources.add(MatiereRSImpl.class);
        resources.add(ProfesseurRSImpl.class);
        resources.add(ProfMatiereEnsRSImpl.class);
        resources.add(MatiereCoutProfRSImpl.class);
        resources.add(JoursCoursRSImpl.class);
        resources.add(TrancheHoraireCoursRSImpl.class);
        resources.add(PlanifCoursRSImpl.class);
        resources.add(TypeAbscenceRSImpl.class);
        resources.add(AbscenceRSImpl.class);
        resources.add(com.kerenedu.jaxrs.dashboard.EducationDashboardRSImpl.class);
        resources.add(NoteSMSRSImpl.class);
        resources.add(NoteMailRSImpl.class);
        resources.add(ConfigMailRSImpl.class);
        resources.add(CoefMatiereRSImpl.class);
        resources.add(GroupeCoursRSImpl.class);
        resources.add(UniteEnsRSImpl.class);
        resources.add(CoefMatiereDetailRSImpl.class);
        resources.add(ExamenRSImpl.class);
        resources.add(NoteRSImpl.class);
        resources.add(NoteDetailRSImpl.class);
        resources.add(BulletinRSImpl.class);
        resources.add(ViewBulletinRSImpl.class);
        resources.add(EmargementProfDetailsRSImpl.class);
        resources.add(EmargementProfRSImpl.class);
        resources.add(PresenceRSImpl.class);
        resources.add(AppreciationRSImpl.class);
        resources.add(DiplomeRSImpl.class);
        resources.add(StatusProfRSImpl.class);
        resources.add(EcheancierRSImpl.class);
        resources.add(RetardRSImpl.class);
        resources.add(PaiementRSImpl.class);
        resources.add(FichePaiementRSImpl.class);
        resources.add(EcheancierDltRSImpl.class);
        resources.add(ReglementRSImpl.class);
        resources.add(ReglementProfRSImpl.class);
        resources.add(RetenueProfRSImpl.class);
        resources.add(AvanceProfRSImpl.class);
        resources.add(PrimeProfRSImpl.class);
        resources.add(FichePaiementProfRSImpl.class);
        resources.add(PaiementProfRSImpl.class);
        resources.add(LieuStageRSImpl.class);
        resources.add(BesionStageRSImpl.class);
        resources.add(BesionStageVRSImpl.class);
        resources.add(StageRSImpl.class);
        resources.add(StageERSImpl.class);
        resources.add(StageCLRSImpl.class);
        resources.add(DivisionStageRSImpl.class);
        resources.add(SuiviStageEleveRSImpl.class);
        resources.add(SuiviStageRSImpl.class);
        resources.add(TacheStageRSImpl.class);
        resources.add(EvaluationStageRSImpl.class);
        resources.add(com.kerenedu.notes.TraitNoteRSImpl.class);
		resources.add(com.kerenedu.notes.MatiereNoteRSImpl.class);
		resources.add(com.kerenedu.notes.NoteDetailRSImpl.class);
		resources.add(com.kerenedu.notes.ModelBulletinRSImpl.class);
		resources.add(com.kerenedu.notes.EdtBulletinRSImpl.class);
		resources.add(com.kerenedu.notes.BulletinHelperGenerateRSImpl.class);
		resources.add(com.kerenedu.configuration.NoteSMSSelectRSImpl.class);
		resources.add(SelectClasseRSImpl.class);
		resources.add(ConsultationEchRSImpl.class);
		resources.add(ConsultationPaieRSImpl.class);
		resources.add(CycleRSImpl.class);
		resources.add(ResponsableRSImpl.class);
		resources.add(TypeDepenseRSImpl.class);
		resources.add(ViewAnniversaireRSImpl.class);
		resources.add(ViewListeEleveRSImpl.class);
		resources.add(ViewBilanFinancierRSImpl.class);
		resources.add(ViewRetardPaiementRSImpl.class);
		resources.add(ViewDltPaiementRSImpl.class);
		resources.add(ViewBilanFinancierEcoleRSImpl.class);
		resources.add(ViewAnniversaireModalRSImpl.class);
		resources.add(ViewBilanFinancierEcoleModalRSImpl.class);
		resources.add(AnneScolaireModalRSImpl.class);
		resources.add(ViewBilanFinancierModalRSImpl.class);
		resources.add(ViewDltPaiementModalRSImpl.class);
		resources.add(ViewDashboardRSImpl.class);
		resources.add(EventEduRSImpl.class);
		resources.add(UserEducationRSImpl.class);
		resources.add(RappelERSImpl.class);
		resources.add(MatiereDltRSImpl.class);
		resources.add(CoefMatiereModalRSImpl.class);
		resources.add(ViewNoteHelperRSImpl.class);
		
    }
    
}

