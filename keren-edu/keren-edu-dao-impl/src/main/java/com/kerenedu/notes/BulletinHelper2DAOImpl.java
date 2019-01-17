
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinHelper2DAO")
public class BulletinHelper2DAOImpl
    extends AbstractGenericDAO<BulletinHelper2, Long>
    implements BulletinHelper2DAOLocal, BulletinHelper2DAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinHelper2DAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinHelper2> getManagedEntityClass() {
        return (BulletinHelper2.class);
    }

}
