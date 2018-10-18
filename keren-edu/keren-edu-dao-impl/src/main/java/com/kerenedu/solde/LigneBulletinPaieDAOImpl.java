
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneBulletinPaieDAO")
public class LigneBulletinPaieDAOImpl
    extends AbstractGenericDAO<LigneBulletinPaie, Long>
    implements LigneBulletinPaieDAOLocal, LigneBulletinPaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneBulletinPaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBulletinPaie> getManagedEntityClass() {
        return (LigneBulletinPaie.class);
    }

}
