
package com.keren.kerenpaie.jaxrs.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.employes.CategorieManagerRemote;
import com.keren.kerenpaie.core.ifaces.employes.FonctionManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.RubriqueManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.RubriqueRS;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.employes.Fonction;
import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.tools.KerenPaieManagerException;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
@Path("/rubrique")
public class RubriqueRSImpl
    extends AbstractGenericService<Rubrique, Long>
    implements RubriqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "RubriqueManagerImpl", interf = RubriqueManagerRemote.class)
    protected RubriqueManagerRemote manager;
    
    @Manager(application = "kerenpaie", name = "MoteurPaieManagerImpl", interf = MoteurPaieManagerRemote.class)
    protected MoteurPaieManagerRemote moteurmanager;
    
    @Manager(application = "kerenpaie", name = "FonctionManagerImpl", interf = FonctionManagerRemote.class)
    protected FonctionManagerRemote fonctionmanager;
    
    @Manager(application = "kerenpaie", name = "CategorieManagerImpl", interf = CategorieManagerRemote.class)
    protected CategorieManagerRemote categoriemanager;

    public RubriqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Rubrique, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new Rubrique(), new HashMap<String, MetaData>()
					, new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work1", "Evaluer la Rubrique", false, "object", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'rubrique','method':'evaluer','template':{'this':'object'}}");
	        workbtn.setStates(new String[]{"etabli"});
//	        workbtn.setPattern("btn btn-success");
	        meta.getHeader().add(workbtn);   
			workbtn = new MetaColumn("button", "work1", "Générer les forfaits", false, "workflow", null);
	        workbtn.setValue("{'model':'kerenpaie','entity':'rubrique','method':'genereforfait'}");
	        workbtn.setStates(new String[]{"etabli"});
	        workbtn.setPattern("btn btn-success");
	       // meta.getHeader().add(workbtn);   
			return meta;
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
	protected void processBeforeDelete(Object key) {
		// TODO Auto-generated method stub
		Rubrique entity = manager.find("id", (Long) key);
		super.processBeforeDelete(entity);
	}

	@Override
	protected void processBeforeSave(Rubrique entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Code est obligatoire");
		}else if(entity.getDesignation()==null||entity.getDesignation().trim().isEmpty()){
			throw new KerenExecption("La Description est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de Rubrique  est obligatoire");
		}else if(entity.getMode()==null||entity.getMode().trim().isEmpty()){
			throw new KerenExecption("Le Mode d'Evaluation est obligatoire");
		}
		super.processBeforeSave(entity);
	}

	@Override
	protected void processBeforeUpdate(Rubrique entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Code est obligatoire");
		}else if(entity.getDesignation()==null||entity.getDesignation().trim().isEmpty()){
			throw new KerenExecption("La Description est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de Rubrique  est obligatoire");
		}else if(entity.getMode()==null||entity.getMode().trim().isEmpty()){
			throw new KerenExecption("Le Mode d'Evaluation est obligatoire");
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public Rubrique genereforfait(HttpHeaders headers, Rubrique entity) {
		// TODO Auto-generated method stub
		if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
			throw new KerenExecption("Le Code est obligatoire");
		}else if(entity.getDesignation()==null||entity.getDesignation().trim().isEmpty()){
			throw new KerenExecption("La Description est obligatoire");
		}else if(entity.getType()==null||entity.getType().trim().isEmpty()){
			throw new KerenExecption("Le Type de Rubrique  est obligatoire");
		}else if(entity.getMode()==null||entity.getMode().trim().isEmpty()){
			throw new KerenExecption("Le Mode d'Evaluation est obligatoire");
		}else if(entity.getType().equalsIgnoreCase("0") && !entity.getForfaitscatprof().isEmpty()){
			throw new KerenExecption("Des forfaits sont déjà liés a cette rubrique");
		}else if(entity.getType().equalsIgnoreCase("1") && !entity.getForfaitscat().isEmpty()){
			throw new KerenExecption("Des forfaits sont déjà liés a cette rubrique");
		}else if(entity.getType().equalsIgnoreCase("2") && !entity.getForfaitsspe().isEmpty()){
			throw new KerenExecption("Des forfaits sont déjà liés a cette rubrique");
		}
		return manager.genereforfait(entity);
	}

	@Override
	public Rubrique evaluer(HttpHeaders headers, Rubrique entity) {
		// TODO Auto-generated method stub
		  try{
			Double valeur = moteurmanager.eval(entity, new Employe(), null, null,entity.getSociete());
			if(valeur<0){
				throw new KerenExecption("Echec de validation de la Rubrique Vérifiez que : <br/> Les variables existent <br/> L'expression arithmétique est bien formées");
			}
			return entity;
		  }catch(KerenPaieManagerException ex){
			  throw new KerenExecption(ex.getMessage());
		  }
//		return entity;
	}

	@Override
	public List<ForfaitCategorieProf> generatecategorieprof(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
//		long idsoc =gson.fromJson(headers.getRequestHeader("societe").get(0), Long.class);
		String value =gson.fromJson(headers.getRequestHeader("mode").get(0), String.class);
		List<ForfaitCategorieProf> listforfait = new ArrayList<ForfaitCategorieProf>();
		if(value!=null&&value.equals("0")){
		List<Fonction> listfonction = new ArrayList<Fonction>();
		listfonction= fonctionmanager.findAll();
		for(Fonction fct :listfonction){
			listforfait.add(new ForfaitCategorieProf(fct));
		}
		}
		return listforfait;
	}
	
	@Override
	public List<ForfaitCategorie> generatecategorie(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
//		long idsoc =gson.fromJson(headers.getRequestHeader("societe").get(0), Long.class);
		String value =gson.fromJson(headers.getRequestHeader("mode").get(0), String.class);
		List<ForfaitCategorie> listforfait = new ArrayList<ForfaitCategorie>();
		
		if(value!=null&&value.equals("1")){
		List<Categorie> listcat = new ArrayList<Categorie>();
		listcat= categoriemanager.findAll();
		for(Categorie cat :listcat){
			listforfait.add(new ForfaitCategorie(cat));
		}
		}
		return listforfait;
	}
    
    

}
