
package com.keren.kerenpaie.core.ifaces.paie;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.keren.kerenpaie.model.paie.Variable;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface MoteurPaieManager
    extends GenericManager<BulletinPaie, Long>
{

    public final static String SERVICE_NAME = "BulletinPaieManager";
    
    /**
     * Evalution d'une rudrique de paie
     * @param rubrique
     * @param salarie
     * @return
     */
    public Double eval(Rubrique rubrique,Employe salarie,PeriodePaie periode,ContratTravail contrat);
    
    /**
     * Evaluation d'une variable de paie
     * @param variable
     * @param salarie
     * @return
     */
    public Double eval(Variable variable,Employe salarie,PeriodePaie periode,ContratTravail contrat);
    
   
    /**
     * Evaluation d'un bulletin
     * @param bulletin
     * @return
     */
    public BulletinPaie eval(BulletinPaie bulletin);
    
    /**
     * Fonction responsable de la preparation de la solde 
     * @param prepa
     * @return
     */
    public PrepaSalaire preparerPaie(PrepaSalaire prepa);
    
    /**
     * Responsable de la validation des salaires
     * @param entity
     * @return
     */
    public ValiderSalaire validerSalaire(ValiderSalaire entity);

}
