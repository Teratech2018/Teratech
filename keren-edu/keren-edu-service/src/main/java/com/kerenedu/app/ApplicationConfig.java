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
import com.kerenedu.configuration.ClasseCycleRSImpl;
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
import com.kerenedu.configuration.ResponsabiliteRSImpl;
import com.kerenedu.configuration.SectionERSImpl;
import com.kerenedu.configuration.ServiceFilliereRSImpl;
import com.kerenedu.configuration.ServiceRSImpl;
import com.kerenedu.configuration.TypeDepenseRSImpl;
import com.kerenedu.configuration.UniteEnsRSImpl;
import com.kerenedu.configuration.UserEducationRSImpl;
import com.kerenedu.configuration.UtilisateurConnectRSImpl;
import com.kerenedu.dashboard.ViewDashboardRSImpl;
import com.kerenedu.discipline.AbscenceModalRSImpl;
import com.kerenedu.discipline.AbscenceRSImpl;
import com.kerenedu.discipline.LigneAbscenceRSImpl;
import com.kerenedu.discipline.PresenceRSImpl;
import com.kerenedu.discipline.TypeAbscenceRSImpl;
import com.kerenedu.discipline.ViewAbscenceRSImpl;
import com.kerenedu.inscription.ChangeClasseRSImpl;
import com.kerenedu.inscription.InscriptionChoiceRSImpl;
import com.kerenedu.inscription.InscriptionRSImpl;
import com.kerenedu.inscription.InscriptioncloneRSImpl;
import com.kerenedu.jaxrs.dashboard.PedagogieDashboardRSImpl;
import com.kerenedu.jaxrs.impl.report.EdtBulletinAnnModalRSImpl;
import com.kerenedu.jaxrs.impl.report.EdtBulletinModalRSImpl;
import com.kerenedu.jaxrs.impl.report.EdtBulletinTrimModalRSImpl;
import com.kerenedu.jaxrs.impl.report.EdtMasseSalModalRSImpl;
import com.kerenedu.jaxrs.impl.report.EdtPeriodeModalRSImpl;
import com.kerenedu.jaxrs.impl.report.EleveInscritSearchRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewAnniversaireModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewAnniversaireRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBadgeModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierEcoleModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierEcoleRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanFinancierRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanServiceEleveRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBilanServiceModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBulletinPaieHelperRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewCouponsInformationRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewDltPaiementModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewDltPaiementRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewEmargementRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewListeEleveModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewListeEleveRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewListingPModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewMatiereClasseModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewNoteClasseModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewNoteHelperRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewNotematiereRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewPaiementJournalierRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewRecapMoyenneModalRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewRetardPaiementRSImpl;
import com.kerenedu.notes.BulletinHelperGeneratePrimaireRSImpl;
import com.kerenedu.notes.BulletinRSImpl;
import com.kerenedu.notes.CloseExamenRSImpl;
import com.kerenedu.notes.CoefMatiereDetailRSImpl;
import com.kerenedu.notes.CoefMatiereModalRSImpl;
import com.kerenedu.notes.CoefMatiereRSImpl;
import com.kerenedu.notes.DltBulletinRSImpl;
import com.kerenedu.notes.ExamenRSImpl;
import com.kerenedu.notes.HelpProfClasseRSImpl;
import com.kerenedu.notes.ImportHeureProfRSImpl;
import com.kerenedu.notes.ImportNoteClasseFileRSImpl;
import com.kerenedu.notes.ImportNoteClasseRSImpl;
import com.kerenedu.notes.NoteDetailRSImpl;
import com.kerenedu.notes.NoteRSImpl;
import com.kerenedu.personnel.DiplomeRSImpl;
import com.kerenedu.personnel.EmargementDtlPeriodeRSImpl;
import com.kerenedu.personnel.EmargementPeriodeRSImpl;
import com.kerenedu.personnel.EmargementProfDetailsRSImpl;
import com.kerenedu.personnel.EmargementProfRSImpl;
import com.kerenedu.personnel.EnseignantPMRSImpl;
import com.kerenedu.personnel.EnseignantSecondaireRSImpl;
import com.kerenedu.personnel.JoursCoursRSImpl;
import com.kerenedu.personnel.MatiereCoutProfRSImpl;
import com.kerenedu.personnel.PlanifCoursRSImpl;
import com.kerenedu.personnel.ProfFichePaieRSImpl;
import com.kerenedu.personnel.ProfMatiereEnsRSImpl;
import com.kerenedu.personnel.ProfesseurChoiceRSImpl;
import com.kerenedu.personnel.ProfesseurRSImpl;
import com.kerenedu.personnel.ProfesseurcloneRSImpl;
import com.kerenedu.personnel.StatusProfRSImpl;
import com.kerenedu.personnel.TrancheHoraireCoursRSImpl;
import com.kerenedu.reglement.AvanceProfRSImpl;
import com.kerenedu.reglement.CaisseRSImpl;
import com.kerenedu.reglement.ConsultationEchRSImpl;
import com.kerenedu.reglement.ConsultationPaieRSImpl;
import com.kerenedu.reglement.DepenseRSImpl;
import com.kerenedu.reglement.EcheancierDltRSImpl;
import com.kerenedu.reglement.EcheancierRSImpl;
import com.kerenedu.reglement.FichePaiementOptionelRSImpl;
import com.kerenedu.reglement.FichePaiementProfRSImpl;
import com.kerenedu.reglement.FichePaiementRSImpl;
import com.kerenedu.reglement.FichePaiementRetardRSImpl;
import com.kerenedu.reglement.MoratoireRSImpl;
import com.kerenedu.reglement.PaiementProfRSImpl;
import com.kerenedu.reglement.PaiementRSImpl;
import com.kerenedu.reglement.PrimeProfRSImpl;
import com.kerenedu.reglement.RecetteRSImpl;
import com.kerenedu.reglement.ReglementProfRSImpl;
import com.kerenedu.reglement.ReglementRSImpl;
import com.kerenedu.reglement.RemiseRSImpl;
import com.kerenedu.reglement.RetardPaiementModalRSImpl;
import com.kerenedu.reglement.RetardRSImpl;
import com.kerenedu.reglement.RetenueProfRSImpl;
import com.kerenedu.reglement.SelectClasseRSImpl;
import com.kerenedu.reglement.TypeRemiseRSImpl;
import com.kerenedu.school.ContactsRSImpl;
import com.kerenedu.school.EleveRSImpl;
import com.kerenedu.school.NationaliteRSImpl;
import com.kerenedu.school.NiveauScolaireRSImpl;
import com.kerenedu.school.ProfessionRSImpl;
import com.kerenedu.school.ResponsableRSImpl;
import com.kerenedu.solde.AcompteRSImpl;
import com.kerenedu.solde.AvanceSalaireRSImpl;
import com.kerenedu.solde.BanqueRSImpl;
import com.kerenedu.solde.BulletinPaieRSImpl;
import com.kerenedu.solde.CategoriePretRSImpl;
import com.kerenedu.solde.CategorieRSImpl;
import com.kerenedu.solde.ConsulterSalaireRSImpl;
import com.kerenedu.solde.ConvensionRSImpl;
import com.kerenedu.solde.DemandePretRSImpl;
import com.kerenedu.solde.EchellonRSImpl;
import com.kerenedu.solde.ElementVariableRSImpl;
import com.kerenedu.solde.EltSalaireLigneRSImpl;
import com.kerenedu.solde.EltSalaireRSImpl;
import com.kerenedu.solde.FonctionRSImpl;
import com.kerenedu.solde.GrilleSalaireRSImpl;
import com.kerenedu.solde.LigneBulletinPaieRSImpl;
import com.kerenedu.solde.LigneConvensionRSImpl;
import com.kerenedu.solde.LigneElementVariableRSImpl;
import com.kerenedu.solde.LigneGrilleSalaireRSImpl;
import com.kerenedu.solde.LignePaieRSImpl;
import com.kerenedu.solde.LignePonderationSalaireRSImpl;
import com.kerenedu.solde.LignePonderationTypeContratRSImpl;
import com.kerenedu.solde.ParametreAvanceRSImpl;
import com.kerenedu.solde.PeriodePaieCloseRSImpl;
import com.kerenedu.solde.PeriodePaieOpenRSImpl;
import com.kerenedu.solde.PeriodePaieRSImpl;
import com.kerenedu.solde.PrepaSalaireRSImpl;
import com.kerenedu.solde.ProfilPaieRSImpl;
import com.kerenedu.solde.RappelSalaireRSImpl;
import com.kerenedu.solde.RemboursementAvanceRSImpl;
import com.kerenedu.solde.RemboursementPretRSImpl;
import com.kerenedu.solde.RubriquePaieRSImpl;
import com.kerenedu.solde.TraitSalaireRSImpl;
import com.kerenedu.solde.TypeContratRSImpl;
import com.kerenedu.solde.VariableRSImpl;
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
		resources.add(EdtBulletinModalRSImpl.class);
		resources.add(DepenseRSImpl.class);
		resources.add(ServiceFilliereRSImpl.class);
		resources.add(SectionERSImpl.class);
		resources.add(RemiseRSImpl.class);
		resources.add(TypeRemiseRSImpl.class);
		resources.add(HelpProfClasseRSImpl.class);
		resources.add(LigneAbscenceRSImpl.class);
		resources.add(CloseExamenRSImpl.class);
		resources.add(PedagogieDashboardRSImpl.class);
		resources.add(DltBulletinRSImpl.class);
		resources.add(ChangeClasseRSImpl.class);
		resources.add(ViewEmargementRSImpl.class);
		resources.add(ViewPaiementJournalierRSImpl.class);
		resources.add(InscriptioncloneRSImpl.class);
		resources.add(ViewBilanServiceEleveRSImpl.class);
		resources.add(ViewBilanServiceModalRSImpl.class);
		resources.add(ViewListeEleveModalRSImpl.class);
		resources.add(RecetteRSImpl.class);
		resources.add(FichePaiementOptionelRSImpl.class);
		resources.add(FichePaiementRetardRSImpl.class);
		resources.add(RetardPaiementModalRSImpl.class);
		resources.add(InscriptionChoiceRSImpl.class);
		resources.add(MoratoireRSImpl.class);
		resources.add(ProfFichePaieRSImpl.class);
		resources.add(ViewBadgeModalRSImpl.class);
		resources.add(BanqueRSImpl.class);
		resources.add(BulletinPaieRSImpl.class);
		resources.add(CategorieRSImpl.class);
		resources.add(EchellonRSImpl.class);
		resources.add(GrilleSalaireRSImpl.class);
		resources.add(LigneGrilleSalaireRSImpl.class);
		resources.add(LignePaieRSImpl.class);
		resources.add(ProfilPaieRSImpl.class);
		resources.add(PeriodePaieRSImpl.class);
		resources.add(RubriquePaieRSImpl.class);
		resources.add(EltSalaireRSImpl.class);
		resources.add(EltSalaireLigneRSImpl.class);
		resources.add(EleveInscritSearchRSImpl.class);
		resources.add(ClasseCycleRSImpl.class);
		resources.add(ViewCouponsInformationRSImpl.class);
		resources.add(ConvensionRSImpl.class);
		resources.add(LigneConvensionRSImpl.class);
		resources.add(VariableRSImpl.class);
		resources.add(FonctionRSImpl.class);
		resources.add(TypeContratRSImpl.class);
		resources.add(ParametreAvanceRSImpl.class);
		resources.add(LignePonderationSalaireRSImpl.class);
		resources.add(LignePonderationTypeContratRSImpl.class);
		resources.add(PeriodePaieOpenRSImpl.class);
		resources.add(PeriodePaieCloseRSImpl.class);
		resources.add(PrepaSalaireRSImpl.class);
		resources.add(TraitSalaireRSImpl.class);
		resources.add(LigneBulletinPaieRSImpl.class);
		resources.add(BulletinPaieRSImpl.class);
		resources.add(LigneElementVariableRSImpl.class);
		resources.add(AcompteRSImpl.class);
		resources.add(AvanceSalaireRSImpl.class);
		resources.add(CategoriePretRSImpl.class);
		resources.add(DemandePretRSImpl.class);
		resources.add(ElementVariableRSImpl.class);
		resources.add(RemboursementAvanceRSImpl.class);
		resources.add(RemboursementPretRSImpl.class);
		resources.add(RappelSalaireRSImpl.class);
		resources.add(ProfesseurcloneRSImpl.class);
		resources.add(UtilisateurConnectRSImpl.class);
		resources.add(ResponsabiliteRSImpl.class);
