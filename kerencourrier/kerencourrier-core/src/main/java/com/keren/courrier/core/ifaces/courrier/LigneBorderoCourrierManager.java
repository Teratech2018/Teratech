
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Fri Jul 27 16:56:33 GMT+01:00 2018
 * 
 */
public interface LigneBorderoCourrierManager
    extends GenericManager<LigneBorderoCourrier, Long>
{

    public final static String SERVICE_NAME = "LigneBorderoCourrierManager";

    /**
     * 
     * @param ligne
     * @param service
     * @return 
     */
    public boolean originalAllReadyaffect(LigneBorderoCourrier ligne , StructureCompany service);
}
