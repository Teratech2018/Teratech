
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
import com.keren.courrier.core.ifaces.archivage.BorderoLiasseRManagerLocal;
import com.keren.courrier.core.ifaces.archivage.BorderoLiasseRManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseRDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentDAOLocal;
import com.keren.courrier.model.archivage.BorderoLiasseR;
import com.keren.courrier.model.archivage.LiasseDocument;
import com.keren.courrier.model.archivage.LigneBorderoLiasseR;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BorderoLiasseRManager")
public class BorderoLiasseRManagerImpl
    extends AbstractGenericManager<BorderoLiasseR, Long>
    implements BorderoLiasseRManagerLocal, BorderoLiasseRManagerRemote
{

    @EJB(name = "BorderoLiasseRDAO")
    protected BorderoLiasseRDAOLocal dao;
    

    @EJB(name = "LiasseDocumentDAO")
    protected LiasseDocumentDAOLocal liassedao;

    public BorderoLiasseRManagerImpl() {
    }

    @Override
    public GenericDAO<BorderoLiasseR, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
    public List<BorderoLiasseR> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<BorderoLiasseR> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BorderoLiasseR> entities = new ArrayList<BorderoLiasseR>();
        for(BorderoLiasseR data:datas){
            entities.add(new BorderoLiasseR(data));
        }
        return entities;
    }

    @Override
    public List<BorderoLiasseR> findAll() {
        List<BorderoLiasseR> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BorderoLiasseR> entities = new ArrayList<BorderoLiasseR>();
        for(BorderoLiasseR data:datas){
            entities.add(new BorderoLiasseR(data));
        }
        return entities;
    }

    @Override
    public BorderoLiasseR find(String propertyName, Long entityID) {
    	BorderoLiasseR data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	BorderoLiasseR entity = new BorderoLiasseR(data);
       for(LigneBorderoLiasseR _instance:data.getLiasses()){
           entity.getLiasses().add(new LigneBorderoLiasseR(_instance));
       }
       return entity;
    }

    @Override
    public BorderoLiasseR delete(Long id) {
    	BorderoLiasseR data =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BorderoLiasseR(data);
    }

    @Override
    public BorderoLiasseR accuserreception(BorderoLiasseR entity,UtilisateurCourrier user) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setDaccuse(new Date());
        entity.setState("receptionne");
        for(LigneBorderoLiasseR ligne:entity.getLiasses()){
            LiasseDocument liasse = ligne.getLiasse();   
            liasse  = liassedao.findByPrimaryKey("id", liasse.getId());
            if(liasse.getPiecesjointes()!=null){
            	liasse.getPiecesjointes().size();
            }//end if(courrier.getPiecesjointes()!=null){
            	liasse.setSource(user);
            	liasse.setSowner(entity.getCible());
            	liasse.setBordero(null);
            	liasse.setState("receptionne");
               //========== @NTW ENREGISTRER LE TRAITEMENT========;
            	// ajout TRT
        		liassedao.update(liasse.getId(), liasse);

        }//end for(LigneBorderoCourrierR ligne:entity.getCourriers()){
        dao.update(entity.getId(), entity);
        return entity;
    }

}
