
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierRManagerLocal;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierRManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierRDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrierR;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrierR;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BorderoCourrierRManager")
public class BorderoCourrierRManagerImpl
    extends AbstractGenericManager<BorderoCourrierR, Long>
    implements BorderoCourrierRManagerLocal, BorderoCourrierRManagerRemote
{

    @EJB(name = "BorderoCourrierRDAO")
    protected BorderoCourrierRDAOLocal dao;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;

    public BorderoCourrierRManagerImpl() {
    }

    @Override
    public GenericDAO<BorderoCourrierR, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
    public List<BorderoCourrierR> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<BorderoCourrierR> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<BorderoCourrierR> entities = new ArrayList<BorderoCourrierR>();
        for(BorderoCourrierR data:datas){
            entities.add(new BorderoCourrierR(data));
        }
        return entities;
    }

    @Override
    public List<BorderoCourrierR> findAll() {
        List<BorderoCourrierR> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<BorderoCourrierR> entities = new ArrayList<BorderoCourrierR>();
        for(BorderoCourrierR data:datas){
            entities.add(new BorderoCourrierR(data));
        }
        return entities;
    }

    @Override
    public BorderoCourrierR find(String propertyName, Long entityID) {
        BorderoCourrierR data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
       BorderoCourrierR entity = new BorderoCourrierR(data);
       for(LigneBorderoCourrierR _instance:data.getCourriers()){
           entity.getCourriers().add(new LigneBorderoCourrierR(_instance));
       }
       return entity;
    }

    @Override
    public BorderoCourrierR delete(Long id) {
        BorderoCourrierR data =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BorderoCourrierR(data);
    }

    @Override
    public BorderoCourrierR accuserreception(BorderoCourrierR entity,UtilisateurCourrier user) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setDaccuse(new Date());
        entity.setState("receptionne");
        for(LigneBorderoCourrierR ligne:entity.getCourriers()){
            CourrierClone courrier = ligne.getCourrier();   
            courrier  = courrierdao.findByPrimaryKey("id", courrier.getId());
            if(courrier.getPiecesjointes()!=null){
                courrier.getPiecesjointes().size();
            }//end if(courrier.getPiecesjointes()!=null){
            if(ligne.getNature().trim().equalsIgnoreCase("0")){
                courrier.setSource(user);
                courrier.setSowner(entity.getCible());
                courrier.setState("receptionne");
                courrierdao.update(courrier.getId(), courrier);
            }else{//Cas de copie
               courrier.setState("receptionne");
               courrier.setOriganal(ligne.getCourrier());
               courrier.setSowner(entity.getCible());
               courrier.setSource(user);
               courrierdao.save(courrier);
            }//end if(ligne.getNature().trim().equalsIgnoreCase("0")){
        }//end for(LigneBorderoCourrierR ligne:entity.getCourriers()){
        dao.update(entity.getId(), entity);
        return entity;
    }

}
