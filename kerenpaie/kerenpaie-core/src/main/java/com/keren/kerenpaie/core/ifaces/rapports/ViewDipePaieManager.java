
package com.keren.kerenpaie.core.ifaces.rapports;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.rapports.ViewDipePaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Apr 19 10:00:59 WAT 2018
 * 
 */
public interface ViewDipePaieManager
    extends GenericManager<ViewDipePaie, Long>
{

    public final static String SERVICE_NAME = "ViewDipePaieManager";
    
    public List<ViewDipePaie> getCriteres(ViewDipePaie critere);

}
