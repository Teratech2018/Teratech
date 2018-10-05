
package com.keren.courrier.dao.ifaces.archivage;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.archivage.CadreClassement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Aug 23 09:56:39 WAT 2018
 * 
 */
public interface CadreClassementDAO
    extends GenericDAO<CadreClassement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CadreClassementDAO";

}
