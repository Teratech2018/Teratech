
package com.teratech.gmao.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.gmao.model.base.Equipement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 13 17:11:00 GMT+01:00 2018
 * 
 */
public interface EquipementDAO
    extends GenericDAO<Equipement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EquipementDAO";

}
