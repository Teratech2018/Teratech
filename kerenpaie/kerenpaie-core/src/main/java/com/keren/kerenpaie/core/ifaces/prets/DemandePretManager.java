
package com.keren.kerenpaie.core.ifaces.prets;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.prets.DemandePret;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface DemandePretManager
    extends GenericManager<DemandePret, Long>
{

    public final static String SERVICE_NAME = "DemandePretManager";
    
    public DemandePret generereglements(DemandePret entity);
	
	public DemandePret confirme(DemandePret entity);

	
	public DemandePret annule(DemandePret entity);
}
