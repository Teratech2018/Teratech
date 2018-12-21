/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatim.common.services.IocContext;
import com.megatimgroup.core.ifaces.archivage.ArchiveOperationManager;
import com.megatimgroup.core.ifaces.echange.ViewOFManager;
import com.megatimgroup.core.ifaces.operations.DeclarationFinanciereManager;
import com.megatimgroup.core.ifaces.operations.DeclarationPMManager;
import com.megatimgroup.core.ifaces.operations.DeclarationPPManager;
import com.megatimgroup.core.ifaces.parametres.SocieteManager;
import com.megatimgroup.core.ifaces.referentiels.ClasseManager;
import com.megatimgroup.core.ifaces.referentiels.DeviseManager;
import com.megatimgroup.core.ifaces.referentiels.DivisionManager;
import com.megatimgroup.core.ifaces.referentiels.GroupeManager;
import com.megatimgroup.core.ifaces.referentiels.MotifManager;
import com.megatimgroup.core.ifaces.referentiels.NationaliteManager;
import com.megatimgroup.core.ifaces.referentiels.NatureClienteleManager;
import com.megatimgroup.core.ifaces.referentiels.NatureJuridiqueManager;
import com.megatimgroup.core.ifaces.referentiels.PaysManager;
import com.megatimgroup.core.ifaces.referentiels.PrecisionDateNaissanceManager;
import com.megatimgroup.core.ifaces.referentiels.QualiteManager;
import com.megatimgroup.core.ifaces.referentiels.SectionManager;
import com.megatimgroup.core.ifaces.referentiels.SensOperationManager;
import com.megatimgroup.core.ifaces.referentiels.StatusResidenceManager;
import com.megatimgroup.core.ifaces.referentiels.TitreManager;
import com.megatimgroup.core.ifaces.referentiels.TypeOperationManager;
import com.megatimgroup.core.ifaces.referentiels.VilleManager;
import com.megatimgroup.model.archivage.ArchiveOperation;
import com.megatimgroup.model.echange.ViewOperationFinanciere;
import com.megatimgroup.model.operations.DeclarationFinanciere;
import com.megatimgroup.model.operations.DeclarationPM;
import com.megatimgroup.model.operations.DeclarationPP;
import com.megatimgroup.model.parametres.Societe;
import com.megatimgroup.model.referentiels.Classe;
import com.megatimgroup.model.referentiels.Devise;
import com.megatimgroup.model.referentiels.Division;
import com.megatimgroup.model.referentiels.Groupe;
import com.megatimgroup.model.referentiels.Motif;
import com.megatimgroup.model.referentiels.Nationalite;
import com.megatimgroup.model.referentiels.NatureClientele;
import com.megatimgroup.model.referentiels.NatureJuridique;
import com.megatimgroup.model.referentiels.Pays;
import com.megatimgroup.model.referentiels.PrecisionDateNaissance;
import com.megatimgroup.model.referentiels.Qualite;
import com.megatimgroup.model.referentiels.Section;
import com.megatimgroup.model.referentiels.SensOperation;
import com.megatimgroup.model.referentiels.StatusResidence;
import com.megatimgroup.model.referentiels.Titre;
import com.megatimgroup.model.referentiels.TypeOperation;
import com.megatimgroup.model.referentiels.Ville;
import com.megatimgroup.model.reporting.BordereauBP;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEV_4
 */
public class ManagerHelper {

