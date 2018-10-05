
package com.keren.courrier.dao.ifaces.others;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.others.CinterneSeqGenerator;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Sep 13 10:59:59 WAT 2018
 * 
 */
public interface CinterneSeqGeneratorDAO
    extends GenericDAO<CinterneSeqGenerator, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CinterneSeqGeneratorDAO";

}
