
package com.keren.courrier.core.impl.traitement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.DeclassementActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.DeclassementActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.DeclassementActionDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.traitement.ClassementAction;
import com.keren.courrier.model.traitement.DeclassementAction;

@TransactionAttribute
@Stateless(mappedName = "DeclassementActionManager")
public class DeclassementActionManagerImpl
    extends AbstractGenericManager<DeclassementAction, Long>
    implements DeclassementActionManagerLocal, DeclassementActionManagerRemote
{

    @EJB(name = "DeclassementActionDAO")
    protected DeclassementActionDAOLocal dao;
    

    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;
    
    @EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;

    public DeclassementActionManagerImpl() {
    }

    @Override
    public GenericDAO<DeclassementAction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public void processBeforeSave(DeclassementAction entity) {
        CourrierClone courrier = entity.getCourrier();
        courrier = courrierdao.findByPrimaryKey("id", courrier.getId());
        TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.DECLASSEMENT);
        traitement.setAvis(entity.getMotif());
        traitement.setDoperation(entity.getDclassement());        
        traitement.setOperateur(entity.getOrdonateur());
        courrier.setState(courrier.getLastState());
        daotrt.save(traitement);
        courrierdao.update(courrier.getId(), courrier);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    

}
