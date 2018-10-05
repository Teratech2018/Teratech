
package com.keren.courrier.core.impl.courrier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.commons.DateHelper;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BorderoCourrierManager")
public class BorderoCourrierManagerImpl
    extends AbstractGenericManager<BorderoCourrier, Long>
    implements BorderoCourrierManagerLocal, BorderoCourrierManagerRemote
{

    @EJB(name = "BorderoCourrierDAO")
    protected BorderoCourrierDAOLocal dao;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;
    
    @EJB(name = "TraitementCourrierDAO")
   	protected TraitementCourrierDAOLocal daotrt;

    public BorderoCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<BorderoCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BorderoCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<BorderoCourrier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BorderoCourrier> entities = new ArrayList<BorderoCourrier>();
        for(BorderoCourrier data:datas){
            entities.add(new BorderoCourrier(data));
        }
        return entities;
    }

    @Override
    public List<BorderoCourrier> findAll() {
        List<BorderoCourrier> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BorderoCourrier> entities = new ArrayList<BorderoCourrier>();
        for(BorderoCourrier data:datas){
            entities.add(new BorderoCourrier(data));
        }
        return entities;
    }

    @Override
    public BorderoCourrier find(String propertyName, Long entityID) {
        BorderoCourrier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
       BorderoCourrier entity = new BorderoCourrier(data);
       
       //entity.setAgentliaison(new UtilisateurCourrier(data.getAgentliaison()));
       for(LigneBorderoCourrier _instance:data.getCourriers()){
           entity.getCourriers().add(new LigneBorderoCourrier(_instance));
       }
       return entity;
    }

    @Override
    public BorderoCourrier delete(Long id) {
        BorderoCourrier data =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BorderoCourrier(data);
    }

    @Override
    public void processBeforeSave(BorderoCourrier entity) {
    	if(entity.getCreation()==null){
    		entity.setCreation(new Date());
    	}
    	entity.setEmission(new Date());
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void processAfterSave(BorderoCourrier entity) {
    	if(entity.getCode()==null||entity.getCode().equals("")||entity.getCode().isEmpty()){
    		entity.setCode("BDR/"+ entity.getType()+"/" + entity.getId() + "/"+ DateHelper.convertToString(entity.getCreation(), "dd/MM/yyyy"));
    	}
    	entity.setNcourrier(entity.getCourriers().size());	
        dao.update(entity.getId(), entity);
        super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void processBeforeUpdate(BorderoCourrier entity) {
    	 entity.setNcourrier(entity.getCourriers().size());	
    	 dao.update(entity.getId(), entity);
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    

    /**
     * 
     * @param source
     * @param cible
     * @param type
     * @return 
     */
    @Override
    public BorderoCourrier checkBordero(StructureCompany source, StructureCompany cible, String type) {
        //To change body of generated methods, choose Tools | Templates.
        return dao.checkBordero(source, cible, type);
    }

    @Override
    public BorderoCourrier distribuer(BorderoCourrier entity) {
        //To change body of generated methods, choose Tools | Templates.
    	int nt=0;
        for(LigneBorderoCourrier ligne:entity.getCourriers()){
        	nt=nt+1;
            CourrierClone courrier = ligne.getCourrier();
            courrier = courrierdao.findByPrimaryKey("id", courrier.getId());
            if(courrier.getPiecesjointes()!=null)courrier.getPiecesjointes().size();
            courrier.setState("transmis");
          //========== @NTW ENREGISTRER LE TRAITEMENT============;
    		TraitementCourrier trtcourrier = new TraitementCourrier(new CourrierClone(courrier),TypeTraitement.TRANSMISSION);
    		daotrt.save(trtcourrier);
            courrierdao.update(courrier.getId(), courrier);
            //Traitement du courrier joint
            if(courrier.getType()!=null&&courrier.getType().trim().equalsIgnoreCase("1")&&courrier.getCourrier()!=null){
                trtcourrier = new TraitementCourrier(new CourrierClone(courrier.getCourrier()),TypeTraitement.TRANSMISSION);
                daotrt.save(trtcourrier);
                courrierdao.update(courrier.getCourrier().getId(), courrier.getCourrier());
            }//end if(courrier.getType()!=null&&courrier.getType().trim().equalsIgnoreCase("1")){
        }//end for(LigneBorderoCourrier ligne:entity.getCourriers()){
        entity.setNctransmis(nt);
        entity.setState("transmis");
        entity.setEmission(new Date());
        dao.update(entity.getId(), entity);
        return find("id", entity.getId());         
    }
    
   
}
