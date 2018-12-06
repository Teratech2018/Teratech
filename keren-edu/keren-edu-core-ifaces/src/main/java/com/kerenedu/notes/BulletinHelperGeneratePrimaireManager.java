
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.EdtBulletinModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 06 02:40:56 WAT 2018
 * 
 */
public interface BulletinHelperGeneratePrimaireManager
    extends GenericManager<BulletinHelperGeneratePrimaire, Long>
{

    public final static String SERVICE_NAME = "BulletinHelperGeneratePrimaireManager";
    
	public List<BulletinHelperGeneratePrimaire> getCriteres(Bulletin critere) ;
	
	public List<BulletinHelperGeneratePrimaire> getCriteres(EdtBulletinModal critere);

}
