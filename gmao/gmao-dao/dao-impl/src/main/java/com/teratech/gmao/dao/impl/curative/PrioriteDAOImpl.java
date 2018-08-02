
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.PrioriteDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.PrioriteDAORemote;
import com.teratech.gmao.model.curative.Priorite;

@Stateless(mappedName = "PrioriteDAO")
public class PrioriteDAOImpl
    extends AbstractGenericDAO<Priorite, Long>
    implements PrioriteDAOLocal, PrioriteDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public PrioriteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Priorite> getManagedEntityClass() {
        return (Priorite.class);
    }

}
