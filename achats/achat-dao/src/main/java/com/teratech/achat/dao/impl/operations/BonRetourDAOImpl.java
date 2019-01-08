
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.BonRetourDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonRetourDAORemote;
import com.teratech.achat.model.operations.BonRetour;

@Stateless(mappedName = "BonRetourDAO")
public class BonRetourDAOImpl
    extends AbstractGenericDAO<BonRetour, Long>
    implements BonRetourDAOLocal, BonRetourDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public BonRetourDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BonRetour> getManagedEntityClass() {
        return (BonRetour.class);
    }

}
