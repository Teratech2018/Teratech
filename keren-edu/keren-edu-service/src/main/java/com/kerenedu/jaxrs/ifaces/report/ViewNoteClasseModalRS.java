package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.model.report.ViewNoteClasseModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}