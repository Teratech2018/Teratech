
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.ActiviteBTDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.ActiviteBTDAORemote;
import com.teratech.gmao.model.curative.ActiviteBT;

@Stateless(mappedName = "ActiviteBTDAO")
public class ActiviteBTDAOImpl
    extends AbstractGenericDAO<ActiviteBT, Long>
    implements ActiviteBTDAOLocal, ActiviteBTDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ActiviteBTDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ActiviteBT> getManagedEntityClass() {
        return (ActiviteBT.class);
    }

}
