
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.CategoriePretDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.CategoriePretDAORemote;
import com.keren.kerenpaie.model.prets.CategoriePret;

@Stateless(mappedName = "CategoriePretDAO")
public class CategoriePretDAOImpl
    extends AbstractGenericDAO<CategoriePret, Long>
    implements CategoriePretDAOLocal, CategoriePretDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public CategoriePretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CategoriePret> getManagedEntityClass() {
        return (CategoriePret.class);
    }

}
