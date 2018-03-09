
package com.kerenedu.reglement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EcheancierDltDAO")
public class EcheancierDltDAOImpl
    extends AbstractGenericDAO<EcheancierDlt, Long>
    implements EcheancierDltDAOLocal, EcheancierDltDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EcheancierDltDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EcheancierDlt> getManagedEntityClass() {
        return (EcheancierDlt.class);
    }

}
