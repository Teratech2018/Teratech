
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
import com.keren.courrier.core.ifaces.archivage.BoiteArchivageManagerRemote;
import com.keren.courrier.jaxrs.ifaces.archivage.BoiteArchivageRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.archivage.BoiteArchivage;
import com.keren.courrier.model.archivage.TiroirArchivage;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Aug 23 09:56:40 WAT 2018
 * 
 */
@Path("/boitearchivage")
public class BoiteArchivageRSImpl
    extends AbstractGenericService<BoiteArchivage, Long>
    implements BoiteArchivageRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "BoiteArchivageManagerImpl", interf = BoiteArchivageManagerRemote.class)
    protected BoiteArchivageManagerRemote manager;

    public BoiteArchivageRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BoiteArchivage, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new BoiteArchivage(), new HashMap<String, MetaData>(), new ArrayList<String>());
               } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
   	public BoiteArchivage delete(@Context HttpHeaders headers, Long id) {

   		// TODO Auto-generated method stub
    	BoiteArchivage entity = manager.find("id", id);
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
