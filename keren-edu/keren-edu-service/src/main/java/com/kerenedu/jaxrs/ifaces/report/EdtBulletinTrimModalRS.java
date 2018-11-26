package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.EdtBulletinTrimModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public abstract interface EdtBulletinTrimModalRS
  extends GenericService<EdtBulletinTrimModal, Long>
{
  @PUT
  @Produces({"application/pdf"})
  @Consumes({"application/json"})
  @Path("trim")
  public abstract Response buildPdfReportTrim(EdtBulletinTrimModal paramEdtBulletinTrimModal, @Context HttpHeaders paramHttpHeaders);
  
  @GET
  @Produces({"application/json"})
  @Path("getidclasse")
  public abstract List<InscriptionChoice> getidclasse(@Context HttpHeaders paramHttpHeaders);
}