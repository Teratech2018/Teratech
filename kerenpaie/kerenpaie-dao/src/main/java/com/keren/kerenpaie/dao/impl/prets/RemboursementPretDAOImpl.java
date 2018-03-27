
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementPretDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementPretDAORemote;
import com.keren.kerenpaie.model.prets.RemboursementPret;

@Stateless(mappedName = "RemboursementPretDAO")
public class RemboursementPretDAOImpl
    extends AbstractGenericDAO<RemboursementPret, Long>
    implements RemboursementPretDAOLocal, RemboursementPretDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public RemboursementPretDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RemboursementPret> getManagedEntityClass() {
        return (RemboursementPret.class);
    }

}
