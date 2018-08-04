
package com.keren.courrier.jaxrs.impl.traitement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.core.ifaces.traitement.RelanceActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.RelanceActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.traitement.RelanceAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jul 31 08:24:48 WAT 2018
 * 
 */
@Path("/relanceaction")
public class RelanceActionRSImpl
    extends AbstractGenericService<RelanceAction, Long>
    implements RelanceActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "RelanceActionManagerImpl", interf = RelanceActionManagerRemote.class)
    protected RelanceActionManagerRemote manager;
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "TraitementCourrierManagerImpl", interf = TraitementCourrierManagerRemote.class)
    protected TraitementCourrierManagerRemote courriermanager;

    public RelanceActionRSImpl() {
        super();
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new RelanceAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    
    @Override
    public RelanceAction save(HttpHeaders headers, RelanceAction entity) {
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        CourrierInterne ci = new CourrierInterne(entity);
        ci.setSource(user);
        ci.setSowner(user.getService());
        ci.setCategorie("2");
        entity.setCourrierinterne(ci);
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public GenericManager<RelanceAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
	public RelanceAction delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
    	RelanceAction entity = manager.find("id", id);
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
