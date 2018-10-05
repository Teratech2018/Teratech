
package com.keren.courrier.core.impl.traitement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.QuotationActionDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.traitement.QuotationAction;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "QuotationActionManager")
public class QuotationActionManagerImpl
    extends AbstractGenericManager<QuotationAction, Long>
    implements QuotationActionManagerLocal, QuotationActionManagerRemote
{

    @EJB(name = "QuotationActionDAO")
    protected QuotationActionDAOLocal dao;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;    
    
    @EJB(name = "BorderoCourrierDAO")
    protected BorderoCourrierDAOLocal borderodao;
    
	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;
	

    public QuotationActionManagerImpl() {
    }

    @Override
    public GenericDAO<QuotationAction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuotationAction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<QuotationAction> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<QuotationAction> results = new ArrayList<QuotationAction>();
        for(QuotationAction data:datas){
            results.add(new QuotationAction(data));
        }
        return results;
    }

    @Override
    public List<QuotationAction> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuotationAction find(String propertyName, Long entityID) {
        QuotationAction data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        QuotationAction entity = new QuotationAction(data);
//        entity.setBordero(new Bor);
        return entity;
    }

    @Override
    public QuotationAction delete(Long id) {
        //To change body of generated methods, choose Tools | Templates.
        //Traitement du bordero contenant
        QuotationAction entity = find("id", id);
        int index = 0;
        if(entity.getBordero()!=null){
            BorderoCourrier bordero = entity.getBordero();
            for(LigneBorderoCourrier ligne:bordero.getCourriers()){
                if(ligne.getCourrier().compareTo(entity.getCourrier())==0){
                    bordero.getCourriers().get(index);
                    break;
                }//end if(ligne.getCourrier().compareTo(entity.getCourrier())==0){
                index++;
            }//end for(LigneBorderoCourrier ligne:bordero.getCourriers()){
            borderodao.update(bordero.getId(), bordero);
        }//end if(entity.getBordero()!=null){
        QuotationAction data = super.delete(id);
        entity = new QuotationAction(data);
        return entity;
    }

    @Override
    public void processBeforeSave(QuotationAction entity) {
//        CourrierClone courrier = entity.getCourrier();
//        courrier = courrierdao.findByPrimaryKey("id",courrier.getId());
//        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.QUOTATION);
//        traitement.setAvis(entity.getNote());
//        traitement.setDoperation(entity.getDquotation());
//        traitement.setOperateur(entity.getQuoteur());
//        
//        traitement.setDestinataire(entity.getQuote());
//        traitement.setCible(entity.getSquote());
//        daotrt.save(traitement);
//        entity.setService(courrier.getService());
//        entity.setQuoteur(new UtilisateurCourrier(entity.getService().getResponsable()));
        
//        
//        //Cas des bordero
//        BorderoCourrier bordero = null;
//        String type = "0";
//        if(courrier.getPorte().trim().equalsIgnoreCase("1")){
//            type ="2";
//        }else if(courrier.getCategorie().trim().equalsIgnoreCase("1")){
//            type ="1";
//        }//end if(courrier.getPorte().trim().equalsIgnoreCase("1")){
////        System.out.println("QuotationActionManagerImpl.processBeforeSave() service quoteur "+entity.getQuoteur().getService().getCode());
////        System.out.println("QuotationActionManagerImpl.processBeforeSave() service quoté "+entity.getQuote().getService().getCode());
//        
//        if(entity.getQuote()!=null&&entity.getQuote().getService().compareTo(entity.getQuoteur().getService())!=0){
//            bordero = borderodao.checkBordero(entity.getQuoteur().getService(), entity.getQuote().getService(),type);
//        }else if(entity.getSquote()!=null&&entity.getSquote().compareTo(entity.getQuoteur().getService())!=0){
//            bordero = borderodao.checkBordero(entity.getQuoteur().getService(), entity.getSquote(),type);
//        }//end if(entity.getSquote()!=null&&entity.getSquote().compareTo(entity.getQuoteur().getService())!=0){         
//        if(courrier.getBordero()==null){
//            courrier.setBordero(bordero);
//        }//end if(courrier.getBordero()==null){
//        courrierdao.update(courrier.getId(), courrier);
//        //Ajout du courrier dans le bordero
//        if (bordero != null) {
//                LigneBorderoCourrier ligne = new LigneBorderoCourrier();
//                ligne.setCourrier(new CourrierClone(courrier));
//                ligne.setInstruction(entity.getNote());
////                System.out.println(QuotationActionManagerImpl.class.toString()+".processBeforeSave(QuotationAction entity) ======================= bordero cree : "+bordero+" ==== bordero entity : "+courrier.getBordero());
//                if(courrier.getBordero().compareTo(bordero)==0){
//                    ligne.setNature("0");
//                }else{
//                    ligne.setNature("1");
//                }//end if(courrier.getBordero().compareTo(bordero)==0){
//                bordero.getCourriers().add(ligne);                
//                borderodao.update(bordero.getId(), bordero);
//        } // end if(entity.getBordero()!=null){
//        entity.setBordero(bordero);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    


	@Override
	public QuotationAction save(QuotationAction entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	@Override
	public void processAfterSave(QuotationAction entity) {
        CourrierClone courrier = entity.getCourrier();
        courrier = courrierdao.findByPrimaryKey("id",courrier.getId());
        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.QUOTATION);
        traitement.setAvis(entity.getNote());
        traitement.setDoperation(entity.getDquotation());
        traitement.setOperateur(entity.getQuoteur());
        traitement.setDestinataire(entity.getQuote());
        traitement.setCible(entity.getSquote());
        daotrt.save(traitement);
        
        // mis a jour du nombre de quatation 
        courrier.setNquotation(courrier.getNquotation()+1);
        courrierdao.update(courrier.getId(), courrier);
		super.processAfterSave(entity);
	}

	@Override
    public void processBeforeUpdate(QuotationAction entity) {
        QuotationAction old = find("id", entity.getId());
        entity.setBordero(old.getBordero());
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
