
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinHelperGeneratePrimaireDAO")
public class BulletinHelperGeneratePrimaireDAOImpl
    extends AbstractGenericDAO<BulletinHelperGeneratePrimaire, Long>
    implements BulletinHelperGeneratePrimaireDAOLocal, BulletinHelperGeneratePrimaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinHelperGeneratePrimaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinHelperGeneratePrimaire> getManagedEntityClass() {
        return (BulletinHelperGeneratePrimaire.class);
    }

}
