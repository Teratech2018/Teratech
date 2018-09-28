
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinPaieDAO")
public class BulletinPaieDAOImpl
    extends AbstractGenericDAO<BulletinPaie, Long>
    implements BulletinPaieDAOLocal, BulletinPaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinPaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinPaie> getManagedEntityClass() {
        return (BulletinPaie.class);
    }

}
