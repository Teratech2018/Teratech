
package com.teratech.gmao.dao.impl.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.base.LotDAOLocal;
import com.teratech.gmao.dao.ifaces.base.LotDAORemote;
import com.teratech.gmao.model.base.Lot;

@Stateless(mappedName = "LotDAO")
public class LotDAOImpl
    extends AbstractGenericDAO<Lot, Long>
    implements LotDAOLocal, LotDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public LotDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Lot> getManagedEntityClass() {
        return (Lot.class);
    }

}
