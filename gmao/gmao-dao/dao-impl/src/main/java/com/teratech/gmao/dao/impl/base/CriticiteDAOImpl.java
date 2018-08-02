
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.CriticiteDAOLocal;
import com.teratech.gmao.dao.ifaces.base.CriticiteDAORemote;
import com.teratech.gmao.model.base.Criticite;

@Stateless(mappedName = "CriticiteDAO")
public class CriticiteDAOImpl
    extends AbstractGenericDAO<Criticite, Long>
    implements CriticiteDAOLocal, CriticiteDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public CriticiteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Criticite> getManagedEntityClass() {
        return (Criticite.class);
    }

}
