
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinHelperDAO")
public class BulletinHelperDAOImpl
    extends AbstractGenericDAO<BulletinHelper, Long>
    implements BulletinHelperDAOLocal, BulletinHelperDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinHelperDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinHelper> getManagedEntityClass() {
        return (BulletinHelper.class);
    }

}
