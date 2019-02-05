
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.configuration.CycleManagerRemote;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.personnel.ProfesseurManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Sep 10 15:39:11 WAT 2018
 * 
 */
@Path("/rubriquepaie")
public class RubriquePaieRSImpl
    extends AbstractGenericService<RubriquePaie, Long>
    implements RubriquePaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "RubriquePaieManagerImpl", interf = RubriquePaieManagerRemote.class)
    protected RubriquePaieManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "CategorieManagerImpl", interf = CategorieManagerRemote.class)
    protected CategorieManagerRemote categoriemanager;
    
    @Manager(application = "kereneducation", name = "CycleManagerImpl", interf = CycleManagerRemote.class)
    protected CycleManagerRemote cyclemanager;
    
    @Manager(application = "kereneducation", name = "ProfesseurManagerImpl", interf = ProfesseurManagerRemote.class)
    protected ProfesseurManagerRemote persomanager;

    public RubriquePaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RubriquePaie, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new RubriquePaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}
    @Override
	public List<ForfaitCategorie> generatecategorie(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
//		long idsoc =gson.fromJson(headers.getRequestHeader("societe").get(0), Long.class);
		String value =gson.fromJson(headers.getRequestHeader("mode").get(0), String.class);
		List<ForfaitCategorie> listforfait = new ArrayList<ForfaitCategorie>();
		
		if(value!=null&&value.equals("0")){
		List<Categorie> listcat = new ArrayList<Categorie>();
		listcat= categoriemanager.findAll();
		//int index =0;
		for(Categorie cat :listcat){
			//cat.setId(-index);
			listforfait.add(new ForfaitCategorie(cat));
			//index++;
		}
		}
		return listforfait;
	}
    
    @Override
	public List<ForfaitCycle> generatecycle(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
//		long idsoc =gson.fromJson(headers.getRequestHeader("societe").get(0), Long.class);
		String value =gson.fromJson(headers.getRequestHeader("mode").get(0), String.class);
		List<ForfaitCycle> listforfait = new ArrayList<ForfaitCycle>();
		
		if(value!=null&&value.equals("1")){
		List<Cycle> listcat = new ArrayList<Cycle>();
		listcat= cyclemanager.findAll();
		//int index =0;
		for(Cycle cat :listcat){
		//	cat.setId(-index);
			listforfait.add(new ForfaitCycle(cat));
		//	index++;
		}
		}
		return listforfait;
	}
    
    @Override
	protected void processBeforeSave(RubriquePaie entity) {
    	if(entity.getAcompte()==null){
    		entity.setAcompte(false);
    	}
    	if(entity.getPret()==null){
    		entity.setPret(false);
    	}
    	
		for(ForfaitCategorie fc : entity.getForfaitscat())
			fc.setId(-1);
		for(ForfaitCycle fc : entity.getForfaitscycle())
			fc.setId(-1);
		for(ForfaitPersonnel fc : entity.getForfaitsperso())
			fc.setId(-1);
		super.processBeforeSave(entity);
	}

	@Override
  	public List<ForfaitPersonnel> generatepersonnel(HttpHeaders headers) {
  		Gson gson = new Gson();
  		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
//  		long idsoc =gson.fromJson(headers.getRequestHeader("societe").get(0), Long.class);
  		String value =gson.fromJson(headers.getRequestHeader("mode").get(0), String.class);
  		List<ForfaitPersonnel> listforfait = new ArrayList<ForfaitPersonnel>();
  		
  		if(value!=null&&value.equals("2")){
  		List<Professeur> listcat = new ArrayList<Professeur>();
  		listcat= persomanager.findAll();
  		//int index =0;
  		for(Professeur cat :listcat){
  		//	cat.setId(-index);
  			listforfait.add(new ForfaitPersonnel(cat));
  		//	index++;
  		}
  		}
  		return listforfait;
  	}
}
