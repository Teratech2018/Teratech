
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerenedu.inscription.Inscription;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface MoteurBulletinManager
    extends GenericManager<Bulletin, Long>
{

    public final static String SERVICE_NAME = "BulletinPaieManager";
    
   
    public EdtBulletin preparerNotes(EdtBulletin prepa);
    
    public void aggregateNote(Inscription param,EdtBulletin critere);
    
    public void aggregateNote(EdtBulletin prepa);
    
   
}
