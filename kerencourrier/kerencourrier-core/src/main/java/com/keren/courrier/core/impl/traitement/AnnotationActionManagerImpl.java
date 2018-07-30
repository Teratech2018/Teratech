
package com.keren.courrier.core.impl.traitement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.AnnotationActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.AnnotationActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.AnnotationActionDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.traitement.AnnotationAction;

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
    public AnnotationAction save(AnnotationAction entity) {
        CourrierClone courrier = entity.getCourrier();
        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.ANNOTATION);
        traitement.setAvis(entity.getNote());
        traitement.setDoperation(entity.getDvisa());
        traitement.setOperateur(entity.getQuoteur());
        courrier.getTraitements().add(traitement);
        courrierdao.update(courrier.getId(), courrier);
//        courrier.get
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
