
package com.keren.courrier.jaxrs.impl.archivage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.archivage.TiroirArchivageManagerRemote;
import com.keren.courrier.jaxrs.ifaces.archivage.TiroirArchivageRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.archivage.ArchiveDossier;
import com.keren.courrier.model.archivage.TiroirArchivage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Aug 23 09:56:40 WAT 2018
 * 
 */
@Path("/tiroirarchivage")
public class TiroirArchivageRSImpl
    extends AbstractGenericService<TiroirArchivage, Long>
    implements TiroirArchivageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "TiroirArchivageManagerImpl", interf = TiroirArchivageManagerRemote.class)
    protected TiroirArchivageManagerRemote manager;

    public TiroirArchivageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TiroirArchivage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new TiroirArchivage(), new HashMap<String, MetaData>(), new ArrayList<String>());
               } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
  	public TiroirArchivage delete(@Context HttpHeaders headers, Long id) {

  		// TODO Auto-generated method stub
    	TiroirArchivage entity = manager.find("id", id);
  		try {
  			
  				// on supprimme l'objet
  				super.delete(headers, id);
  	

  		} catch (Exception ex) {
  			throw new KerenExecption(
  					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
  		}

  		return entity;
  	}

}