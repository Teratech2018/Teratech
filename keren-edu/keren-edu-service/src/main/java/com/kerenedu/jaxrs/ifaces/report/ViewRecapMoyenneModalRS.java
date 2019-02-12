package com.kerenedu.jaxrs.ifaces.report;

import com.kerenedu.model.report.ViewRecapMoyenneModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

public abstract interface ViewRecapMoyenneModalRS
  extends GenericService<ViewRecapMoyenneModal, Long>
{
  @PUT
  @Produces({"application/pdf"})
  @Path("bi/note")
  public abstract Response ficheMoyenneReportbi(ViewRecapMoyenneModal entity);
  
  @PUT
  @Produces({"application/pdf"})
  @Path("note")
  public abstract Response ficheMoyenneReport(ViewRecapMoyenneModal entity);
  
  
  @PUT
  @Produces({"application/pdf"})
  @Path("mmoy")
  public abstract Response matrriceMoyenne(ViewRecapMoyenneModal entity);
  
  
  @PUT
  @Produces({"application/pdf"})
  @Path("bi/mmoy")
  public abstract Response matrriceMoyennebi(ViewRecapMoyenneModal entity);
  
  
}