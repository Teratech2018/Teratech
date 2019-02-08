
package com.kerenedu.personnel;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewAnneeModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 06 15:23:28 WAT 2018
 * 
 */
public interface EmargementDtlPeriodeManager
    extends GenericManager<EmargementDtlPeriode, Long>
{

    public final static String SERVICE_NAME = "EmargementDtlPeriodeManager";
    
    public List<EmargementDtlPeriode> getCriteres(ViewAnneeModal critere);

}
