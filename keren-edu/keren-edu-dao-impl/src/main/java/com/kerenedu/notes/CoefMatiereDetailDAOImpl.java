
package com.kerenedu.notes;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "CoefMatiereDetailDAO")
public class CoefMatiereDetailDAOImpl
    extends AbstractGenericDAO<CoefMatiereDetail, Long>
    implements CoefMatiereDetailDAOLocal, CoefMatiereDetailDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public CoefMatiereDetailDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<CoefMatiereDetail> getManagedEntityClass() {
        return (CoefMatiereDetail.class);
    }

}
