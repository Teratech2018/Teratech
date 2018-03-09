
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "AvanceProfDAO")
public class AvanceProfDAOImpl
    extends AbstractGenericDAO<AvanceProf, Long>
    implements AvanceProfDAOLocal, AvanceProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public AvanceProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<AvanceProf> getManagedEntityClass() {
        return (AvanceProf.class);
    }

}
