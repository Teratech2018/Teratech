
package com.keren.courrier.core.impl.traitement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.AnnotationActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.AnnotationActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.AnnotationActionDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.others.UtilisateurClone;
import com.keren.courrier.model.traitement.AnnotationAction;
import com.keren.courrier.model.traitement.AnnotationAction;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "AnnotationActionManager")
public class AnnotationActionManagerImpl
    extends AbstractGenericManager<AnnotationAction, Long>
    implements AnnotationActionManagerLocal, AnnotationActionManagerRemote
{

    @EJB(name = "AnnotationActionDAO")
    protected AnnotationActionDAOLocal dao;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;
    
    @EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;
	

    public AnnotationActionManagerImpl() {
    }

    @Override
    public GenericDAO<AnnotationAction, Long> getDao() {
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
    public List<AnnotationAction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<AnnotationAction> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<AnnotationAction> results = new ArrayList<AnnotationAction>();
        for(AnnotationAction data:datas){
            results.add(new AnnotationAction(data));
        }
        return results;
    }

    @Override
    public List<AnnotationAction> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnnotationAction find(String propertyName, Long entityID) {
        AnnotationAction data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        AnnotationAction entity = new AnnotationAction(data);
        return entity;
    }

    @Override
    public AnnotationAction delete(Long id) {
        //To change body of generated methods, choose Tools | Templates.
        AnnotationAction data = super.delete(id);
        AnnotationAction entity = new AnnotationAction(data);
        return entity;
    }

    @Override
    public void processBeforeSave(AnnotationAction entity) {
        CourrierClone courrier = entity.getCourrier();
        courrier = courrierdao.findByPrimaryKey("id", courrier.getId());
        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.ANNOTATION);
        traitement.setAvis(entity.getNote());
        traitement.setDoperation(entity.getDvisa());
        traitement.setOperateur(entity.getQuoteur());
        daotrt.save(traitement);
        // mis a jour du nombre de quatation 
        courrier.setNannotation(courrier.getNannotation()+1);
        courrierdao.update(courrier.getId(), courrier);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    

     
    

}
