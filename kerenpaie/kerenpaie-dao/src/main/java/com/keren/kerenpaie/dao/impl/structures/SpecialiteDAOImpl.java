
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.SpecialiteDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.SpecialiteDAORemote;
import com.keren.kerenpaie.model.structures.Specialite;

@Stateless(mappedName = "SpecialiteDAO")
public class SpecialiteDAOImpl
    extends AbstractGenericDAO<Specialite, Long>
    implements SpecialiteDAOLocal, SpecialiteDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
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
