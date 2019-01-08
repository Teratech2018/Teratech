
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.Facture;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Sat Jan 05 23:43:04 WAT 2019
 * 
 */
public interface FactureManager
    extends GenericManager<Facture, Long>
{

    public final static String SERVICE_NAME = "FactureManager";

    public Facture confirmer(Facture entity);
    
    public Facture transfert(Facture entity);
    
    public Facture annule(Facture entity);
}
