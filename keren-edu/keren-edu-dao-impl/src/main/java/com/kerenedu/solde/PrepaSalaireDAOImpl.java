
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PrepaSalaireDAO")
public class PrepaSalaireDAOImpl
    extends AbstractGenericDAO<PrepaSalaire, Long>
    implements PrepaSalaireDAOLocal, PrepaSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PrepaSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PrepaSalaire> getManagedEntityClass() {
        return (PrepaSalaire.class);
    }

}
