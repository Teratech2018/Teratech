
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.kerenedu.inscription.Inscription;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Dec 13 14:34:46 WAT 2018
 * 
 */
public interface BulletinHelperDAO
    extends GenericDAO<BulletinHelper, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BulletinHelperDAO";
    
    public BulletinHelper gethelper(Inscription critere);
    
    public LigneHelper getLigneHelper(LigneBulletinClasse ligne,Inscription critere );

}
