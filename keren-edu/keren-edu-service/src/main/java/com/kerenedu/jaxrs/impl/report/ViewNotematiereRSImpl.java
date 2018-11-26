package com.kerenedu.jaxrs.impl.report;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewNotematiereManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewNotematiereRS;
import com.kerenedu.model.report.ViewNotematiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


@Path("/viewnotematiere")
public class ViewNotematiereRSImpl
  extends AbstractGenericService<ViewNotematiere, Long>
  implements ViewNotematiereRS
{
  @Manager(application="kereneducation", name="ViewNotematiereManagerImpl", interf=ViewNotematiereManagerRemote.class)
  protected ViewNotematiereManagerRemote manager;
  
  public ViewNotematiereRSImpl() {}
  
  public GenericManager<ViewNotematiere, Long> getManager()
  {
    return manager;
  }
  
  public String getModuleName() {
    return "kereneducation";
  }
  
  public MetaData getMetaData(HttpHeaders headers)
  {
    try
    {
      return MetaDataUtil.getMetaData(new ViewNotematiere(), new HashMap(), new ArrayList());
    }
    catch (Exception e) {
      throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
    }
  }
}