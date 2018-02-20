/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.app;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.kerenedu.configuration.AnneScolaireRSImpl;
import com.kerenedu.configuration.ClasseRSImpl;
import com.kerenedu.configuration.ConfigMailRSImpl;
import com.kerenedu.configuration.EtablissementRSImpl;
import com.kerenedu.configuration.FiliereRSImpl;
import com.kerenedu.configuration.FraisScolaireRSImpl;
import com.kerenedu.configuration.GroupeCoursRSImpl;
import com.kerenedu.configuration.MatiereRSImpl;
import com.kerenedu.configuration.NiveauRSImpl;
import com.kerenedu.configuration.NoteMailRSImpl;
import com.kerenedu.configuration.NoteSMSRSImpl;
import com.kerenedu.configuration.PeriodeScolaireRSImpl;
import com.kerenedu.configuration.ReductionRSImpl;
import com.kerenedu.configuration.ServiceRSImpl;
import com.kerenedu.configuration.UniteEnsRSImpl;
import com.kerenedu.discipline.AbscenceRSImpl;
import com.kerenedu.discipline.TypeAbscenceRSImpl;
import com.kerenedu.inscription.InscriptionRSImpl;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.jaxrs.search.EleveSearchRSImpl;
import com.kerenedu.notes.BulletinRSImpl;
import com.kerenedu.notes.CoefMatiereDetailRSImpl;
import com.kerenedu.notes.CoefMatiereRSImpl;
import com.kerenedu.notes.ExamenRSImpl;
import com.kerenedu.notes.NoteDetailRSImpl;
import com.kerenedu.notes.NoteRSImpl;
import com.kerenedu.personnel.JoursCoursRSImpl;
import com.kerenedu.personnel.MatiereCoutProfRSImpl;
import com.kerenedu.personnel.PlanifCoursRSImpl;
import com.kerenedu.personnel.ProfMatiereEnsRSImpl;
import com.kerenedu.personnel.ProfesseurRSImpl;
import com.kerenedu.personnel.TrancheHoraireCoursRSImpl;
import com.kerenedu.reglement.CaisseRSImpl;
import com.kerenedu.reglement.ReglementRSImpl;
import com.kerenedu.school.ContactsRSImpl;
import com.kerenedu.school.EleveRSImpl;
import com.kerenedu.school.NationaliteRSImpl;
import com.kerenedu.school.NiveauScolaireRSImpl;
import com.kerenedu.school.ProfessionRSImpl;

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
    }
    
}
