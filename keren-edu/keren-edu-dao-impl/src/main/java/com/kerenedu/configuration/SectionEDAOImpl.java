
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "SectionEDAO")
public class SectionEDAOImpl
    extends AbstractGenericDAO<SectionE, Long>
    implements SectionEDAOLocal, SectionEDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public SectionEDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SectionE> getManagedEntityClass() {
        return (SectionE.class);
    }

}
