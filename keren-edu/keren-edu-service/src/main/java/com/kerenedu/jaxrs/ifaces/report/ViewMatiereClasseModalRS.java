package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public abstract interface ViewMatiereClasseModalRS
  extends GenericService<ViewMatiereClasseModal, Long>
{
  @PUT
  @Produces({"application/pdf"})
  @Path("pdf")
  public abstract Response buildPdfReport(ViewMatiereClasseModal paramViewMatiereClasseModal);
  
  @PUT
  @Produces({"application/pdf"})
  @Path("note")
  public abstract Response fichenotes(ViewMatiereClasseModal paramViewMatiereClasseModal);
  
  
  @PUT
  @Produces({"application/pdf"})
  @Path("bi/pdf")
  public abstract Response buildPdfReportbi(ViewMatiereClasseModal paramViewMatiereClasseModal);
  
  @PUT
  @Produces({"application/pdf"})
  @Path("bi/note")
  public abstract Response fichenotesbi(ViewMatiereClasseModal paramViewMatiereClasseModal);
}