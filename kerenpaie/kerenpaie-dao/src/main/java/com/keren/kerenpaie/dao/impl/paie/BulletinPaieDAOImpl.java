
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAORemote;
import com.keren.kerenpaie.model.paie.BulletinPaie;

@Stateless(mappedName = "BulletinPaieDAO")
public class BulletinPaieDAOImpl
    extends AbstractGenericDAO<BulletinPaie, Long>
    implements BulletinPaieDAOLocal, BulletinPaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
