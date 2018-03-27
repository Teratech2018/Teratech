
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.PaysDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.PaysDAORemote;
import com.keren.kerenpaie.model.structures.Pays;

@Stateless(mappedName = "PaysDAO")
public class PaysDAOImpl
    extends AbstractGenericDAO<Pays, Long>
    implements PaysDAOLocal, PaysDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public PaysDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Pays> getManagedEntityClass() {
        return (Pays.class);
    }

}
