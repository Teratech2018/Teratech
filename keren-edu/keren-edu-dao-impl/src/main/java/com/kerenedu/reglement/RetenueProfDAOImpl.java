
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "RetenueProfDAO")
public class RetenueProfDAOImpl
    extends AbstractGenericDAO<RetenueProf, Long>
    implements RetenueProfDAOLocal, RetenueProfDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public RetenueProfDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<RetenueProf> getManagedEntityClass() {
        return (RetenueProf.class);
    }

}
