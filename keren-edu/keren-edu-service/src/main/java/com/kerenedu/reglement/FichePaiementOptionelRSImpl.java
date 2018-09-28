
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Service;
import com.kerenedu.configuration.ServiceFilliere;
import com.kerenedu.configuration.ServiceManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Aug 24 09:40:04 WAT 2018
 * 
 */
@Path("/fichepaiementoptionel")
public class FichePaiementOptionelRSImpl
    extends AbstractGenericService<FichePaiementOptionel, Long>
    implements FichePaiementOptionelRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "FichePaiementOptionelManagerImpl", interf = FichePaiementOptionelManagerRemote.class)
    protected FichePaiementOptionelManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ServiceManagerImpl", interf = ServiceManagerRemote.class)
    protected ServiceManagerRemote managerservice;
    
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
    protected InscriptionManagerRemote managerins;

    public FichePaiementOptionelRSImpl() {
        super();
    }
    
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new FichePaiementOptionel(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FichePaiementOptionel, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }


	@Override
	protected void processBeforeSave(FichePaiementOptionel entity) {
		entity.setPayer(true);
		long total = entity.getzQte()*entity.getzMntHt();
		entity.setZtotal(total);
		entity.setAnneScolaire(entity.getEleve().getAnneScolaire());
		entity.setSolde((long)0);
		entity.setMatricule(entity.getEleve().getEleve().getMatricule());
		
		
		if(total!=entity.getMntpayer()){
			throw new KerenExecption("Traitement impossible<br/> montant saisir incorrect !!!");
		}
					
		System.out.println("FichePaiementOptionelRSImpl.processAfterSave() je suis ici ......");
		super.processAfterSave(entity);
	}
	
	@Override
	protected void processAfterSave(FichePaiementOptionel entity) {
		
		super.processAfterSave(entity);
	}
	


	@Override
	public Long getMontant(HttpHeaders headers) {
		Gson gson = new Gson();
		Long versement = (long) 0;
		Long id = (long) 0;
		Long eleve = (long) 0;
		ServiceFilliere sfiliere = new ServiceFilliere();
		id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		eleve = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
		if(id>0&&eleve>0){
		Service service = managerservice.find("id", id);
		Inscription ins = managerins.find("id",eleve);
		CacheMemory.setIncription(ins);
		System.out.println("FichePaiementOptionelRSImpl.getMontant()service trouvé is  is   "+service.getLibelle());
		if(service!=null){
			for(ServiceFilliere sf : service.getFiliere()){
					if(sf.getFiliere().getCode().equals(ins.getClasse().getFiliere().getCode())){
					sfiliere = sf;
					break;
				}
			}
			versement= sfiliere.getzMnt();
			System.out.println("FichePaiementOptionelRSImpl.getMontant()versement avec value is   "+versement);
		}
		
		}
		
		return versement;
	}
	
	 @Override
	    public RSNumber count(HttpHeaders headers) {
	        //To change body of generated methods, choose Tools | Templates.
	         //To change body of generated methods, choose Tools | Templates.
	        Gson gson = new Gson();
	        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
	       
	        //Type predType = ;
	        List contraints = new ArrayList();
	        if(headers.getRequestHeader("predicats")!=null){
	            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
	        }//end if(headers.getRequestHeader("predicats")!=null){        
	        RestrictionsContainer container = RestrictionsContainer.newInstance();  
	         if(contraints!=null&&!contraints.isEmpty()){
	            for(Object obj : contraints){
	                FilterPredicat filter = (FilterPredicat) obj ;
	                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
	                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
	                      container = addPredicate(container, filter);
	                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
	            }//end  for(Object obj : contraints)
	        }//end if(contraints!=null&&!contraints.isEmpty())
//	         if (headers.getRequestHeader("eleve") != null) {
//	 			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
//
//	 			FichePaiementOptionel inscription = null;
//	 			inscription = manager.find("id", studenid);
//	 			container.addEq("eleve.id", inscription.getId());
//	 		}
	        container.addEq("service.exige", false);
	        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//	        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
	        return number;
	    }
	    
	    
	    
	    @Override
	    public List<FichePaiementOptionel> filter(HttpHeaders headers, int firstResult, int maxResult) {
	        //To change body of generated methods, choose Tools | Templates.
	         Gson gson = new Gson();
	        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
	        //Type predType = ;
	        List contraints = new ArrayList();
	        if(headers.getRequestHeader("predicats")!=null){
	            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
	        } //end if(headers.getRequestHeader("predicats")!=null){       
//	        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
	        RestrictionsContainer container = RestrictionsContainer.newInstance();  
	        if(contraints!=null&&!contraints.isEmpty()){
	            for(Object obj : contraints){
	                FilterPredicat filter = (FilterPredicat) obj ;
	                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
	                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
	                        container = addPredicate(container,filter);
	                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
	            }//end  for(Object obj : contraints)
	        }//end if(contraints!=null&&!contraints.isEmpty())
//	        if (headers.getRequestHeader("eleve") != null) {
//	 			long studenid = gson.fromJson(headers.getRequestHeader("eleve").get(0), Long.class);
//
//	 			FichePaiementOptionel inscription = null;
//	 			inscription = manager.find("id", studenid);
//	 			container.addEq("eleve.id", inscription.getId());
//	 		}
	        container.addEq("service.exige", false);
	        //List result = new ArrayList();
	        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
	    }


		


}
