
package com.keren.kerenpaie.core.ifaces.paie;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.rapports.BPaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface BulletinPaieManager
    extends GenericManager<BulletinPaie, Long>
{

    public final static String SERVICE_NAME = "BulletinPaieManager";
    
    public List<BulletinPaie> getCriteres(BPaie critere);
    
    public List<BulletinPaie> getCriteres(BulletinPaie critere);

}
