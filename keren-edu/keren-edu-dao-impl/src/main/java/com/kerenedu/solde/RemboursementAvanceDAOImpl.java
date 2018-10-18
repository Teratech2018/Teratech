
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RemboursementAvanceDAO")
public class RemboursementAvanceDAOImpl
    extends AbstractGenericDAO<RemboursementAvance, Long>
    implements RemboursementAvanceDAOLocal, RemboursementAvanceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RemboursementAvanceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RemboursementAvance> getManagedEntityClass() {
        return (RemboursementAvance.class);
    }

}
