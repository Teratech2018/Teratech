
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.model.report.ViewBulletin;
import com.kerenedu.model.report.ViewRecapMoyenneModal;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
public interface BulletinManager
    extends GenericManager<Bulletin, Long>
{

    public final static String SERVICE_NAME = "BulletinManager";
    
    public List<Bulletin> getCriteres(Bulletin critere);
    
	public List<Bulletin> getCriteres(ViewRecapMoyenneModal critere) ;

}
