
package com.kerenedu.jaxrs.impl.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewBulletinPaieHelperRS;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Nov 30 09:20:29 WAT 2018
 * 
 */
@Path("/viewbulletinpaiehelper")
public class ViewBulletinPaieHelperRSImpl
    extends AbstractGenericService<ViewBulletinPaieHelper, Long>
    implements ViewBulletinPaieHelperRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewBulletinPaieHelperManagerImpl", interf = ViewBulletinPaieHelperManagerRemote.class)
    protected ViewBulletinPaieHelperManagerRemote manager;

    public ViewBulletinPaieHelperRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewBulletinPaieHelper, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
    	try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewBulletinPaieHelper(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
		
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(EdtPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EdtPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
   	}

}
