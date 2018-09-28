
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RubriquePaieDAO")
public class RubriquePaieDAOImpl
    extends AbstractGenericDAO<RubriquePaie, Long>
    implements RubriquePaieDAOLocal, RubriquePaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RubriquePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RubriquePaie> getManagedEntityClass() {
        return (RubriquePaie.class);
    }

}
