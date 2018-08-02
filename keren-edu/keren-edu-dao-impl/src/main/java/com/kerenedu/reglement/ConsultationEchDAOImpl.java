
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ConsultationEchDAO")
public class ConsultationEchDAOImpl
    extends AbstractGenericDAO<ConsultationEch, Long>
    implements ConsultationEchDAOLocal, ConsultationEchDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConsultationEchDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConsultationEch> getManagedEntityClass() {
        return (ConsultationEch.class);
    }

}
