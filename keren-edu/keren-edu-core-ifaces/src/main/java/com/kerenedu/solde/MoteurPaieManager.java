
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.personnel.Professeur;


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
    public Double eval(RubriquePaie rubrique,Professeur salarie,PeriodePaie periode,Etablissement structure);
    
  
    
   
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
    
   
}
