
package com.teratech.stock.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.stock.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.stock.dao.ifaces.base.LienEmplacementDAORemote;
import com.teratech.stock.model.base.LienEmplacement;

@Stateless(mappedName = "LienEmplacementDAO")
public class LienEmplacementDAOImpl
    extends AbstractGenericDAO<LienEmplacement, Long>
    implements LienEmplacementDAOLocal, LienEmplacementDAORemote
{

    @PersistenceContext(unitName = "teratech")
    protected EntityManager em;

    public LienEmplacementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LienEmplacement> getManagedEntityClass() {
        return (LienEmplacement.class);
    }

}
