
package com.kerenedu.notes;

import java.util.List;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
public interface BulletinDAO
    extends GenericDAO<Bulletin, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinDAO";
    
    public long deleteRadBulletin(Bulletin entity);
    
    public long updateforce(String value) ;
  	public long updateforce2(EdtBulletin prepa) ;
 	public long deleteforce2(List<Bulletin> datas);

}
