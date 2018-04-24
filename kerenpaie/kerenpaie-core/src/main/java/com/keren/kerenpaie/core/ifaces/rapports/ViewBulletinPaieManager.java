
package com.keren.kerenpaie.core.ifaces.rapports;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
public interface ViewBulletinPaieManager
    extends GenericManager<ViewBulletinPaie, Long>
{

    public final static String SERVICE_NAME = "ViewBulletinPaieManager";
    public List<ViewBulletinPaie> getCriteres(ViewBulletinPaie critere);
}
