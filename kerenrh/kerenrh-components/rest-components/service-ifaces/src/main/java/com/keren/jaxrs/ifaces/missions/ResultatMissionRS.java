
package com.keren.jaxrs.ifaces.missions;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.missions.Mission;
import com.keren.model.missions.ResultatMission;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS

 * @since Wed Apr 11 11:50:58 GMT+01:00 2018
 * 
 */
public interface ResultatMissionRS
    extends GenericService<ResultatMission, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("cloture")
    public ResultatMission cloture(@Context HttpHeaders headers,ResultatMission entity);

}