
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 15:46:58 WAT 2018
 * 
 */
@Path("/lignebulletinpaie")
public class LigneBulletinPaieRSImpl
    extends AbstractGenericService<LigneBulletinPaie, Long>
    implements LigneBulletinPaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "LigneBulletinPaieManagerImpl", interf = LigneBulletinPaieManagerRemote.class)
    protected LigneBulletinPaieManagerRemote manager;

    public LigneBulletinPaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBulletinPaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new LigneBulletinPaie(), new HashMap<String, MetaData>()
  					, new ArrayList<String>());
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
