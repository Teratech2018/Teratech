
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri May 11 09:52:55 WAT 2018
 * 
 */
public interface ConsultationEchDAO
    extends GenericDAO<ConsultationEch, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ConsultationEchDAO";

}
