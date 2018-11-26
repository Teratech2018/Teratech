package com.kerenedu.notes;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

public abstract interface ImportNoteClasseRS
  extends GenericService<ImportNoteClasse, Long>
{
  @GET
  @Produces({"application/json"})
  @Path("findmatiere")
  public abstract List<ImportNoteClasseFile> findmatierclasse(@Context HttpHeaders paramHttpHeaders);
}