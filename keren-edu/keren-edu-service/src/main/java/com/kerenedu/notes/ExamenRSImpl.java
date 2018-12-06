
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Feb 14 10:30:55 CET 2018
 * 
 */
@Path("/examen")
public class ExamenRSImpl
    extends AbstractGenericService<Examen, Long>
    implements ExamenRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ExamenManagerImpl", interf = ExamenManagerRemote.class)
    protected ExamenManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "AnneScolaireManagerImpl", interf = AnneScolaireManagerRemote.class)
    protected AnneScolaireManagerRemote managerAnne;

    public ExamenRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Examen, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new Examen(), new HashMap<String, MetaData>(),new ArrayList<String>());
  			
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
    
    @Override
    protected void processBeforeSave(Examen entity) {
    	entity.setState("etabli");
    	entity.setTypecycle(entity.getCycle().getTypecycle());
        // find exercice
//    	RestrictionsContainer container = RestrictionsContainer.newInstance();
//    	container.addEq("code", entity.getCode());
//    	AnneScolaire annee = managerAnne.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
//        // TODO Auto-generated method stub
//        if(entity.getdDeb().after(entity.getdFin())){
//           throw new KerenExecption("La date debut est incorrecte");
//        }else if(!DateHelper.between(entity.getdDeb(), annee.getDdeb(), annee.getDfin())){
//            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
//        }else if(!DateHelper.between(entity.getdFin(),  annee.getDdeb(), annee.getDfin())){
//            throw new KerenExecption("L'intervalle de temps est incorrect, la periode doit etre incluse dans l'exerice");
//        }
        
        super.processBeforeSave(entity);
    }
    
    @Override
    public Examen delete(@Context HttpHeaders headers , Long id) {

        // TODO Auto-generated method stub
    	Examen entity = manager.find("id", id);

        try{

            //on supprimme l'objet
            super.delete(headers,id);

        }catch(Exception ex){
            throw new KerenExecption("Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
        }

        return entity;
    }
    
    

}
