
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ElementVariable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Mar 17 12:54:26 GMT+01:00 2018
 * 
 */
public interface ElementVariableManager
    extends GenericManager<ElementVariable, Long>
{

    public final static String SERVICE_NAME = "ElementVariableManager";
    
//    /**SALBASE
//     * Renvoie le salaire de base de l'employe
//     * @param salarie
//     * @return
//     */
//    public Double salaireBase(ElementVariable element); 
//    
//    /**ANCIEN
//     * Renvoie l'anciennité de l'employé
//     * @param salarie
//     * @return
//     */
//    public Double anciennite(ElementVariable element);
//    
//    /**SALCATEGO
//     * Salaire Catégoriel
//     * @param salarie
//     * @return
//     */
//    public Double salaireCategoriel(ElementVariable element);
//    
//    /**SBB
//     * Salaire de base brut
//     * @param salarie
//     * @return
//     */
//    public Double salaireBaseBrut(ElementVariable elemente);
//    
//    /**
//     * SALBRUTANNUEL
//     * Salaire de base Brut Annuel
//     * @param salaire
//     * @return
//     */
//    public Double salaireBrutAnnuel(ElementVariable element);
//    
//    /**
//     * SALCO
//     * Salaire cotisable
//     * @param salarie
//     * @return
//     */
//    public Double salaireCotisable(ElementVariable element);
//    
//    /**
//     * SALTAX
//     * Salaire Taxable
//     * @param element
//     * @return
//     */
//    public Double salairetaxable(ElementVariable element);
//
//    
//    /**
//     * NBREABSENCE
//     * Nombre d'heures d'absences sur la periodes
//     * @param element
//     * @return
//     */
//    public Double nbreHeuresAbsence(ElementVariable element);
//    
//    /**
//     * NBRECONGES
//     * Nombre d'heures de congés sur la période courante
//     * @param element
//     * @return
//     */
//    public Double nbreHeuresConges(ElementVariable element);
//    
//    /**
//     * NBREEFT21
//     * Nombres d'enfants de moins de 21 ans éligibles
//     * @param element
//     * @return
//     */
//    public Double nbreEnfants21(ElementVariable element);
//    
//    /**
//     * VEHICULE
//     * Indique si l'employé est véhiculé
//     * @param element
//     * @return
//     */
//    public Boolean vehicule(ElementVariable element);
//    
//    /**
//     * LOGEMENT
//     * Indemnité de logement de l'employé
//     * @param element
//     * @return
//     */
//    public Double logement(ElementVariable element);
//    
//    /**
//     * AGELEE
//     * Anciennité gélée de l'employé
//     * @param element
//     * @return
//     */
//    public Double ancienniteGelee(ElementVariable element);
//    
//    /**
//     * COMPLEMENT_SAL
//     * Complément de salaire d'un employé
//     * @param element
//     * @return
//     */
//    public Double complementSalaire(ElementVariable element);
//    
//    /**
//     * SYNDIQUE
//     * Taux de retenue Syndical
//     * @param element
//     * @return
//     */
//    public Double tauxSyndical(ElementVariable element);
//    
//    /**
//     * RETRAITE_CPLM
//     * Retraite complementaire employé
//     * @param element
//     * @return
//     */
//    public Double retraiteComplementaire(ElementVariable element);
//    
//    /**
//     * COMPLEMENT_LOG
//     * Complement  indemnité du logement
//     * @param element
//     * @return
//     */
//    public Double complementLogement(ElementVariable element);
//    
//    /**
//     * COEFF_ID_LOGE
//     * Coefficient indemnité de logement
//     * @param element
//     * @return
//     */
//    public Double coefIndemniteLogement(ElementVariable element);
//    
//    /**
//     * SALCONGESANNUEL
//     * Cumul des rubrique de salaire participant aux congés sur une année
//     * @param element
//     * @return
//     */
//    public Double cumulSalaireAnnuel(ElementVariable element);
}
