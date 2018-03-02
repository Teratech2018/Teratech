
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.ExprBesion;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue Feb 27 14:29:39 GMT+01:00 2018
 * 
 */
public interface ExprBesionManager
    extends GenericManager<ExprBesion, Long>
{

    public final static String SERVICE_NAME = "ExprBesionManager";
    
    public ExprBesion confirmer(ExprBesion entity);
    
    public ExprBesion annuler(ExprBesion entity);

}
