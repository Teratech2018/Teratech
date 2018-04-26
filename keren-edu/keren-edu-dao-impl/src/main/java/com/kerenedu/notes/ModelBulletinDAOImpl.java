
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ModelBulletinDAO")
public class ModelBulletinDAOImpl
    extends AbstractGenericDAO<ModelBulletin, Long>
    implements ModelBulletinDAOLocal, ModelBulletinDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ModelBulletinDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ModelBulletin> getManagedEntityClass() {
        return (ModelBulletin.class);
    }

}
