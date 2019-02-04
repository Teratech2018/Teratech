package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.ViewNoteClasseModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public abstract interface ViewNoteClasseModalRS
  extends GenericService<ViewNoteClasseModal, Long>
{
  @PUT
  @Produces({"application/pdf"})
  @Path("pdf")
  public abstract Response buildPdfReport(ViewNoteClasseModal paramViewNoteClasseModal);
  
  @PUT
  @Produces({"application/pdf"})
  @Path("bi/pdf")
  public abstract Response buildPdfReportbi(ViewNoteClasseModal paramViewNoteClasseModal);
  
  @GET
  @Produces({"application/json"})
  @Path("getidclasse")
  public abstract List<InscriptionChoice> getidclasse(@Context HttpHeaders paramHttpHeaders);
}