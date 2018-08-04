
package com.keren.courrier.dao.impl.traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.traitement.RelanceActionDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.RelanceActionDAORemote;
import com.keren.courrier.model.traitement.RelanceAction;

@Stateless(mappedName = "RelanceActionDAO")
public class RelanceActionDAOImpl
    extends AbstractGenericDAO<RelanceAction, Long>
    implements RelanceActionDAOLocal, RelanceActionDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public RelanceActionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RelanceAction> getManagedEntityClass() {
        return (RelanceAction.class);
    }

}
