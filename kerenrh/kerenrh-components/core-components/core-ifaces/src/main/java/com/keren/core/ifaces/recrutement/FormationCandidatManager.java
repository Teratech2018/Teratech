
package com.keren.core.ifaces.recrutement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.recrutement.FormationCandidat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface FormationCandidatManager
    extends GenericManager<FormationCandidat, Long>
{

    public final static String SERVICE_NAME = "FormationCandidatManager";

}
