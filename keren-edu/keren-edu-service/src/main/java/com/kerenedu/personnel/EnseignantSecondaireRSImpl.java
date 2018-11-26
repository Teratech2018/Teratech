
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.notes.ImportNoteClasseFile;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Nov 26 15:39:58 WAT 2018
 * 
 */
@Path("/enseignantsecondaire")
public class EnseignantSecondaireRSImpl
    extends AbstractGenericService<EnseignantSecondaire, Long>
    implements EnseignantSecondaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EnseignantSecondaireManagerImpl", interf = EnseignantSecondaireManagerRemote.class)
    protected EnseignantSecondaireManagerRemote manager;

    public EnseignantSecondaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EnseignantSecondaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
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

}
