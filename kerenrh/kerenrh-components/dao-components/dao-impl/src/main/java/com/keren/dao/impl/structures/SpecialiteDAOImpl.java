
package com.keren.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.structures.SpecialiteDAOLocal;
import com.keren.dao.ifaces.structures.SpecialiteDAORemote;
import com.keren.model.structures.Specialite;

@Stateless(mappedName = "SpecialiteDAO")
public class SpecialiteDAOImpl
    extends AbstractGenericDAO<Specialite, Long>
    implements SpecialiteDAOLocal, SpecialiteDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public SpecialiteDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Specialite> getManagedEntityClass() {
        return (Specialite.class);
    }

}
