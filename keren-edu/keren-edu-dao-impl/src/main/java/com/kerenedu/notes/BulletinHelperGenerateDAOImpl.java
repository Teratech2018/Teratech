
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "BulletinHelperGenerateDAO")
public class BulletinHelperGenerateDAOImpl
    extends AbstractGenericDAO<BulletinHelperGenerate, Long>
    implements BulletinHelperGenerateDAOLocal, BulletinHelperGenerateDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public BulletinHelperGenerateDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BulletinHelperGenerate> getManagedEntityClass() {
        return (BulletinHelperGenerate.class);
    }

}
