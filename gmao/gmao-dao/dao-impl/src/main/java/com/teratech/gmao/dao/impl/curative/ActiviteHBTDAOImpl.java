
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.ActiviteHBTDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.ActiviteHBTDAORemote;
import com.teratech.gmao.model.curative.ActiviteHBT;

@Stateless(mappedName = "ActiviteHBTDAO")
public class ActiviteHBTDAOImpl
    extends AbstractGenericDAO<ActiviteHBT, Long>
    implements ActiviteHBTDAOLocal, ActiviteHBTDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public ActiviteHBTDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ActiviteHBT> getManagedEntityClass() {
        return (ActiviteHBT.class);
    }

}
