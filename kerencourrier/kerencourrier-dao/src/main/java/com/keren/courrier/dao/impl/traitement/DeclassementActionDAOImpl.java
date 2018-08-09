
package com.keren.courrier.dao.impl.traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.traitement.DeclassementActionDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.DeclassementActionDAORemote;
import com.keren.courrier.model.traitement.DeclassementAction;

@Stateless(mappedName = "DeclassementActionDAO")
public class DeclassementActionDAOImpl
    extends AbstractGenericDAO<DeclassementAction, Long>
    implements DeclassementActionDAOLocal, DeclassementActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public DeclassementActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DeclassementAction> getManagedEntityClass() {
        return (DeclassementAction.class);
    }

}
