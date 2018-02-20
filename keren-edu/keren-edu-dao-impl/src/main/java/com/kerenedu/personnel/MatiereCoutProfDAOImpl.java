
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "MatiereCoutProfDAO")
public class MatiereCoutProfDAOImpl
    extends AbstractGenericDAO<MatiereCoutProf, Long>
    implements MatiereCoutProfDAOLocal, MatiereCoutProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public MatiereCoutProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MatiereCoutProf> getManagedEntityClass() {
        return (MatiereCoutProf.class);
    }

}
