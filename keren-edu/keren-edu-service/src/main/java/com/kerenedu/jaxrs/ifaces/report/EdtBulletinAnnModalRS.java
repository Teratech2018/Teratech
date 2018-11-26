package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.model.report.EdtBulletinAnnModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public abstract interface EdtBulletinAnnModalRS
  extends GenericService<EdtBulletinAnnModal, Long>
{
  @PUT
  @Produces({"application/pdf"})
  @Consumes({"application/json"})
  @Path("ann")
  public abstract Response buildPdfReportAnn(EdtBulletinAnnModal paramEdtBulletinAnnModal, @Context HttpHeaders paramHttpHeaders);
}