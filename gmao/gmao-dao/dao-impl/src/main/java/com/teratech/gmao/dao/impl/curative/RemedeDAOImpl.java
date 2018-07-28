
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.RemedeDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.RemedeDAORemote;
import com.teratech.gmao.model.curative.Remede;

@Stateless(mappedName = "RemedeDAO")
public class RemedeDAOImpl
    extends AbstractGenericDAO<Remede, Long>
    implements RemedeDAOLocal, RemedeDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public RemedeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Remede> getManagedEntityClass() {
        return (Remede.class);
    }

}
