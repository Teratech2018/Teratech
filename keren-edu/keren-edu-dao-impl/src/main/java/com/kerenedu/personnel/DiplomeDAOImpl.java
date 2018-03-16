
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "DiplomeDAO")
public class DiplomeDAOImpl
    extends AbstractGenericDAO<Diplome, Long>
    implements DiplomeDAOLocal, DiplomeDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public DiplomeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Diplome> getManagedEntityClass() {
        return (Diplome.class);
    }

}
