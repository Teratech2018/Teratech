
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.notes.MatiereNote;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 06 15:23:28 WAT 2018
 * 
 */
public interface EmargementPeriodeManager
    extends GenericManager<EmargementPeriode, Long>
{

    public final static String SERVICE_NAME = "EmargementPeriodeManager";
    public void importNote(EmargementPeriode entity);

}
