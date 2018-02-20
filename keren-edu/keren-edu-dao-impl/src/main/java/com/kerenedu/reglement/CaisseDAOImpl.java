
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CaisseDAO")
public class CaisseDAOImpl
    extends AbstractGenericDAO<Caisse, Long>
    implements CaisseDAOLocal, CaisseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CaisseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Caisse> getManagedEntityClass() {
        return (Caisse.class);
    }

}
