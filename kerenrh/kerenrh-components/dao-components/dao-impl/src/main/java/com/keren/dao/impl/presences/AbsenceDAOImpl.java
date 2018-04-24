
package com.keren.dao.impl.presences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.presences.AbsenceDAOLocal;
import com.keren.dao.ifaces.presences.AbsenceDAORemote;
import com.keren.model.presences.Absence;

@Stateless(mappedName = "AbsenceDAO")
public class AbsenceDAOImpl
    extends AbstractGenericDAO<Absence, Long>
    implements AbsenceDAOLocal, AbsenceDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AbsenceDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<Absence> getManagedEntityClass() {
        return (Absence.class);
    }

}
