
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 14:27:01 WAT 2018
 * 
 */
public interface PeriodePaieCloseManager
    extends GenericManager<PeriodePaieClose, Long>
{

    public final static String SERVICE_NAME = "PeriodePaieCloseManager";
    
    public void closeperiode(PeriodePaieClose entity);

}