//		resources.add(ExamenPRSImpl.class);
//		resources.add(ExamenSRSImpl.class);
		resources.add(EnseignantPMRSImpl.class);
		resources.add(EnseignantSecondaireRSImpl.class);
		resources.add(ViewMatiereClasseModalRSImpl.class);
		resources.add(ViewNoteClasseModalRSImpl.class);
		resources.add(ViewRecapMoyenneModalRSImpl.class);
//		resources.add(ImportNoteRSImpl.class);
		resources.add(ViewAbscenceRSImpl.class);
		resources.add(ViewNotematiereRSImpl.class);
//		resources.add(ImportNoteModalRSImpl.class);
		resources.add(EdtBulletinAnnModalRSImpl.class);
		resources.add(EdtBulletinTrimModalRSImpl.class);
		resources.add(ImportNoteClasseRSImpl.class);
		resources.add(ImportNoteClasseFileRSImpl.class);
		resources.add(AbscenceModalRSImpl.class);
		resources.add(ProfesseurChoiceRSImpl.class);
		resources.add(EdtPeriodeModalRSImpl.class);
		resources.add(EdtMasseSalModalRSImpl.class);
		resources.add(ViewListingPModalRSImpl.class);
		resources.add(ConsulterSalaireRSImpl.class);
		resources.add(ViewBulletinPaieHelperRSImpl.class);
		resources.add(BulletinHelperGeneratePrimaireRSImpl.class);
		resources.add(EmargementPeriodeRSImpl.class);
		resources.add(EmargementDtlPeriodeRSImpl.class);
		resources.add(ImportHeureProfRSImpl.class);
		
		
		
		
		
		
		
    }
    
}

