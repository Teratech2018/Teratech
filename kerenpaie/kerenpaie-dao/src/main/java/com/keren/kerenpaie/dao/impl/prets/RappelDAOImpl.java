
package com.keren.kerenpaie.dao.impl.prets;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.prets.RappelDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RappelDAORemote;
import com.keren.kerenpaie.model.prets.Rappel;

@Stateless(mappedName = "RappelDAO")
public class RappelDAOImpl
    extends AbstractGenericDAO<Rappel, Long>
    implements RappelDAOLocal, RappelDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public RappelDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Rappel> getManagedEntityClass() {
        return (Rappel.class);
    }

}
