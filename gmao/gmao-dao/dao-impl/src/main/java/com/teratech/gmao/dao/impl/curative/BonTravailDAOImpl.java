
package com.teratech.gmao.dao.impl.curative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.curative.BonTravailDAOLocal;
import com.teratech.gmao.dao.ifaces.curative.BonTravailDAORemote;
import com.teratech.gmao.model.curative.BonTravail;

@Stateless(mappedName = "BonTravailDAO")
public class BonTravailDAOImpl
    extends AbstractGenericDAO<BonTravail, Long>
    implements BonTravailDAOLocal, BonTravailDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public BonTravailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BonTravail> getManagedEntityClass() {
        return (BonTravail.class);
    }

}
