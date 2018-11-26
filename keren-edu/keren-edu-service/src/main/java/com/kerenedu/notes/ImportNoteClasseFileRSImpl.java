package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;















@Path("/importnoteclassefile")
public class ImportNoteClasseFileRSImpl
  extends AbstractGenericService<ImportNoteClasseFile, Long>
  implements ImportNoteClasseFileRS
{
//  @Manager(application="kereneducation", name="ImportNoteManagerImpl", interf=ImportNoteManagerRemote.class)
//  protected ImportNoteManagerRemote manager;
  @Manager(application="kereneducation", name="NoteDetailManagerImpl", interf=NoteDetailManagerRemote.class)
  protected NoteDetailManagerRemote managernote;
  @Manager(application="kereneducation", name="MatiereNoteManagerImpl", interf=MatiereNoteManagerRemote.class)
  protected MatiereNoteManagerRemote managermat;
  
  public ImportNoteClasseFileRSImpl() {}
  
  public MetaData getMetaData(HttpHeaders headers)
  {
    try
    {
      return MetaDataUtil.getMetaData(new ImportNoteClasseFile(), new HashMap<String, MetaData>(), new ArrayList<String>());
    }
    catch (Exception e) {
      throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
    }
  }
  





  public GenericManager<ImportNoteClasseFile, Long> getManager()
  {
    return null;
  }
  
  public String getModuleName() {
    return "kereneducation";
  }
}