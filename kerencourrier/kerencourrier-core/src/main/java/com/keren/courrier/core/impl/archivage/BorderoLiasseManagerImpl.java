
package com.keren.courrier.core.impl.archivage;

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
import com.keren.courrier.core.ifaces.archivage.BorderoLiasseManagerLocal;
import com.keren.courrier.core.ifaces.archivage.BorderoLiasseManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentDAOLocal;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.archivage.LiasseDocument;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BorderoLiasseManager")
public class BorderoLiasseManagerImpl
    extends AbstractGenericManager<BorderoLiasse, Long>
    implements BorderoLiasseManagerLocal, BorderoLiasseManagerRemote
{

    @EJB(name = "BorderoLiasseDAO")
    protected BorderoLiasseDAOLocal dao;
    
    @EJB(name = "LiasseDocumentDAO")
    protected LiasseDocumentDAOLocal liassedao;

    public BorderoLiasseManagerImpl() {
    }

    @Override
    public GenericDAO<BorderoLiasse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public List<BorderoLiasse> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<BorderoLiasse> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BorderoLiasse> entities = new ArrayList<BorderoLiasse>();
        for(BorderoLiasse data:datas){
            entities.add(new BorderoLiasse(data));
        }
        return entities;
    }

    @Override
    public List<BorderoLiasse> findAll() {
        List<BorderoLiasse> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BorderoLiasse> entities = new ArrayList<BorderoLiasse>();
        for(BorderoLiasse data:datas){
            entities.add(new BorderoLiasse(data));
        }
        return entities;
    }

    @Override
    public BorderoLiasse find(String propertyName, Long entityID) {
    	BorderoLiasse data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	BorderoLiasse entity = new BorderoLiasse(data);
    	System.out.println("BorderoLiasseManagerImpl.find() je suis ici taille "+data.getLignes().size());
       for(LigneBorderoLiasse _instance:data.getLignes()){
           entity.getLignes().add(new LigneBorderoLiasse(_instance));
       }
       return entity;
    }

    @Override
    public BorderoLiasse delete(Long id) {
    	BorderoLiasse data =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BorderoLiasse(data);
    }

    @Override
    public void processBeforeSave(BorderoLiasse entity) {
        
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void processBeforeUpdate(BorderoLiasse entity) {
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
    public BorderoLiasse checkBordero(StructureCompany source, StructureCompany cible) {
        //To change body of generated methods, choose Tools | Templates.
        return dao.checkBordero(source, cible);
    }

    @Override
    public BorderoLiasse distribuer(BorderoLiasse entity) {
        //To change body of generated methods, choose Tools | Templates.
    	 for(LigneBorderoLiasse ligne:entity.getLignes()){
             LiasseDocument liasse = ligne.getLiasse();   
             liasse  = liassedao.findByPrimaryKey("id", liasse.getId());
             if(liasse.getPiecesjointes()!=null){
             	liasse.getPiecesjointes().size();
             }//end if(courrier.getPiecesjointes()!=null){
             	liasse.setSowner(entity.getCible());
             	liasse.setState("transmis");
                //========== @NTW ENREGISTRER LE TRAITEMENT========;
             	// ajout TRT
         		liassedao.update(liasse.getId(), liasse);

         }//end for(LigneBorderoCourrierR ligne:entity.getCourriers()){
        entity.setState("transmis");
        entity.setEmission(new Date());
        
        dao.update(entity.getId(), entity);
        return find("id", entity.getId());         
    }
    
}
