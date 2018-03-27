
package com.keren.kerenpaie.dao.impl.paie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.paie.LigneBulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.LigneBulletinPaieDAORemote;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;

@Stateless(mappedName = "LigneBulletinPaieDAO")
public class LigneBulletinPaieDAOImpl
    extends AbstractGenericDAO<LigneBulletinPaie, Long>
    implements LigneBulletinPaieDAOLocal, LigneBulletinPaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
