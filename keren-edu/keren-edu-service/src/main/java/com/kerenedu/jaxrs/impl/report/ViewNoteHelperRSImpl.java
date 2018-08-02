
package com.kerenedu.jaxrs.impl.report;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewNoteHelperRS;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.CoefMatiereModal;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jul 03 11:27:54 WAT 2018
 * 
 */
@Path("/viewnotehelper")
public class ViewNoteHelperRSImpl
    extends AbstractGenericService<ViewNoteHelper, Long>
    implements ViewNoteHelperRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewNoteHelperManagerImpl", interf = ViewNoteHelperManagerRemote.class)
    protected ViewNoteHelperManagerRemote manager;

    public ViewNoteHelperRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewNoteHelper, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new ViewNoteHelper(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}

}
