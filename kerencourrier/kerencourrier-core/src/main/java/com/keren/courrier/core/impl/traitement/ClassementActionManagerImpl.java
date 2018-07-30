
package com.keren.courrier.core.impl.traitement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.ClassementActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.ClassementActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.ClassementActionDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.traitement.ClassementAction;

@TransactionAttribute
@Stateless(mappedName = "ClassementActionManager")
public class ClassementActionManagerImpl
    extends AbstractGenericManager<ClassementAction, Long>
    implements ClassementActionManagerLocal, ClassementActionManagerRemote
{

    @EJB(name = "ClassementActionDAO")
    protected ClassementActionDAOLocal dao;

    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;
    
    
    public ClassementActionManagerImpl() {
    }

    @Override
    public GenericDAO<ClassementAction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public ClassementAction save(ClassementAction entity) {
        //To change body of generated methods, choose Tools | Templates.
        CourrierClone courrier = entity.getCourrier();
        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.CLASSEMENT);
        traitement.setAvis(entity.getMotif());
        traitement.setDoperation(entity.getDclassement());
        traitement.setOperateur(entity.getOrdonateur());
        traitement.setClasseur(entity.getClasseur());
        traitement.setCompartiment(entity.getCompartiment());
        courrier.getTraitements().add(traitement);
        courrier.setState("classer");
        courrierdao.update(courrier.getId(), courrier);
//        courrier.get
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
