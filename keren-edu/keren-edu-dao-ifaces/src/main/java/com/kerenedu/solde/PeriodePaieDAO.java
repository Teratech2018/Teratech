
package com.kerenedu.solde;

import java.util.Date;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Sep 10 15:39:10 WAT 2018
 * 
 */
public interface PeriodePaieDAO
    extends GenericDAO<PeriodePaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PeriodePaieDAO";
    
    public PeriodePaie getPeriodeFromDate(Date date);

}
