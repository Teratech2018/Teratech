
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CoefMatiereDAO")
public class CoefMatiereDAOImpl
    extends AbstractGenericDAO<CoefMatiere, Long>
    implements CoefMatiereDAOLocal, CoefMatiereDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CoefMatiereDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CoefMatiere> getManagedEntityClass() {
        return (CoefMatiere.class);
    }

}
