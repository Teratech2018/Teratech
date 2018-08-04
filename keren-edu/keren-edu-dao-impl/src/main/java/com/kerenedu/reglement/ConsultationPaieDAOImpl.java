
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ConsultationPaieDAO")
public class ConsultationPaieDAOImpl
    extends AbstractGenericDAO<ConsultationPaie, Long>
    implements ConsultationPaieDAOLocal, ConsultationPaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ConsultationPaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ConsultationPaie> getManagedEntityClass() {
        return (ConsultationPaie.class);
    }

}
