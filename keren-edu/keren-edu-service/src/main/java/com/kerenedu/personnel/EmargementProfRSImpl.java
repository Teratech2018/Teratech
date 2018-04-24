
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
@Path("/emargementprof")
public class EmargementProfRSImpl
    extends AbstractGenericService<EmargementProf, Long>
    implements EmargementProfRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "EmargementProfManagerImpl", interf = EmargementProfManagerRemote.class)
    protected EmargementProfManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ProfesseurManagerImpl", interf = ProfesseurManagerRemote.class)
    protected ProfesseurManagerRemote managerProf;
    
    @Manager(application = "kereneducation", name = "EmargementProfDetailsManagerImpl", interf = EmargementProfDetailsManagerRemote.class)
    protected EmargementProfDetailsManagerRemote manageremargedlt;
    

    public EmargementProfRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EmargementProf, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new EmargementProf(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
	public List<Professeur> findprofclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);		
		return managerProf.findprofclasse(id);
	}

	@Override
	public List<EmargementProfDetails> findmatiereprof(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		long idclasse =gson.fromJson(headers.getRequestHeader("classe").get(0), Long.class);
		Date date =gson.fromJson(headers.getRequestHeader("datemarg").get(0), Date.class);
		
		
		System.out.println("EmargementProfRSImpl.findprofclasse() id===========X "+id);
		System.out.println("EmargementProfRSImpl.findprofclasse() idClass===========X "+idclasse);
		System.out.println("EmargementProfRSImpl.findprofclasse() date===========X "+date);
		
		return manageremargedlt.findmatiereprof(id,idclasse,date);
	}



}