    /**
     *
     * @param clazz
     * @return
     */
    public static Map<GenericManager, String> getManager(Class<?> clazz) {

        IocContext context = new IocContext();

        Map<GenericManager, String> result = new HashMap<GenericManager, String>();

        try {
            if (clazz.equals(Ville.class)) {
                result.put((GenericManager) context.lookup(VilleManager.SERVICE_NAME), "code");
            } else if (clazz.equals(TypeOperation.class)) {
                result.put((GenericManager) context.lookup(TypeOperationManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Titre.class)) {
                result.put((GenericManager) context.lookup(TitreManager.SERVICE_NAME), "code");
            }else if (clazz.equals(StatusResidence.class)) {
                result.put((GenericManager) context.lookup(StatusResidenceManager.SERVICE_NAME), "code");
            }else if (clazz.equals(SensOperation.class)) {
                result.put((GenericManager) context.lookup(SensOperationManager.SERVICE_NAME), "code");
            } else if (clazz.equals(Section.class)) {
                result.put((GenericManager) context.lookup(SectionManager.SERVICE_NAME), "code");
            } else if (clazz.equals(Qualite.class)) {
                result.put((GenericManager) context.lookup(QualiteManager.SERVICE_NAME), "code");
            } else if (clazz.equals(PrecisionDateNaissance.class)) {
                result.put((GenericManager) context.lookup(PrecisionDateNaissanceManager.SERVICE_NAME), "code");
            } else if (clazz.equals(Pays.class)) {
                result.put((GenericManager) context.lookup(PaysManager.SERVICE_NAME), "code");
            } else if (clazz.equals(NatureJuridique.class)) {
                result.put((GenericManager) context.lookup(NatureJuridiqueManager.SERVICE_NAME), "code");
            } else if (clazz.equals(NatureClientele.class)) {
                result.put((GenericManager) context.lookup(NatureClienteleManager.SERVICE_NAME), "code");
            } else if (clazz.equals(Nationalite.class)) {
                result.put((GenericManager) context.lookup(NationaliteManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Motif.class)) {
                result.put((GenericManager) context.lookup(MotifManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Groupe.class)) {
                result.put((GenericManager) context.lookup(GroupeManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Division.class)) {
                result.put((GenericManager) context.lookup(DivisionManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Devise.class)) {
                result.put((GenericManager) context.lookup(DeviseManager.SERVICE_NAME), "code");
            }else if (clazz.equals(Classe.class)) {
                result.put((GenericManager) context.lookup(ClasseManager.SERVICE_NAME), "code");
            } else if (clazz.equals(ViewOperationFinanciere.class)) {
                result.put((GenericManager) context.lookup(ViewOFManager.SERVICE_NAME), "idOperation");
            } 
//            else if (clazz.equals(ViewPersonnePhysisque.class)) {
//                result.put((GenericManager) context.lookup(ViewPPManager.SERVICE_NAME), "code");
//            }
            return result;
        } catch (Exception ex) {
            Logger.getLogger(ManagerHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 
     * @return 
     */
//    public static Societe getSociete() {
//        try {
//            IocContext context = new IocContext();
//            GenericManager manager = (GenericManager) context.lookup(SocieteManager.SERVICE_NAME);
//            if (manager == null) {
//                return null;
//            }
//            List results = manager.findAll();
//            if (results != null && !results.isEmpty()) {
//                return (Societe) manager.findAll().get(0);
//            } else {
//                return null;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManagerHelper.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    
    /**
     *
     * @param clazz
     * @return
     */
    public static GenericManager getManager2(Class<?> clazz) {

         IocContext context = new IocContext();

        try {
            if (clazz.equals(Ville.class)) {
                return (GenericManager) context.lookup(VilleManager.SERVICE_NAME);
            } else if (clazz.equals(TypeOperation.class)) {
                return (GenericManager) context.lookup(TypeOperationManager.SERVICE_NAME);
            }else if (clazz.equals(Titre.class)) {
                return (GenericManager) context.lookup(TitreManager.SERVICE_NAME);
            }else if (clazz.equals(StatusResidence.class)) {
                return (GenericManager) context.lookup(StatusResidenceManager.SERVICE_NAME);
            }else if (clazz.equals(SensOperation.class)) {
                return (GenericManager) context.lookup(SensOperationManager.SERVICE_NAME);
            } else if (clazz.equals(Section.class)) {
                return (GenericManager) context.lookup(SectionManager.SERVICE_NAME);
            } else if (clazz.equals(Qualite.class)) {
                return (GenericManager) context.lookup(QualiteManager.SERVICE_NAME);
            } else if (clazz.equals(PrecisionDateNaissance.class)) {
                return (GenericManager) context.lookup(PrecisionDateNaissanceManager.SERVICE_NAME);
            } else if (clazz.equals(Pays.class)) {
                return (GenericManager) context.lookup(PaysManager.SERVICE_NAME);
            } else if (clazz.equals(NatureJuridique.class)) {
                return (GenericManager) context.lookup(NatureJuridiqueManager.SERVICE_NAME);
            } else if (clazz.equals(NatureClientele.class)) {
                return (GenericManager) context.lookup(NatureClienteleManager.SERVICE_NAME);
            } else if (clazz.equals(Nationalite.class)) {
                return (GenericManager) context.lookup(NationaliteManager.SERVICE_NAME);
            }else if (clazz.equals(Motif.class)) {
                return (GenericManager) context.lookup(MotifManager.SERVICE_NAME);
            }else if (clazz.equals(Groupe.class)) {
                return (GenericManager) context.lookup(GroupeManager.SERVICE_NAME);
            }else if (clazz.equals(Division.class)) {
                return (GenericManager) context.lookup(DivisionManager.SERVICE_NAME);
            }else if (clazz.equals(Devise.class)) {
                return (GenericManager) context.lookup(DeviseManager.SERVICE_NAME);
            }else if (clazz.equals(Classe.class)) {
                return (GenericManager) context.lookup(ClasseManager.SERVICE_NAME);
            }else if (clazz.equals(DeclarationPP.class)) {
                return (GenericManager) context.lookup(DeclarationPPManager.SERVICE_NAME);
            }else if (clazz.equals(DeclarationPM.class)) {
                return (GenericManager) context.lookup(DeclarationPMManager.SERVICE_NAME);
            }else if (clazz.equals(DeclarationFinanciere.class)) {
                return (GenericManager) context.lookup(DeclarationFinanciereManager.SERVICE_NAME);
            }else if (clazz.equals(BordereauBP.class)) {
                return (GenericManager) context.lookup(DeclarationFinanciereManager.SERVICE_NAME);
            }else if (clazz.equals(Societe.class)) {
                return (GenericManager) context.lookup(SocieteManager.SERVICE_NAME);
            }else if (clazz.equals(ViewOperationFinanciere.class)) {
                return (GenericManager) context.lookup(ViewOFManager.SERVICE_NAME);
            }else if (clazz.equals(ArchiveOperation.class)) {
                return (GenericManager) context.lookup(ArchiveOperationManager.SERVICE_NAME);
            }
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ManagerHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
