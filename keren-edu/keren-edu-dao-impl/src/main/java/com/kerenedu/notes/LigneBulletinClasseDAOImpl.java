
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "LigneBulletinClasseDAO")
public class LigneBulletinClasseDAOImpl
    extends AbstractGenericDAO<LigneBulletinClasse, Long>
    implements LigneBulletinClasseDAOLocal, LigneBulletinClasseDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneBulletinClasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBulletinClasse> getManagedEntityClass() {
        return (LigneBulletinClasse.class);
    }

}
