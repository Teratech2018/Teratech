
package com.keren.kerenpaie.core.ifaces.prets;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.prets.Acompte;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface AcompteManager
    extends GenericManager<Acompte, Long>
{

    public final static String SERVICE_NAME = "AcompteManager";
    
    public Acompte confirme(Acompte entity);
	
	public Acompte paye(Acompte entity,PeriodePaie periode);

	
	public Acompte annule(Acompte entity);

}
