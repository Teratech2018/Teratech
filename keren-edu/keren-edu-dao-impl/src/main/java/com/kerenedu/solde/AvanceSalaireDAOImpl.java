
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AvanceSalaireDAO")
public class AvanceSalaireDAOImpl
    extends AbstractGenericDAO<AvanceSalaire, Long>
    implements AvanceSalaireDAOLocal, AvanceSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AvanceSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AvanceSalaire> getManagedEntityClass() {
        return (AvanceSalaire.class);
    }

}
