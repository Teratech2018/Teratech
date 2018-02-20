
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ReglementDAO")
public class ReglementDAOImpl
    extends AbstractGenericDAO<Reglement, Long>
    implements ReglementDAOLocal, ReglementDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ReglementDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Reglement> getManagedEntityClass() {
        return (Reglement.class);
    }

}
