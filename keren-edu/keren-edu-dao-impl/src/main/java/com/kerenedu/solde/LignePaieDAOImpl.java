
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LignePaieDAO")
public class LignePaieDAOImpl
    extends AbstractGenericDAO<LignePaie, Long>
    implements LignePaieDAOLocal, LignePaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LignePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LignePaie> getManagedEntityClass() {
        return (LignePaie.class);
    }

}
