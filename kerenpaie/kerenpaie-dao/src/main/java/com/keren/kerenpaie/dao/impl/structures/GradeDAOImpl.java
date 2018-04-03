
package com.keren.kerenpaie.dao.impl.structures;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.structures.GradeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.GradeDAORemote;
import com.keren.kerenpaie.model.structures.Grade;

@Stateless(mappedName = "GradeDAO")
public class GradeDAOImpl
    extends AbstractGenericDAO<Grade, Long>
    implements GradeDAOLocal, GradeDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public GradeDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Grade> getManagedEntityClass() {
        return (Grade.class);
    }

}
