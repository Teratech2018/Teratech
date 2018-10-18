
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AcompteDAO")
public class AcompteDAOImpl
    extends AbstractGenericDAO<Acompte, Long>
    implements AcompteDAOLocal, AcompteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AcompteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Acompte> getManagedEntityClass() {
        return (Acompte.class);
    }

}
