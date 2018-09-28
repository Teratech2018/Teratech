
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "MoratoireDAO")
public class MoratoireDAOImpl
    extends AbstractGenericDAO<Moratoire, Long>
    implements MoratoireDAOLocal, MoratoireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MoratoireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Moratoire> getManagedEntityClass() {
        return (Moratoire.class);
    }

}
