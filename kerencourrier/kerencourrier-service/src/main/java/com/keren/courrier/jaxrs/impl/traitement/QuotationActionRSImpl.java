
package com.keren.courrier.jaxrs.impl.traitement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.StructureCompanyManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.QuotationActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.traitement.QuotationAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jul 26 18:00:19 GMT+01:00 2018
 * 
 */
@Path("/quotationaction")
public class QuotationActionRSImpl
    extends AbstractGenericService<QuotationAction, Long>
    implements QuotationActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "QuotationActionManagerImpl", interf = QuotationActionManagerRemote.class)
    protected QuotationActionManagerRemote manager;
      
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "StructureCompanyManagerImpl", interf = StructureCompanyManagerRemote.class)
    protected StructureCompanyManagerRemote structuremanager;
    
    @Manager(application = "kerencourrier", name = "BorderoCourrierManagerImpl", interf = BorderoCourrierManagerRemote.class)
    protected BorderoCourrierManagerRemote borderomanager;
    
    @Manager(application = "kerencourrier", name = "CourrierCloneManagerImpl", interf = CourrierCloneManagerRemote.class)
    protected CourrierCloneManagerRemote courriermanager;
    
    
    
    

    public QuotationActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<QuotationAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new QuotationAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
//            workbtn.setValue("{'model':'kerencourrier','entity':'courrier','method':'distribuer'}");
//            workbtn.setStates(new String[]{"etabli","valide"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
           // MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            //meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuotationAction> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson = new Gson();
        Long courrierid = null;
        if(headers.getRequestHeader("courrier")==null){
             return new ArrayList<QuotationAction>();
         }//end if(headers.getRequestHeader("courrier")!=null){
        courrierid = gson.fromJson(headers.getRequestHeader("courrier").get(0), Long.class);
         Long userid  = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){       
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
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
        container.addEq("courrier.id", courrierid);
        container.addEq("quoteur.service", user.getService());
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("courrier")+" === "+firstResult+" === "+maxResult+" == ");       
//        return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
         Long courrierid = null;
         if(headers.getRequestHeader("courrier")==null){
             return new RSNumber(0);
         }//end if(headers.getRequestHeader("courrier")!=null){
         courrierid = gson.fromJson(headers.getRequestHeader("courrier").get(0), Long.class);
         Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);         
         UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
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
        container.addEq("courrier.id", courrierid);
        container.addEq("quoteur.service", user.getService());
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    

	@Override
	public QuotationAction save(HttpHeaders headers, QuotationAction entity) {
		 	CourrierClone courrier = entity.getCourrier();
	        courrier = courriermanager.find("id",courrier.getId());
		  Gson gson = new Gson();
		 Long userid  = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
	        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
	       // entity.setQuote(user);
	        entity.setService(user.getService());
	        entity.setQuoteur(user);
	        //Cas des bordero
	        BorderoCourrier bordero = null;
	        String type = "0";
	        if(courrier.getPorte().trim().equalsIgnoreCase("1")){
	            type ="2";
	        }else if(courrier.getCategorie().trim().equalsIgnoreCase("1")){
	            type ="1";
	        }//end if(courrier.getPorte().trim().equalsIgnoreCase("1")){
//	        System.out.println("QuotationActionManagerImpl.processBeforeSave() service quoteur "+entity.getQuoteur().getService().getCode());
//	        System.out.println("QuotationActionManagerImpl.processBeforeSave() service quoté "+entity.getQuote().getService().getCode());
	        
	        if(entity.getQuote()!=null&&entity.getQuote().getService().compareTo(entity.getQuoteur().getService())!=0){
	            bordero = borderomanager.checkBordero(entity.getQuoteur().getService(), entity.getQuote().getService(),type);
	        }else if(entity.getSquote()!=null&&entity.getSquote().compareTo(entity.getQuoteur().getService())!=0){
	            bordero = borderomanager.checkBordero(entity.getQuoteur().getService(), entity.getSquote(),type);
	        }//end if(entity.getSquote()!=null&&entity.getSquote().compareTo(entity.getQuoteur().getService())!=0){         
	        if(courrier.getBordero()==null){
	            courrier.setBordero(bordero);
	        }//end if(courrier.getBordero()==null){
	        courriermanager.update(courrier.getId(), courrier);
	        //Ajout du courrier dans le bordero
	        if (bordero != null) {
	                LigneBorderoCourrier ligne = new LigneBorderoCourrier();
	                ligne.setCourrier(new CourrierClone(courrier));
	                ligne.setInstruction(entity.getNote());
//	                System.out.println(QuotationActionManagerImpl.class.toString()+".processBeforeSave(QuotationAction entity) ======================= bordero cree : "+bordero+" ==== bordero entity : "+courrier.getBordero());
	                if(courrier.getBordero().compareTo(bordero)==0){
	                    ligne.setNature("0");
	                }else{
	                    ligne.setNature("1");
	                }//end if(courrier.getBordero().compareTo(bordero)==0){
	                bordero.getCourriers().add(ligne);                
	                borderomanager.update(bordero.getId(), bordero);
	        } // end if(entity.getBordero()!=null){
	        entity.setBordero(bordero);
		return super.save(headers, entity);
	}

	@Override
	protected void processBeforeSave(QuotationAction entity) {
		   RestrictionsContainer container = RestrictionsContainer.newInstance();  	
		List<StructureCompany> listParent = new ArrayList<StructureCompany>();
	 	container.addEq("parent", entity.getService());
	 	listParent= structuremanager.filter(container.getPredicats(), null, null, 0, -1);
	 	if(listParent!=null&&listParent.size()>0){
	 		for(StructureCompany service : listParent){
	 			if(service==entity.getSquote()){
	 			throw new KerenExecption("Quotation impossible impossible<br/> Le courrier  vous ne pourviez quoté le courrier à votre superieure hiérachique ");
	 			}
	 		}
	 		
	 	}
		
	
		super.processBeforeSave(entity);
	}
	
	
    
    
    
    
    
}
