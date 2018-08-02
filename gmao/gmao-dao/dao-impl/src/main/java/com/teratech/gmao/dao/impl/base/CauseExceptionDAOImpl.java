
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CauseExceptionDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CauseExceptionDAORemote;
import com.teratech.gmao.model.base.CauseException;

@Stateless(mappedName = "CauseExceptionDAO")
public class CauseExceptionDAOImpl
    extends AbstractGenericDAO<CauseException, Long>
    implements CauseExceptionDAOLocal, CauseExceptionDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CauseExceptionDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CauseException> getManagedEntityClass() {
        return (CauseException.class);
    }

}
